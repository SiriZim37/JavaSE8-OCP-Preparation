package iterators;

public class A01_WasIstIterator {

	
	/*
	  Iterator<E> Interface (อินเตอร์เฟซ Iterator<E>)
	   - Purpose (จุดประสงค์): 
	     Provides methods to iterate over a collection.
	     ให้เมธอดสำหรับการวนซ้ำในคอลเลคชัน
	   - Key Methods (เมธอดสำคัญ):
	     - boolean hasNext(): 
	       Returns true if the iteration has more elements.
	       คืนค่า true ถ้าการวนซ้ำยังมีองค์ประกอบอีก
	     - E next(): 
	       Returns the next element in the iteration.
	       ส่งคืนองค์ประกอบถัดไปในการวนซ้ำ
	     - void remove(): 
	       Removes the last element returned by the iterator (optional operation).
	       ลบองค์ประกอบล่าสุดที่ส่งคืนโดย Iterator (เป็นการทำงานตามความสมัครใจ) 
	*/

	/*
	 1. Iterable<E> Interface (อินเตอร์เฟซ Iterable<E>)
	   - Purpose (จุดประสงค์): 
	     Represents a collection that can be iterated, allowing access to its elements one by one.
	     แสดงถึงคอลเลคชันที่สามารถวนซ้ำได้ ทำให้เข้าถึงองค์ประกอบได้ทีละตัว
	   - Key Methods (เมธอดสำคัญ):
	     - Iterator<E> iterator(): E
	       Returns an iterator over elements of type `E`.
	       ส่งคืน Iterator ที่สามารถใช้วนซ้ำกับองค์ประกอบประเภท E
	     - default void forEach(Consumer<? super E> action): 
	       Performs the given action for each element of the `Iterable`.
	       ดำเนินการตามที่ระบุสำหรับแต่ละองค์ประกอบใน Iterable
	     - default Spliterator<E> spliterator(): 
	       Creates a `Spliterator` over the elements.
	       สร้าง Spliterator สำหรับองค์ประกอบใน Iterable
	*/

	/*
	2. Collection<E> Interface (อินเตอร์เฟซ Collection<E>)
	   - Purpose (จุดประสงค์): 
	     The root interface for handling groups of objects, known as collections.
	     อินเตอร์เฟซหลักในการจัดการกลุ่มของวัตถุที่เรียกว่าคอลเลคชัน
	   - Key Methods (เมธอดสำคัญ):
	     - boolean add(E e): Adds an element to the collection.
	       เพิ่มองค์ประกอบลงในคอลเลคชัน
	     - boolean remove(Object o): Removes an element from the collection.
	       ลบองค์ประกอบออกจากคอลเลคชัน
	     - int size(): Returns the number of elements in the collection.
	       ส่งคืนจำนวนองค์ประกอบในคอลเลคชัน
	*/

