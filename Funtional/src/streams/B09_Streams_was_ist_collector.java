package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class Student {
    private String name;
    private int age;
    private double grade;
    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    public int getAge() { return age;}

    public double getGrade() {    return grade;}

    public String getName() {  return name;}

    public String toString() {
        return name + " (Grade: " + grade + ")";
    }
}

public class B09_Streams_was_ist_collector {

	/*
	 * Collector เป็นอินเทอร์เฟซที่ใช้ใน Java SE 8 สำหรับการสะสมและรวบรวมค่าจากสตรีม 
	 * โดยปกติจะใช้ร่วมกับการดำเนินการบนสตรีม เช่น collect() เพื่อทำการรวมผลลัพธ์ที่กำหนดเอง 
	 * หรือใช้กับ Collectors ที่เตรียมมาให้ใน java.util.stream.Collectors เช่น toList(), toSet(), หรือ joining() เป็นต้น
		
		Collector ประกอบไปด้วยขั้นตอนหลักๆ ได้แก่:
		
		Supplier		: Supplies a new container for collecting elements.(สร้างคอนเทนเนอร์เปล่าสำหรับเก็บข้อมูล)
		Accumulator		: Adds an element to the current container. ( กำหนดวิธีการใส่ค่าเข้าไปในคอนเทนเนอร์ปัจจุบัน)
		Combiner		: Merges two containers, typically used in parallel processing. (รวมคอนเทนเนอร์สองอันเข้าด้วยกันเมื่อทำงานแบบขนาน)
		Finisher		: Converts the container into the final result. ( แปลงคอนเทนเนอร์ไปเป็นค่าผลลัพธ์สุดท้ายที่ต้องการ)
		Characteristics	: Defines the properties of the collector ( กำหนดคุณสมบัติของตัวสะสม เช่น การสนับสนุนการประมวลผลแบบขนาน)
							(e.g., whether it supports parallel processing).
	 */
	public static void main(String[] args) {

		List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");

		// A1 
		
        // ใช้ Collectors.joining() ที่เตรียมไว้
        String result = names.stream()
                             .collect(Collectors.joining(", ")); // รวมค่าในสตรีมเป็นสตริงเดียว โดยใช้คอมม่า (", ") คั่น
        System.out.println(result); // แสดงผล: John, Jane, Jack, Jill

        
        // A2 
        
        // สร้าง Custom Collector ที่รวมชื่อเข้าด้วยกัน
        Collector<String, StringJoiner, String> customCollector = 
            Collector.of(
                // Supplier: จัดหาคอนเทนเนอร์เปล่า (ในที่นี้ใช้ StringJoiner)
                () -> new StringJoiner(", "),
                
                // Accumulator: กำหนดวิธีการใส่ค่าเข้าไปในคอนเทนเนอร์ (ในที่นี้เพิ่มชื่อเข้าไป)
                (joiner, name) -> joiner.add(name),
                
                // Combiner: รวมคอนเทนเนอร์สองอันเข้าด้วยกัน (ใช้เมื่อสตรีมทำงานแบบขนาน)
                (joiner1, joiner2) -> joiner1.merge(joiner2),
                
                // Finisher: แปลงคอนเทนเนอร์ไปเป็นค่าที่เราต้องการ (ในที่นี้คือการแปลง StringJoiner เป็นสตริง)
                StringJoiner::toString
            );

        // ใช้ Custom Collector ในการรวมค่าในสตรีม
        result = names.stream().collect(customCollector);
        System.out.println(result); // แสดงผล: John, Jane, Jack, Jill
        
        System.out.println();
        // A3
        
        // รายการของนักเรียน
        List<Student> students = Arrays.asList(
            new Student("Alice", 20, 85.5),
            new Student("Bob", 20, 92.0),
            new Student("Charlie", 19, 88.5),
            new Student("David", 19, 79.0),
            new Student("Eve", 21, 91.0),
            new Student("Frank", 21, 85.0)
        );

        // Group students by age and find the student with the highest grade per age group
        Map<Integer, Optional<Student>> topStudentsByAge = students.stream()
            .collect(Collectors.groupingBy(
                Student::getAge, // Group by age (จัดกลุ่มตามอายุ)
                Collectors.maxBy(Comparator.comparing(Student::getGrade)) // หาเกรดสูงสุดในแต่ละกลุ่ม
            ));

        // แสดงผลลัพธ์
        topStudentsByAge.forEach((age, student) -> {
            System.out.println("Age " + age + ": " + student.orElse(null));
        });


        // ซับซ้อนยิ่งขึ้นด้วยการใช้ Collector แบบกำหนดเอง
        Map<Integer, Student> topStudentMap = students.stream()
            .collect(Collectors.groupingBy(
                Student::getAge, // Group by age (จัดกลุ่มตามอายุ)
                Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparing(Student::getGrade)), // หาเกรดสูงสุด
                    Optional::get // ดึงค่า Optional ออกมาเป็น Student
                )
            ));

        // แสดงผลลัพธ์
        System.out.println("\nTop student per age group (Using Custom Collector):");
        topStudentMap.forEach((age, student) -> {
            System.out.println("Age " + age + ": " + student);
        });
	}

}
