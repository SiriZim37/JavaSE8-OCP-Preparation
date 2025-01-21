package serialisieren;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class Aquarium implements Serializable{ 
	int preis;
	public Aquarium(int preis) {
		this.preis = preis;
	}
	public String toString() {
		return "Aquarium. preis= " + preis;
	}
}

public class TestSerialisieren {

	public static void main(String[] args) throws FileNotFoundException {
		
		Aquarium a1 = new Aquarium(1);
		a1.preis = 13;
		// Serialisieren #1
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.bin"))) {
			
			oos.writeObject(a1);
			System.out.println("Serialisiert : " + a1 ); // Serialisiert : serialisieren.Aquarium@5315b42e
														 // wenn ToString implementiert : Aquarium. preis= 13
		}catch (IOException e) {
			e.printStackTrace();
		}

		//---------------------------------------------------------------------
		Aquarium a2;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.bin"))){
			
			a2 = (Aquarium)ois.readObject();
			System.out.println("Deserielisiert : " + a2); // Deserielisiert : serialisieren.Aquarium@4678c730
														  // wenn ToString implementiert : Aquarium. preis= 13
			
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

//		System.out.println("Deserielisiert : " + a2);   // a2 muss initialisiert
				
	}
}
