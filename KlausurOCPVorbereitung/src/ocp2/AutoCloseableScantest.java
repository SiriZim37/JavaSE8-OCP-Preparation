package ocp2;

 class ImageScanner implements AutoCloseable {
    public void close() throws Exception {
        System.out.print("Scanner closed. ");
    }

    public void scanImage() throws Exception {
        System.out.print("Scan. ");
        throw new Exception("Unable to scan. ");
    }
}

class ImagePrinter implements AutoCloseable {
    public void close() throws Exception {
        System.out.print("Printer closed. ");
    }

    public void printImage() {
        System.out.print("Print. ");
    }
}


public class AutoCloseableScantest {

    public static void main(String[] args) {
        try (ImageScanner ir = new ImageScanner();
             ImagePrinter iw = new ImagePrinter()) {
            ir.scanImage();
            iw.printImage();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    
    /*
     /**
	 * ขั้นตอนการทำงานของโค้ด:
	 * การใช้ try-with-resources:
	 * - ในบล็อก try-with-resources นี้ ImageScanner และ ImagePrinter ถูกสร้างขึ้น 
	 * และทั้งสองคลาสต้องทำการปิด (close) เมื่อบล็อก try เสร็จสิ้นการทำงาน.
	 *
	 * การทำงานของ scanImage:
	 * - เมื่อเรียก ir.scanImage(), จะพิมพ์ข้อความ "Scan." และจากนั้นจะเกิดการโยน exception ที่มีข้อความ "Unable to scan.".
	 * - เนื่องจากเกิด exception ใน scanImage(), การทำงานจะข้ามไปที่ catch และไม่ไปเรียก iw.printImage() ต่อ.
	 *
	 * การทำงานของ catch:
	 * - เนื่องจาก exception ถูกโยนออกมาจาก scanImage(), ข้อความ "Unable to scan." จะถูกพิมพ์ออกมาจาก catch.
	 *
	 * การปิด Resource:
	 * - เมื่อ try-with-resources จบการทำงาน (ไม่ว่าจะสำเร็จหรือเกิด exception) ก็จะทำการเรียก close() 
	 * 	สำหรับ ImageScanner และ ImagePrinter ตามลำดับ.
	 * - เนื่องจาก ImageScanner ปิดก่อน ImagePrinter ภายใน try-with-resources, 
	 * 	จึงพิมพ์ "Scanner closed." ก่อน จากนั้น ImagePrinter จะปิดและพิมพ์ "Printer closed.".
	 *
	 * การพิมพ์ข้อความ:
	 * - ข้อความที่พิมพ์ในลำดับ:
	 *   1. "Scan." จากการเรียก ir.scanImage().
	 *   2. "Unable to scan." จาก catch.
	 *   3. "Scanner closed." จากการปิด ImageScanner.
	 *   4. "Printer closed." จากการปิด ImagePrinter.
	 */

     
}
