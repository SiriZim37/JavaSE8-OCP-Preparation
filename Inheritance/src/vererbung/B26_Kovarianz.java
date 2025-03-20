package vererbung;

public class B26_Kovarianz {

	public static void main(String[] args) {
		
		Pflanze p1 = new Pflanze();
		Pflanze p2 = new Pflanze();
		
		Baum b1 = new Baum();
		Baum b2 = b1.create();
		System.out.println(b2);
		
		Ahorn a1 = new Ahorn();
		Ahorn a2 = a1.create();
		System.out.println(a2);

	}

}

class Pflanze{
	
	public Pflanze create() {
		return new Pflanze();
	}

	public Object getObject() {
		return new Object();
	}
	
	// Kovariant erlaubt nicht primitive Typ
	public double getPI() {
		return Math.PI;
	}
}

class Baum extends Pflanze{
	// seit Java 5 ist es erlaut , als Rückgabetyp einer überschriebenen Methode
	// einen Subtyp der geerbten Mthode zu verwenden.
	// Vorher duftesn man nut senselben Typen verwenden. 
	
	// Das nennt man dann einen kovarianten Rückgabetypen. 
	// Baum ist ein Kovarianter Typ zu Pflanze (Subtyp)
	@Override
	public Baum create() {
		return new Baum(); // Rückgabekovarianz: gibt ein Baum-Objekt zurück
	}
	
	 @Override
	public Integer getObject() {
		// TODO Auto-generated method stub
		return 42;
	}
	
	// Funktionniert nicht bei primitiven Datatypen
//	@Override
//	public int getPI() {
//		return Math.PI;
//	}
	
}

class  Ahorn extends Baum{
	
	 @Override
	 public Ahorn create() {
	     return new Ahorn(); // Rückgabekovarianz: gibt ein Tulpe-Objekt zurück
	 }
	
	 
}