	/*
	3. List<E> Interface (อินเตอร์เฟซ List<E>)
	 	 เป็นส่วนหนึ่งของ java.util package และเป็น sub-interface ของ Collection<E>
		 List คือโครงสร้างข้อมูลที่เก็บ elements ที่เป็นลำดับ (ordered) และสามารถเก็บ duplicates ได้
		 Elements ใน List สามารถเข้าถึงได้โดยใช้ index (ตำแหน่งใน list)
	   - Purpose (จุดประสงค์): 
	     A `Collection` that maintains an ordered sequence of elements with index-based access.
	     เป็นคอลเลคชันที่รักษาลำดับขององค์ประกอบโดยเข้าถึงด้วยดัชนี
	   - Key Implementations (การนำไปใช้สำคัญ):
	     - ArrayList<E>:
	       Resizable-array implementation.
	       อาร์เรย์ที่สามารถปรับขนาดได้
	     - LinkedList<E>:
	       Doubly-linked list implementation.
	       รายการที่ลิงค์สองทาง
	   - Key Methods (เมธอดสำคัญ):	     
		 1. int size()
		    	- Returns the number of elements in the list. (ส่งคืนจำนวน elements ใน list)		
		 2. boolean isEmpty()
		    	- ตรวจสอบว่า list ว่างหรือไม่ (Returns true ถ้า list ไม่มี elements)		
		 3. boolean contains(Object o)
		    	- Returns true ถ้า list มี element ที่ระบุอยู่		
		 4. E get(int index)
		    	- คืนค่าของ element ที่ตำแหน่ง index ที่ระบุใน list		
		 5. E set(int index, E element)
		    	- แทนที่ element ที่ตำแหน่ง index ด้วย element ที่ระบุ		
		 6. void add(int index, E element)
		    	- แทรก element ที่ตำแหน่งที่ระบุใน list (เลื่อน elements อื่นๆ ไปทางขวา)		
		 7. boolean add(E e)
		    	- เพิ่ม element ไปที่ส่วนท้ายของ list	
		 8. E remove(int index)
		    	- ลบ element ที่ตำแหน่งที่ระบุ (เลื่อน elements ที่เหลือไปทางซ้าย)		
		 9. boolean remove(Object o)
		    	- ลบการเกิดขึ้นครั้งแรกของ element ที่ระบุใน list ถ้ามี	
		 10. int indexOf(Object o)
		    	- ส่งคืน index ของการเกิดขึ้นครั้งแรกของ element ที่ระบุ หรือ -1 ถ้าไม่มี		
		 11. int lastIndexOf(Object o)
		    	- ส่งคืน index ของการเกิดขึ้นครั้งสุดท้ายของ element ที่ระบุ หรือ -1 ถ้าไม่มี		
		 12. List<E> subList(int fromIndex, int toIndex) 
		 		- Returns a view of the portion of this list between the specified fromIndex (inclusive) and toIndex (exclusive).
		    	- คืนค่ามุมมองของส่วนหนึ่งของ list ระหว่าง fromIndex (รวม) และ toIndex (ไม่รวม)		
		 13. Iterator<E> iterator()
		    	- คืนค่า iterator สำหรับการวน loop ผ่าน elements ใน list ตามลำดับ		
		 14. ListIterator<E> listIterator()
		    	- คืนค่า list iterator สำหรับการวน loop ผ่าน list ไปข้างหน้าและถอยหลัง	
		 15. ListIterator<E> listIterator(int index)
		    	- คืนค่า list iterator เริ่มต้นที่ตำแหน่งที่ระบุ	
		 การ Implement ของ List:
		 คลาสที่มักจะใช้กับ List<E> ได้แก่:
		 - ArrayList<E> (โครงสร้างข้อมูลที่เป็น dynamic array)
		 - LinkedList<E> (โครงสร้างข้อมูลที่เป็น doubly-linked list)
		 - Vector<E> (โครงสร้างข้อมูลที่เป็น array และ synchronized)
		
		 หมายเหตุ: List interface รองรับ generics ซึ่งหมายความว่าสามารถสร้าง list ที่เก็บข้อมูลเฉพาะประเภทได้
	*/

	/*
	4. Set<E> Interface (อินเตอร์เฟซ Set<E>)
	   - Purpose (จุดประสงค์): 
	     A `Collection` that contains no duplicate elements.
	     เป็นคอลเลคชันที่ไม่มีองค์ประกอบซ้ำกัน
	   - Key Implementations (การนำไปใช้สำคัญ):
	     - HashSet<E>:
	       Implements a `Set` backed by a hash table.
	       นำไปใช้โดยใช้แฮชเทเบิล
	     - LinkedHashSet<E>:
	       Maintains insertion order.
	       รักษาลำดับการแทรก
	   - Key Methods (เมธอดสำคัญ):
	     - boolean add(E e): Adds the specified element to the set if it's not already present.
	       เพิ่มองค์ประกอบลงในเซ็ตถ้าไม่ได้มีอยู่แล้ว
	     - boolean remove(Object o): Removes the specified element from the set.
	       ลบองค์ประกอบที่ระบุออกจากเซ็ต
	*/

