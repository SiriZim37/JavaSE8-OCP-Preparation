package aufgaben;

enum Belaege{
	TOMATEN, PILZE, SALAMI, SCHINKEN, ARTISCHOCKEN, KÄSE , BROCCOLI ;

	static boolean isValid(String belag ) {
		for (Belaege bl : Belaege.values()) {
            if (bl.name().toLowerCase().equals(belag.trim().toLowerCase())) {
                return true;
            }
        }
        return false;
	}
}

//// ES DARF NUR MAXIMAM 1 PUBLIC SEIN

public class PizzaService {

	public static void main(String[] args)  {  // Kommandozeile
		//args =  new String[]{ "dasdsa", "15614564" };
	
		try{
			if(args.length!=3) {
				throw new IllegalToppingsCountException("Bitte geben Sie bis zu drei Beläge ein." + args.length);

			}
			
			try{
		         validateBelag(args);  
		         for(String belag : args) {
		        	 if(Belaege.isValid(belag)) {
		        		  System.out.println("- " + capitalize(belag));
		        	 }
		         }
		     } catch (BadFoodException e) {  //  BadFoodException() muss behaldelt oder deklariert
		    	 System.out.println(getBelaege());
		         System.err.println("Fehler: " + e.getMessage());
		     }
			
		}catch (IllegalToppingsCountException e) {
			 System.err.println("Fehler: " + e.getMessage());
		}

	}

	static void validateBelag(String[] belaege) throws BadFoodException {
	    for (String b : belaege) {
	        if (!Belaege.isValid(b)) {	 	
	            throw new BadFoodException("Der Pizzabelag : < " + b + " > ist ungültig.");
	          
	        }
	    }
	}
	
	private static String capitalize(String str) {
	        if (str == null || str.isEmpty()) {
	            return str;
	        }
	        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}
	  
	static StringBuilder getBelaege() {
		StringBuilder sb = new StringBuilder();		
		sb.append("Die Pizzabestellung enthält die folgenden Beläge").append(System.getProperty("line.separator"));
		sb.append("- Tomaten").append(System.getProperty("line.separator"));
		sb.append("- Pilze").append(System.getProperty("line.separator"));
		sb.append("- Salami").append(System.getProperty("line.separator"));
		sb.append("- Schinken").append(System.getProperty("line.separator"));
		sb.append("- Artischocken").append(System.getProperty("line.separator"));
		sb.append("- Käse").append(System.getProperty("line.separator"));
		sb.append("- Broccoli").append(System.getProperty("line.separator"));
		return sb;
	}
	
}


class BadFoodException extends Exception {
	BadFoodException(String message) { // public oder kein public sind gleichbedeutend mit Sichtbarkeit.
	    super(message);
	}
}

class IllegalToppingsCountException extends RuntimeException {
	IllegalToppingsCountException(String message) {
	    super(message);
	}
}


