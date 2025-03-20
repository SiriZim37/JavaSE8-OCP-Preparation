package aufgaben.lists;

public class Schiff {

	private String name;
		
	public Schiff(String name) {
		this.name = name;
	}
		
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		Schiff s = (Schiff) obj;
		return name!= null ? name.equals(s.name) : s.name == null;
	}
		
		
}
