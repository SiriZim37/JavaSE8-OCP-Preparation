package classes;

class Version{
	int value;
	
}

class OS {
	String name;
	Version version; 
	
	OS( String name) {
		this.name = name ; 
	}
	
	OS( String name , Version version) {
		this.name = name ; 
		this.version = version;
	}
	
	
	
	public String toString() {
		return name + " v. " + version.value ;
	 }
}


public class WdhKlassen {

	public static void main(String[] args) {
//		System.out.println(new Version()); // 
		
		OS os1 = new OS("Linux"); // Es gibt keine Addresse von Objekt  // referenz version ist NULL weil es kann nicht value in objekt finden !
//		System.out.println(os1);  // NUllPointException in der toString
								  // von OS(version is null)
		
		Version v = new Version();  //   v Objekte wird in Objekt OS kopieren 
		v.value =95;
		OS win = new OS("Window",v);
		System.out.println(win); // die Referenz win kann value finden weil es nicht null ist. 
	
	}

}
