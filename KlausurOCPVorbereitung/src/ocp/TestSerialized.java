package ocp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class AAnimal {
	AAnimal(String n ) { System.out.print("a"); } // Constructor prints "a"
}

class DDog extends AAnimal implements Serializable {
	DDog(String n ) { super("test"); System.out.print("d"); } // Constructor prints "d"
}

class Beagle extends DDog {
	 Beagle() { super("test"); System.out.print("c"); }
}

public class TestSerialized {

	public static void main(String[] args) {
		 try {
	            // Creating and printing Beagle instance
	            Beagle beagle1 = new Beagle(); // Prints "a d"
	            
	            // Serializing Beagle instance
	            FileOutputStream fos = new FileOutputStream("beagle.ser");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(beagle1);
	            oos.close();
	            fos.close();

	            System.out.print(" "); // Separator to make output clearer

	            // Deserializing Beagle instance
	            FileInputStream fis = new FileInputStream("beagle.ser");
	            ObjectInputStream ois = new ObjectInputStream(fis);
	            Beagle beagle2 = (Beagle) ois.readObject(); // Prints "a"
	            ois.close();
	            fis.close();

	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		
	}
	
	
}