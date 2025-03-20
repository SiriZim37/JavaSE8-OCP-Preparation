package aufgaben.InMatrix;

import java.util.Random;

public class IntMatrix {

	private int[][] matrix;

	 
	
	public IntMatrix( int zeilen , int spalten) {
		this.matrix = new int[zeilen][spalten];
	}
	
	public IntMatrix( int zeilen , int spalten , int wert) {
		this.matrix = new int[zeilen][spalten];
		
		for(int x = 0 ; x < zeilen ; x++ ) {
			for(int y = 0 ; y < spalten ; y++) {
				matrix[x][y] = wert;
			}
		}
	}
	
	public int get(int zeilen , int spalten ) {
		
		return matrix[zeilen][spalten];
		 
	}
	
	public void set(int zeilen , int spalten , int wert) {
		matrix[zeilen][spalten] = wert;
	}
	
	/**
	 *  getRandomMatrix muss statische Mothode erzeugen , weil es Konstruktur gibt,
	 *  die auch 3 Parameter(Referenzen) definiert. Dann wird es überladen.
	 *  
	 * @param zeilen
	 * @param spalten
	 * @param wert
	 * @return
	 */
	static IntMatrix getRandomMatrix(int zeilen , int spalten , int wert) {
		
		IntMatrix randMatrix = new IntMatrix(zeilen, spalten);		
		
		Random rand = new Random();

		for(int x = 0 ; x < zeilen ; x++ ) {
			for(int y = 0 ; y < spalten ; y++) {
				randMatrix.matrix[x][y] =  rand.nextInt(wert)+1;
			}
		}
	
		return randMatrix;
	}
	
//	public String toString() {
//		/*
//		 * Actung! Viele Konkatenationen sind langsam.
//		 * Besser ist mit einem Stringbuilder den String zu erzugen.
//		 */
//
//		String result = "";
//		
//		for(int x = 0 ; x < matrix.length ; x++ ) {
//			for(int y = 0 ; y < matrix[x].length ; y++) {
//				result += matrix[x][y];
//				if (y <  matrix[x].length - 1) {
//					result +=", "; 
//		        }	
//			}
//			result +="\n";
//		}
//		return result;
//	}
	

    @Override
    public String toString() {
    	/*
		 * Actung! Viele Konkatenationen sind langsam.
		 * Besser ist mit einem Stringbuilder den String zu erzugen.
		 */
        StringBuilder result = new StringBuilder();

        for (int x = 0; x < this.matrix.length; x++) {
            for (int y = 0; y < this.matrix[x].length; y++) {
                result.append(this.matrix[x][y]);
                if (y < this.matrix[x].length - 1) {
                    result.append(", ");
                }
            }
            result.append("\n");
        }

        return result.toString();
    }
	
	/*
	 * Typ der Vergleichsoperation: 
	 *  Die erste Bedingung verwendet 'instanceof', um den Typ von 'obj' zu prüfen, 
	 *  während die zweite Bedingung 'getClass()' verwendet, um die tatsächliche 'Klasse' von 'obj' und this zu vergleichen.
		
		Verhalten bei Subklassen: 
		Die erste Bedingung '(instanceof)' berücksichtigt Subklassen von 'IntMatrix',
		während die zweite Bedingung ('getClass()') nur die 'genaue Klasse' vergleicht und keine Subklassen berücksichtigt.
		
		Behandlung von null: 
		Die erste Bedingung prüft 'explizit' auf 'null', während die zweite Bedingung 'null' 'nicht explizit' behandelt. 
		Wenn 'obj' 'null' ist, wird die zweite Bedingung jedoch zu einem 'NullPointerException' führen, 
		da getClass() auf null nicht aufgerufen werden kann.
	 */
	public boolean equal(Object obj ) {
		 if (this == obj) { return true; }
		
		 /*
		  *  In der Praxis  Verglcheichen Class Objekt wird besser ! 
		  */
		
//		 if (obj == null || !(obj instanceof IntMatrix)) { return false; }
		  
		 
		 /*
		  * Class objekt für class eindutig 
		  */
		 if( obj.getClass() != getClass() ) {
				return false;
			}
			
			IntMatrix m2 = ((IntMatrix)obj);
			
			if(getRows() != m2.getRows()) {
				return false;
			}
			if(getColumns() != m2.getColumns()) {
				return false;
			}
			
			int[][] arr1 = matrix;
			int[][] arr2 = m2.matrix;
			
			for (int i = 0; i < arr1.length; i++) {
				for (int j = 0; j < arr1[i].length; j++) {
					if(arr1[i][j] != arr2[i][j]) {
						return false;
					}
				}
			}
			
		return true;
	}
	
