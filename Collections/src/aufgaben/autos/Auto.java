package aufgaben.autos;

import java.util.Objects;

/*
 * s. java.time.LocalDate (ist auch Comparable<eigener Basistyp>)
 */
public abstract class Auto implements Comparable<Auto> {
	protected String modell;
	protected int baujahr;
	
	public Auto(String modell, int baujahr) {
		this.modell = modell;
		this.baujahr = baujahr;
	}
	
	@Override
	public int compareTo(Auto a2) {
		int res = modell.compareTo(a2.modell);
		
		if(res==0) {
			res = baujahr - a2.baujahr;
		}
		
		return res;
	}
	
	public String getModell() {
		return modell;
	}
	
	public int getBaujahr() {
		return baujahr;
	}
	
	public String getHersteller() {
		return getClass().getSimpleName();
	}
	
	@Override
	public String toString() {
		return getHersteller() + ". Modell: " + modell + ", Baujahr " + baujahr;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if(obj==null) {
			return false;
		}
		
		if(getClass()!=obj.getClass()) {
			return false;
		}

		Auto a2 = (Auto)obj;
		
		return baujahr == a2.baujahr && Objects.equals(modell, a2.modell);
	}
	
	@Override
	public int hashCode() {
		return baujahr + Objects.hashCode(modell);
	}	
}