	/*
	5. SortedSet<E> Interface (อินเตอร์เฟซ SortedSet<E>)
	   - Purpose (จุดประสงค์): 
	     A set that maintains its elements in ascending order, either according to their natural ordering or by a comparator provided at set creation.
	     เซ็ตที่รักษาองค์ประกอบในลำดับที่เพิ่มขึ้น ตามลำดับธรรมชาติของมันหรือโดยการเปรียบเทียบที่กำหนดในขณะสร้างเซ็ต
	   - Key Implementations (การนำไปใช้สำคัญ):
	     - TreeSet<E>: 
		       Implements the `SortedSet` interface, storing elements in a red-black tree structure.
		       ใช้ TreeSet เพื่อเก็บองค์ประกอบในโครงสร้างต้นไม้สีแดง-ดำ
	   - Relation to NavigableSet (ความสัมพันธ์กับ NavigableSet):
	     - The `NavigableSet<E>` interface extends `SortedSet<E>`, providing additional methods for navigation.
	       อินเตอร์เฟซ `NavigableSet<E>` ขยาย `SortedSet<E>` โดยให้เมธอดการนำทางเพิ่มเติม
	   - Key Methods (เมธอดสำคัญ):
	     - Comparator<? super E> comparator(): 
		       Returns the comparator used to sort the elements, or `null` if the set uses the natural ordering.
		       คืนค่า Comparator ที่ใช้ในการเรียงลำดับองค์ประกอบ หรือ `null` ถ้าเซ็ตใช้การเรียงลำดับตามธรรมชาติ
	     - E first(): 
		       Returns the first (lowest) element in the sorted set.
		       ส่งคืนองค์ประกอบแรก (ต่ำสุด) ในเซ็ตที่เรียงลำดับ
	     - E last(): 
		       Returns the last (highest) element in the sorted set.
		       ส่งคืนองค์ประกอบสุดท้าย (สูงสุด) ในเซ็ตที่เรียงลำดับ
	     - SortedSet<E> headSet(E toElement): 
		       Returns a view of the portion of the set whose elements are strictly less than `toElement`.
		       ส่งคืนมุมมองของส่วนหนึ่งของเซ็ตที่มีองค์ประกอบน้อยกว่า `toElement`
	     - SortedSet<E> tailSet(E fromElement): 
		       Returns a view of the portion of the set whose elements are greater than or equal to `fromElement`.
		       ส่งคืนมุมมองของส่วนหนึ่งของเซ็ตที่มีองค์ประกอบมากกว่าหรือเท่ากับ `fromElement`
	     - SortedSet<E> subSet(E fromElement, E toElement): 
		       Returns a view of the portion of the set whose elements range from `fromElement`, inclusive, to `toElement`, exclusive.
		       ส่งคืนมุมมองของส่วนหนึ่งของเซ็ตที่มีองค์ประกอบอยู่ระหว่าง `fromElement` (รวม) ถึง `toElement` (ไม่รวม)
	*/
	/*
	5.1. NavigableSet<E> Interface (อินเตอร์เฟซ NavigableSet<E>)
	   - Purpose (จุดประสงค์): 
	     A `SortedSet` that provides navigation methods to return the closest matches for given search targets.
	     เป็น `SortedSet` ที่ให้เมธอดการนำทางเพื่อตอบสนองการค้นหาที่ใกล้เคียงที่สุดกับเป้าหมายที่กำหนด
	   - Key Implementations (การนำไปใช้สำคัญ):
	     - TreeSet<E>:
	       		Implements the `NavigableSet` interface, allowing for efficient retrieval and navigation.
	       		ใช้ TreeSet เพื่อให้การดึงข้อมูลและการนำทางที่มีประสิทธิภาพ
	   - Key Methods (เมธอดสำคัญ):
	     - E lower(E e): 
	       		Returns the greatest element less than the given element, or `null` if there is no such element.
	       		ส่งคืนองค์ประกอบที่มากที่สุดน้อยกว่าค่าที่กำหนด หรือ `null` ถ้าไม่มีองค์ประกอบดังกล่าว
	     - E floor(E e): 
	       		Returns the greatest element less than or equal to the given element, or `null` if there is no such element.
	       		ส่งคืนองค์ประกอบที่มากที่สุดน้อยกว่าหรือเท่ากับค่าที่กำหนด หรือ `null` ถ้าไม่มีองค์ประกอบดังกล่าว
	     - E ceiling(E e): 
		       Returns the least element greater than or equal to the given element, or `null` if there is no such element.
		       ส่งคืนองค์ประกอบที่น้อยที่สุดมากกว่าหรือเท่ากับค่าที่กำหนด หรือ `null` ถ้าไม่มีองค์ประกอบดังกล่าว
	     - E higher(E e): 
		       Returns the least element greater than the given element, or `null` if there is no such element.
		       ส่งคืนองค์ประกอบที่น้อยที่สุดมากกว่าค่าที่กำหนด หรือ `null` ถ้าไม่มีองค์ประกอบดังกล่าว
	     - NavigableSet<E> descendingSet(): 
		       Returns a reverse order view of the elements contained in the set.
		       ส่งคืนมุมมองขององค์ประกอบในเซ็ตในลำดับย้อนกลับ
	     - NavigableSet<E> headSet(E toElement, boolean inclusive): 
		       Returns a view of the portion of the set whose elements are less than (or equal to) `toElement`.
		       ส่งคืนมุมมองของส่วนหนึ่งของเซ็ตที่มีองค์ประกอบน้อยกว่าหรือเท่ากับ `toElement`
	     - NavigableSet<E> tailSet(E fromElement, boolean inclusive): 
		       Returns a view of the portion of the set whose elements are greater than (or equal to) `fromElement`.
		       ส่งคืนมุมมองของส่วนหนึ่งของเซ็ตที่มีองค์ประกอบมากกว่าหรือเท่ากับ `fromElement`
	     - NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive): 
		       Returns a view of the portion of the set whose elements range from `fromElement` to `toElement`.
		       ส่งคืนมุมมองของส่วนหนึ่งของเซ็ตที่มีองค์ประกอบอยู่ระหว่าง `fromElement` และ `toElement`
	*/

