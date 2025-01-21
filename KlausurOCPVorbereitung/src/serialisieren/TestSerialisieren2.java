package serialisieren;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

class GameObject{
	public int id;
	public GameObject() {
		System.out.println("GameObject");
	}
}
class Fisch{}

class Aquarium2 extends GameObject implements Serializable{ 
	
	int preis;
	String name;
	Fisch[] fische = new Fisch[5];
	int[] arr = new int[] { 5,6,7,8};
	
	public Aquarium2(int preis) {
		this.preis = preis;
	}
	public String toString() {
		return "Aquarium. id=" + id
				+ ", name= " + name
				+ ", preis= " + preis 
				+ ", int= " + Arrays.toString(arr)
				+ ", fische= " + Arrays.toString(fische);
	}
}

public class TestSerialisieren2 {

	/*
	 * 1. String เป็นชนิดข้อมูลที่มีอยู่แล้วในรูปแบบ Serializable เพราะมันเป็น java.lang.String ซึ่งโดยธรรมชาติรองรับ java.io.Serializable อยู่แล้ว 
	 * 
	 * 2. Array ใน Java ไม่ได้เป็น Serializable โดยตรงทุกประเภท แต่ถ้าเป็น Array ที่ประกอบด้วยชนิดข้อมูลที่ Serializable 
	 *(เช่น String[] หรือ Integer[]) คุณสามารถ serialisieren ได้ทันที:
	 *
	 ***** ถ้าเป็น Array ของชนิดข้อมูลที่ไม่ Serializable เช่น custom object จะต้อง implement Serializable ก่อน
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Aquarium2 a1 = new Aquarium2(1);
		a1.id = 1;
		a1.preis = 33;
		a1.name = "Gross";			// ok String has Serializable
		a1.fische[0] = new Fisch(); // Fisch is not serialisieren 
									
		
		// Serialisieren #1
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.bin"))) {
			
			oos.writeObject(a1);
			System.out.println("Serialisiert : " + a1 ); 
		}catch (IOException e) {
			e.printStackTrace();     // java.io.NotSerializableException serialisieren.Fisch
		}

		System.out.println("--------------------------------------------------------------------");
		Aquarium2 a2;
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.bin"))){
			
			a2 = (Aquarium2)ois.readObject();
			System.out.println("Deserielisiert : " + a2); 
			
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace(); // java.io.WriteAbortedException: writing aborted; java.io.NotSerializableException: serialisieren.Fisch
		}

				
	}
}
