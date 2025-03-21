package ocpexam;

public class StreamTest1 {

	/*
	 	Given:
		class Student {
		
		String course, name, city;
		
		public Student (String name, String course, String city) {
		
		this.course = course; this.name = name; this.city = city;
		
		}
		
		public String toString() {
		
		return course + '':'' + name + '':'' + city;
		
		}
		
		public String getCourse() {return course;}
		
		public String getName() {return name;}
		
		public String getCity() {return city;}
		
		and the code fragment:
		
		List<Student> stds = Arrays.asList(
		
		new Student (''Jessy'', ''Java ME'', ''Chicago''),
		
		new Student (''Helen'', ''Java EE'', ''Houston''),
		
		new Student (''Mark'', ''Java ME'', ''Chicago''));
		
		stds.stream()
		
		.collect(Collectors.groupingBy(Student::getCourse))
		
		.forEach(src, res) -> System.out.println(res));
		
		What is the result?
		
		Options
		A	A compilation error occurs.
		B	Java EEJava ME
		C	[Java EE: Helen:Houston][Java ME: Jessy:Chicago, Java ME: Mark:Chicago]
		D	[Java ME: Jessy:Chicago, Java ME: Mark:Chicago][Java EE: Helen:Houston]
		
		
		Answer
		B
	 */
}
