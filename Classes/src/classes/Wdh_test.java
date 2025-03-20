package classes;

class Auto1{	
	int baujahr; 
}

class Auto2{	
	int baujahr;	 
}


public class Wdh_test {

	public static void main(String[] args) {

		
		/// TEST 1 /// 
		Auto1 a1 = new Auto1(); /*   Object wird in Heap und reservieren und dann speichert in Stack a1[addressnumber] : dann macht baujahr = 0 */
		
		Auto1 a2 = a1; /* Referez a1 wird die Addresse kopiert dann macht Referez a2 auch baujahr = 0 */
		
		a2.baujahr = 2021;  	/*  Der referenze soll Objekt , die berets stellt, finden , wo die Adresse gespeichert wird*/
								/* Dann mach Objeckt in heap baujarh = 2021*/
	
		System.out.println(a1.baujahr);		/* deswegen hat Refereze a1  baujahr = 2021 */
		

		/// TEST 2 /// 
		Auto2 b1 = new Auto2();		/* a1 wird  auf dem Stack reservieren.*/
		Auto2 b2 = process(b1);		/* b2 wird reserviert im Stack b2 = müll 
		 							 -  Aufrufen process(b1) : Variable auf dem  Stack wird auch reservieren. 
		 							    Es steht die Addresse von Objekt b1 a[12345] 	
		 							    dann wird baujahr in Objekt finden = 2021 
		 							    return Anweizung : eine Kopie der Variable wird in CPU hochladen.
		 							  Es wird zurückgelieferten Wert in b2 kopieren.*/
		System.out.println(b2.baujahr);  /* Das Objekt in der Referenz hat bereits baujahr 2021 */
		
	
	}
	
	static Auto2 process(Auto2 a) {
		a.baujahr = 2021;
		return a;
	}

}

/* ------------------------------------------------------------------------------------------------------------------------------------
		public class Auto2 {
		    int baujahr; // instance variable, stored in heap
		}
		
		public class Main {
		    public static void main(String[] args) {
		        Auto2 b1 = new Auto2(); // b1 reference stored in stack, Auto2 object stored in heap
		        Auto2 b2 = process(b1); // b2 reference stored in stack, points to the same Auto2 object in heap
		    }
		
		    static Auto2 process(Auto2 a) {
		        a.baujahr = 2021; // modifies the Auto2 object in heap
		        return a; // returns reference to the modified Auto2 object
		    }
		}

		Memory Allocation and Flow
		1.Main Method Execution:
		
		-When the main method is called, a stack frame for main is created.
		-Auto2 b1 = new Auto2();:
			.The reference variable b1 is created and stored in the stack.
			.new Auto2() creates an Auto2 object in the heap, and b1 holds the reference to this object.
		
		2.Calling process Method:
		
		-Auto2 b2 = process(b1);:
			.The method process is called with b1 as an argument, creating a new stack frame for process.
			.The reference b1 is passed to the process method, so a in the process method points to the same Auto2 object in the heap that b1 points to.
		
		3.Inside the process Method:
		
		-a.baujahr = 2021;:
			The instance variable baujahr of the Auto2 object in the heap is updated to 2021.
		-return a;:
			.The reference to the Auto2 object is returned.
			.The returned reference is stored in b2 in the main method's stack fram
*/
