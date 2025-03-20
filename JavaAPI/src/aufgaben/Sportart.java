package aufgaben;

//A1
public class Sportart  implements Comparable<Sportart> {
	
	protected String name ; 
	protected boolean olmpisch; 

	public Sportart( String name , boolean olmpisch) {
		this.name = name;
		this.olmpisch =olmpisch;
		
	}

	public String getName() {
		
		final int MIN = 4 ;
		if(name!=null && name.length() < MIN) {
			throw new IllegalArgumentException("Name der Sportart miss mind. " + MIN + "  Zeichen enthalten: " + name);
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOlmpisch() {
		return olmpisch;
	}

	public void setOlmpisch(boolean olmpisch) {
		this.olmpisch = olmpisch;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;      
		if (obj == null )
			return false;
		if( !(obj instanceof Sportart)) {
			return false;
		}
		Sportart sport = ( Sportart ) obj ;	
		return this.name.equals(sport.name) && this.olmpisch == sport.olmpisch;
	}
	
	
	// Es wird nicht funktioniert , weil noch nicht überschreiben wurde.
	// Wenn es ohne @Override steht, wird es nicht benutzt.
//	public boolean equals(Sportart s) {
//		return this.name.equals(s.name) ;  
//	}
//	

	@Override
	public String toString() {
		
		return "name : " + name + " is olmpisch : " + olmpisch;
	}

	  
	@Override
	public int compareTo(Sportart sp) {
		
		  return this.name.compareTo(sp.name);
	}


	
	 
}
