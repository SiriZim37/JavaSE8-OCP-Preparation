package aufgaben.enums;

import java.util.ArrayList;


public final class MyOS {

	public static final MyOS UNIX = new MyOS("UNIX");
	public static final MyOS WINDOWS = new MyOS("WINDOWS");
	public static final MyOS MAC = new MyOS("MAC");

	private static ArrayList<MyOS> VALUES  = new ArrayList<MyOS>(); 
	
	static {
		VALUES.add(UNIX);
		VALUES.add(WINDOWS);
		VALUES.add(MAC);
	}
	
	private String name; 
	
	private MyOS(String name) {
		this.name = name;
	}
	
	private String getOS(){
		return name  ;
	}
	
	@Override
	public String toString() {
		return getOS();
	}

	public static MyOS[] values() {
		return VALUES.toArray(new MyOS[VALUES.size()]);
	}
	
	 public static MyOS valueOf(String name) {
	     for (MyOS os : VALUES) {
	         if (os.name.equals(name)) {
	             return os;
	         }
	     }
	     throw new IllegalArgumentException("No enum constant " + MyOS.class.getCanonicalName() + "." + name);
	}
}

