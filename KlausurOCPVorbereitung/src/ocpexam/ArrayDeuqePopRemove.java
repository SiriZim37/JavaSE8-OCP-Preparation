package ocpexam;

import java.util.ArrayDeque;


public class ArrayDeuqePopRemove {

	
	public static void main(String[] args) {
		
		
		ArrayDeque<Integer> d = new ArrayDeque<Integer>();
		d.add(4000);
		d.addFirst(3000);
		d.offer(2000);
		d.push(1000);
		
		int s1 = d.remove();
		int s2 = d.poll();
		
		System.out.println( s1 + "=" + s2);		// 1000=3000
		
	}
}

