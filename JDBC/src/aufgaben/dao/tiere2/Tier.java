package aufgaben.dao.tiere2;

public class Tier {

	private String name;
	private int id;
	private String art;
	private int geburtsjahr;
	

	public Tier(int id , String name , String art , int geburtsjahr) {
		this.id = id;
		this.name = name;
		this.art = art;
		this.geburtsjahr = geburtsjahr;
	}


	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}


	public String getArt() {
		return art;
	}


	public int getGeburtsjahr() {
		return geburtsjahr;
	}
	
}
