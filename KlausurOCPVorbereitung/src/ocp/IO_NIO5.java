package ocp;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class IO_NIO5 extends Dog {
	/*
	 * Given the following possible steps to take when working with WatchService:
	 * 
	 * I: Create a WatchService on the default FileSystem.
	 * 
	 * II: Instantiate the WatchService object by calling "new".
	 * 
	 * III: On a Path, register the WatchService without the events.
	 * 
	 * IV: On a Path, register the WatchService and which event types you want to subscribe to in one method call.
	 * 
	 * V: Set the event types to subscribe to.
	 * 
	 * VI: Write logic to process events from the WatchService.
	 * 
	 * Which set of steps will create and run a useful WatchService?
	 * 
	 * A. I, IV, VI
	 * 
	 * B. II, IV, VI
	 * 
	 * C. I, III, V, VI
	 * 
	 * D. II, III, V, VI
	 * 
	 * E. None of the above
	 * 
	 * 
	 * 
	 * A is correct. You call FileSystems.getDefault().newWatchService(); first. Then you register one or more events such as 
	 * dir.register(watcher, ENTRY_DELETE, ENTRY_MODIFY);. (Note: These constants are in the StandardWatchEventKinds class.) 
	 * Finally, you start processing events as they come in. II is not correct because you cannot instantiate WatchService directly. 
	 * III and V are not correct because you have to listen to one or more events at the same time you register the WatchService.
	 * 
		ขั้นตอนที่สำคัญ:
		I. สร้าง WatchService บน FileSystem ที่ใช้โดยค่าเริ่มต้น
			การเริ่มต้น WatchService จำเป็นต้องใช้ FileSystems.getDefault().newWatchService() ซึ่งจะคืนค่าผลลัพธ์เป็น 
			WatchService ที่ใช้ในการติดตามการเปลี่ยนแปลงในไฟล์หรือไดเรกทอรี
		
		II. การสร้างออบเจกต์ WatchService โดยการเรียกใช้ new
			คุณไม่สามารถสร้าง WatchService โดยตรงด้วย new เพราะมันเป็นอินเตอร์เฟส ดังนั้นคำตอบที่มีการใช้ new โดยตรงจะไม่ถูกต้อง
		
		III. การลงทะเบียน WatchService บน Path โดยไม่กำหนดเหตุการณ์
			คุณต้องลงทะเบียน WatchService กับเหตุการณ์ที่ต้องการติดตาม เช่น ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE 
			ดังนั้นการลงทะเบียนโดยไม่มีเหตุการณ์จึงไม่สมบูรณ์
		
		IV. การลงทะเบียน WatchService บน Path พร้อมทั้งเหตุการณ์ที่ต้องการติดตามในคำสั่งเดียว
			นี่คือลำดับที่ถูกต้อง เนื่องจากคุณต้องลงทะเบียนทั้ง WatchService และเหตุการณ์ที่ต้องการติดตามในการเรียกใช้เพียงครั้งเดียว 
			เช่น dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE)
			
		V. การตั้งค่าเหตุการณ์ที่ต้องการติดตาม
			ควรตั้งเหตุการณ์ที่ต้องการติดตามเมื่อคุณลงทะเบียน WatchService กับ Path ซึ่งทำในขั้นตอน IV ดังนั้นขั้นตอนนี้ไม่ได้ถูกต้องแยกต่างหาก
			
		VI. เขียนโลจิกเพื่อประมวลผลเหตุการณ์จาก WatchService
			เมื่อคุณลงทะเบียน WatchService และเหตุการณ์ที่ต้องการติดตามแล้ว คุณต้องมีการประมวลผลเหตุการณ์ที่เกิดขึ้น ซึ่งทำได้ในขั้นตอนนี้
			
			
		การเลือกชุดของขั้นตอนที่ถูกต้อง:
		A. I, IV, VI คือชุดขั้นตอนที่ถูกต้อง เนื่องจากเริ่มต้นด้วยการสร้าง WatchService ด้วย FileSystems.getDefault().newWatchService() (I), ลงทะเบียนเหตุการณ์ที่ต้องการในคำสั่งเดียว (IV), และสุดท้ายก็เริ่มต้นการประมวลผลเหตุการณ์ (VI)
		
		B. II, IV, VI ไม่ถูกต้อง เพราะ WatchService ไม่สามารถถูกสร้างโดยตรงด้วย new (II)
		
		C. I, III, V, VI ไม่ถูกต้อง เพราะการลงทะเบียน WatchService โดยไม่มีเหตุการณ์ (III) หรือการตั้งค่าเหตุการณ์แยกต่างหาก (V) ไม่สามารถทำงานได้
		
		D. II, III, V, VI ไม่ถูกต้อง จากข้อผิดพลาดใน II และ III
		
		E. None of the above ไม่ถูกต้องเพราะ A ถูกต้อง
		
		สรุป: คำตอบที่ถูกต้องคือ A
	 */
/*
	 public static void main(String[] args) throws IOException, InterruptedException {
	        // Step I: Create a WatchService on the default FileSystem
	        WatchService watchService = FileSystems.getDefault().newWatchService();

	        // Step IV: Register the directory with WatchService and specify the events to watch
	        Path path = Paths.get("/myDir"); // Replace with your directory path
	        WatchKey watchKey = path.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

	        System.out.println("Watching directory: " + path);

	        // Step VI: Write logic to process events from the WatchService
	        while (true) {
	            // Wait for the next event
	            WatchKey key;
	            try {
	                key = watchService.take();
	            } catch (InterruptedException ex) {
	                System.out.println("WatchService interrupted");
	                return;
	            }

	            // Process each event
	            for (WatchEvent<?> event : key.pollEvents()) {
	                // Get the event kind and the file path
	                WatchEvent.Kind<?> kind = event.kind();
	                WatchEvent<Path> ev = (WatchEvent<Path>) event;
	                Path fileName = ev.context();

	                System.out.println("Event kind: " + kind + ", File affected: " + fileName);

	                // Handle different event kinds (create, delete, modify)
	                if (kind == ENTRY_CREATE) {
	                    System.out.println("New file created: " + fileName);
	                } else if (kind == ENTRY_DELETE) {
	                    System.out.println("File deleted: " + fileName);
	                } else if (kind == ENTRY_MODIFY) {
	                    System.out.println("File modified: " + fileName);
	                }
	            }

	            // Reset the key to receive further events
	            boolean valid = key.reset();
	            if (!valid) {
	                break;
	            }
	        }
	 }
*/
	
}

