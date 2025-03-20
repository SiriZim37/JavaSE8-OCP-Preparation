package oca;

public class FinalRule {

	public static void main(String[] args) {
		 /*
         * === สรุปการใช้ final ใน Java ===
         * 1. คลาส (final class): ป้องกันการสืบทอด
         * 2. เมธอด (final method): ไม่สามารถ override ได้
         * 3. ตัวแปร (final variable): ไม่สามารถเปลี่ยนค่าได้หลังจากกำหนดค่า
         * 4. พารามิเตอร์ (final parameter): ไม่สามารถเปลี่ยนค่าได้ภายในเมธอด
         * 5. Effectively Final: ใช้ใน Lambda หรือ Inner Class ได้ หากไม่มีการเปลี่ยนค่า
         * 
         * หมายเหตุ: final ไม่เกี่ยวข้องกับ immutability (ความไม่เปลี่ยนแปลงของ object)
         * การประกาศตัวแปรเป็น final ไม่ได้หมายความว่า object ที่มันอ้างถึงจะไม่เปลี่ยนแปลง
         * การป้องกัน immutability ต้องออกแบบโครงสร้างคลาสให้เหมาะสม เช่น คลาส String
         */
				
	}
	  // 1. final กับตัวแปร (Final Variables)
    // 1.1 ตัวแปร Primitive: ไม่สามารถเปลี่ยนค่าได้หลังจากกำหนด
    void testFinalPrimitive() {
        final int a = 10;
        // a = 20; // Error: ไม่สามารถเปลี่ยนค่าของตัวแปร final ได้

        final int b;
        b = 30; // กำหนดค่าได้ครั้งแรก
        // b = 40; // Error: กำหนดค่าได้ครั้งเดียว
    }

    // 1.2 ตัวแปรอ้างอิง (Reference Variables): เปลี่ยน object ไม่ได้ แต่เนื้อหาเปลี่ยนได้
    void testFinalReference() {
        final StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World"); // ถูกต้อง: เปลี่ยนเนื้อหา object ได้
        // sb = new StringBuilder("New Object"); // Error: เปลี่ยน object ที่อ้างถึงไม่ได้
    }

    // 2. final กับเมธอด (Final Methods): เมธอดไม่สามารถ override ได้
    class Parent1 {
        final void show() {
            System.out.println("This is a final method.");
        }
    }

    class Child1 extends Parent1 {
        // void show() { // Error: ไม่สามารถ override เมธอด final ได้
        //     System.out.println("Cannot override final method.");
        // }
    }

    // ข้อควรจำ: final ไม่ได้ป้องกันการ overload
    class Parent2 {
        final void show() {
            System.out.println("This is a final method.");
        }
    }

    class Child2 extends Parent2 {
        void show(String message) { // Overload ได้
            System.out.println("Overloaded method: " + message);
        }
    }

    // 3. final กับคลาส (Final Classes): คลาสที่ประกาศเป็น final ไม่สามารถสืบทอดได้
    final class FinalClass {
        void display() {
            System.out.println("This is a final class.");
        }
    }

    // class SubClass extends FinalClass { // Error: ไม่สามารถสืบทอดคลาส final ได้
    // }

    // 4. final กับตัวแปรภายในเมธอด (Local Final Variables): เปลี่ยนค่าไม่ได้
    public void testLocalFinalVariable() {
        final String x = "a";
        // x = "v"; // Error: ไม่สามารถเปลี่ยนค่าของตัวแปร final ได้

        final String y;
        y = "h"; // กำหนดค่าได้ครั้งแรก
        // y = "u"; // Error: กำหนดค่าได้ครั้งเดียว
    }

    // 5. final กับพารามิเตอร์ (Final Parameters): ค่าพารามิเตอร์ไม่เปลี่ยนได้ภายในเมธอด
    public void display(final int number) {
        // number = number + 10; // Error: พารามิเตอร์ final ไม่สามารถเปลี่ยนแปลงได้
        System.out.println("Number: " + number);
    }

    // 6. ข้อควรทราบ: Effectively Final
    // ใช้ได้ใน Lambda หรือ Inner Class หากไม่มีการเปลี่ยนค่า
    public void testEffectivelyFinal() {
        int x = 100; // "Effectively Final" เพราะไม่มีการเปลี่ยนค่า
        Runnable r = () -> System.out.println("Value: " + x);
        r.run();
    }
}
