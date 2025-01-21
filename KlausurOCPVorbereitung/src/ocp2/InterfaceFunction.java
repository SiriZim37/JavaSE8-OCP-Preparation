package ocp2;

/*
 
 QUESTION 61
 Given:
 public interface Moveable<Integer>    {
    public default void walk (Integer distance) {System.out.println("Walking");)    
    
     
	Which statement is true?

	 A. Moveable can be used as below:
	 Moveable<Integer> animal = n - > System.out.println("Running" + n); animal.run(100); animal.walk(20);
	 B. Moveable can be used as below:
	 Moveable<Integer> animal = n - > n + 10; animal.run(100); animal.walk(20);
	 C. Moveable can be used as below:
	 Moveable animal = (Integer n)  - > System.out.println(n); animal.run(100);
	 Moveable.walk(20);
	 D. Movable cannot be used in a lambda expression.
 
 
 */

interface Moveable<Integer>    {
    public default void walk (Integer distance) { System.out.println("Walking"); }
    public void run(Integer distance);   
}
    
public class InterfaceFunction {

	public static void main(String[] args) {
		 Moveable<Integer> animal = n -> System.out.println("Running" + n); animal.run(100); animal.walk(20);
	}
}
