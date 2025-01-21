package inner;

// คำอธิบายเกี่ยวกับคลาสภายใน (Inner Class) สำหรับการสอบ OCP Java SE 8
// ใน Java SE 8, **Inner Class** คือคลาสที่ถูกประกาศไว้ภายในคลาสอื่น
// คลาสภายในช่วยในการจัดระเบียบโค้ดให้กระชับมากขึ้นและมีประโยชน์เมื่อคลาสภายในมีความสัมพันธ์ใกล้ชิดกับคลาสภายนอก

public class A00_WasIstInnerKlasseFeurOCP {

    /*
     * ประเภทของ Inner Class:
     * - Member Inner Class: คลาสภายในที่ไม่ใช่ static ซึ่งเป็นสมาชิกของคลาสภายนอก
     * - Static Nested Class: คลาสภายในที่เป็น static และไม่ต้องการอินสแตนซ์ของคลาสภายนอก
     * - Local Inner Class: คลาสที่ถูกประกาศภายใน method ซึ่งมีขอบเขตจำกัด
     * - Anonymous Inner Class: คลาสภายในที่ไม่มีชื่อ ใช้ในการสร้างออบเจ็กต์ที่มีพฤติกรรมเฉพาะ
     */

    // 1. **Member Inner Class**
    // Member Inner Class เป็นคลาสภายในที่ไม่ใช่ static ที่อยู่ภายในคลาสภายนอก สามารถเข้าถึงสมาชิกของคลาสภายนอกได้
    // เมื่อต้องการใช้งานจำเป็นต้องสร้างอินสแตนซ์ของคลาสภายนอกก่อน
    class Outer {
        private String message = "Hello from Outer class!";

        // Member inner class
        class Inner {
            public void display() {
                System.out.println(message); // เข้าถึงสมาชิกของคลาสภายนอก
            }
        }
    }

    // 2. **Static Nested Class**
    // Static Nested Class เป็นคลาสภายในที่ใช้ static และไม่จำเป็นต้องมีอินสแตนซ์ของคลาสภายนอก
    // สามารถเข้าถึงได้เฉพาะสมาชิกที่เป็น static ของคลาสภายนอก
//    class OuterStatic {
//        private static String message = "Hello from Outer class!";
//
//        // Static nested class
//        static class Nested {
//            public void display() {
//                System.out.println(message); // เข้าถึงสมาชิกที่เป็น static ของคลาสภายนอก
//            }
//        }
//    }

  
    class OuterLocal {
        public void display() {
            final String localMessage = "Hello from Local inner class!";

            // Local inner class
            class Local {
                public void show() {
                    System.out.println(localMessage); // เข้าถึงตัวแปรใน method
                }
            }

            Local local = new Local();
            local.show();
     
        }
    }

    // 3. **Anonymous Inner Class**
    // Anonymous Inner Class เป็นคลาสที่ไม่มีชื่อ ใช้สำหรับสร้างออบเจ็กต์ของ interface หรือ abstract class
    class OuterAnonymous {
        public void display() {
            // Anonymous inner class implementing Runnable
            Runnable r = new Runnable() {
                public void run() {
                    System.out.println("Hello from Anonymous Inner Class!");
                }
            };
            r.run(); // เรียกใช้งาน method ของคลาส anonymous
        }
    }
    
    // 4. **Local Inner Class**
    // Local Inner Class คือคลาสที่ถูกประกาศภายใน method ซึ่งสามารถเข้าถึงตัวแปรที่เป็น final หรือ effectively final ได้
    // It can marked abstract class *
    static void staticMethodeWithLocalAnonymeClasses() {
        abstract class AbstractInner {
            abstract void printMessage();
        }

        class ConcreteInner extends AbstractInner {
            void printMessage() {
                System.out.println("Concrete implementation!");
            }
        }

        AbstractInner instance = new ConcreteInner();
        instance.printMessage();
//		class static StaticLocalClass3{  }	// cf
    }
    void methodeWithLocalClasses() {
        abstract class AbstractInner {
            abstract void printMessage();
        }

        class ConcreteInner extends AbstractInner {
            void printMessage() {
                System.out.println("Concrete implementation!");
            }
        }

        AbstractInner instance = new ConcreteInner();
        instance.printMessage();
        
        int value = 42;
        class LocalClass {
            void printValue() {
                System.out.println(value); // Valid
            }
        }
        new LocalClass().printValue();
        
//    	class static StaticLocalClass3{  }	 // cf
    }
    // **ตัวอย่างการใช้งานใน Main Method**
    public static void main(String[] args) {
        // ตัวอย่างของ Member Inner Class
        Outer outer = new A00_WasIstInnerKlasseFeurOCP().new Outer(); // สร้างอินสแตนซ์ของคลาสภายนอก
        Outer.Inner inner = outer.new Inner(); // สร้างอินสแตนซ์ของคลาสภายใน
        inner.display();

        // ตัวอย่างของ Static Nested Class
//        OuterStatic.Nested nested = new OuterStatic.Nested(); // สร้างอินสแตนซ์ของ Static Nested Class
//        nested.display();

        // ตัวอย่างของ Local Inner Class
        OuterLocal outerLocal = new A00_WasIstInnerKlasseFeurOCP().new OuterLocal();
        outerLocal.display();

        // ตัวอย่างของ Anonymous Inner Class
        OuterAnonymous outerAnonymous = new A00_WasIstInnerKlasseFeurOCP().new OuterAnonymous();
        outerAnonymous.display();
    }
}

/*
 * **จุดสำคัญสำหรับการสอบ OCP:**
 * - Member Inner Class: ต้องมีอินสแตนซ์ของคลาสภายนอก และสามารถเข้าถึงสมาชิกทั้งหมดได้
 * - Static Nested Class: สามารถสร้างได้โดยไม่ต้องมีอินสแตนซ์ของคลาสภายนอก และเข้าถึงได้เฉพาะสมาชิกที่เป็น static
 * - Local Inner Class: ถูกประกาศใน method; สามารถเข้าถึงตัวแปรใน method ที่เป็น final หรือ effectively final ได้
 * - Anonymous Inner Class: ใช้สำหรับการสร้างออบเจ็กต์จาก interface หรือ abstract class ที่มีพฤติกรรมเฉพาะ
 * 
 * **ข้อดีของการใช้ Inner Class:**
 * - **Encapsulation**: คลาสภายในช่วยในการซ่อนการทำงานที่ไม่ต้องการให้คลาสภายนอกเข้าถึง
 * - **เข้าถึงสมาชิกของคลาสภายนอกได้ง่าย**: โดยเฉพาะใน Member Inner Class สามารถเข้าถึงสมาชิกของคลาสภายนอกได้โดยตรง
 * - **ใช้ในสถานการณ์ที่จำเป็นเท่านั้น**: เหมาะสำหรับคลาสที่ใช้ในที่เดียว เช่น anonymous หรือ local inner class
 */
