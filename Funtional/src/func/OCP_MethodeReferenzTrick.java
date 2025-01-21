package func;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;


public class OCP_MethodeReferenzTrick {
	public static void main(String[] args) {
		
		// 1. ตัวอย่างการใช้ Supplier: คืนค่าผลลัพธ์โดยไม่ต้องการพารามิเตอร์
        // ใช้ method reference เพื่ออ้างอิงไปที่ nextInt() ของ Random
        Supplier<Integer> randomSupplier = new Random()::nextInt;
        System.out.println("Random number: " + randomSupplier.get()); // จะได้เลขสุ่ม
        
        // 2. ตัวอย่างการใช้ Consumer: รับพารามิเตอร์และไม่คืนค่าใดๆ
        // ใช้ method reference ไปที่ println ของ System.out
        Consumer<String> printConsumer = System.out::println;
        printConsumer.accept("Hello, World!"); // จะพิมพ์ "Hello, World!"
        
        // 3. ตัวอย่างการใช้ Function: รับพารามิเตอร์และคืนค่าผลลัพธ์
        // ใช้ method reference ไปที่ concat() ของ String
        Function<String, String> concatFunction = "Hello "::concat;
        String result = concatFunction.apply(" World");
        System.out.println("Concatenated String: " + result); // จะได้ "Hello World"
       
        Function<String, Integer> lengthString = String::length;
        Integer result2 = lengthString.apply("Hello");
        System.out.println("lengthString : " + result2); 
        
        // 4. ตัวอย่างการใช้ UnaryOperator: ใช้กับเมธอดที่รับพารามิเตอร์และคืนค่าผลลัพธ์ที่มีประเภทเดียวกัน
        // ใช้ method reference ไปที่ abs() ของ Math
        UnaryOperator<Integer> absOperator = Math::abs;
        System.out.println("Absolute value: " + absOperator.apply(-5)); // จะได้ 5
        
        // 5. ตัวอย่างการใช้ BiFunction: รับพารามิเตอร์สองตัวและคืนค่าผลลัพธ์
        // ใช้ method reference ไปที่ sum() ของ Integer
        BiFunction<Integer, Integer, Integer> sumFunction = Integer::sum;
        System.out.println("Sum of 3 and 5: " + sumFunction.apply(3, 5)); // จะได้ 8
        
       // 6. ใช้ method reference `Integer::sum` (เป็น method reference ที่เตรียมไว้ใน Java)
        //ใช้สำหรับฟังก์ชันที่รับ 2 พารามิเตอร์ที่มีชนิดเดียวกัน และคืนผลลัพธ์ที่เป็นชนิดเดียวกันกับพารามิเตอร์ทั้งสอง
        BinaryOperator<Integer> addOperator = Integer::sum;
        int result1 = addOperator.apply(5, 3);  // 5 + 3
        System.out.println("ผลลัพธ์การใช้ Integer::sum: " + result1);  // Output: 8
        
        // 6. ตัวอย่างการใช้ method reference กับเมธอดที่ไม่มีพารามิเตอร์และไม่มีค่าคืน
        // ใช้ method reference ไปที่ System.exit() ซึ่งไม่มีพารามิเตอร์และไม่มีค่าผลลัพธ์
//        Runnable exitTask = System::exit;
        // exitTask.run(); // นี้จะทำให้โปรแกรมปิดทันที
        
        
     // สรุปการใช้งาน Method References:
     // 1. Supplier: ใช้เมื่อคุณต้องการค่าผลลัพธ์โดยไม่ต้องการพารามิเตอร์
//         - เช่น การสร้างอินสแตนซ์ของคลาสหรือการให้ค่าคงที่
//         - ตัวอย่าง: Supplier<Integer> randomSupplier = () -> new Random().nextInt();
             
     // 2. Consumer: ใช้เมื่อคุณต้องการรับพารามิเตอร์และไม่ต้องการค่าผลลัพธ์
//         - ใช้กับฟังก์ชันที่ทำงานกับค่าที่ส่งเข้าไป เช่น การแสดงผลลัพธ์หรือบันทึกข้อมูล
//         - ตัวอย่าง: Consumer<String> printConsumer = System.out::println;

     // 3. Function: ใช้เมื่อคุณต้องการรับพารามิเตอร์และคืนค่าผลลัพธ์
//         - ฟังก์ชันนี้ใช้เมื่อคุณต้องการแปลงค่าจากประเภทหนึ่งไปเป็นอีกประเภทหนึ่ง
//         - ตัวอย่าง: Function<String, Integer> stringLengthFunction = String::length;

     // 4. UnaryOperator: ใช้เมื่อรับพารามิเตอร์และคืนค่าผลลัพธ์ที่เป็นประเภทเดียวกัน
//         - ใช้เมื่อรับค่าประเภทเดียวกันและคืนค่าประเภทเดียวกัน เช่น การเพิ่มค่าหรือการทำบางอย่างกับค่าหนึ่ง
//         - ตัวอย่าง: UnaryOperator<Integer> squareOperator = x -> x * x;

     // 5. BinaryOperator: ใช้เมื่อรับพารามิเตอร์สองตัวและคืนค่าผลลัพธ์ที่เป็นประเภทเดียวกัน
//         - ใช้เมื่อรับสองพารามิเตอร์ที่มีชนิดเดียวกันและคืนค่าผลลัพธ์ที่เป็นชนิดเดียวกัน เช่น การบวก การคูณ
//         - ตัวอย่าง: BinaryOperator<Integer> addOperator = Integer::sum;  // บวกเลขสองตัว

     // 6. BiFunction: ใช้เมื่อรับพารามิเตอร์สองตัวและคืนค่าผลลัพธ์ที่อาจเป็นประเภทที่แตกต่างกัน
//         - ใช้ในกรณีที่รับสองพารามิเตอร์และต้องการคืนผลลัพธ์ที่เป็นประเภทที่แตกต่างจากพารามิเตอร์
//         - ตัวอย่าง: BiFunction<String, Integer, String> concatFunction = String::concat;

     // 7. Predicate: ใช้เมื่อรับพารามิเตอร์และคืนค่าผลลัพธ์เป็น Boolean
//         - ใช้เมื่อคุณต้องการตรวจสอบเงื่อนไขหรือกรองข้อมูล
//         - ตัวอย่าง: Predicate<String> isNotEmpty = s -> !s.isEmpty();

     // 8. BiPredicate: ใช้เมื่อรับพารามิเตอร์สองตัวและคืนค่าผลลัพธ์เป็น Boolean
//         - ใช้เมื่อคุณต้องการตรวจสอบเงื่อนไขที่มีสองพารามิเตอร์
//         - ตัวอย่าง: BiPredicate<String, String> areEqual = String::equals;

     // 9. Runnable: ใช้เมื่อไม่รับพารามิเตอร์และไม่คืนค่าผลลัพธ์
//         - ใช้สำหรับฟังก์ชันที่ไม่รับพารามิเตอร์และไม่คืนค่าผลลัพธ์ เช่น การทำงานใน background หรือ thread
//         - ตัวอย่าง: Runnable task = () -> System.out.println("Task is running...");

     // 10. Function<T, R> with type parameters: ใช้เมื่อรับพารามิเตอร์ T และคืนค่าผลลัพธ์ R ซึ่งอาจจะเป็นประเภทที่แตกต่างกัน
//          - ใช้สำหรับแปลงค่าจากประเภทหนึ่งเป็นอีกประเภทหนึ่ง
//          - ตัวอย่าง: Function<String, Integer> parseInt = Integer::parseInt;

     // 11. Method references แบบ static: ใช้กับฟังก์ชันที่เป็น static
//          - ใช้เมื่อคุณต้องการเรียก method ของคลาสโดยตรง
//          - ตัวอย่าง: BiFunction<String, String, Integer> compareLength = String::compareToIgnoreCase;

     // สรุป: การเลือกใช้ Method References นั้นขึ้นอยู่กับลักษณะของฟังก์ชันที่เราต้องการจะใช้งานและประเภทของพารามิเตอร์หรือค่าผลลัพธ์ที่เราต้องการ
        
	}
}
