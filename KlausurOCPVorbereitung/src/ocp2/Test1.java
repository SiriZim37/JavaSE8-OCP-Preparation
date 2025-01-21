package ocp2;


class Vehhicle {
	int distance;        //line n1
	Vehhicle(int x) {
	    this.distance = x;
	}
	public void increSpeed(int time)   {    //line n2
	    int timeTravel = time;            //line n3
	    class Car {
	        int value = 0;
	        public void speed () {
	            value = distance /timeTravel;
	            System.out.println ("Velocity with new speed "+value+" kmph");
	        }
	    }

	    new Car().speed();
	}
	}
	
public class Test1 {
	
	public static void main(String[] args) {
		
		new Vehhicle(10).increSpeed(5);
		
	}
}
