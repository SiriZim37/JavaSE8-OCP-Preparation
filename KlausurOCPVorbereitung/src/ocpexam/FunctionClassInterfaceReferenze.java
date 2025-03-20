package ocpexam;

import java.util.Arrays;
import java.util.List;

class Fly {
    private String name;

    public Fly(String name) {
        this.name = name;
    }

    public void fly() {
        System.out.println(name + " is flying");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

interface Flying {
    void fly();
}


public class FunctionClassInterfaceReferenze {

	public static void main(String[] args) {
		
		
		List<Fly> fliers = Arrays.asList(
			    new Fly("Eagle"),
			    new Fly("Sparrow"),
			    new Fly("Pigeon")
			);
		
		
	}
	
	
	/*
	 Options:

		A)
			fliers.forEach(Fly::fly);
		B)
			fliers.forEach(f -> f.fly());
		C)
			fliers.forEach(Flying::fly);
		D)
			fliers.forEach(f -> Flying.fly());
	 */
}
