package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class A00_WasIstThreadsJavaOCP {

    /*
     * In Java, a thread is the smallest unit of execution within a process. 
     * A thread allows for concurrent execution, 
     * meaning multiple threads can run simultaneously in the same application.
     * This is crucial for handling tasks that can be performed concurrently 
     * without blocking other tasks, such as downloading files while still allowing
     * a user to interact with the application.
     * 
     * ใน Java OCP SE 8, **Thread** คือกระบวนการที่ทำให้โปรแกรมสามารถทำงานหลายๆ งานพร้อมกันได้ในเวลาเดียวกัน 
     * ซึ่งเรียกว่า **Multithreading** หรือ **การทำงานหลายเธรด** โดยแต่ละเธรดในโปรแกรมจะทำงานในกระบวนการต่างๆ 
     * ในเวลาเดียวกัน
     */

    /*
     * การสร้างและใช้งาน **Thread**:
     * 1. **Thread** คือหน่วยย่อยของการทำงานในกระบวนการ (process) ซึ่งสามารถทำงานได้อย่างอิสระจากกันภายในโปรแกรมเดียวกัน
     * 2. Java ใช้ **Thread** เพื่อช่วยให้โปรแกรมสามารถทำงานหลายอย่างได้พร้อมกัน เช่น การดาวน์โหลดไฟล์ขณะเดียวกันกับการประมวลผลข้อมูล
     *    หรือการทำงานในแอปพลิเคชันที่ต้องตอบสนองต่อผู้ใช้ในขณะที่กำลังดำเนินการบางอย่างอยู่
     */

    public static void main(String[] args) {

        /*
         * วิธีการสร้าง **Thread** ใน Java:
         * 1. การสืบทอดคลาส `Thread`: 
         *    - คุณสามารถสร้างคลาสใหม่ที่สืบทอดจาก `Thread` และ override เมธอด `run()` เพื่อกำหนดการทำงานที่ต้องการให้เธรดนั้นทำ
         */
        
        // ตัวอย่างการสร้างคลาสที่สืบทอดจาก Thread
        class MyThread extends Thread {
            @Override
            public void run() {
                System.out.println("Hello from MyThread");
            }
        }

        // สร้างและเริ่มต้นเธรด
        MyThread thread = new MyThread();
        thread.start(); // เริ่มต้นเธรด

        /*
         * 2. การใช้ `Runnable` interface:
         *    - คุณสามารถสร้างคลาสที่ implement `Runnable` interface และกำหนดการทำงานในเมธอด `run()`
         */
        
        // ตัวอย่างการใช้ Runnable
        class MyRunnable implements Runnable {
            @Override
            public void run() {
                System.out.println("Hello from MyRunnable");
            }
        }

        // สร้างและเริ่มต้นเธรด
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start(); // เริ่มต้นเธรด

        /*
         * การจัดการกับเธรด:
         * - **start()**: ใช้เริ่มต้นเธรดใหม่
         * - **sleep()**: ใช้หยุดการทำงานของเธรดชั่วขณะ (ไม่ใช้เวลา CPU)
         * - **join()**: ใช้ให้เธรดหนึ่งรอจนกว่าอีกเธรดจะทำงานเสร็จ
         * - **isAlive()**: ใช้เช็คว่าเธรดยังทำงานอยู่หรือไม่
         * - **setPriority(int priority)**: ใช้กำหนดความสำคัญของเธรด
         * - **interrupt()**: ใช้เพื่อหยุดการทำงานของเธรด อาจทำให้มันหยุดทำงานเมื่ออยู่ในสถานะ sleep หรือ wait
         */
        
        System.out.println("main 1");

        //---------------------------------------------------------------------------------------
        /*
         * การใช้ **ExecutorService**:
         * ใน Java 8, การใช้ `ExecutorService` เป็นวิธีที่นิยมในการจัดการเธรด เพราะมันช่วยให้สามารถจัดการเธรดหลายๆ ตัวได้ง่ายขึ้น
         * ตัวอย่าง:
         */
        
        // ใช้ ExecutorService สำหรับการจัดการเธรดหลายๆ ตัว
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            System.out.println("Task 1");
        });
        executorService.submit(() -> {
            System.out.println("Task 2");
        });
        executorService.shutdown(); // ปิด ExecutorService เมื่อทำงานเสร็จ
        
        /*
         * การใช้คำสั่ง synchronized ใน Java:
         * คำสั่ง synchronized ใน Java ถูกใช้เพื่อให้มั่นใจว่า มีแค่เธรดเดียวที่สามารถเข้าไปทำงานในบล็อกโค้ดที่ถูกกำหนดไว้ได้ในแต่ละครั้ง 
         * ซึ่งช่วยป้องกันไม่ให้เกิดปัญหาการเข้าถึงข้อมูลหรือทรัพยากรที่ใช้ร่วมกัน (shared resources) โดยเธรดหลายตัวในเวลาเดียวกัน
         * ซึ่งอาจทำให้ข้อมูลเสียหายหรือเกิดข้อผิดพลาด (race condition) ได้
         * เมื่อเธรดใดๆ เข้ามาถึงโค้ดที่มีคำว่า synchronized มันจะต้อง ล็อก โค้ดส่วนนี้ก่อนที่จะทำงาน 
         * และเมื่อมันทำงานเสร็จแล้วมันจะปลดล็อกให้เธรดอื่นๆ ที่ต้องการเข้ามาใช้งานในส่วนนี้ได้
         * ดังนั้น synchronized จะทำให้การทำงานร่วมกันระหว่างเธรดเป็นไปอย่างปลอดภัย
         */
        
        // ตัวอย่างการใช้ synchronized
        class Counter {
            private int count = 0;

            // ใช้ synchronized เพื่อให้เธรดเดียวเท่านั้นที่สามารถเข้าถึงและแก้ไขค่าของ count ได้ในแต่ละครั้ง
            public synchronized void increment() {
                count++;
            }

            public synchronized int getCount() {
                return count;
            }
        }

        // การใช้งาน Counter
        Counter counter = new Counter();
        Thread thread3 = new Thread(() -> {
            counter.increment();
            System.out.println("Count: " + counter.getCount());
        });
        thread3.start();
        
        System.out.println("main 2");
    }
}
