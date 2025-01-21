package wdh.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AcessStaticAndNonStaticVariable {

	int x1 = 222;
	static int x2 = 111;
	
	public static void main(String[] args) {

		try {
			AcessStaticAndNonStaticVariable a1 = null;
			System.out.println("a1=" + a1.x1);		// java.lang.NullPointerException
		} catch (Exception e) {
			System.out.println(e);
		}
		
		AcessStaticAndNonStaticVariable a2 = null;
		System.out.println("a2=" + a2.x2);			// 111 
	}
	
}
