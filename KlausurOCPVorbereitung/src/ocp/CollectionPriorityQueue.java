package ocp;

import java.util.PriorityQueue;

public class CollectionPriorityQueue {

	public static void main(String[] args) {
		
		PriorityQueue<String> p = new PriorityQueue<String>();
		p.add("2");
		p.add("4");
		System.out.println(p.peek());
		p.offer("1");
		p.add("3");
		System.out.println("p= " + p);
		
		p.remove("1");
		
		System.out.println("p= " + p);
		
		System.out.println(p.poll());
		if(p.remove("2"))System.out.println(p.poll());
		System.out.println(p.poll() + "" + p.peek());
	}
}
