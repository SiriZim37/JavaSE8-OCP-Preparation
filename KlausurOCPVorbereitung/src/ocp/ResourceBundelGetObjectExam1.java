package ocp;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;



public class ResourceBundelGetObjectExam1 {

	public static void main(String[] args) {

			ResourceBundle rb = ResourceBundle.getBundle("ocp.ResourceBundelGetObject" , Locale.getDefault());
			Object obj = rb.getObject("123"); System.out.println(obj );
			Object obj1 = rb.getString("123");  // ClassCastExeption!!!! 
			System.out.println(obj1 );
			
	}
}
