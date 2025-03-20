package aufgaben.InMatrix;



public class AufgabeIntMatrix {

	public static void main(String[] args) {
	
		System.out.println("m1:"); 
		IntMatrix m1 = new IntMatrix( 2, 3);
		System.out.println(m1);
		
		
		System.out.println("m2:");
		IntMatrix m2 = new IntMatrix(5, 3,100);
		System.out.println(m2);
			
		int i = m1.get(1, 2);
		System.out.println("m1.get(1, 2): " + i);
		m1.set(1,1 ,15);
		System.out.println(m1);
		
		int j = m2.get(1, 2);
		System.out.println("m2.get(1, 2): " + j);
		System.out.println(m2);
		
		
		
		System.out.println("\nm3;");
		IntMatrix m3 = IntMatrix.getRandomMatrix(4, 6, 200);
		System.out.println(m3);
		
		
		boolean checkMatrix =  m1.equal(m2);
		System.out.println("\nm1.equals(m2):" + checkMatrix);
		
		
		 IntMatrix m4 = new IntMatrix(2, 3);
		 IntMatrix m5 = new IntMatrix(2, 3 , 10);
		 IntMatrix m6 = new IntMatrix(2, 3 , 10);		 
		 IntMatrix m7 = new IntMatrix(4, 5);

		 System.out.println("\nm1.equals(m4):" +  m1.equal(m4));
		 System.out.println("\nm1.equals(m5):" +  m1.equal(m5));
		 System.out.println("\nm5.equals(m6):" +  m5.equal(m6));
		 System.out.println("\nm6.equals(m7):" +  m6.equal(m7));
		 
		 
		    IntMatrix mA = new IntMatrix(4, 5, 6);
			System.out.println("1. soll = true, ist = " + mA.equals(mA));
			
			IntMatrix mB = new IntMatrix(4, 5, 6);
			System.out.println("2. soll = true, ist = " + mA.equals(mB));
			
			IntMatrix mC = new IntMatrix(4, 5);
			System.out.println("3. soll = false, ist = " + mA.equals(mC));
			
			IntMatrix mD = new IntMatrix(4, 5, 6);
			mD.set(1, 1, -7);
			System.out.println("4. soll = false, ist = " + mA.equals(mD));
			
			IntMatrix mE = new IntMatrix(3, 5, 6);
			System.out.println("5. soll = false, ist = " + mA.equals(mE));
			
			IntMatrix mF = new IntMatrix(4, 4, 6);
			System.out.println("6. soll = false, ist = " + mA.equals(mF));
			
		 IntMatrix trans = m1.transpose();
	     System.out.println("\nTransposed m1:");
	     System.out.print(trans);
	     
	     
	     IntMatrix m8 = new IntMatrix(4, 5 ,5);
		 System.out.println("\nm8:");
		 System.out.println(m8);
		 
		 IntMatrix transm8 = m8.transpose();
		 System.out.println("\nTransposed m8:");
	     System.out.print(transm8);
	     
	     
	     System.out.println("\nSum: 8 & 5 ");
	     IntMatrix sum =  IntMatrix.add(m8, m5);
	     System.out.println(sum);
	     
	     System.out.println("\nMultiple:");
	     IntMatrix multiple =  IntMatrix.multiplizieren(m1, m5);
	     System.out.println(multiple);
	     
	     System.out.println("\nMultiple.2:");
	     IntMatrix multiple2 =  IntMatrix.multiplizieren(m8, m5);
	     System.out.println(multiple2);

	     System.out.println("\nm8:");
	     System.out.println(m8);
		 
	     IntMatrix m9 = new IntMatrix(4, 5 ,10);
		 System.out.println("\nm9:");
		 System.out.println(m9);
	     
	     System.out.println("\nDivide.1:");
	     IntMatrix divide1 = IntMatrix.divide(m8, m9);
	     System.out.print(divide1);
	}

}
