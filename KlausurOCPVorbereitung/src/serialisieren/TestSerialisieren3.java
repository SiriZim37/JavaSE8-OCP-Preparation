package serialisieren;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/*
 * Serializable: การทำให้คลาส Oliv implements Serializable 
 * ทำให้สามารถเก็บสถานะของอ็อบเจ็กต์ Oliv ได้ 
 * แต่คลาส Popeye ไม่ได้ทำการ implement Serializable อย่างชัดเจน
 */
class Popeye{
	public Popeye() {
		System.out.print("P");
	}
}
class Oliv extends Popeye implements Serializable{
	public Oliv() {
		System.out.print("O");
	}
}

public class TestSerialisieren3 {

	/*
	 * สำคัญ: ในระหว่างการ Deserialization, คอนสตรัคเตอร์ของคลาส Oliv จะไม่ถูกเรียกใช้ 
	 * เพราะว่าคอนสตรัคเตอร์ของคลาส Oliv ถูกข้ามไปในระหว่างการ Deserialization. แค่คอนสตรัคเตอร์ของ Popeye (ซึ่งเป็น superclass) ที่จะถูกเรียกเพื่อทำการสร้างอ็อบเจ็กต์.
	 * ดังนั้น ในระหว่าง Deserialization จะพิมพ์แค่ "P" ซึ่งเป็นการเรียกคอนสตรัคเตอร์ของ Popeye เท่านั้น.
	 * 
	 *
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Oliv a1 = new Oliv();
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.Test"))){
			oos.writeObject(a1);
			
		} catch (IOException e) {
			System.out.println(e);
		}
		
		Oliv a2;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.Test"))){
			a2 = (Oliv)ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
		}

	
		/*
		 * result : POP	
		 */
	}
}
