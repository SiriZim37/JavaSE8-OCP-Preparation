package aufgeben.pcverwaltung;


public class PC {
	String bezeichung;
	float prozessSorGeschwindigkeit;
	int ram;
	int festplattengröße;
	
	public PC( String bezeichung , float prozessSorGeschwindigkeit,int ram,int festplattengröße) {
		this.bezeichung = bezeichung;
		this.prozessSorGeschwindigkeit = prozessSorGeschwindigkeit;
		this.ram = ram;
		this.festplattengröße = festplattengröße;
	}

	public String getBezeichung() {
		return bezeichung;
	}

	public void setBezeichung(String bezeichung) {
		this.bezeichung = bezeichung;
	}

	public float getProzessSorGeschwindigkeit() {
		return prozessSorGeschwindigkeit;
	}

	public void setProzessSorGeschwindigkeit(float prozessSorGeschwindigkeit) {
		this.prozessSorGeschwindigkeit = prozessSorGeschwindigkeit;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getFestplattengröße() {
		return festplattengröße;
	}

	public void setFestplattengröße(int festplattengröße) {
		this.festplattengröße = festplattengröße;
	}
	
	void starten() {
		
	}
	
	void runterfahren() {
		
	}
	
	void inSchlafenModusGehen() {
		
	}


}
