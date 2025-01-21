package streams;

class Duck implements Comparable<Duck>{
	String name ;
	String color;
	int age;
	
	public Duck(String name, String color, int age) {
		super();
		this.name = name;
		this.color = color;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public int getAge() {
		return age;
	}

	@Override
	public int compareTo(Duck duck) {
		return this.getName().compareTo(duck.getName() );
	}
	
	
}
