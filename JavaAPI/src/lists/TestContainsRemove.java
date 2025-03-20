package lists;

import java.util.ArrayList;
import java.util.List;

class Blume{
	private int preis ; 
	
	public Blume(int preis ) {
		this.preis = preis ; 
	}
	@Override
	public String toString() {

		return "Blume ( " + preis + " )";
	}
	
	@Override
	public boolean equals(Object obj) {
		if( !(obj instanceof Blume)) {
			return false;
		}
		
		Blume b2 = (Blume)obj;
		return this.preis == b2.preis;
	}
	
}
public class TestContainsRemove {

	public static void main(String[] args) {


		List<Blume> list = new ArrayList<Blume>();
		
		System.out.println("1. size(): " + list.size());	// 0 
		
		Blume b1 = new Blume(100);
		list.add(b1);
		list.add(new Blume(120));
		
		System.out.println("2. size(): " + list.size());	// 2 
		
		System.out.println("3. contains(): " + list.contains(b1));	// true 
		System.out.println("3. contains(): " + list.contains( new Blume(120)));	// true
		
		System.out.println("5. vor remove : " + list);	// [Blume ( 100 ), Blume ( 120 )]
		System.out.println("6. remove() : " + list.remove(new Blume(120)));	// true
		System.out.println("7. nach remove() : " + list);	// [Blume ( 100 )]
			
		

	}

}
