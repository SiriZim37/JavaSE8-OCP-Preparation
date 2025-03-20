package lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class B02_ArrayListWithCars {

	public static void main(String[] args) {

				
		Car a1 = new Car("Volk" , "Golf"  , 90 , 210 , 5 ) ;
		Car a2 = new Car("Ford" , "Fiesta"  , 75 , 200 , 5 ) ;
		Car a3 = new Car("Audi" , "A3"  , 100 , 270 , 5 ) ;
		Car a4 = new Car("Cittron" , "Plurierl"  , 73 , 180 , 3 ) ;
		Car a5 = new Car("Fiat" , "500"  , 80 , 205 , 3 ) ;
		Car a6 = new Car("Volvo" , "V40"  , 120 , 225 , 5 ) ;
		Car a7 = new Car("Dacia" , "Logan"  , 75 , 200 , 5 ) ;
		Car a8 = new Car("Opel" , "Astri"  , 85 , 210 , 0 ) ;
		Car a9 = new Car("BMW" , "525i"  , 180 , 235 , 5 ) ;
		Car a10 = new Car("Toyota" , "Corolla"  , 90 , 210 , 5 ) ;
	

		Car[] cars = { a1,a2,a3,a4,a5 ,a6 ,null ,  a7 , a8 , a9 , a10 , null };
		

		ArrayList<Car> autos = new ArrayList<>(Arrays.asList(cars));
		autos.forEach(System.out::println);
		Car such = new Car("BMW" , "525i"  , 180 , 235 , 5  ); // das gleich Objekt
		//such = a9;											   // das selbe Objekt
		
		// test null 
		boolean contains = autos.contains(null);
		System.out.println("contains = null  " + contains); // true
		
		/*
		 * equals überschreiben in class Car um zu vergleichen 
		 */
		contains = autos.contains(such);
		System.out.println("contains = " + contains); 
		
		// bevor sortiert muss NULL entwerfen.
		autos.removeIf(n->n==null);
		
		// cf :  Ohne implements Comparable<Car> kann autos nicht sortieren 
		
//		autos.sort(Comparator.naturalOrder());
		Collections.sort(autos);
		autos.forEach(System.out::println);
		
		
		// List muss den Typ deklariert werden. 
		List<String> strList = new ArrayList<>(); // diamond-operator, seit Java 7  :  
		//Diamond-Operator: Seit Java 7 können Sie den Diamond-Operator <> auf der rechten Seite der Zuweisung verwenden. 
		//Der Typ auf der rechten Seite wird vom Typ auf der linken Seite abgeleitet, was den Code sauberer macht.

//		strList.add(42); // cf : Compiler-Fehler , Compiler überprüft , ob den Typ passt.
		
		
		
		List list = new ArrayList<>(); // nicht-generisch , vor Java 5 
		// Raw Type: List without a type parameter is a raw type. 
		// This means it can hold any type of objects, but it loses type safety.
		list.add(42);
		list.add("Fred");
		list.add(a8);
		list.forEach(System.out::println);
		
	}

}

class Car implements Comparable<Car>{   // Jeder class erbt Objekt
	
	private String hersteller;
	private String model;
	private int leistungPS;
	private int maxSpeed;
	private int anzahlTueren;
	
	public Car() {
	
	}
	
	public Car( String herstellen, String model, int leistungPS, int maxSpeed, int anzahlTueren) {
		this.hersteller =  herstellen;
		this.model =  model;
		this.leistungPS =   leistungPS;
		this.maxSpeed =  maxSpeed;
		this.anzahlTueren =  anzahlTueren;
		
	}
	
	 @Override  // equals überschreiben, damit contain = true
	 public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Car c = (Car) o;
	        return  hersteller.equals(c.hersteller) &&
	        		model.equals(c.model)  ;
	  }
	 
	@Override
	public int compareTo(Car c) {
		// Car c = (Car)o;
		// Vergleich nach Hersteller (aufsteigend)
		// return this.hersteller.compareTo(c.hersteller);
		
		// Verglcih nach PS absteigend
		//return c.leistungPS - this.leistungPS
		return Integer.compare(c.leistungPS, this.leistungPS);
	}
	

    
	public String getHerstellen() {
		return hersteller;
	}
	public void setHerstellen(String herstellen) {
		this.hersteller = herstellen;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getLeistungPS() {
		return leistungPS;
	}
	public void setLeistungPS(int leistungPS) {
		this.leistungPS = leistungPS;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public int getAnzahlTueren() {
		return anzahlTueren;
	}
	public void setAnzahlTueren(int anzahlTueren) {
		this.anzahlTueren = anzahlTueren;
	}
	
	public String toString() {
		return  "Auto " + "[" + "hersteller="+ hersteller + ", " + "model="+model + ", " +"leistungPS="+  leistungPS + ", " + "maxSpeed=" + maxSpeed  + ", " + "anzahlTueren="+ anzahlTueren + "]";
	}
	
	
}
