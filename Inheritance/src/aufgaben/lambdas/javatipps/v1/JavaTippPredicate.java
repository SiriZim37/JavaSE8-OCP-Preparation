package aufgaben.lambdas.javatipps.v1;

import java.util.function.Predicate;

public class JavaTippPredicate   {

	static Predicate<JavaTipp> hasThema(int thema ) {
		return  tip -> {
            for (int t : tip.getThemen()) {
                if (t == thema) {
                    return true;
                }
            }
            return false ;
		};

	}

	static Predicate<JavaTipp> selectThema1WithoutThema2(int thema1 ,  int thema2) {
		return tip -> {
            boolean hasThema1 = false;
            boolean hasThema2 = false;
            for (int t : tip.getThemen()) {
                if (t == thema1) {
                	hasThema1 = true;
                }
                if (t == thema2) {
                	hasThema2 = true;
                }
            }
            return hasThema1 && !hasThema2;
        };
        
        
//        return t -> t.getThemen().contains(thema1) && !t.getThemen().contains(thema1);
	}
	
    public static Predicate<JavaTipp> themenContainsIgnoreCase(String substring) {
        return tip -> tip.getText().toLowerCase().contains(substring.toLowerCase());
    }
    
    
    public static Predicate<JavaTipp> withOutThisThema(int thema) {
    	return tip -> {
            for (int t : tip.getThemen()) {
                if (t == thema) {
                    return false;
                }
            }
            return true ;
		};
	}
	
}
