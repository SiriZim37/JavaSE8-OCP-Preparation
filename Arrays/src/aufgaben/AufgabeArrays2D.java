package aufgaben;

public class AufgabeArrays2D {

	public static void main(String[] args) {

		
		System.out.println("#### A1.");
		int[][] arr = createArray( 4 , 5) ;

		System.out.println("#### A2.& A6. ");
		printArray( arr);
		
		System.out.println("\n#### A3.");
		arr[1][1] = 5 ;
		printArray(arr);
		
	
		System.out.println("\n#### A4.");
		setArrayValue(arr,2); // diese Methode macht irgendwas mit dem Array-Objekt
		printArray(arr);
		
		System.out.println("\n#### Test set new Value by position");
		setNewInt(arr); // n[0][3] = 15;
		printArray(arr); 
		
		
		System.out.println("\n#### A5.& A6.");
//		arr = createArray(4,5,2);
		printArray(arr);
		

		
		
		System.out.println("\n#### A7.");
		char[][] charArr = createBorderArray(5,'X');
		printArray(charArr);
		charArr = createBorderArray(5,10,'X');
		printArray(charArr);
	}

	
	// A1
	static int[][] createArray(int x , int y){
		return new  int[x][y];
	}
	
	// A2  
	static void printArray( int[][] arr ) {

		for(int x = 0 ; x < arr.length ; x++) {
			for(int y = 0 ; y < arr[x].length ; y++) {
				 System.out.print(arr[x][y]);
	             if (y < arr[x].length - 1) {
	                 System.out.print(", "); // Komma für A6
	             }	
			}
			System.out.println();
		}
	}
	
	// A7 charArray
	static void printArray( char[][] arr ) {

		for (char[] x : arr) {
            for (char y : x) {
                System.out.print(y);
            }
            System.out.println();
        }		
	}
	
	// A4
	static void setArrayValue(int[][] arr , int val) {
		for(int i = 0 ; i < arr.length ; i++) {
			for ( int j = 0 ; j < arr[i].length ; j++) {
				arr[i][j] = val;
			}
		}
		
	}
	
	
	static void setNewInt(int[][] n) {
		n[0][3] = 15;
	}
	// A5
	static int[][] createArray(int x , int y , int value){
		int[][] arr = new int[x][y]; 
		for(int i = 0 ; i < x ; i++) {
			for(int j = 0 ; j < y ; j++) {
				arr[i][j] = value;
			}
		}
		return arr;
	}
	
	// A7 
	static char[][] createBorderArray(int dim , char ch ) {
		char[][] arr = new char[dim][dim];
		 
		for(int x = 0 ; x < dim ; x++) {
			for( int y = 0 ; y < dim ; y++ ) {
				  if (x == 0 || x == dim - 1 || y == 0 || y == dim - 1) {
					  arr[x][y] = ch; 
				  }else {
					  arr[x][y] = ' '; // Innenbereich mit Leerzeichen füllen
	               }
			}
		}
		return arr;
	}
	
	static char[][] createBorderArray(int hoehe , int breite , char ch ) {
		boolean fuellen = false;
		
		char[][] arr = new char[hoehe][breite];
		 
		for(int x = 0 ; x < hoehe ; x++) {
			for( int y = 0 ; y < breite ; y++ ) {
				  if (x == 0 || x == hoehe - 1 || y == 0 || y == breite - 1) {
					  arr[x][y] = ch; 
				  }else {
					  arr[x][y] = ' '; // Innenbereich mit Leerzeichen füllen
	               }
			}
		}
		return arr;
	}
	
	
		
}
