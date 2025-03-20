package aufgaben.hafen;

public class Schiff {
	
	private String name;
	
	Schiff(){ this.name = "" ;} // set default empty name
	
	Schiff(String name){
		this.name = name;
	}

	public String getName() {	   
		return name;
	}
	
	public void setName(String name) {
		this.name = name;		
	}
	
	public String toString() {
		return name;
	}
}
