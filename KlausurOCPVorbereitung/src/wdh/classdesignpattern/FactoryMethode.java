package wdh.classdesignpattern;



//Immutable class
//Immutable Product Class
final class Product {
 private final String name;
 private final int price;

 // Constructor
 private Product(String name, int price) {
     this.name = name;
     this.price = price;
 }

 // Getter methods
 public String getName() {
     return name;
 }

 public int getPrice() {
     return price;
 }

 // Factory Method to create immutable Product
 public static Product createProduct(String name, int price) {
     // You can add validation here to ensure product data is valid
     return new Product(name, price);
 }
}

public class FactoryMethode {
	/*
	 * Factory Method with Immutable Objects
	 * Factory Method เป็นเทคนิคการออกแบบที่ใช้สำหรับสร้างอ็อบเจ็กต์ในวิธีที่ควบคุมได้ และในกรณีที่ใช้ร่วมกับ Immutable Objects 
	 * (อ็อบเจ็กต์ที่ไม่สามารถเปลี่ยนแปลงได้หลังจากการสร้าง), เราจะใช้ Factory Method 
	 * เพื่อสร้างอ็อบเจ็กต์และรักษาคุณสมบัติของอ็อบเจ็กต์ที่ไม่เปลี่ยนแปลง โดยที่ไม่สามารถแก้ไขค่าของฟิลด์ได้หลังจากสร้างแล้ว
	 */

	 public static void main(String[] args) {
	     // Using Factory Method to create an immutable object
	     Product product = Product.createProduct("Laptop", 1000);
	
	     // Accessing the immutable properties of the product
	     System.out.println("Product Name: " + product.getName());
	     System.out.println("Product Price: " + product.getPrice());
	 }
}

