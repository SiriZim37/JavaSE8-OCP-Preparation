package aufgaben.lambdas.javatipps.v2;

import java.util.List;

public class JavaTipp2 {

	    private String text;
	    private List<String> themen;

	    public JavaTipp2(String text, List<String> themen) {
	        this.text = text;
	        this.themen = themen;
	    }

	    public String getText() {
	        return text;
	    }

	    public List<String> getThemen() {
	        return themen;
	    }

	    @Override
	    public String toString() {
	        return "Text: " + text + ", Themen: " + themen;
	    }

}
