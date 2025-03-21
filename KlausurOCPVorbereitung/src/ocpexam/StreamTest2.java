package ocpexam;

public class StreamTest2 {

	/*
	 	Given the definition of the Emp class:

		public class Emp
		
		private String eName;
		
		private Integer eAge;
		
		Emp(String eN, Integer eA) {
		
		this.eName = eN;
		
		this.eAge = eA;
		
		}
		
		public Integer getEAge () {return eAge;}
		
		public String getEName () {return eName;}
		
		}
		
		and code fragment:
		
		List<Emp>li = Arrays.asList(new Emp(''Sam'', 20), New Emp(''John'', 60), New Emp(''Jim'', 51));
		
		Predicate<Emp> agVal = s -> s.getEAge() > 50;//line n1
		
		li = li.stream().filter(agVal).collect(Collectors.toList());
		
		Stream<String> names = li.stream()map.(Emp::getEName);//line n2
		
		names.forEach(n -> System.out.print(n + '' ''));
		
		What is the result?
		
		Options
		A	Sam John Jim
		B	John Jim
		C	A compilation error occurs at line n1.
		D	A compilation error occurs at line n2.
		
		
		Answer
		B
	 */
}
