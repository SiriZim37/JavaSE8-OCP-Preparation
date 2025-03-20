package aufgaben.lists;

import java.util.*;
import java.util.Iterator;

public class Hafen implements Iterable<Schiff> {


	private List<Schiff> schiffs = new ArrayList<>(); 
	private static final int MAX = 100;
	
	public Hafen() {
	}
	
	public Hafen(List<Schiff> s) {
		this.schiffs = s ;
	}
	

	public void setSchiffs(List<Schiff> schiffs) {
		this.schiffs = schiffs;
	}

	public List<Schiff> getSchiffs() {
		return schiffs;
	}

	
	public int getAnzahl() {
		return schiffs.size();
	}
	
	public int getFreierPlaetze() {
		return MAX - schiffs.size();
	}
	
	public void anzeigeAllSchiffe() {
		 System.out.println(schiffs);
	}
	
	public boolean hinzufügen(Schiff schiff) {
		if (schiffs.size() < MAX) {
	         	this.schiffs.add(schiff);
	        return true; 
	    } else {
//	        System.out.println("Kein Platz mehr im Hafen. Maximale Kapazität erreicht.");
	        return false; 
	    }
	}
	
	public boolean isEmptyPlatz() {
		return getAnzahl() < MAX;
	}
	
	public void shiffVerlassen(int index) {
		if (index >= 0 && index < schiffs.size()) {
			this.schiffs.remove(index);
		} else {
		   System.out.println("Index out of bounds: " + index);
		}
	}
	
	public int schiffFinden(Schiff s) {
		  return this.schiffs.indexOf(s);
	}
	
	public int schiffFinden(String name) {
		 for (int i = 0; i < schiffs.size(); i++) {
	        if (schiffs.get(i).getName().equals(name)) {
	            return i;
	        }
	     }
	     return -1; 
	}
	
	@Override
	public String toString() {
		return "Hafen (Schiffe: " + getAnzahl() +" . Freie Plätze: " + getFreierPlaetze() + ")"; 
	}

	@Override
	public Iterator<Schiff> iterator() {
		return schiffs.iterator();
	}

}
