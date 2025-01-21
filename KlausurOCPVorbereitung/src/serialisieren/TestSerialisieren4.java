package serialisieren;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;


class Potter{

}
class Hawgward implements Serializable{
	 Potter p = new Potter();
}

public class TestSerialisieren4 {


	public static void main(String[] args) throws FileNotFoundException {
		
		Hawgward h = new Hawgward();
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Hawgward.Test"))){
			oos.writeObject(h);
			oos.close();
			System.out.println("done");
		} catch (IOException e) {
			System.out.println("exe");
		}

		/*
		 * result : exe	
		 * 
		 * สาเหตุของข้อผิดพลาด:
		 * เมื่อคลาส Hawgward พยายามทำการ serialization ของอ็อบเจ็กต์, มันจะตรวจสอบว่าอ็อบเจ็กต์ทั้งหมดที่เกี่ยวข้องสามารถทำการ serialization ได้หรือไม่
		 * เพราะว่า Potter ไม่ได้ implement Serializable, การทำ serialization ของ Hawgward จะล้มเหลว
		 * ผลลัพธ์คือ ข้อความ exe จะถูกพิมพ์ออกมา (จากการจับข้อผิดพลาด IOException)
		 * 
		 * Wenn Potter transient definiert wird , es wird 'done' ausgeben
		 */
	}
}