	/*
	6. Queue<E> Interface (อินเตอร์เฟซ Queue<E>)
	   - Purpose (จุดประสงค์): 
	     A collection designed for holding elements prior to processing, typically in a first-in, first-out (FIFO) order.
	     คอลเลกชันที่ออกแบบมาเพื่อถือองค์ประกอบก่อนการประมวลผล โดยทั่วไปในลำดับเข้าก่อน-ออกก่อน (FIFO)
	   - Key Implementations (การนำไปใช้สำคัญ):
	     - LinkedList<E>: 
	       Can be used as a `Queue` implementation that provides dynamic sizing and efficient insertion and deletion.
	       สามารถใช้ LinkedList เป็นการนำไปใช้ Queue ที่ให้การปรับขนาดแบบไดนามิกและการแทรกและลบที่มีประสิทธิภาพ
	     - PriorityQueue<E>: 
	       A `Queue` implementation that orders its elements based on their natural ordering or a specified comparator.
	       การนำไปใช้ Queue ที่เรียงลำดับองค์ประกอบตามลำดับธรรมชาติหรือ Comparator ที่กำหนด
	   - Key Methods (เมธอดสำคัญ):
	     - boolean add(E e): 
		       Adds the specified element to the queue, returning `true` upon success.
		       เพิ่มองค์ประกอบที่ระบุไปยังคิว คืนค่า `true` หากสำเร็จ
	     - boolean offer(E e): 
		       Inserts the specified element into the queue, returning `true` if successful, or `false` if not.
		       แทรกองค์ประกอบที่ระบุไปยังคิว คืนค่า `true` หากสำเร็จ หรือ `false` หากไม่สำเร็จ
	     - E remove(): 
		       Retrieves and removes the head of the queue. Throws `NoSuchElementException` if the queue is empty.
		       ดึงและลบหัวของคิว หากคิวว่าง จะโยน `NoSuchElementException`
	     - E poll(): 
		       Retrieves and removes the head of the queue, or returns `null` if the queue is empty.
		       ดึงและลบหัวของคิว หรือส่งคืน `null` หากคิวว่าง
	     - E element(): 
		       Retrieves, but does not remove, the head of the queue. Throws `NoSuchElementException` if the queue is empty.
		       ดึงแต่ไม่ลบหัวของคิว หากคิวว่าง จะโยน `NoSuchElementException`
	     - E peek(): 
		       Retrieves, but does not remove, the head of the queue, or returns `null` if the queue is empty.
		       ดึงแต่ไม่ลบหัวของคิว หรือส่งคืน `null` หากคิวว่าง
	*/

