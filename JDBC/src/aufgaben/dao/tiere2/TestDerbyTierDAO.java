package aufgaben.dao.tiere2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestDerbyTierDAO implements TierDao {

    private static final String URL = "jdbc:derby:C:\\path\\to\\mydb;create=true;"; 
    
    
    public TestDerbyTierDAO() {
    	
		try (Connection c = DriverManager.getConnection(URL);
				Statement stm = c.createStatement()){
			
			String sql = "drop table Tiere";
			try {
				stm.executeUpdate(sql);
				System.out.println("***Alte Tebele 'Tiere' gelöscht");
				
			} catch (SQLException e) {
				if("42Y55".equals(e.getSQLState()))
					System.out.println("***Tabelle 'Tiere' existiert nicht");
				e.printStackTrace();
			}
			
			// Tabelle erneuet erzeugen
			sql = "CREATE TABLE Tiere (id INT PRIMARY KEY, name VARCHAR(100), art VARCHAR(100), geburtsjahr INT)";
			stm.executeUpdate(sql);

			System.out.println("***Tabelle 'Tiere' erzeugt");
			
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
    
    public void shutdownDatabase() {
        try {
            DriverManager.getConnection("jdbc:derby:;shutdown=true");
        } catch (SQLException se) {
            if ("XJ015".equals(se.getSQLState())) {
                System.out.println("ปิดฐานข้อมูลสำเร็จ");
            } else {
                se.printStackTrace();
            }
        }
    }

    @Override
    public List<Tier> getAllTiere()  {
        String query = "SELECT * FROM Tiere";
        List<Tier> tiere = new ArrayList<>();
        
        try (Connection c = DriverManager.getConnection(URL);
             Statement stmt = c.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String art = rs.getString("art");
                int geburtsjahr = rs.getInt("geburtsjahr");
                
                tiere.add(new Tier(id, name, art, geburtsjahr));
            }
        } catch (SQLException e) {
        	 System.out.println("exception" + e);
        }
        
        return tiere;
    }

    @Override
    public boolean deleteOnId(int id) {
        String query = "DELETE FROM Tiere WHERE id = ?";
        
        try (Connection c = DriverManager.getConnection(URL);
             PreparedStatement stmt = c.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
        	 e.printStackTrace();
        }
		return false;
    }

    @Override
    public void add(Tier newTier) {
        
    	String checkIdSQL = "SELECT COUNT(*) FROM Tiere WHERE id = ?";
    	  
    	try (Connection c = DriverManager.getConnection(URL);
    		         PreparedStatement checkStmt = c.prepareStatement(checkIdSQL)) {
    		        
    	    checkStmt.setInt(1, newTier.getId());
    	    
    	    try (ResultSet rs = checkStmt.executeQuery()) {
               if (rs.next() && rs.getInt(1) > 0) {
                   System.out.println("Tier with ID " + newTier.getId() + " already exists.");
                   return;
               }
            }
    		        
	        String insertSQL = "INSERT INTO Tiere (id, name, art, geburtsjahr) VALUES (?, ?, ?, ?)";
	        
	        try (PreparedStatement pstm = c.prepareStatement(insertSQL)) {
	            
	        	pstm.setInt(1, newTier.getId());
	        	pstm.setString(2, newTier.getName());
	        	pstm.setString(3, newTier.getArt());
	        	pstm.setInt(4, newTier.getGeburtsjahr());
	            
	        	pstm.executeUpdate();
	        }
        } catch (SQLException e) {
        	 e.printStackTrace();
        }
    }


}

