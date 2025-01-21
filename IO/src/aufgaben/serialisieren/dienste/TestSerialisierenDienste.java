package aufgaben.serialisieren.dienste;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dienst{
	private String name;

	Dienst() {}
	
	public Dienst(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


class Defragmentierung  extends Dienst{
	
	private int zeitabstand;
	private String laufwerk;
	

	public Defragmentierung(int zeitabstand, String laufwerk) {
		super("Defrag");
		this.zeitabstand = zeitabstand;
		this.laufwerk = laufwerk;
	}
	public int getZeitabstand() {
		return zeitabstand;
	}
	public String getLaufwerk() {
		return laufwerk;
	}
	@Override
	public String toString() {
		return "Zeitabstand(" + zeitabstand + "), LW(" + laufwerk + ")";
	}
}

class SpeicherManager extends Dienst implements Serializable{
	
	private int size;
	transient Defragmentierung defrag;
	

	public SpeicherManager(int size , Defragmentierung defrag) {
		super("S-Man");
		this.size = size;
		this.defrag = defrag;
	}
	 
	@Override
	public String toString() {
		return this.getName() + ". Size: " + size+ ". Defrag-Dienst: " + defrag + "Dienst : " ;
	}
	
	private void writeObject(ObjectOutputStream oos) throws IOException{
		
		oos.defaultWriteObject();

		oos.writeUTF(getName()); 				 // Serialize the name of Dienst
	    oos.writeUTF(defrag.getLaufwerk());		 // Serialize laufwerk
	    oos.writeInt(defrag.getZeitabstand());   // Serialize zeitabstand
		
	}
	
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
	   
		ois.defaultReadObject();
		
		setName(ois.readUTF()); 				 // Deserialize the name of Dienst
        String laufwerk = ois.readUTF(); 		 // Deserialize laufwerk  
        int zeitabstand = ois.readInt();		 // Deserialize zeitabstand
		this.defrag = new Defragmentierung(zeitabstand,laufwerk);
		
	}
}


public class TestSerialisierenDienste {
	/*
	 *  Object
	 *     |
	 *  Dienst <- muss fürs Deserialisieren eines SpeicherManager-Objektes
	 *     |      den noargs-Konstruktor haben
	 *     |
	 *  SpeicherManager <- Serializable
	 * 
	 */
	
	public static void main(String[] args) {

		String fileName = "sManager.bin";
		
		SpeicherManager sManager = new SpeicherManager(2000, new Defragmentierung (3000, "C:\\"));
		  
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
		
			oos.writeObject(sManager);
		
			System.out.println("*** Serialisiert: ");
			System.out.println(sManager);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SpeicherManager sManager2 = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			
			sManager2 = (SpeicherManager) ois.readObject();
			
			System.out.println("\n*** Deserialisiert:");
			System.out.println(sManager2);
			
		}catch (InvalidClassException e) {
			e.printStackTrace();
		} catch (IOException | ClassNotFoundException   e) {
			e.printStackTrace();
		}
		
		System.out.println("Referenzen unterschiedlich: " + (sManager != sManager2)); // true
	}

}