	/*
	7. Deque<E> Interface (อินเตอร์เฟซ Deque<E>)
	   - Purpose (จุดประสงค์): 
	     A double-ended queue that allows elements to be added or removed from both ends, supporting both FIFO (first-in, first-out) and LIFO (last-in, first-out) operations.
	     คิวแบบสองด้านที่อนุญาตให้เพิ่มหรือลบองค์ประกอบจากทั้งสองด้าน สนับสนุนการดำเนินการ FIFO (เข้าก่อน-ออกก่อน) และ LIFO (เข้าหลัง-ออกก่อน)
	   - Key Implementations (การนำไปใช้สำคัญ):
	     - LinkedList<E>: 
	       Can be used as a `Deque` implementation, allowing dynamic sizing and efficient insertion and removal at both ends.
	       สามารถใช้ LinkedList เป็นการนำไปใช้ Deque ซึ่งอนุญาตให้ปรับขนาดแบบไดนามิกและการแทรกและลบที่มีประสิทธิภาพที่ทั้งสองด้าน
	     - ArrayDeque<E>: 
	       A resizable array implementation of the `Deque` interface, offering better performance for stack and queue operations.
	       การนำไปใช้ Deque ด้วยอาร์เรย์ที่ปรับขนาดได้ ซึ่งให้ประสิทธิภาพที่ดีกว่าสำหรับการดำเนินการสแต็คและคิว
	   - Key Methods (เมธอดสำคัญ):
	     - void addFirst(E e): 
		       Inserts the specified element at the front of the deque.
		       แทรกองค์ประกอบที่ระบุที่ด้านหน้าของ Deque
	     - void addLast(E e): 
		       Inserts the specified element at the end of the deque.
		       แทรกองค์ประกอบที่ระบุที่ด้านท้ายของ Deque
	     - boolean offerFirst(E e): 
		       Inserts the specified element at the front of the deque, returning `true` upon success.
		       แทรกองค์ประกอบที่ระบุที่ด้านหน้า Deque คืนค่า `true` หากสำเร็จ
	     - boolean offerLast(E e): 
		       Inserts the specified element at the end of the deque, returning `true` upon success.
		       แทรกองค์ประกอบที่ระบุที่ด้านท้าย Deque คืนค่า `true` หากสำเร็จ
	     - E removeFirst(): 
		       Retrieves and removes the first element of the deque. Throws `NoSuchElementException` if the deque is empty.
		       ดึงและลบองค์ประกอบแรกของ Deque หาก Deque ว่าง จะโยน `NoSuchElementException`
	     - E removeLast(): 
		       Retrieves and removes the last element of the deque. Throws `NoSuchElementException` if the deque is empty.
		       ดึงและลบองค์ประกอบสุดท้ายของ Deque หาก Deque ว่าง จะโยน `NoSuchElementException`
	     - E pollFirst():		
	     		ดึงและลบองค์ประกอบแรก (หัว) ของ Deque คืนค่า null หาก Deque ว่าง
		 - E pollLast()	:	
		 		ดึงและลบองค์ประกอบสุดท้าย (ท้าย) ของ Deque คืนค่า null หาก Deque ว่าง
	     - E getFirst(): 
		       Retrieves, but does not remove, the first element of the deque. Throws `NoSuchElementException` if the deque is empty.
		       ดึงแต่ไม่ลบองค์ประกอบแรกของ Deque หาก Deque ว่าง จะโยน `NoSuchElementException`
	     - E getLast(): 
		       Retrieves, but does not remove, the last element of the deque. Throws `NoSuchElementException` if the deque is empty.
		       ดึงแต่ไม่ลบองค์ประกอบสุดท้ายของ Deque หาก Deque ว่าง จะโยน `NoSuchElementException`
	     - E peekFirst(): 
		       Retrieves, but does not remove, the first element of the deque, or returns `null` if the deque is empty.
		       ดึงแต่ไม่ลบองค์ประกอบแรกของ Deque หรือส่งคืน `null` หาก Deque ว่าง
	     - E peekLast(): 
		       Retrieves, but does not remove, the last element of the deque, or returns `null` if the deque is empty.
		       ดึงแต่ไม่ลบองค์ประกอบสุดท้ายของ Deque หรือส่งคืน `null` หาก Deque ว่าง
	*/

