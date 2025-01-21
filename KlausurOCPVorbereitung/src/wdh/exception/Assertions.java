package wdh.exception;

public class Assertions {

	/*
	 * 1. Assertions are used for debugging and checking assumptions, not for handling runtime errors.
	 * 2. Assertions are disabled by default and need to be enabled with the -ea flag at runtime.
	 * 3. The condition in an assertion must evaluate to a boolean expression.
	 * 4. Assertions cannot be used in production environments for exception handling.
	 * 5. The performance impact of assertions is negligible when disabled.
	 * 6. Assertions can be used in multithreaded environments but 
	 *    should be used with caution in performance-critical areas.
	 * 7. Assertions are for debugging and testing during development, not for validating 
	 * 		user input or business logic in public methods.
	 * 8. Public methods should rely on exceptions to handle invalid conditions or inputs.
	 * 9. Assertions can be disabled at runtime, so using them for 
	 * 		critical logic in public methods can lead to unpredictable behavior in production.
	 */
	
	/*
	 * 1. Assertions ใช้สำหรับการดีบักและตรวจสอบสมมติฐาน ไม่ใช่สำหรับการจัดการข้อผิดพลาดในขณะรันไทม์
	 * 2. Assertions ถูกปิดใช้งานโดยค่าเริ่มต้น และต้องเปิดใช้งานด้วย -ea flag ในการรันโปรแกรม
	 * 3. เงื่อนไขใน assertion จะต้องเป็นนิพจน์ที่สามารถประเมินได้เป็นค่า boolean
	 * 4. Assertions ไม่สามารถใช้ในสภาพแวดล้อมการผลิตเพื่อจัดการข้อยกเว้นได้
	 * 5. ผลกระทบด้านประสิทธิภาพจากการใช้ assertions จะไม่มีความสำคัญเมื่อมันถูกปิดการใช้งาน
	 * 6. Assertions สามารถใช้ในสภาพแวดล้อมหลายเธรดได้ แต่ควรใช้ด้วยความระมัดระวังในพื้นที่ที่มีความสำคัญทางด้านประสิทธิภาพ
	 * 7. Assertions เหมาะสำหรับการดีบักและการทดสอบในระหว่างการพัฒนา ไม่ใช่สำหรับการตรวจสอบข้อมูลที่ผู้ใช้ป้อนหรือตรรกะทางธุรกิจ public methods.
	 * 8. public methods. ใช้ exceptions การจัดการกับเงื่อนไขหรือข้อมูลที่ไม่ถูกต้อง
	 * 9. Assertions สามารถปิดการใช้งานได้ในระหว่างการรัน ดังนั้นการใช้ assertions
	 *  	สำหรับตรรกะที่สำคัญใน public methods อาจทำให้เกิดพฤติกรรมที่ไม่สามารถคาดเดาได้ในสภาพแวดล้อมการผลิต
	 */

}
