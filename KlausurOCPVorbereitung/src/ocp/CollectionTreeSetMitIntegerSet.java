package ocp;

import java.util.TreeSet;


class HODog {
	int id;
	public HODog(int id) {
		this.id = id;
	}
}

class GoodDog implements Comparable<GoodDog>{
	int id;
	public GoodDog(int id) {
		this.id = id;
	}
	public int compareTo(GoodDog d2) {
		return id - d2.id ;
	}
}
public class CollectionTreeSetMitIntegerSet {


	public static void main(String[] args) {
		
		TreeSet<HODog> setDogs = new TreeSet<>();
		TreeSet<Integer> setInteger = new TreeSet<>();
//		
//		setDogs.add(new HODog(1));
//		setDogs.add(new HODog(2));
//		setDogs.add(new HODog(1));
		
		setInteger.add(1);
		setInteger.add(2);
		setInteger.add(3);
		
		System.out.println(setDogs.size() + " " + setInteger.size());
		
		/*
		 * Ausgabe :  HoDog must implement Comparable becase Treeset need compare object
		 * java.lang.ClassCastException: class ocp.HODog cannot be cast to class java.lang.Comparable
		 */
		
		// Lösung 
		TreeSet<GoodDog> setGoodDogs = new TreeSet<>();
		setGoodDogs.add(new GoodDog(1));
		setGoodDogs.add(new GoodDog(2));
		setGoodDogs.add(new GoodDog(1));
		System.out.println(setGoodDogs.size() + " " + setInteger.size());
		
		
	}
}
