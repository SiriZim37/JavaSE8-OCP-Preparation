package ocp2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/*
 
  QUESTION 64
 Given the definition of the Emp class:
 public class Emp
    private String eName;
    private Integer eAge;
    Emp(String eN, Integer eA)    {
        this.eName = eN;
        this.eAge = eA;
    }
    public Integer getEAge () {return eAge;}
    public String getEName () {return eName;}
 }
 and code fragment:
 List<Emp>li = Arrays.asList(new Emp(“Sam”, 20), New Emp(“John”, 60), New Emp(“Jim”, 51));
 Predicate<Emp> agVal = s -> s.getEAge() > 50;            //line n1
 li = li.stream().filter(agVal).collect(Collectors.toList());
 Stream<String> names = li.stream()map.(Emp::getEName);    //line n2
 names.forEach(n -> System.out.print(n + “ “));
 What is the result?
 A. Sam John Jim
 B. John Jim
 C. A compilation error occurs at line n1.
 D. A compilation error occurs at line n2
 
 */
class EmpS{

private String eName;
private Integer eAge;
EmpS(String eN, Integer eA)    {
    this.eName = eN;
    this.eAge = eA;
}
public Integer getEAge () {return eAge;}
public String getEName () {return eName;}
}
public class StreamTest {

	public static void main(String[] args) {
		 List<EmpS>li = Arrays.asList(new EmpS("Sam", 20), new EmpS("John", 60), new EmpS("Jim", 51));
		 Predicate<EmpS> agVal = s -> s.getEAge() > 50;            //line n1
		 li = li.stream().filter(agVal).collect(Collectors.toList());
		 Stream<String> names = li.stream().map(EmpS::getEName);    //line n2
		 names.forEach(n -> System.out.print(n + " "));
	}
	 
}
