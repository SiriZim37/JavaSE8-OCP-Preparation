package ocp;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IO_NIO2 extends Dog {

	public static void main(String[] args) {
		try {
		    final List<String> lines = Files.readAllLines(Paths.get("readings.csv"));
		    for (String line: lines) {
		        System.out.println(line);
		    }
		} catch (IOException e) {
		    System.out.println("Error: " + e);
		}
	}
	
	/*
	 * 
	 * Which code fragment(s), inserted independently below, will produce the same output? (Choose all that apply.)
	 * 
	 * A.
	 * try (Stream<List<String>> stream = Files.lines(Paths.get("readings.csv"))) {
	 *     stream.flatMap(l -> l.stream()).forEach(System.out::println);
	 * } catch (IOException e) {
	 *     System.out.println("Error: " + e);
	 * }
	 * 
	 * B.
	 * try (Stream<String> stream = Files.lines(Paths.get("readings.csv"))) {
	 *     stream.forEach(System.out::println);
	 * } catch (IOException e) {
	 *     System.out.println("Error: " + e);
	 * }
	 * 
	 * C.
	 * try (Stream<String> stream = Files.lines(Paths.get("readings.csv"))) {
	 *     stream.get().forEach(System.out::println);
	 * } catch (IOException e) {
	 *     System.out.println("Error: " + e);
	 * }
	 * 
	 * D.
	 * try (Stream<String> stream = Files.lines(Paths.get("readings.csv"))) {
	 *     stream.collect(Collectors.toList()).forEach(System.out::println);
	 * } catch (IOException e) {
	 *     System.out.println("Error: " + e);
	 * }
	 * 
	 * B and D are correct. In B, we get a Stream from Files.lines(); this streams the data from the file in lines. We use forEach() to take each line and display it. In D, we collect each line from the file into a list, and then call forEach() on that list to take the lines and display them.
	 * 
	 * A and C are incorrect.
	 * 
	 * คำอธิบาย:
	 * - A: ข้อนี้ไม่ถูกต้อง เพราะการใช้ `flatMap` กับ `Stream<List<String>>` นั้นไม่จำเป็น และไม่ได้ผลลัพธ์เหมือนกับการอ่านไฟล์ทีละบรรทัด
	 * - B: ข้อนี้ถูกต้อง เพราะการใช้ `Files.lines` คืนค่าเป็น `Stream<String>` ซึ่งอ่านไฟล์ทีละบรรทัด และ `forEach` ใช้เพื่อแสดงผลแต่ละบรรทัด
	 * - C: ข้อนี้ไม่ถูกต้อง เพราะ `stream.get()` จะทำให้เกิดข้อผิดพลาด เนื่องจาก `Stream<String>` ไม่มี `get()` เมธอด
	 * - D: ข้อนี้ถูกต้อง เพราะ `collect(Collectors.toList())` เก็บผลลัพธ์ไว้ในลิสต์ จากนั้นใช้ `forEach` เพื่อแสดงแต่ละบรรทัดจากลิสต์
	 */

	
}

