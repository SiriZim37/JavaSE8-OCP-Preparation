package coll;

public class A01_collection_hierarchy {

	/*,
	  In Java SE 8, the Collection interface is a root interface in the Java Collections Framework. 
	  It represents a group of objects, known as elements. 
	  This interface provides basic methods to manipulate the collection of elements, 
	  including adding, removing, and checking for elements.
	  
	  ใน Java SE 8, Collection เป็นอินเทอร์เฟซรากฐานใน Java Collections Framework 
	  ซึ่งเป็นตัวแทนของกลุ่มของวัตถุที่เรียกว่า องค์ประกอบ (elements) อินเทอร์เฟซนี้จัดเตรียมวิธีการพื้นฐาน
	  ในการจัดการคอลเลกชันขององค์ประกอบ รวมถึงการเพิ่ม การลบ และการตรวจสอบว่าองค์ประกอบอยู่ในคอลเลกชันหรือไม่
	  
         


Collection<E>
├── Set<E>
│   ├── Characteristics:
│   │   ├── Unordered collection of unique elements:
│   │   │   └── Does not allow duplicate elements.
│   │   ├── Allows null elements:
│   │   │   └── Null values can be stored in the set.
│   │   └── Not synchronized (not thread-safe):
│   │       └── Requires external synchronization if used in a concurrent environment.
│   └── Methods:
│       ├── `add(E e)`: boolean - Adds the specified element to the set (returns true if successful).
│       ├── `remove(Object o)`: boolean - Removes the specified element from the set (returns true if successful).
│       ├── `contains(Object o)`: boolean - Returns true if the set contains the specified element.
│       ├── `size()`: int - Returns the number of elements in the set.
│       ├── `isEmpty()`: boolean - Returns true if the set is empty.
│       ├── `clear()`: void - Removes all elements from the set.
│       ├── `iterator()`: Iterator<E> - Returns an iterator over the elements in the set.
│       ├── `toArray()`: Object[] - Returns an array containing all elements in the set.
│       └── `toArray(T[] a)`: T[] - Returns an array containing all elements in the set; the runtime type of the returned array is that of the specified array.
│
├── List<E>
│   ├── Characteristics:
│   │   ├── Ordered collection of elements:
│   │   │   └── Allows duplicates and maintains the order of insertion.
│   │   ├── Allows null elements:
│   │   │   └── Null values can be stored in the list.
│   │   └── Indexed access to elements:
│   │       └── Elements can be accessed by their position in the list.
│   └── Methods:
│       ├── `add(E e)`: boolean - Adds the specified element to the end of the list (returns true if successful).
│       ├── `remove(int index)`: E - Removes and returns the element at the specified position.
│       ├── `get(int index)`: E - Returns the element at the specified position.
│       ├── `size()`: int - Returns the number of elements in the list.
│       ├── `isEmpty()`: boolean - Returns true if the list is empty.
│       ├── `clear()`: void - Removes all elements from the list.
│       ├── `iterator()`: Iterator<E> - Returns an iterator over the elements in the list.
│       ├── `toArray()`: Object[] - Returns an array containing all elements in the list.
│       └── `toArray(T[] a)`: T[] - Returns an array containing all elements in the list; the runtime type of the returned array is that of the specified array.
│
├── Queue<E>
│   ├── Characteristics:
│   │   ├── Ordered collection designed for holding elements prior to processing:
│   │   │   └── Typically follows FIFO (First In, First Out) order.
│   │   ├── Allows null elements:
│   │   │   └── Null values can be stored in the queue.
│   │   └── Not synchronized (not thread-safe):
│   │       └── Requires external synchronization if used in a concurrent environment.
│   └── Methods:
│       ├── `add(E e)`: boolean - Adds the specified element to the queue (returns true if successful).
│       ├── `remove()`: E - Removes and returns the head of the queue.
│       ├── `peek()`: E - Retrieves but does not remove the head of the queue.
│       ├── `size()`: int - Returns the number of elements in the queue.
│       ├── `isEmpty()`: boolean - Returns true if the queue is empty.
│       ├── `clear()`: void - Removes all elements from the queue.
│       ├── `iterator()`: Iterator<E> - Returns an iterator over the elements in the queue.
│       └── `toArray()`: Object[] - Returns an array containing all elements in the queue.
│
└── Map<K, V>
    ├── Characteristics:
    │   ├── Collection of key-value pairs:
    │   │   └── Each key is unique, but values can be duplicated.
    │   ├── Allows null keys and values:
    │   │   └── Depending on the implementation, null values and sometimes null keys are allowed.
    │   └── Not synchronized (not thread-safe):
    │       └── Requires external synchronization if used in a concurrent environment.
    └── Methods:
        ├── `put(K key, V value)`: V - Associates the specified value with the specified key (returns the previous value associated with the key, or null if there was no mapping).
        ├── `remove(Object key)`: V - Removes the mapping for the specified key (returns the previous value associated with the key, or null if there was no mapping).
        ├── `get(Object key)`: V - Returns the value to which the specified key is mapped, or null if the map contains no mapping for the key.
        ├── `size()`: int - Returns the number of key-value pairs in the map.
        ├── `isEmpty()`: boolean - Returns true if the map is empty.
        ├── `clear()`: void - Removes all mappings from the map.
        ├── `containsKey(Object key)`: boolean - Returns true if the map contains a mapping for the specified key.
        ├── `containsValue(Object value)`: boolean - Returns true if the map maps one or more keys to the specified value.
        ├── `keySet()`: Set<K> - Returns a Set view of the keys contained in the map.
        ├── `values()`: Collection<V> - Returns a Collection view of the values contained in the map.
        └── `entrySet()`: Set<Map.Entry<K, V>> - Returns a Set view of the mappings contained in the map.


Collection<E>
├── Set<E>
│   ├── ลักษณะ:
│   │   ├── คอลเลกชันที่ไม่มีลำดับขององค์ประกอบที่ไม่ซ้ำกัน:
│   │   │   └── ไม่อนุญาตให้มีองค์ประกอบซ้ำกัน
│   │   ├── อนุญาตให้องค์ประกอบเป็นค่า null:
│   │   │   └── สามารถเก็บค่าที่เป็น null ในเซ็ตได้
│   │   └── ไม่ซิงโครไนซ์ (ไม่ปลอดภัยในเธรด):
│   │       └── ต้องมีการซิงโครไนซ์ภายนอกหากใช้ในสภาพแวดล้อมที่มีการทำงานพร้อมกัน
│   └── เมธอด:
│       ├── `add(E e)`: boolean - เพิ่มองค์ประกอบที่ระบุลงในเซ็ต (ส่งคืน true ถ้าสำเร็จ)
│       ├── `remove(Object o)`: boolean - ลบองค์ประกอบที่ระบุออกจากเซ็ต (ส่งคืน true ถ้าสำเร็จ)
│       ├── `contains(Object o)`: boolean - ส่งคืน true ถ้าเซ็ตมีองค์ประกอบที่ระบุ
│       ├── `size()`: int - ส่งคืนจำนวนองค์ประกอบในเซ็ต
│       ├── `isEmpty()`: boolean - ส่งคืน true ถ้าเซ็ตว่าง
│       ├── `clear()`: void - ลบองค์ประกอบทั้งหมดออกจากเซ็ต
│       ├── `iterator()`: Iterator<E> - ส่งคืนอิตเตอร์เรเตอร์สำหรับองค์ประกอบในเซ็ต
│       ├── `toArray()`: Object[] - ส่งคืนอาร์เรย์ที่มีองค์ประกอบทั้งหมดในเซ็ต
│       └── `toArray(T[] a)`: T[] - ส่งคืนอาร์เรย์ที่มีองค์ประกอบทั้งหมดในเซ็ต โดยอาร์เรย์ที่ส่งคืนจะมีประเภทตามอาร์เรย์ที่ระบุ
│
├── List<E>
│   ├── ลักษณะ:
│   │   ├── คอลเลกชันที่มีลำดับขององค์ประกอบ:
│   │   │   └── อนุญาตให้มีองค์ประกอบซ้ำกันและรักษาลำดับของการแทรก
│   │   ├── อนุญาตให้องค์ประกอบเป็นค่า null:
│   │   │   └── สามารถเก็บค่าที่เป็น null ในลิสต์ได้
│   │   └── การเข้าถึงตามดัชนีขององค์ประกอบ:
│   │       └── สามารถเข้าถึงองค์ประกอบตามตำแหน่งในลิสต์ได้
│   └── เมธอด:
│       ├── `add(E e)`: boolean - เพิ่มองค์ประกอบที่ระบุไปยังจุดสิ้นสุดของลิสต์ (ส่งคืน true ถ้าสำเร็จ)
│       ├── `remove(int index)`: E - ลบและส่งคืนองค์ประกอบที่ตำแหน่งที่ระบุ
│       ├── `get(int index)`: E - ส่งคืนองค์ประกอบที่ตำแหน่งที่ระบุ
│       ├── `size()`: int - ส่งคืนจำนวนองค์ประกอบในลิสต์
│       ├── `isEmpty()`: boolean - ส่งคืน true ถ้าลิสต์ว่าง
│       ├── `clear()`: void - ลบองค์ประกอบทั้งหมดออกจากลิสต์
│       ├── `iterator()`: Iterator<E> - ส่งคืนอิตเตอร์เรเตอร์สำหรับองค์ประกอบในลิสต์
│       ├── `toArray()`: Object[] - ส่งคืนอาร์เรย์ที่มีองค์ประกอบทั้งหมดในลิสต์
│       └── `toArray(T[] a)`: T[] - ส่งคืนอาร์เรย์ที่มีองค์ประกอบทั้งหมดในลิสต์ โดยอาร์เรย์ที่ส่งคืนจะมีประเภทตามอาร์เรย์ที่ระบุ
│
├── Queue<E>
│   ├── ลักษณะ:
│   │   ├── คอลเลกชันที่มีลำดับที่ออกแบบมาเพื่อเก็บองค์ประกอบก่อนการประมวลผล:
│   │   │   └── โดยทั่วไปจะทำตามลำดับ FIFO (First In, First Out)
│   │   ├── อนุญาตให้องค์ประกอบเป็นค่า null:
│   │   │   └── สามารถเก็บค่าที่เป็น null ในคิวได้
│   │   └── ไม่ซิงโครไนซ์ (ไม่ปลอดภัยในเธรด):
│   │       └── ต้องมีการซิงโครไนซ์ภายนอกหากใช้ในสภาพแวดล้อมที่มีการทำงานพร้อมกัน
│   └── เมธอด:
│       ├── `add(E e)`: boolean - เพิ่มองค์ประกอบที่ระบุไปยังคิว (ส่งคืน true ถ้าสำเร็จ)
│       ├── `remove()`: E - ลบและส่งคืนองค์ประกอบแรกในคิว
│       ├── `peek()`: E - ดึงแต่ไม่ลบองค์ประกอบแรกในคิว
│       ├── `size()`: int - ส่งคืนจำนวนองค์ประกอบในคิว
│       ├── `isEmpty()`: boolean - ส่งคืน true ถ้าคิวว่าง
│       ├── `clear()`: void - ลบองค์ประกอบทั้งหมดออกจากคิว
│       ├── `iterator()`: Iterator<E> - ส่งคืนอิตเตอร์เรเตอร์สำหรับองค์ประกอบในคิว
│       └── `toArray()`: Object[] - ส่งคืนอาร์เรย์ที่มีองค์ประกอบทั้งหมดในคิว
│
└── Map<K, V>
    ├── ลักษณะ:
    │   ├── คอลเลกชันของคู่กุญแจ-ค่า:
    │   │   └── กุญแจแต่ละรายการจะต้องไม่ซ้ำกัน แต่ค่าสามารถซ้ำกันได้
    │   ├── อนุญาตให้มีกุญแจและค่าเป็น null:
    │   │   └── ขึ้นอยู่กับการนำไปใช้ ค่าที่เป็น null และบางครั้งกุญแจที่เป็น null จะถูกอนุญาต
    │   └── ไม่ซิงโครไนซ์ (ไม่ปลอดภัยในเธรด):
    │       └── ต้องมีการซิงโครไนซ์ภายนอกหากใช้ในสภาพแวดล้อมที่มีการทำงานพร้อมกัน
    └── เมธอด:
        ├── `put(K key, V value)`: V - เชื่อมโยงค่าที่ระบุไว้กับกุญแจที่ระบุ (ส่งคืนค่าก่อนหน้านี้ที่เชื่อมโยงกับกุญแจ หรือ null ถ้าไม่มีการเชื่อมโยง)
        ├── `remove(Object key)`: V - ลบการเชื่อมโยงสำหรับกุญแจที่ระบุ (ส่งคืนค่าก่อนหน้านี้ที่เชื่อมโยงกับกุญแจ หรือ null ถ้าไม่มีการเชื่อมโยง)
        ├── `get(Object key)`: V - ส่งคืนค่าที่เชื่อมโยงกับกุญแจที่ระบุ หรือ null ถ้าคุณไม่มีการเชื่อมโยง
        ├── `size()`: int - ส่งคืนจำนวนคู่กุญแจ-ค่าที่อยู่ในแผนที่
        ├── `isEmpty()`: boolean - ส่งคืน true ถ้าแผนที่ว่าง
        ├── `clear()`: void - ลบการเชื่อมโยงทั้งหมดออกจากแผนที่
        ├── `containsKey(Object key)`: boolean - ส่งคืน true ถ้าแผนที่มีการเชื่อมโยงสำหรับกุญแจที่ระบุ
        ├── `containsValue(Object value)`: boolean - ส่งคืน true ถ้าแผนที่เชื่อมโยงกุญแจหนึ่งหรือมากกว่ากับค่าที่ระบุ
        ├── `keySet()`: Set<K> - ส่งคืนมุมมองแบบ Set ของกุญแจที่อยู่ในแผนที่
        ├── `values()`: Collection<V> - ส่งคืนมุมมองแบบ Collection ของค่าที่อยู่ในแผนที่
        └── `entrySet()`: Set<Map.Entry<K, V>> - ส่งคืนมุมมองแบบ Set ของการเชื่อมโยงที่อยู่ในแผนที่

	 */
	
	
	public static void main(String[] args) {
		

	}

}
