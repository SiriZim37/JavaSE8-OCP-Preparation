package streams;

public class Temperature {

	String location;
	Double temp ;
	public Temperature(String location, Double temp) {
		super();
		this.location = location;
		this.temp = temp;
	}
	public String getLocation() {
		return location;
	}
	public Double getTemp() {
		return temp;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Temp : " + location + " was " + temp ;
	}
}
