package func;

import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

public class B14_MethodenreferenzV0_Zusammenfassung {

	/*
	 * สรุป Method References ใน Java:
	 * 
	 * 1. Static Method Reference (อ้างถึงเมธอดแบบสแตติก):
	 *    - ใช้เพื่ออ้างถึงเมธอดแบบสแตติกของคลาส
	 *    - รูปแบบ: ClassName::staticMethodName
	 *    - ตัวอย่าง: Function<String, Integer> func = Integer::parseInt;
	 *
	 * 2. Constructor Reference (อ้างถึงตัวสร้าง):
	 *    - ใช้เพื่ออ้างถึงตัวสร้างของคลาส
	 *    - รูปแบบ: ClassName::new
	 *    - ตัวอย่าง: Function<String, StringBuilder> func = StringBuilder::new;
	 *
	 * 3. Instance Method Reference of a Particular Object 
	 *    (อ้างถึงเมธอดของอ็อบเจกต์เฉพาะ):
	 *    - ใช้เพื่ออ้างถึงเมธอดของอ็อบเจกต์ที่กำหนดไว้แล้ว
	 *    - รูปแบบ: objectRef::instanceMethodName
	 *    - ตัวอย่าง: Supplier<Double> func = ref::doubleValue;
	 *
	 * 4. Instance Method Reference of an Arbitrary Object of a Particular Type
	 *    (อ้างถึงเมธอดของอ็อบเจกต์ใด ๆ ของประเภทที่ระบุ):
	 *    - ใช้เพื่ออ้างถึงเมธอดของอ็อบเจกต์ประเภทที่กำหนด
	 *    - รูปแบบ: ClassName::instanceMethodName
	 *    - ตัวอย่าง: BinaryOperator<String> func = String::concat;
	 */	
}

class StaticMethodReferenceExample {
    public static void main(String[] args) {
        Function<String, Integer> parseInt = Integer::parseInt; // Static method reference
        Integer result = parseInt.apply("123");
        System.out.println(result); // Output: 123
    }
}

class ConstructorReferenceExample {
    public static void main(String[] args) {
        Supplier<StringBuilder> createBuilder = StringBuilder::new; // Constructor reference
        StringBuilder sb = createBuilder.get();
        sb.append("Hello, OCP!");
        System.out.println(sb); // Output: Hello, OCP!
    }
}

class InstanceMethodReferenceExample {
    public static void main(String[] args) {
        String message = "OCP Exam";
        Supplier<Integer> lengthSupplier = message::length; // Instance method reference
        System.out.println(lengthSupplier.get()); // Output: 8
    }
}

class ArbitraryObjectMethodReferenceExample {
    public static void main(String[] args) {
        BiPredicate<String, String> startsWith = String::startsWith; // Instance method reference
        boolean result = startsWith.test("OCP", "O");
        System.out.println(result); // Output: true
    }
}