	public int getRows() {
		return matrix.length;
	}
	public int getColumns() {
		if(getRows()==0) {
			return 0 ; 
		}
		return matrix[0].length;
	}
    public IntMatrix transpose() {
    	
        int zeilen = matrix.length;
        int spalten = matrix[0].length;
        
        IntMatrix trans = new IntMatrix(spalten, zeilen);
      
        for (int x = 0; x< zeilen; x++) {
            for (int y = 0; y < spalten; y++) {
            	trans.matrix[y][x] = matrix[x][y];
            }
        }
        return trans;
    }
	
    public static IntMatrix add(IntMatrix m1, IntMatrix m2) {
    	
        int zeilen1 = m1.matrix.length;
        int spalten1 = m1.matrix[0].length;
        int zeilen2 = m2.matrix.length;
        int spalten2 = m2.matrix[0].length;
        
        int maxRows = Math.max(zeilen1, zeilen2);
        int maxCols = Math.max(spalten1, spalten2);
       
        IntMatrix newMatrix = new IntMatrix(maxRows, maxCols);
        
   
        for (int x = 0; x < maxRows ; x++) {
            for (int y = 0; y < maxCols ; y++) {
            	int val1 = 0; 
            	int val2 = 0;
            	if( x < zeilen1 && y < spalten1) 
            		val1 =	m1.matrix[x][y]  ;
            	if (x < zeilen2 && y < spalten2) 
            		val2 =	m2.matrix[x][y]  ;	
            	newMatrix.matrix[x][y] = val1 + val2;
            }
        }
        return newMatrix;
    }
    
    
 public static IntMatrix multiplizieren(IntMatrix m1, IntMatrix m2) {
    	
        int zeilen1 = m1.matrix.length;
        int spalten1 = m1.matrix[0].length;
        int zeilen2 = m2.matrix.length;
        int spalten2 = m2.matrix[0].length;
        
        int maxRows = Math.max(zeilen1, zeilen2);
        int maxCols = Math.max(spalten1, spalten2);
       
        IntMatrix newMatrix = new IntMatrix(maxRows, maxCols);
        
   
        for (int x = 0; x < maxRows ; x++) {
            for (int y = 0; y < maxCols ; y++) {
            	int val1 = 0; 
            	int val2 = 0;
            	if( x < zeilen1 && y < spalten1) 
            		val1 =	m1.matrix[x][y]  ;
            	if (x < zeilen2 && y < spalten2) 
            		val2 =	m2.matrix[x][y]  ;	
            	newMatrix.matrix[x][y] = val1 * val2;
            }
        }
        return newMatrix;
    }
 
 
 public static IntMatrix divide(IntMatrix m1, IntMatrix m2) {
 	
     int zeilen1 = m1.matrix.length;
     int spalten1 = m1.matrix[0].length;
     int zeilen2 = m2.matrix.length;
     int spalten2 = m2.matrix[0].length;
     
     int maxRows = Math.max(zeilen1, zeilen2);
     int maxCols = Math.max(spalten1, spalten2);
    
     IntMatrix newMatrix = new IntMatrix(maxRows, maxCols);
     

     for (int x = 0; x < maxRows ; x++) {
         for (int y = 0; y < maxCols ; y++) {
        	 int val1 = 0;
             int val2 = 1; // Default to 1 to avoid division by zero
         	

            if (x < zeilen1 && y < spalten1) 
                val1 = m1.matrix[x][y];
            if (x < zeilen2 && y < spalten2) 
                val2 = m2.matrix[x][y];

            if (val2 != 0)
                newMatrix.matrix[x][y] = val1 / val2;
            else
                newMatrix.matrix[x][y] = 0; // or handle as needed
         }
     }
     return newMatrix;
 }
	
}
