package aufgaben.cyclicbarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RaceCar2 implements Runnable {
	private String name;
	private List<RaceCar2> finish;
	private CyclicBarrier barrier;
	
	public RaceCar2(String name, List<RaceCar2> finish, CyclicBarrier barrier) {
		this.name = name;
		this.finish = finish;
		this.barrier = barrier;
	}

	public void run() {
		System.out.println(name + " started.");
		
		finish.add(this);
		System.out.println(name + " finished.");
		
		try {
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	public String toString() {
		return name;
	}
}

public class AufgabenCyclicBarrier2 {

	public static void main(String[] args) {
		
		int anzahlAutos = 4;

		List<RaceCar2> finish = new ArrayList<>();
		
		Runnable barrierAction = () -> {
			System.out.println("\n*** Das Rennen ist vorbei");
			for (int i = 0; i < finish.size(); i++) {
				RaceCar2 rc = finish.get(i);
				System.out.println(i+1 + ". " + rc);
			}
		};
		
		CyclicBarrier barrier = new CyclicBarrier(anzahlAutos, barrierAction);
		
		RaceCar2[] cars = {
			new RaceCar2("VW", finish, barrier),	
			new RaceCar2("Opel", finish, barrier),	
			new RaceCar2("Mercedes", finish, barrier),	
			new RaceCar2("Mazda", finish, barrier),	
		};

		ExecutorService service = Executors.newFixedThreadPool(anzahlAutos);
		
		for(RaceCar2 rc : cars) {
			service.execute(rc);
		}
		
		service.shutdown();
	}

}
