package aufgaben.interfacesI;

public class OS implements Comparable<OS>{

	private String name;
	private int version;
	
	public OS(String name , int version) {
		this.name = name;
		this.version = version;
	}
	
	public String getName() {
		return name;
	}
	
	public int getVersion() {
		return version;
	}


	public int compareTo(OS os2) {
		OS os1 = this;
		int compareName = os1.getName().compareTo(os2.getName());
		return compareName != 0 ? compareName : (os1.version - os2.version);

	}
	

}
