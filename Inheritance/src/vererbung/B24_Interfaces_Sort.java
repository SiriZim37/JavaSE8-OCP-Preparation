package vererbung;

import java.util.Comparator;
import java.util.Arrays;

public class B24_Interfaces_Sort {

	public static void main(String[] args) {
		String[] strings = {"Volk" , "audi"  , "Golf"  , "Audi" , "Citron" , "Fiat" , };
		
		System.out.println("\n****** vorher *******\n");
	
		
		for( String string : strings) {
			System.out.print(string + "  ");  // aufgabe : Volk  audi Golf  Audi  Citron  Fiat  !
		}
		

		System.out.println("\n****** nacher *******\n");
		
		Arrays.sort(strings);
		for( String string : strings) {
			System.out.print(string + "  "); // Aufgabe : Audi  Citron  Fiat  Golf  Volk  audi !
		}

		System.out.println("\n*****************\n");

		
		Car a1 = new Car("Volk" , "Golf"  , 90 , 210 , 5 ) ;
		Car a2 = new Car("Ford" , "Fiesta"  , 75 , 200 , 5 ) ;
		Car a3 = new Car("Audi" , "A3"  , 100 , 270 , 5 ) ;
		Car a4 = new Car("Cittron" , "Plurierl"  , 73 , 180 , 3 ) ;
		Car a5 = new Car("Fiat" , "500"  , 80 , 205 , 3 ) ;

		Car[] autos = { a1,a2,a3,a4,a5};
		
		System.out.println("\n****** vorher *******\n");
		
		for( Car auto : autos) {
			System.out.println(auto);
		}
		
		// Autos sortieren (Standard)
		Arrays.sort(autos);
		
		System.out.println();
		System.out.println("\n****** nacher *******\n");
		for( Car auto : autos) {
			System.out.println(auto); 
		}
		// Exception : java.lang.ClassCastException 
		// class vererbung.Car cannot be cast to class java.lang.Comparable 
		// (vererbung.Car is in unnamed module of loader 'app'; java.lang.Comparable 
	
		System.out.println("*****************");
		
		
		System.out.println("********Autos sortieren mit Comparator*********");
		// Autos sortieren mit Comparator
		Arrays.sort(autos , new MayCarComparator());
		
		
		for( Car auto : autos) {
			System.out.println(auto); 
		}
		
		System.out.println("*****************");
		
		Arrays.sort(autos , Comparator.comparing(Car::getMaxSpeed).reversed());  
		// Car::getMaxSpeed is a method reference that provides the key for comparison. 
		// It refers to the getMaxSpeed() method of the Car class.
		// reversed() changes this to descending order.
		for( Car auto : autos) {
			System.out.println(auto); 
		}
	}
}

 class MayCarComparator implements Comparator<Car> {

    @Override
    public int compare(Car c1, Car c2) {
    	// Verglcih nach PS absteigend
    	//return c.leistungPS - this.leistungPS
        return Integer.compare(c2.getLeistungPS(), c1.getLeistungPS());
    }
}


// Car-Object müssen vergleichbar sein , um sie sortieren zu können.
// Typisierung auf Car macht compareTo-Methode mit Parameter Car möglich, man spart sich den DownCast
// Das Interface Comparable repräsentiert die Standardsortierung
class Car implements Comparable<Car>{
	
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
		return  "Auto " + "[" + hersteller + "," + model + "," +  leistungPS + "," + maxSpeed  + "," +anzahlTueren + "]";
	}
	
	
}
