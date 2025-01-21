# Aufgabe 'Cyclic Barrier'

Gegeben ist folgende Klasse:

	class RaceCar implements Runnable {
		private String name;
		private List<RaceCar> finish;
		
		public RaceCar(String name, List<RaceCar> finish) {
			this.name = name;
			this.finish = finish;
		}
	
		public void run() {
			System.out.println(name + " started.");
			
			finish.add(this);
			System.out.println(name + " finished.");
		}
		public String toString() {
			return name;
		}
	}

Erstellen Sie eine Anwendung in der mindestens vier `RaceCar` Objekte an einem Rennen in parallelen Threads teilnehmen. Alle Rennwagen sollten sich dieselbe Liste `finish` threadsicher teilen. Verwenden Sie `CyclicBarrier` um zu erkennen, wann alle beteiligten das Finish erreichen. Wenn das Rennen vorbei ist, geben Sie die am Ziel angekommenen Rennwagen aus in der Reihenfolge, in der sie am Finish waren.

> Sie dürfen die Klasse `RaceCar` ändern.
