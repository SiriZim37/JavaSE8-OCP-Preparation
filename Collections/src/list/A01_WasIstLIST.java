package list;

public class A01_WasIstLIST {
/*
	    List<E>
	├── ArrayList<E>
	│   ├── Characteristics:
	│   │   ├── Resizable array implementation:
	│   │   │   ├── Expands when more space is needed.
	│   │   │   └── Provides fast access to elements via index.
	│   │   ├── Allows null elements:
	│   │   │   └── Null values can be stored in the list.
	│   │   └── Fast access time (O(1)):
	│   │       ├── Average time for accessing an element.
	│   │       └── Adding and removing from the middle is slower (O(n)).
	│   └── Methods:
	│       ├── `add(E e)`: void - Adds the specified element to the end of the list.
	│       ├── `add(int index, E element)`: void - Adds the specified element at the specified position.
	│       ├── `remove(int index)`: E - Removes and returns the element at the specified position.
	│       ├── `remove(Object o)`: boolean - Removes the first occurrence of the specified element from the list (returns true if successful).
	│       ├── `get(int index)`: E - Returns the element at the specified position.
	│       ├── `size()`: int - Returns the number of elements in the list.
	│       ├── `isEmpty()`: boolean - Returns true if the list is empty.
	│       ├── `clear()`: void - Removes all elements from the list.
	│       ├── `indexOf(Object o)`: int - Returns the index of the first occurrence of the specified element, or -1 if not found.
	│       ├── `toArray()`: Object[] - Returns an array containing all elements in the list.
	│       └── `iterator()`: Iterator<E> - Returns an iterator that iterates through the elements in the list.
	│
	├── LinkedList<E>
	│   ├── Characteristics:
	│   │   ├── Doubly linked list implementation:
	│   │   │   ├── Each element (node) has references to the previous and next node.
	│   │   │   └── Allows easy addition and removal of elements.
	│   │   ├── Allows null elements:
	│   │   │   └── Null values can be stored in the list.
	│   │   └── Fast add and remove times (O(1)):
	│   │       ├── Efficient for adding or removing elements at the ends.
	│   │       └── Average access time for elements (O(n)).
	│   └── Methods:
	│       ├── `add(E e)`: void - Adds the specified element to the end of the list.
	│       ├── `add(int index, E element)`: void - Adds the specified element at the specified position.
	│       ├── `remove(int index)`: E - Removes and returns the element at the specified position.
	│       ├── `remove(Object o)`: boolean - Removes the first occurrence of the specified element from the list (returns true if successful).
	│       ├── `get(int index)`: E - Returns the element at the specified position.
	│       ├── `size()`: int - Returns the number of elements in the list.
	│       ├── `isEmpty()`: boolean - Returns true if the list is empty.
	│       ├── `clear()`: void - Removes all elements from the list.
	│       ├── `indexOf(Object o)`: int - Returns the index of the first occurrence of the specified element, or -1 if not found.
	│       ├── `toArray()`: Object[] - Returns an array containing all elements in the list.
	│       └── `iterator()`: Iterator<E> - Returns an iterator that iterates through the elements in the list.
	│
	├── Vector<E>
	│   ├── Characteristics:
	│   │   ├── Similar to ArrayList but synchronized:
	│   │   │   └── Thread safety through synchronization of methods.
	│   │   ├── Allows null elements:
	│   │   │   └── Null values can be stored in the list.
	│   │   └── Expansion strategy: doubles in size:
	│   │       ├── Expands when reaching current capacity.
	│   │       └── May be useful in scenarios requiring thread safety.
	│   └── Methods:
	│       ├── `add(E e)`: void - Adds the specified element to the end of the list.
	│       ├── `add(int index, E element)`: void - Adds the specified element at the specified position.
	│       ├── `remove(int index)`: E - Removes and returns the element at the specified position.
	│       ├── `remove(Object o)`: boolean - Removes the first occurrence of the specified element from the list (returns true if successful).
	│       ├── `get(int index)`: E - Returns the element at the specified position.
	│       ├── `size()`: int - Returns the number of elements in the list.
	│       ├── `isEmpty()`: boolean - Returns true if the list is empty.
	│       ├── `clear()`: void - Removes all elements from the list.
	│       ├── `indexOf(Object o)`: int - Returns the index of the first occurrence of the specified element, or -1 if not found.
	│       ├── `toArray()`: Object[] - Returns an array containing all elements in the list.
	│       └── `iterator()`: Iterator<E> - Returns an iterator that iterates through the elements in the list.
	│
	└── Stack<E> (inherits from Vector)
	    ├── Characteristics:
	    │   ├── Follows LIFO (Last In, First Out) structure:
	    │   │   └── The most recently added element is removed first.
	    └── Methods:
	        ├── `push(E item)`: void - Adds the specified element to the top of the stack.
	        ├── `pop()`: E - Removes and returns the element at the top of the stack.
	        └── `peek()`: E - Returns the element at the top without removing it.
	
	

	 List<E>
	├── ArrayList<E>
	│   ├── Characteristics:
	│   │   ├── การนำไปใช้งานแบบอาเรย์ที่ขยายได้:
	│   │   │   ├── ขยายขนาดเมื่อจำเป็นต้องใช้พื้นที่มากขึ้น
	│   │   │   └── ให้การเข้าถึงที่รวดเร็วต่อองค์ประกอบผ่านดัชนี
	│   │   ├── อนุญาตให้องค์ประกอบเป็น null:
	│   │   │   └── ค่าที่เป็น null สามารถจัดเก็บในรายการได้
	│   │   └── เวลาการเข้าถึงที่รวดเร็ว (O(1)):
	│   │       ├── เวลาเฉลี่ยในการเข้าถึงองค์ประกอบ
	│   │       └── การเพิ่มและลบในตำแหน่งกลางช้า (O(n))
	│   └── Methods:
	│       ├── `add(E e)`: void - เพิ่มองค์ประกอบที่ระบุที่ส่วนท้ายของรายการ
	│       ├── `add(int index, E element)`: void - เพิ่มองค์ประกอบที่ระบุในตำแหน่งที่ระบุ
	│       ├── `remove(int index)`: E - ลบและคืนค่าองค์ประกอบที่ตำแหน่งที่ระบุ
	│       ├── `remove(Object o)`: boolean - ลบองค์ประกอบแรกที่พบจากรายการ (คืนค่า true หากลบสำเร็จ)
	│       ├── `get(int index)`: E - คืนค่าองค์ประกอบที่ตำแหน่งที่ระบุ
	│       ├── `size()`: int - คืนค่าจำนวนองค์ประกอบในรายการ
	│       ├── `isEmpty()`: boolean - คืนค่า true หากรายการว่างเปล่า
	│       ├── `clear()`: void - ลบองค์ประกอบทั้งหมดออกจากรายการ
	│       ├── `indexOf(Object o)`: int - คืนค่าดัชนีขององค์ประกอบแรกที่พบ หรือ -1 หากไม่มี
	│       ├── `toArray()`: Object[] - คืนค่าอาเรย์ที่มีองค์ประกอบทั้งหมดในรายการ
	│       └── `iterator()`: Iterator<E> - คืนค่าอิเตอร์เรเตอร์ที่ใช้วนซ้ำผ่านองค์ประกอบในรายการ
	│
	├── LinkedList<E>
	│   ├── Characteristics:
	│   │   ├── การนำไปใช้งานแบบลิงก์คู่:
	│   │   │   ├── องค์ประกอบแต่ละตัว (โหนด) มีการอ้างอิงไปยังโหนดก่อนหน้าและโหนดถัดไป
	│   │   │   └── อนุญาตให้เพิ่มและลบองค์ประกอบได้ง่าย
	│   │   ├── อนุญาตให้องค์ประกอบเป็น null:
	│   │   │   └── ค่าที่เป็น null สามารถจัดเก็บในรายการได้
	│   │   └── เวลาการเพิ่มและลบที่รวดเร็ว (O(1)):
	│   │       ├── มีประสิทธิภาพในการเพิ่มหรือลบองค์ประกอบที่ปลาย
	│   │       └── เวลาเฉลี่ยในการเข้าถึงองค์ประกอบ (O(n))
	│   └── Methods:
	│       ├── `add(E e)`: void - เพิ่มองค์ประกอบที่ระบุที่ส่วนท้ายของรายการ
	│       ├── `add(int index, E element)`: void - เพิ่มองค์ประกอบที่ระบุในตำแหน่งที่ระบุ
	│       ├── `remove(int index)`: E - ลบและคืนค่าองค์ประกอบที่ตำแหน่งที่ระบุ
	│       ├── `remove(Object o)`: boolean - ลบองค์ประกอบแรกที่พบจากรายการ (คืนค่า true หากลบสำเร็จ)
	│       ├── `get(int index)`: E - คืนค่าองค์ประกอบที่ตำแหน่งที่ระบุ
	│       ├── `size()`: int - คืนค่าจำนวนองค์ประกอบในรายการ
	│       ├── `isEmpty()`: boolean - คืนค่า true หากรายการว่างเปล่า
	│       ├── `clear()`: void - ลบองค์ประกอบทั้งหมดออกจากรายการ
	│       ├── `indexOf(Object o)`: int - คืนค่าดัชนีขององค์ประกอบแรกที่พบ หรือ -1 หากไม่มี
	│       ├── `toArray()`: Object[] - คืนค่าอาเรย์ที่มีองค์ประกอบทั้งหมดในรายการ
	│       └── `iterator()`: Iterator<E> - คืนค่าอิเตอร์เรเตอร์ที่ใช้วนซ้ำผ่านองค์ประกอบในรายการ
	│
	├── Vector<E>
	│   ├── Characteristics:
	│   │   ├── คล้ายกับ ArrayList แต่มีการซิงโครไนซ์:
	│   │   │   └── ความปลอดภัยของเธรดผ่านการซิงโครไนซ์ของวิธีการ
	│   │   ├── อนุญาตให้องค์ประกอบเป็น null:
	│   │   │   └── ค่าที่เป็น null สามารถจัดเก็บในรายการได้
	│   │   └── ยุทธศาสตร์การขยาย: การเพิ่มขนาดเป็นสองเท่า:
	│   │       ├── ขยายขนาดเมื่อถึงขีดจำกัดปัจจุบัน
	│   │       └── อาจมีประโยชน์ในสถานการณ์ที่ต้องการความปลอดภัยของเธรด
	│   └── Methods:
	│       ├── `add(E e)`: void - เพิ่มองค์ประกอบที่ระบุที่ส่วนท้ายของรายการ
	│       ├── `add(int index, E element)`: void - เพิ่มองค์ประกอบที่ระบุในตำแหน่งที่ระบุ
	│       ├── `remove(int index)`: E - ลบและคืนค่าองค์ประกอบที่ตำแหน่งที่ระบุ
	│       ├── `remove(Object o)`: boolean - ลบองค์ประกอบแรกที่พบจากรายการ (คืนค่า true หากลบสำเร็จ)
	│       ├── `get(int index)`: E - คืนค่าองค์ประกอบที่ตำแหน่งที่ระบุ
	│       ├── `size()`: int - คืนค่าจำนวนองค์ประกอบในรายการ
	│       ├── `isEmpty()`: boolean - คืนค่า true หากรายการว่างเปล่า
	│       ├── `clear()`: void - ลบองค์ประกอบทั้งหมดออกจากรายการ
	│       ├── `indexOf(Object o)`: int - คืนค่าดัชนีขององค์ประกอบแรกที่พบ หรือ -1 หากไม่มี
	│       ├── `toArray()`: Object[] - คืนค่าอาเรย์ที่มีองค์ประกอบทั้งหมดในรายการ
	│       └── `iterator()`: Iterator<E> - คืนค่าอิเตอร์เรเตอร์ที่ใช้วนซ้ำผ่านองค์ประกอบในรายการ
	│
	└── Stack<E> (สืบทอดจาก Vector)
	    ├── Characteristics:
	    │   ├── มีโครงสร้างแบบ LIFO (Last In, First Out):
	    │   │   └── องค์ประกอบที่เพิ่มล่าสุดจะถูกลบก่อน
	    └── Methods:
	        ├── `push(E item)`: void - เพิ่มองค์ประกอบที่ด้านบนของกอง
	        ├── `pop()`: E - ลบและคืนค่าองค์ประกอบที่ด้านบนของกอง
	        └── `peek()`: E - คืนค่าองค์ประกอบที่ด้านบนโดยไม่ลบออก

 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
