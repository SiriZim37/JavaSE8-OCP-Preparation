package streams.miniproject.mini1;

public class Ort {
	private int osm_id; 
	private String ort; 
	private String postleitzahl;
	private String  bundesland;
	
	public Ort(int osm_id , String ort, String postleihzahl, String bundesland) {
		this.osm_id = osm_id;
		this.ort = ort;
		this.postleitzahl = postleihzahl;
		this.bundesland = bundesland;
	}

	public String getOrt() {
		return ort;
	}

	public String getPostleitzahl() {
		return postleitzahl;
	}

	public String getBundesland() {
		return bundesland;
	}
	
	@Override
	public String toString() {
		//String.format("|PLZ.: %s | Ort : %s | Bundesland : %s|", 
		return String.format("| %-8d | %-30s | %-5s | %-25s|", 
				this.osm_id , 
				this.ort , 
				this.postleitzahl , 
				this.bundesland);
	}
	
	
}
