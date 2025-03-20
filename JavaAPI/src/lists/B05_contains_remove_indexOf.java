package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Dozent{
	private int id;
	private String name;
	
	public Dozent(int id , String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "(" + id + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		Dozent d2 = (Dozent)obj;
		return id== d2.id && Objects.equals(name , d2.name); // vergleich nur deselben Class 
	}
	
	
}

public class B05_contains_remove_indexOf {

	public static void main(String[] args) {
		
		testDozent();
		testStrings(); 

	}
	
	static void testDozent() {
		System.out.println("*** mit Dozent");
		List<Dozent> list = new ArrayList<Dozent>();
		
		list.add(new Dozent(0, "Peter"));
		list.add(new Dozent(1, "Paul"));
		list.add(new Dozent(2, "Mary"));
		
		System.out.println("1. list : " + list); // [Peter(0), Paul(1), Mary(2)]
		
		System.out.println("2. contains : " + list.contains(new Dozent(1,"Paul")) ); // false
		
		System.out.println("3. indexOf : " + list.indexOf(new Dozent(1,"Paul")) );	// 1
		
		System.out.println("4. remove : " + list.remove(new Dozent(1,"Paul")) );	// true
		
		System.out.println("4. remove : " + list.remove(new Dozent(1,"Paul")) );	// false
		
		System.out.println("5. list : " + list );	// [Peter(0), Mary(2)]
		
		
	}
	static void testStrings() {
		System.out.println("\n*** mit Strings");
		
		List<String> list = new ArrayList<String>();
		
		list.add("mo");
		list.add(new String("di"));	// nur zum Testen, ansonsten ist kein neuse Objekt
		list.add("mi");
		
		System.out.println("1. list : " + list); // [mo, id, mi]
		
		System.out.println("2. contains : " + list.contains("di"));	// true
		
		System.out.println("3. indexOf : " + list.indexOf("di"));	// 1
		
		System.out.println("4. remove : " + list.remove("di"));	//  true
		
		System.out.println("5. list: " + list); //	 [mo, mi]
		
	}
}
