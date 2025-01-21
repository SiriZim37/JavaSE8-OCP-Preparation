package aufgaben.interfacesI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

class OSReverseComparator implements Comparator<OS>{
	
	public int compare(OS os1, OS os2) {
		String name1 = os1.getName();
		String name2 = os2.getName();
		int compareName=  name2.compareTo( name2)  ;
		
		int version1 = os1.getVersion();
		int version2 = os2.getVersion();
		return compareName != 0 ? compareName : ( version2 - version1 )  ;
	}
}


public class OSInterfaceTest {

	public static void main(String[] args) {

		System.out.println("#2.");
		OS[] osArray =  { 	new OS( "Linux" , 3 ) , 
							new OS( "Windows" , 95 ) , 
						 	new OS( "Mac" , 9 ) ,
							new OS( "Linux" , 1 ) };
		System.out.println("\n#3. ");
		printTable(osArray);
		
		System.out.println("\n#4. aufsteigend");
		
		/* Es wird ohne Comparable java.lang.ClassCastException ,wenn die Array nicht comparable ist. 
		 * Arrays.sort(osArray);	
		 */
	    
	    Arrays.sort(osArray);	
	    
	    printTable(osArray);
	    
	    System.out.println("\n#6. ");
	    OS key = new OS("Linux", 1);
        int index = Arrays.binarySearch(osArray, key);
        System.out.println("Gefunden 'Linux 1' an Index : " + index);
        key = new OS( "Mac" , 9 );
        index = Arrays.binarySearch(osArray, key);
        System.out.println("Gefunden 'Max 9' an Index : " + index);
        
        
        
	    System.out.println("\n#5. absteigend");
	    Comparator<OS> cmp = new OSReverseComparator();    
//	    Comparator<OS> cmp = Comparator.reverseOrder();
	    
		Arrays.sort(osArray , cmp);
	    printTable(osArray);
	    
	    System.out.println("\n#7. ");
	    key = new OS("Windows", 95);
	    index = Arrays.binarySearch(osArray, key, cmp);  
	    System.out.println("Gefunden 'Windows 95' an Index : " + index);
	    key = new OS( "Linux" , 3 );
	    index = Arrays.binarySearch(osArray, key, cmp);  
	    System.out.println("Gefunden 'Linux 3' an Index : " + index);
	
	    System.out.println("\n#8. shuffle Array");
	    shuffle(osArray);
	    printTable(osArray);
	    

	    
	}
	
	static void printTable(OS[] osArr ) {
		 for (int i = 0; i < osArr.length; i++) {
	         System.out.format("| %d.  | %-8s | %-3d |%n", i + 1, osArr[i].getName() , osArr[i].getVersion() );
	    }
	}
	
	static void shuffle(OS[] osArr) {
	    Random rand = new Random();
	    for (int i = osArr.length - 1; i > 0; i--) {
	        int index = rand.nextInt(i + 1);
	        OS temp = osArr[index];
	        osArr[index] = osArr[i];
	        osArr[i] = temp;
	    }
	}
	

}


