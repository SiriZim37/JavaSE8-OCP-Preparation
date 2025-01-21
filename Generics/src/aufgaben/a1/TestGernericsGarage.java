package aufgaben.a1;

class Fahrzeug{
	 private String name;
	 
	 public Fahrzeug(String name) {
	     this.name = name;
	 }

	public String toString() {
		return name;
	}
}
class PKW extends Fahrzeug {	
	public PKW(String name) {
		super(name);
	}
}
class LKW extends Fahrzeug {
	public LKW(String name) {
		super(name);
	}
}


// # Generische Klasse Garage, die nur Fahrzeuge akzeptiert
class Garage< T extends Fahrzeug>{
	private T fahrzeug;
	
	void reinfahren(T fahrzeug) {
		this.fahrzeug = fahrzeug;
	}
	
    public T getFahrzeug() {
        return fahrzeug;
    }

    public String toString() {
    	if(fahrzeug==null) {
			return "Die Garage ist leer";
		}
    	return "In der Garage steht " + fahrzeug.getClass().getSimpleName();
    }
}

public class TestGernericsGarage {

	public static void main(String[] args) {

		Fahrzeug f ; 
		
		f = new PKW("Audi");		// Fahrzeug IS-A PKW
		f= new LKW("Mercedes");		// Fahrzeug IS-A LKW
		
		PKW meinPkw = new PKW("Audi");
		LKW meinLkw = new LKW("Mercedes");
			
		
//		lkw = pkw; 							//# LKW ist kein PKW
//		pkw = lkw;							//# PKW ist kein LKW
		
		Garage<PKW>  garagePKW = new Garage<PKW>();
		Garage<LKW>  garageLKW	= new Garage<LKW>();
		
		System.out.println("1. PKW-Garage. " + garagePKW);
		System.out.println("2. LKW-Garage. " + garageLKW);
		
		garagePKW.reinfahren(meinPkw); 		// # In eine Garage für LKWs darf nur ein LKW reinfahren 
		garageLKW.reinfahren(meinLkw); 		// # In eine Garage für PKWs darf nur ein PKW reinfahren 
		
//		garageLKW.reinfahren(meinPkw);		// # Garage für PKW ist KEINE Garage für LKW
//		garagePKW.reinfahren(meinLkw); 		
		

//		garagePKW = garageLKW; 	  			//  Inkompatible Typen (Nicht erlaubt)
//		garageLKW = garagePKW;	  			//  Inkompatible Typen (Nicht erlaubt)
		
		PKW pkw1 = garagePKW.getFahrzeug();
//		LKWs lkw1 = garagePKW.getFahrzeug();
		System.out.println(pkw1);
		
//		PKWs pkw2 = garageLKW.getFahrzeug();
		LKW lkw2 = garageLKW.getFahrzeug();
		System.out.println(lkw2);
		
//		Garage<String> sinnlos; // cf: String passt nicht für den Type Bound
	}

}
