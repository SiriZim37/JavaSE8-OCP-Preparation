package ocp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StreamsTesMitClass {

    int id;
    int price;

    public StreamsTesMitClass(int id, int price) {
        this.id = id;
        this.price = price;
    }

    public String toString() {
        return id + ":" + price;
    }
    
	public static void main(String[] args) {
//		 List<StreamsTesMitClass> products = Arrays.asList(new StreamsTesMitClass(1, 10),
//				    new StreamsTesMitClass (2, 30),
//				    new StreamsTesMitClass (2, 30));
		 
		 List<StreamsTesMitClass> products = new ArrayList<>(Arrays.asList(new StreamsTesMitClass(1, 10),
				    new StreamsTesMitClass (2, 30),
				    new StreamsTesMitClass (2, 30)));
				    
		 StreamsTesMitClass p = products.stream()
				 .reduce(new StreamsTesMitClass (4, 0), (p1,  p2) -> {
									 p1.price+=p2.price;
									 return new StreamsTesMitClass (p1.id, p1.price);});
		
		products.add(p);		// java.lang.UnsupportedOperationException
		products.stream().parallel()
				  .reduce((p1, p2) -> p1.price > p2.price ? p1 : p2)
				  .ifPresent(System.out::println);
		
		/*
		 * Die Größe einer mit Arrays.asList() erstellten Liste kann nicht verändert werden.
		 */
		

    }
	
	
	
}
