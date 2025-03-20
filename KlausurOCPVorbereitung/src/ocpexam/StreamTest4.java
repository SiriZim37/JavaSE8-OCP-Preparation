package ocpexam;

public class StreamTest4 {

	/*
	 Given the definition of the Country class:
	
	public class country {
	
	public enum Continent {ASIA, EUROPE}
	
	String name;
	
	Continent region;
	
	public Country (String na, Continent reg) {
	
	name = na, region = reg;
	
	}
	
	public String getName () {return name;}
	
	public Continent getRegion () {return region;}
	
	}
	
	and the code fragment:
	
	List couList = Arrays.asList (
	
	new Country (''Japan'', Country.Continent.ASIA),
	
	new Country (''Italy'', Country.Continent.EUROPE),
	
	new Country (''Germany'', Country.Continent.EUROPE));
	
	Map> regionNames = couList.stream ()
	
	.collect(Collectors.groupingBy (Country ::getRegion,
	
	Collectors.mapping(Country::getName, Collectors.toList()))));
	
	System.out.println(regionNames);
	
	
	
	Options
	A	{EUROPE = [Italy, Germany], ASIA = [Japan]}
	B	{ASIA = [Japan], EUROPE = [Italy, Germany]}
	C	{EUROPE = [Germany, Italy], ASIA = [Japan]}
	D	{EUROPE = [Germany], EUROPE = [Italy], ASIA = [Japan]}
	
	Answer
	B
 */
}
