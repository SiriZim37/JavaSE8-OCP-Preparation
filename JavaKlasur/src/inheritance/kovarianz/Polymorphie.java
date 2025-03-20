package inheritance.kovarianz;



class Auto{	
}

class Opel extends Auto{
}

class Mercedes extends Auto{
}

class MM extends Mercedes{
}


// kovariante Rückgabewerte Überschreiben (Overriding).

class AutoFabrik{
	static AutoFabrik getInstance() {
//		return new OpelFabrik();
		return new MecedesFabrik();
	}
	
	Auto buildAuto() {
		return new Auto();
	}
}

class OpelFabrik extends AutoFabrik{
	
	Opel buildAuto() {
		return new Opel();
	}
}


class MecedesFabrik extends AutoFabrik{
	
	Mercedes buildAuto() {
		return new Mercedes();
	}
}

public class Polymorphie {

	public static void main(String[] args) {
		/*
		 * Universeller Code
		 */
		
		AutoFabrik f = AutoFabrik.getInstance();
		
		Auto a = f.buildAuto();
		
		System.out.println(a);
		
		/*
		 * Spezzieller Code
		 */
		
		MecedesFabrik mf = new MecedesFabrik();
		
		MM m = (MM) mf.buildAuto(); // java.lang.ClassCastException:
		
		System.out.println();

	}

}
