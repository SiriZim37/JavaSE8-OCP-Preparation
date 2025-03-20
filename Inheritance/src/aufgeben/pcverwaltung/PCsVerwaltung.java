package aufgeben.pcverwaltung;

import java.util.ArrayList;
import java.util.List;

public class PCsVerwaltung {
	final int MAX_PCS = 100;
	List<PC> pcs;
	
	public PCsVerwaltung() {
		pcs = new ArrayList<>();
	}

	void addNewPC(PC pc) {
		pcs.add(pc);
	}
	
	
}
