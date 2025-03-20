package vererbung;

import java.time.Period;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class B25_Interfaces_Lambdas {

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
	

		Car[] cars = { a1,a2,a3,a4,a5 ,a6 , a7 , a8 , a9 , a10};
		
		System.out.println("1.  Standard \n");
		System.out.println("Car with max speed = " + getCarWithmaxSpeed(cars));
		

        System.out.println("\n2. FilterCarsWithSpeedGreater100 \n");
        Car[] results = filterCarsWithSpeedGreater100(cars);

        for (Car car : results) {
            System.out.println(car);
        }
        
        System.out.println("\n3. FilterCarsWithDoorGreater4 \n");
        Car[] carFilterDoor4 = filterCarsWithDoorGreaterthan4(cars);

        for (Car car : carFilterDoor4) {
            System.out.println(car);
        }
        
        //**************** Lambda-Ausdruck für Predicate ***********************/
        Predicate<Car> pred1 = (Car auto)-> {
        	return auto.getLeistungPS() >=100;
        };
       
        pred1 = auto -> auto.getLeistungPS () >=100; 
        System.out.println("\n4. Auto mit mehr als 100 PS als Lambda-Ausdruck\n");
        results = filterCars(cars, pred1) ;
        for (Car car : results) {
            System.out.println(car);
        }
        
        System.out.println("\n5. Auto mit Herstelle . der mit F\n");
        Predicate<Car> pred2 = auto -> auto.getHerstellen().startsWith("F");
      
        results = filterCars(cars, pred2) ;
        for (Car car : results) {
            System.out.println(car);
        }

           /*
         *  Vorausshau auf Stream im OCP
         */
        System.out.println("\n6. Auto mit mehr als 150 PS als Stream\n");
        Predicate<Car> pred3 = auto -> auto.getLeistungPS () >= 100; 
        Arrays.stream(cars).filter(pred3).forEach(System.out::println);
        

        Predicate<Car> p4 = auto-> auto != null; // ok 
        Predicate<Car> p6 = auto-> { return auto.getLeistungPS() >=100 ; } ; // ok
        Predicate<Car> p7 = auto-> {int i = 100; return auto.getLeistungPS() >=100 ;}; // ok
        Predicate<Car> p8 = (Car auto) -> {return auto.getLeistungPS() >=100 ;}; // ok
        
//      Predicate<Car> p5 = auto->  return auto.getLeistungPS() >=100; // cf
//      Predicate<Car> p3 = auto-> auto; // cf 
//      Predicate<Car> p8 = Car auto -> {return auto.getLeistungPS() >=100 ;}; // cf
        
        /*
         * lambda expressions with Predicate 
         * (parameters) -> expression that returns boolean
         * @FunctionalInterface
			interface Predicate<T> {
			    boolean test(T t);
			}
			Predicate<String> isEmpty = s -> s.isEmpty();
			Predicate<Integer> isPositive = num -> num > 0;
         * 
         */
        
        // WDH Lambdas
        /*
         * 		 parameters) -> expression
         * 		(x, y) -> x + y
         * 
         ****** GÜLTIG LAMBDAS *******
         * @FunctionalInterface
			interface MyFunction {
	    		int apply(int a, int b);
			}
			MyFunction add = (a, b) -> a + b;  // OK 
			----- 2 ----- 
			@FunctionalInterface
			interface PrintMessage {
			    void print(String message);
			}
			
			PrintMessage printer = message -> System.out.println(message); // OK 
			----- 3 ----- 
			@FunctionalInterface
			interface NoArg {
			    void run();
			}
			NoArg greet = () -> System.out.println("Hello!"); // OK 
			
			--- 4 ---- 
			@FunctionalInterface
			interface MyFunction {
			    int apply(int a, int b);
			}
			
			MyFunction add = (a, b) -> {
			    int result = a + b;
			    return result;
			};
         * 
         */
        
	}// end of main 
	
	
	// Wir machen wir nur in eine Mthode statt dass
	// filterCarsWithDoorGreaterthan4 & filterCarsWithSpeedGreater100 zu erzeugen! 
	
	public static  Car[] filterCars(Car[] cars , Predicate<Car> pred) {
		  Car[] temp = new Car[cars.length];
		  
		int index = 0;
	    for (Car car : cars) {
	        if (pred.test(car)) {
	        	temp[index++] = car ;
	        }
	    }
	    Car[] results = new Car[index];

	   index = 0;
	    for (Car car : temp) {
	        if (car != null) {
	            results[index++] = car;
	        }
	    }
	    return results;
	    
	}
	
	
	
	public static Car[] filterCarsWithDoorGreaterthan4(Car[] cars) {
		
	    int count = 0;
	    for (Car car : cars) {
	        if (car.getAnzahlTueren() >= 4) {
	            count++;
	        }
	    }
	    Car[] results = new Car[count];

	    int index = 0;
	    for (Car car : cars) {
	        if (car.getAnzahlTueren() >= 4) {
	            results[index++] = car;
	        }
	    }
	    return results;
	}
	
	public static Car[] filterCarsWithSpeedGreater100(Car[] cars) {
		
	    int count = 0;
	    for (Car car : cars) {
	        if (car.getLeistungPS() >= 100) {
	            count++;
	        }
	    }
	    Car[] results = new Car[count];

	    int index = 0;
	    for (Car car : cars) {
	        if (car.getLeistungPS() >= 100) {
	            results[index++] = car;
	        }
	    }
	    return results;
	}
	
	
	public static Car getCarWithmaxSpeed(Car[] cars) {
		if(cars == null || cars.length == 0)
			return null ;
		
		Car carMaxSpeed = cars[0];
		
		for(Car c : cars ) {
			if(carMaxSpeed.getMaxSpeed() < c.getMaxSpeed()) {
				carMaxSpeed = c ; 
			}
		}
		return carMaxSpeed;
		
	}
	
	

}
