package ocpexam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Product   {
	
    int id; int price;
    public Product (int id, int price)   {
        this.id = id;
        this.price = price;
    }
    public String toString() {   return id + ":" + price;   }
}




public class StreamReduce {

	public static void main(String[] args) {
		

	List<Product> products = new ArrayList<>(Arrays.asList(new Product(1, 10), 
		new Product(2, 30), 
		new Product(3, 20)));
	
	Product p = products.stream().reduce(new Product(4, 0), (p1, p2) -> {
	    p1.price += p2.price;
	    return new Product(p1.id, p1.price);
	});
	
	products.add(p);
	
	products.stream()
	    .parallel()
	    .reduce((p1, p2) -> p1.price > p2.price ? p1 : p2)
	    .ifPresent(System.out::println);
	}
	
}

/*

QUESTION: 25 <<<< OCP Test 2025

Given:

public class product   {
    int id; int price;
    public Product (int id, int price)   {
        this.id = id;
    }   
    this.price = price;
    public String toString()  {   return id + ":" + price;   }
}

and the code fragment:

List<Product> products = new ArrayList<>(Arrays.asList(new Product(1, 10), 
	new Product(2, 30), 
	new Product(3, 20)));
Product p = products.stream().reduce(new Product (4, 0), (p1,  p2) -> {
    p1.price+=p2.price;
    return new Product (p1.id, p1.price);});
products.add(p);
products.stream()
	.parallel()
    .reduce((p1, p2) - > p1.price > p2.price ? p1 : p2)
    .ifPresent(System.out: :println);
    
What is the result?

A. 	2 : 30
B. 	4 : 0
C. 	4 : 60
D. 	4 : 60 
	2 : 30 
	3 : 20 
	1 : 10
E. The program prints nothing.




C Correct

*/