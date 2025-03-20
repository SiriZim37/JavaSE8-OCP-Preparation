package lists;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class B03_List_API {

	/*
	 * Hier werden nicht alle Methoden gezeigt,
	 * aber alle prüfungsrelevanten
	 */
	public static void main(String[] args) {
		test_CollectionAPI();
		test_ListAPI();
	}

	static void test_ListAPI() {
		System.out.println("\n*** List-Methoden");
		
		List<String> list = new ArrayList<String>();

		list.add("DI");
		list.add("DO");
		
		/*
		 * E get(int index)
		 */
		System.out.println("1. get(int index): ");

		/*
		 * Garantierte Reiehenfolge der Elemente. 
		 * So, wie sie hinzugefügt wurden:
		 * 
		 * 	DI DO
		 */
		for(int i=0; i<list.size(); i++) {
			String s = list.get(i);
			System.out.print(s + " ");
		}
		System.out.println();
		
		/*
		 * void add(int index, E e)
		 * 
		 * Hinzufügen (nicht ersetzen!)
		 */
		list.add(0, "MO");
		System.out.println("2. list: " + list); // [MO, DI, DO]

		list.add(2, "MI");
		System.out.println("3. list: " + list); // [MO, DI, MI, DO]
		
		try {
			list.add(5, "So.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Falscher Index für add(int, E)");
		}
		
		/*
		 * E set(int index, E element)
		 * 
		 * Ersetzt das Element an der Stelle index, liefert 
		 * das ersetzte Element zurück
		 */
		String replaced = list.set(2, "Mittwoch");
		System.out.println("4. replaced: " + replaced); // MI
		System.out.println("5. list: " + list); // [MO, DI, Mittwoch, DO]
		
		try {
			list.set(20, "So.");
		} catch (IndexOutOfBoundsException e) {
			System.err.println("Flascher Index für set");
		}
		
		/*
		 * E remove(int index)
		 * 
		 * Löscht das Element an der Stelle index und 
		 * liefert das Element zurück 
		 */
		String removed = list.remove(2);
		System.out.println("6. removed: " + removed); // Mittwoch
		System.out.println("7. list: " + list); // [MO, DI, DO]
		
		/*
		 * int indexOf(Object o) 
		 * 
		 * Sucht das Element o und liefert seine Position zurück,
		 * oder -1, wenn das Element nicht gefunden wird.
		 */
		
		int pos = list.indexOf("Mittwoch");
		System.out.println("8. indexOf 'Mittwoch': " + pos); // -1
		
		pos = list.indexOf("DO");
		System.out.println("9. indexOf 'DO': " + pos); // 2
		
		/*
		 * List<E> subList(int fromInclusive, int toExclusive)
		 * 
		 * wird im Bsp. TestSubList gezeigt
		 */
	}
	
	static void test_CollectionAPI() {
		System.out.println("*** Collection-Methoden");
		
		Collection<String> coll = new ArrayList<String>();
		
		/*
		 * int size()
		 */
		
		System.out.println("1. size(): " + coll.size()); // 0
		
		/*
		 * boolean isEmpty()
		 */
		
		boolean empty = coll.isEmpty();
		System.out.println("2. isEmpty(): " + empty); // true
		 
		/*
		 * boolean add(E e)
		 */
		
		boolean added = coll.add("mo");
		System.out.println("3. add: " + added); // true
		
		System.out.println("4. size(): " + coll.size()); // 1
		System.out.println("5. isEmpty(): " + coll.isEmpty()); // false
		
		/*
		 * boolean addAll(Collection c)
		 * 
		 * kopiert alle Referenzen aus c
		 */
		List<String> list = new ArrayList<String>();
		list.add("di");
		list.add("mi");
		
		coll.addAll(list);
		
		System.out.println("6. size(): " + coll.size()); // 3
		System.out.println("7. coll: " + coll); // [mo, di, mi]
		
		/*
		 * boolean contains(Object o)
		 * 
		 * überprüft, ob es das Element o gibt 
		 */
		boolean result = coll.contains("Freitag");
		System.out.println("8. contains 'Freitag': " + result); // false
		
		result = coll.contains("di");
		System.out.println("9. contains 'di': " + result); // true
		
		/*
		 * boolean remove(Object o)
		 * 
		 * sucht und entfernt das Element o
		 */
		result = coll.remove("Freitag");
		System.out.println("10. remove 'Freitag': " + result); // false
		
		result = coll.remove("di");
		System.out.println("11. remove 'di': " + result); // true
		
		System.out.println("12. coll: " + coll); // [mo, mi]
		
		/*
		 * boolean removeIf(Predicate)
		 * 
		 * wird im Bsp. B04 getestet
		 */
		
		/*
		 * void clear()
		 */
		coll.clear();
		
		System.out.println("13. size(): " + coll.size()); // 0
		System.out.println("14. isEmpty(): " + coll.isEmpty()); // true
		System.out.println("15. coll: " + coll); // []
		
	}
}
