package serialisieren;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


class ClassA implements Serializable{
	public ClassA() {
		System.out.println("ClassA");
	}
}
class ClassB extends ClassA{    // B is-A subclass of ClassA and can serialize
	int id;
	public ClassB(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ClassB. id=" +id;
	}
}

class ClassC extends ClassA{    // C is-A subclass of ClassA but cannt serialize because WimWim is not serialize
	transient WimWim w = new WimWim();
	@Override
		public String toString() {
			return  "ClassC. . WimWim: " + w;
		}
}

class WimWim  {}  
/*
 * C is-A subclass of ClassA but cannt serialize because WimWim is not serialize
 * 
 * Solve > 1. class WimWim implement Serializable {}   it must implements Serializable
 *     
 * if use   transient WimWim w = new WimWim(); in Class C 
 *         (การใช้ transient ทำให้ attribute นั้นไม่ถูกจัดเก็บเมื่อทำการ serialisieren 
*	       ซึ่งเป็นวิธีที่ใช้ในการละเว้นข้อมูลที่ไม่ต้องการเก็บในกระบวนการนี้)
 */    
public class TestSerialisierenBasicClass {

	public static void main(String[] args) throws FileNotFoundException {
		
		ClassB b1 = new ClassB(33);
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("b.bin"))) {
			
			oos.writeObject(b1);
			System.out.println("Serialisiert : " + b1 );
		}catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("--------------------------------------------------------------------");
		ClassB b2;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("b.bin"))){
			
			b2 = (ClassB)ois.readObject();
			System.out.println("Deserielisiert : " + b2);
			
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}


		System.out.println("\n\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		ClassC c1 = new ClassC();
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c.bin"))) {
			
			oos.writeObject(c1);
			System.out.println("Serialisiert : " + c1 );
		}catch (IOException e) {
			e.printStackTrace();  // NotSerializableException: serialisieren.WimWim
		}

		System.out.println("--------------------------------------------------------------------");
		ClassC c2;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c.bin"))){
			
			c2 = (ClassC)ois.readObject();
			System.out.println("Deserielisiert : " + c2);
			
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace(); // NotSerializableException: serialisieren.WimWim
		}
		
				
	}
}
