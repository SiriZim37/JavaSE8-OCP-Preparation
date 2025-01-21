package ocp2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student    {
    String course, name, city;
    public Student (String name, String course, String city)   {
        this.course = course; this.name = name; this.city = city;
    }
    
    
    public String getCourse() {
		return course;
	}


	public String toString()    {
        return course + ":" + name + ":" + city;
    }
}
    
public class StreamCollectionsTest {

	public static void main(String[] args) {
		 List<Student> stds = Arrays.asList(
				    new Student ("Jessy", "Java ME", "Chicago"),
				    new Student ("Helen", "Java EE", "Houston"),
				    new Student ("Mark", "Java ME", "Chicago"));

		 stds.stream()
		    .collect(Collectors.groupingBy(Student::getCourse))
		    .forEach((src, res) -> System.out.println(src));
			 
			
	}
	
	/*
	 *  What is the result?
		 A. [Java EE: Helen:Houston]
		 [Java ME: Jessy:Chicago, Java ME: Mark:Chicago]
		 B. Java EE
		 Java ME
		 C. [Java ME: Jessy:Chicago, Java ME: Mark:Chicago]
		 [Java EE: Helen:Houston]
		 www.vceplus.com - VCE Exam Simulator - Download A+ VCE (latest) free Open VCE Exams - VCE to PDF Converter - PDF Online
		D. A compilation error occurs.
	 */
	
	/*
	 การใช้ groupingBy จัดกลุ่ม Student ตามค่า course ซึ่งทำให้เรามีสองกลุ่ม:
		
		Java ME: มีนักเรียนสองคนคือ Jessy และ Mark (ทั้งสองคนเรียน Java ME ที่ Chicago)
		Java EE: มีนักเรียนหนึ่งคนคือ Helen (เรียน Java EE ที่ Houston)
		เมื่อใช้ forEach เราแสดงแค่ชื่อคอร์ส (src), ซึ่งทำให้ผลลัพธ์คือการแสดงชื่อคอร์สเท่านั้น:
		
		Java ME
		Java EE
	 */
}
