package aufgaben.enums;

import java.util.ArrayList;

public class MyOS2 {


	public static final MyOS2 UNIX = new MyOS2("UNIX");
	public static final MyOS2 WINDOWS = new MyOS2("WINDOWS");
	public static final MyOS2 MAC = new MyOS2("MAC");
	
	private String name; 
	
	private MyOS2(String name) {
		this.name = name;
	}
	
	private String getOS(){
		return name  ;
	}
	
	@Override
	public String toString() {
		return getOS();
	}

	public static MyOS2[] values() {
		return new MyOS2[] { UNIX , WINDOWS , MAC} ;
	}
	
	public static MyOS2[] getValues() {
		return new MyOS2[] { UNIX , WINDOWS , MAC} ;
	}
	 public static MyOS2 valueOf(String name) {
	     for (MyOS2 os : getValues() ) {
	         if (os.name.equals(name)) {
	             return os;
	         }
	     }
	     throw new IllegalArgumentException("No enum constant " + MyOS2.class.getCanonicalName() + "." + name);
	}
	 
}
