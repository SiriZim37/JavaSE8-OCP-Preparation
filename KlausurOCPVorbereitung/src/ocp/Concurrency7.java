package ocp;

public class Concurrency7 {
	/* 
	Question and Choices:
	List<String> goodDogs = 
	   Arrays.asList("Boi", "Charis", "Clover", "Buffy", "Rex", "Fido");
	goodDogs.stream()
	        .unordered()                    // L1
	          .parallel()
	          .filter(d -> d.startsWith("B") || d.startsWith("C"))
	          .forEach(System.out::println);    // L2
	Which are true? (Choose all that apply.)

	A.
	As is, the output is predictable.

	B.
	As is, the output is unpredictable.

	C.
	If we remove L1, the output is predictable.

	D.
	If we leave L1 and replace L2 with

	.forEachOrdered(System.out::println);
	the output is predictable.

	E.
	If we remove L1 and replace L2 with

	.forEachOrdered(System.out::println);
	the output is predictable.

	Answer Explanation:
	B and E are correct. In B, as is, we are streaming unordered, using forEach() with System.out.println(), which creates a side effect, so the order of output is not guaranteed. In E, if we remove L1, then the stream is ordered, and we force the output to be ordered (in the same order as the source items) with forEachOrdered().

	A, C, and D are incorrect. In C, removing unordered() doesn’t help, as we still have a side effect (forEach() with System.out.println()) with a parallel stream, so the output is not predictable. In D, if we leave unordered() and use forEachOrdered(), we will very likely see the same order (because calling unordered() just unsets the ORDERED characteristic and does not change the ordering of the source), but we aren’t guaranteed the correct order since the stream is no longer ordered.
	*/

	/*
	คำอธิบายภาษาไทย:
	1. ในตัวเลือก B: โค้ดที่กำหนดใช้ unordered() ซึ่งบอกให้ Stream ไม่ต้องรักษาลำดับที่มาจากแหล่งข้อมูลเดิม และใช้ parallel stream 
	   (เรียกแบบขนาน) ร่วมกับ forEach() ดังนั้นลำดับผลลัพธ์ที่ได้จาก System.out.println() จะไม่สามารถคาดเดาได้

	2. ในตัวเลือก E: ถ้าเอา unordered() (บรรทัด L1) ออก จะทำให้ Stream กลับมารักษาลำดับข้อมูลตามแหล่งข้อมูลเดิม 
	   และถ้าเปลี่ยน forEach() เป็น forEachOrdered() จะบังคับให้ผลลัพธ์ออกมาตามลำดับเดิมของแหล่งข้อมูล

	3. ตัวเลือก A, C, และ D ผิด:
	   - ตัวเลือก A: ลำดับยังคงไม่สามารถคาดเดาได้เพราะ parallel stream ใช้ forEach() ซึ่งไม่การันตีลำดับ
	   - ตัวเลือก C: การเอา unordered() ออกไม่ช่วยอะไรเพราะยังใช้ parallel stream กับ forEach()
	   - ตัวเลือก D: การใช้ unordered() ร่วมกับ forEachOrdered() อาจทำให้ลำดับเหมือนเดิมในบางกรณี 
	     แต่ไม่สามารถการันตีได้ เนื่องจาก unordered() ทำให้ Stream ไม่รักษาลำดับ
	*/

}
