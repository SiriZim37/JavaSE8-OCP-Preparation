package aufgaben;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AufgabeSaveLoadArray {

	public static void main(String[] args) {

		// #A1 
		int len = new java.util.Random().nextInt(100) + 1;
		
		int[] arr1 = MyArrayUtils.createArray(len, -20, 21);
		
		
		// #A2
		FileUtils.saveArray(arr1, "array.txt");

		// #A3 
		int[] arr2 = FileUtils.loadArray("array.txt");
		
		// #A4
		System.out.println("Array 1 : "+ Arrays.toString(arr1));
		System.out.println("Array 2 : "+ Arrays.toString(arr2));
		
		System.out.println("\n--------------------------------------------------------------------");
		
		
	}

	
}
