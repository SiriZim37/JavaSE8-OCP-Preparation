package nio;

public class A00_FileAllMethode {
	/*
		 เมธอดทั้งหมดของ java.nio.file.Files สำหรับ Java SE 8
		 คลาส Files ในแพ็กเกจ java.nio.file เป็นคลาสยูทิลิตี้ที่มีเมธอดคงที่ (static methods)
		 สำหรับการทำงานกับไฟล์และไดเรกทอรี เช่น การคัดลอก, ย้าย, ลบ และตรวจสอบสถานะไฟล์
	
		 1. สร้างไฟล์หรือไดเรกทอรี
		Path createFile(Path path, FileAttribute<?>... attrs); // สร้างไฟล์ใหม่
		Path createDirectory(Path dir, FileAttribute<?>... attrs); // สร้างไดเรกทอรีใหม่
		Path createDirectories(Path dir, FileAttribute<?>... attrs); // สร้างไดเรกทอรีย่อยพร้อมกัน
		Path createTempFile(String prefix, String suffix, FileAttribute<?>... attrs); // สร้างไฟล์ชั่วคราว
		Path createTempDirectory(String prefix, FileAttribute<?>... attrs); // สร้างไดเรกทอรีชั่วคราว
	
		 2. คัดลอกและย้ายไฟล์
		Path copy(Path source, Path target, CopyOption... options); // คัดลอกไฟล์หรือไดเรกทอรี
		Path move(Path source, Path target, CopyOption... options); // ย้ายหรือเปลี่ยนชื่อไฟล์/ไดเรกทอรี
	
		 3. ลบไฟล์
		void delete(Path path); // ลบไฟล์หรือไดเรกทอรี (ถ้าว่าง)
		boolean deleteIfExists(Path path); // ลบไฟล์หรือไดเรกทอรี (ถ้ามีอยู่)
	
		 4. อ่านและเขียนข้อมูล
		List<String> readAllLines(Path path); // อ่านไฟล์ทั้งหมดเป็น List<String>
		BufferedReader newBufferedReader(Path path, Charset cs); // เปิด BufferedReader สำหรับอ่านไฟล์
		BufferedWriter newBufferedWriter(Path path, Charset cs, OpenOption... options); // เปิด BufferedWriter สำหรับเขียนไฟล์
		byte[] readAllBytes(Path path); // อ่านข้อมูลทั้งหมดจากไฟล์เป็นอาเรย์ของไบต์
		Path write(Path path, byte[] bytes, OpenOption... options); // เขียนข้อมูลไบต์ลงไฟล์
		Path write(Path path, Iterable<? extends CharSequence> lines, Charset cs, OpenOption... options); // เขียนบรรทัดข้อความลงไฟล์
	
		 5. ตรวจสอบคุณสมบัติของไฟล์
		boolean exists(Path path, LinkOption... options); // ตรวจสอบว่าไฟล์/ไดเรกทอรีมีอยู่หรือไม่
		boolean notExists(Path path, LinkOption... options); // ตรวจสอบว่าไฟล์/ไดเรกทอรีไม่มีอยู่
		boolean isReadable(Path path); // ตรวจสอบว่าไฟล์สามารถอ่านได้หรือไม่
		boolean isWritable(Path path); // ตรวจสอบว่าไฟล์สามารถเขียนได้หรือไม่
		boolean isExecutable(Path path); // ตรวจสอบว่าไฟล์สามารถรันได้หรือไม่
		boolean isDirectory(Path path, LinkOption... options); // ตรวจสอบว่าเป็นไดเรกทอรีหรือไม่
	
		 6. การทำงานเกี่ยวกับสตรีม
		Stream<Path> list(Path dir); // คืน Stream ของไฟล์และโฟลเดอร์ในไดเรกทอรี
		Stream<String> lines(Path path); // คืน Stream ของบรรทัดในไฟล์
		Stream<Path> walk(Path start, int maxDepth, FileVisitOption... options); // เดินสำรวจไฟล์และไดเรกทอรีย่อย (กำหนดความลึกได้)
	
		 7. เปรียบเทียบไฟล์
		boolean isSameFile(Path path1, Path path2); // ตรวจสอบว่าไฟล์หรือไดเรกทอรีสองตำแหน่งเป็นไฟล์เดียวกันหรือไม่
		long mismatch(Path path1, Path path2); // (Java 12+) เปรียบเทียบความต่างในไฟล์และคืนตำแหน่งบิตแรกที่ต่างกัน
	
		 8. การอ่าน/ตั้งค่าคุณสมบัติของไฟล์
		FileTime getLastModifiedTime(Path path, LinkOption... options); // คืนเวลาที่แก้ไขล่าสุดของไฟล์
		Path setLastModifiedTime(Path path, FileTime time); // ตั้งค่าเวลาที่แก้ไขล่าสุดของไฟล์
		long size(Path path); // คืนขนาดไฟล์ในไบต์
	
		 9. จัดการ Symbolic Links
		Path createSymbolicLink(Path link, Path target, FileAttribute<?>... attrs); // สร้าง symbolic link
		Path readSymbolicLink(Path link); // อ่าน symbolic link และคืนตำแหน่งที่ลิงก์
	
		 10. การเยี่ยมชมไฟล์ (File Visitor)
		void walkFileTree(Path start, Set<FileVisitOption> options, int maxDepth, FileVisitor<? super Path> visitor); // เดินสำรวจไฟล์ในไดเรกทอรีย่อยพร้อมประมวลผลด้วย File Visitor
		void walkFileTree(Path start, FileVisitor<? super Path> visitor); // สำรวจไฟล์โดยไม่กำหนดความลึก
	
	*/	
}
