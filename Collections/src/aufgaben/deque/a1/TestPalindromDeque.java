package aufgaben.deque.a1;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestPalindromDeque {

	public static void main(String[] args) {

		System.out.println("***1. ");
		Character[] arr = { 'a', 'n', 'n', 'a' };
        
	    boolean erg = isPalindrome(arr);
	    System.out.println(erg); // true
	      
	    System.out.println("\n***2. ");
	    arr = new Character[] { 'r', 'o', 't', 'o', 'r' };
	    erg = isPalindrome(arr);
	    System.out.println(erg); // true

	    System.out.println("\n***3. ");
	    arr = new Character[] { 'm', 'o', 't', 'o', 'r' };
	    erg = isPalindrome(arr);
	    System.out.println(erg); // false 
	}
	
	static boolean isPalindrome(Character[] params) {	
		
		Deque<Character> deque = new ArrayDeque<Character>();
		
		for (Character ch : params) {
			deque.offer(ch);
		}	
		System.out.println("deque : " + deque );
		
	    while (deque.size() > 1) {
            Character head = deque.pollFirst(); 
            Character tail = deque.pollLast(); 
            System.out.println("deque : " + deque );
            if (!head.equals(tail)) {
                return false; 
            }
        }
		return true;
	}
	


}
