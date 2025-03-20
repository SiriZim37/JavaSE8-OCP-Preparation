package lists;

import java.util.*;

/*
 * 1. Iterable Interface
 * 		- The Iterable interface is the root interface for all collection classes that 
 * 			support iteration over elements.
 * 		*Methode :  Iterator<T> iterator(): Returns an iterator over a set of elements of type T.
 * 
 * 2. Collection Interface
 * 		- The Collection interface is the root interface of the Java Collections Framework 
 * 			that represents a group of objects, known as elements.
 * 		*Methode : 
 * 			- boolean add(E e): Adds an element to the collection.
 * 			- boolean remove(Object o): Removes a specified element from the collection.
 * 			- int size(): Returns the number of elements in the collection.
 * 			- boolean contains(Object o): Checks if the collection contains the specified element.
 *
 * 3. List Interface
 * 			- The List interface extends Collection and represents an ordered collection
 * 				(also known as a sequence).
 * 			Key Features:
 * 			 - Allows duplicate elements.
 * 			 - Elements are ordered (i.e., they have a specific position/index).
 *		 *Methods:
 * 			 - E get(int index): Returns the element at the specified position.
 *			 - E set(int index, E element): Replaces the element at the specified position.
 * 			 - void add(int index, E element): Inserts an element at the specified position.
 * 			 - E remove(int index): Removes the element at the specified position.
 * 
 * 4. LinkedList Class
 * 			- LinkedList is a class that implements the List interface and also 
 * 					the Deque interface. It represents a doubly linked list where each element (node) has references to the previous and next elements.
 *			Key Features:
 * 				- Efficient insertions and deletions as nodes can be easily 
 * 					added or removed by adjusting pointers.
 * 				- Less efficient random access compared to ArrayList as elements
 * 					 must be traversed sequentially.
 * 			Common Use Cases: 
 * 				When you need frequent insertion and deletion of elements, 
 * 				particularly at the beginning or end of the list.
 * 
 * 5. ArrayList Class
 * 		 	-  ArrayList is a resizable array implementation of the List interface. 
 * 					It uses an underlying array to store the elements.
 * 			Key Features:
 * 				- Provides fast random access to elements (O(1) time complexity for get() and set()).
 * 				- Slower insertions and deletions, especially in the middle of the list, 
 * 						because elements need to be shifted.
 * 				- Automatically resizes itself when the underlying array is full.	
 * 			Common Use Cases: 
 * 				When you need fast access to elements and don’t require frequent 
 * 				insertions or deletions in the middle of the list.
 * 
 * 
 * 
 * 
 *Summary:
	- Iterable: The root interface for any object that can be iterated over.
	- Collection: The root interface for all collections (groups of objects), with subinterfaces like List.
	- List: An ordered collection that allows duplicates and provides positional access.
	- LinkedList: A List implementation backed by a doubly linked list, good for frequent insertions/deletions.
	- ArrayList: A List implementation backed by a resizable array, good for fast access to elements.
 */
public class B01_ArrayList_und_Array {

	public static void main(String[] args) {

		/*
		 * Die Länge des Arrays bleibt konstant
		 */
		String[] arr = new String[3];	

		
		System.out.println("arr.length: " + arr.length);
		
		/*
		 * 	Die Größe einer Liste darf geändert werden
		 */
		List<String> list = new ArrayList<>();
		
		System.out.println("1 -. list.size(): " + list.size()); 	// 0 
		
		list.add("mo");
		System.out.println("2 -. list.size(): " + list.size()); 	// 1

		list.add("di");
		list.add("mi");
		System.out.println("3 -. list.size(): " + list.size()); 	// 3
		
		for (int i = 0; i < 100; i++) {
			list.add("i" + i);
		}
	}

}
