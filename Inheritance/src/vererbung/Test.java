package vererbung;


class Auto{
	
	private int id;		// definiert private : private wird nicht vererbt.
	
	private void check() {}	 // definiert private 
	
	static class PKW extends Auto{  
		void wasHatEinPKW(){
//			System.out.println(id); // cf Cannot make a static reference to the non-static field id
			System.out.println(super.id); // ok
//			check();
		}
		
		@Override
		public String toString() { return "";}
	
//		@Override
//		void check() { } // cf : The method check() of type Auto.PKW must override or implement a supertype method
	}
	
}

public class Test {

	public static void main(String[] args) {
		

	}

}
