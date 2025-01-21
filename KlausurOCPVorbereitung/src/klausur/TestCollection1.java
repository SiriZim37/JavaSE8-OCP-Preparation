package klausur;

public class TestCollection1 {
/*
 * 
 Was kompiliert?
Eine oder mehrere richtige Antworten sind möglich.

[   ] java.util.Collection coll = new java.util.Collection();
[   ] java.util.Collection coll = new java.util.ArrayList();
[   ] java.util.List coll = new java.util.HashSet();
[   ] java.util.Set coll = new java.util.TreeSet();
 */
	
	public static void main(String[] args) {
		
		
//		java.util.Collection coll1 = new java.util.Collection(); >> java.util.Collection ist ein Interface und kann nicht direkt instanziiert werden.
		java.util.Collection coll2 = new java.util.ArrayList();
//		java.util.List coll3 = new java.util.HashSet();			 >> HashSet implementiert das Interface Set, nicht List.
		java.util.Set coll4 = new java.util.TreeSet();
		
	}
}
