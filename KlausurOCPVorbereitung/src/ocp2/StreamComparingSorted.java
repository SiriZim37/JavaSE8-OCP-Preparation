package ocp2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Emp {
    String fName;
    String lName;

    public Emp(String fn, String ln) {
        fName = fn;
        lName = ln;
    }

    public String getfName() { return fName; }
    public String getlName() { return lName; }
    
    @Override
    public String toString() {
    	return fName + " " + lName;
    }
}


public class StreamComparingSorted {

	public static void main(String[] args) {
		List<Emp> emp = Arrays.asList(
			    new Emp("John", "Smith"),
			    new Emp("Peter", "Sam"),
			    new Emp("Thomas", "Wale")
			);
		emp.stream()
		  //line n1
	    .collect(Collectors.toList())	
		.forEach(System.out::println);
	}
	
	/*
	  Which code fragment, when inserted at line n1, sorts the employees list in descending 
	  order of fName and then ascending order of lName?
		 A. .sorted (Comparator.comparing(Emp::getfName).reserved().thenComparing(Emp::getlName))
		 B. .sorted (Comparator.comparing(Emp::getfName).thenComparing(Emp::getlName))
		 C. .map(Emp::getfName).sorted(Comparator.reserveOrder())
		 D. .map(Emp::getfName).sorted(Comparator.reserveOrder().map(Emp::getlName).reserved
	 */
	
	/*
	 A. .sorted(Comparator.comparing(Emp::getfName).reversed().thenComparing(Emp::getlName))
		ตัวเลือกนี้ถูกต้อง!
		Comparator.comparing(Emp::getfName) ใช้เพื่อเรียงลำดับตาม fName ในลำดับปกติ
		.reversed() ใช้เพื่อกลับลำดับให้เป็นลำดับถอยหลัง
		thenComparing(Emp::getlName) ใช้เพื่อเรียงลำดับ lName ในลำดับปกติหลังจากที่ fName ถูกเรียงลำดับแล้ว
		ดังนั้นพนักงานจะถูกเรียงตาม fName ในลำดับถอยหลัง และถ้ามีชื่อเหมือนกัน จะใช้ lName ในลำดับปกติ
	 */
}
