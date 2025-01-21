package ocp2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
  Given the code fragments:
 class TechName    {
    String techName;
    TechName (String techName)   {
        this.techName=techName;
    }
 }
 and
 List<TechName> tech = Arrays.asList   (
    new TechName("Java-"),
    new TechName("Oracle DB-"),
 new TechName("J2EE-")
 );
 Stream<TechName> stre = tech.stream();
 //line n1
 Which should be inserted at line n1 to print 
 
 Java-Oracle DB-J2EE-?
 A. stre.forEach(System.out::print);
 B. stre.map(a-> a.techName).forEach(System.out::print);
 C. stre.map(a-> a).forEachOrdered(System.out::print);
 D. stre.forEachOrdered(System.out::print);
 
 */


class TechName    {
    String techName;
    TechName (String techName)   {
        this.techName=techName;
    }
 }

public class StreamCollectionmap {

	public static void main(String[] args) {
		
		 List<TechName> tech = Arrays.asList   (
				    new TechName("Java-"),
				    new TechName("Oracle DB-"),
				    new TechName("J2EE-")
				 );
		Stream<TechName> stre = tech.stream();
		 stre.map(a-> a.techName).forEach(System.out::print);	 //line n1
	}
}
