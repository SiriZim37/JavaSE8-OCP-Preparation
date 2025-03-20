package inheritance;

class Building {
	 
	Building() {
//		super();
		System.out.print("b ");
	}
	
	Building(String name) {
//		 this();
	}
	
	Building(String name1 , String name2) {
//		 this();
	}
	
}

class House extends Building{
	House(){
		System.out.print("h ");
	}
	
	House(String name){
		System.out.print("hn " + name);
	}
	
	House(String name1 , String name2){
		super(name1,name2);
		System.out.print("hn " + name1);
	}
	
}

class House2 extends Building{
	House2(){
		System.out.print("h ");
	}
	
	House2(String name){
		this();
		System.out.print("hn " + name);
	}
	
	House2(String name1 , String name2){
		super(name1,name2);
		System.out.print("hn " + name1);
	}
	
}

public class KonstruktorenAufrufen {

	
	public static void main(String[] args) {

		/*
		 * House(name = "x "){
		 * 
		 * 		House(){
		 * 			Building(){
		 * 				super();
		 * 				System.out.print("b");
		 * 			}
		 * 			
		 * 			System.out.print("h"); // < this();
		 * 		}
		 * 		
		 * 		System.out.print("hn " + name);
		 * 		
		 * }
		 */
		new House("x ");

		// Asugabe : b hn x 
		System.out.println();
		new House2("x ");
		// Asugabe : b hn x 
	}

}