	/*
	8. Map<K, V> Interface (อินเตอร์เฟซ Map<K, V>)
	   - Purpose (จุดประสงค์): 
	     Stores key-value pairs, where each key is unique.
	     เก็บคู่ของคีย์และค่า ซึ่งแต่ละคีย์จะไม่ซ้ำกัน
	   - Key Implementations (การนำไปใช้สำคัญ):
	     - HashMap<K, V>:
	       Implements the `Map` interface using hash buckets for fast access.
	       นำอินเตอร์เฟซ Map ไปใช้โดยใช้แฮชบัคเก็ตสำหรับการเข้าถึงที่รวดเร็ว
	     - LinkedHashMap<K, V>:
	       Maintains insertion order.
	       รักษาลำดับการแทรก
	     - TreeMap<K, V>:
	       Implements a `SortedMap` where keys are sorted either by natural order or by a provided `Comparator`.
	       นำ SortedMap ไปใช้ ซึ่งคีย์จะถูกจัดเรียงตามลำดับธรรมชาติหรือตัวเปรียบเทียบที่ระบุ
	   - Key Methods (เมธอดสำคัญ):
	     - V put(K key, V value):
		     	Adds a key-value pair to the Map.
		        เพิ่มคู่คีย์และค่าเข้าไปใน Map
	     - V get(Object key): 
		     	Returns the value associated with the specified key.
		        คืนค่าที่จับคู่กับคีย์ที่กำหนด
	   	 - V get(Object key): 
		     	Returns the value associated with the specified key.
		      	คืนค่าที่จับคู่กับคีย์ที่กำหนด
	   	 - V remove(Object key): 
	     		Removes the key-value pair associated with the specified key.
	     		(ลบคู่คีย์-ค่าที่จับคู่กับคีย์นั้นออก)
	   	 - boolean containsKey(Object key): 
	     		Checks if the specified key is present in the Map.
	    		(ตรวจสอบว่ามีคีย์อยู่ใน Map หรือไม่)
	   	 - boolean containsValue(Object value): 
	     		Checks if the specified value is present in the Map.
	     	 	(ตรวจสอบว่ามีค่าอยู่ใน Map หรือไม่)
	   	 - Set<K> keySet(): 
	     		Returns a Set of all keys in the Map.
	    		(คืนค่าเป็น Set ของคีย์ทั้งหมด)	
	   	 - Collection<V> values(): 
	     		Returns a Collection of all values in the Map.
	     	 	(คืนค่าเป็น Collection ของค่าทั้งหมด)
	   	 - Set<Map.Entry<K, V>> entrySet(): 
	    		Returns a Set of key-value pairs (Map entries).
	     		(คืนค่าเป็น Set ของคู่คีย์-ค่า)
	   	 - default V putIfAbsent(K key, V value): 
	   			Adds a key-value pair to the Map only if the specified key is not already present.
	     		(เพิ่มคู่คีย์-ค่าเข้าไปใน Map เฉพาะเมื่อคีย์ที่กำหนดยังไม่มีอยู่)
	*/


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
