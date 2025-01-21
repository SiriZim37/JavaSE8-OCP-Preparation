package aufgaben.a3;

interface Tontraeger {}

class Schallplatte implements Tontraeger {}

class Tonband implements Tontraeger {}

class CD implements Tontraeger {}

class Abspielgeraet<T extends Tontraeger> {
	void abspielen(T tontrager) {
		System.out.println("Abspielt : " + tontrager);
	}
}

public class TestGenericsTontraeger {

	public static void main(String[] args) {
		
		Abspielgeraet<Schallplatte> agSchallplatte = new Abspielgeraet<>();
		agSchallplatte.abspielen(new Schallplatte());		// ok  	nur  nur CD kompliert kompliert
//		agSchallplatte.abspielen(new CD());					// cf 
//		agSchallplatte.abspielen(new Tonband());			// cf 
//		agSchallplatte.abspielen("testString");				// cf 
		
		Abspielgeraet<CD> agCD = new Abspielgeraet<>();
//		agCD.abspielen(new Schallplatte());					// cf 
		agCD.abspielen(new CD());							// ok : nur CD kompliert
//		agCD.abspielen(new Tonband());						// cf 
//		agSchallplatte.abspielen("testString");				// cf 
		
		
		Abspielgeraet<Tonband> agTonband = new Abspielgeraet<>();
//		agTonband.abspielen(new Schallplatte());			// cf 
//		agTonband.abspielen(new CD());						// cf 
		agTonband.abspielen(new Tonband());					// ok : nur Tonband kompliert
//		agTonband.abspielen("testString");					// cf 			
	
	}

}
