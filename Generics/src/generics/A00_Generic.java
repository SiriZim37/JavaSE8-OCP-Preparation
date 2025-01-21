package generics;

public class A00_Generic {

    public static void main(String[] args) {
        
    	  /*
         * สิ่งที่ต้องรู้เกี่ยวกับ Generic สำหรับการสอบ OCP
         *
         * ** การใช้งาน Generic กับ Collections Framework **
         * - ตัวอย่างเช่น List<String>, Map<Integer, String>, และ Set<Double>
         * - ความแตกต่างระหว่าง ArrayList กับ LinkedList ในการใช้งาน Generic
         *		สรุปความแตกต่างระหว่างการใช้ Generic ใน ArrayList และ LinkedList:
         *			- ArrayList เหมาะสำหรับการเข้าถึงข้อมูลแบบเร็ว (โดยใช้ index) และมีประสิทธิภาพดีกว่าเมื่อข้อมูลไม่ถูกเพิ่มหรือลบบ่อย ๆ
         *			- LinkedList เหมาะสำหรับการเพิ่มหรือลบข้อมูลที่ตำแหน่งไหนก็ได้ (ต้น, กลาง, ท้าย) โดยไม่สนใจประสิทธิภาพในการเข้าถึงข้อมูลจากตำแหน่งต่าง ๆ
         * ** Wildcards (?) **
         * - Unbounded Wildcard: ใช้ ? เมื่อประเภทไม่จำกัด
         *   ตัวอย่าง: List<?> list = new ArrayList<String>();
         *
         * - Bounded Wildcard:
         *   1. Upper Bounded: <? extends Type>
         *      ใช้เมื่อประเภทเป็น subclass หรือสืบทอดมาจาก Type
         *      ตัวอย่าง: List<? extends Number> numbers = new ArrayList<Integer>();
         *   2. Lower Bounded: <? super Type>
         *      ใช้เมื่อประเภทเป็น superclass ของ Type
         *      ตัวอย่าง: List<? super Integer> integers = new ArrayList<Number>();
         *
         * ** Bounded Type Parameters **
         * - ใช้เพื่อจำกัดประเภทข้อมูลที่สามารถใช้ใน Generic ได้
         *   ตัวอย่าง:
         *   class Box<T extends Number> {
         *       private T value;
         *       public Box(T value) {
         *           this.value = value;
         *       }
         *   }
         *
         * ** Type Inference **
         * - ให้ Java คาดเดาประเภทโดยอัตโนมัติ (Type Inference)
         *   ตัวอย่าง: Box<Integer> box = new Box<>(10); // <> แสดงการ Inference
         *
         * ** Generic กับ Interface/Method **
         * - การเขียนเมธอดที่รองรับ Generic:
         *   ตัวอย่าง:
         *   public static <T> void printArray(T[] array) {
         *       for (T item : array) {
         *           System.out.println(item);
         *       }
         *   }
         *
         * ** Raw Types (แนะนำให้หลีกเลี่ยง) **
         * - การใช้ Generic โดยไม่ระบุประเภท
         *   ตัวอย่าง: 
         *   List list = new ArrayList(); // Raw Type
         *   list.add("String");
         *   list.add(123);
         *
         * ** Type Erasure (Erasure) **
         * - Generic จะถูกลบออกเมื่อคอมไพล์ เพื่อให้โค้ดทำงานร่วมกับ JVM รุ่นเก่าได้
         *   ตัวอย่าง:
         *   ก่อนคอมไพล์:
         *   List<String> list = new ArrayList<>();
         *   list.add("Test");
         *
         *   หลังคอมไพล์:
         *   List list = new ArrayList();
         *   list.add("Test");
         */

    }
}
