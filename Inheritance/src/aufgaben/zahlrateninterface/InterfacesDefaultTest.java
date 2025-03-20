package aufgaben.zahlrateninterface;

public class InterfacesDefaultTest {

	public static void main(String[] args) {
		System.out.println("*** A1");
		
		Sum s1 = new SumImpl();
		s1.add(2, 3);
		int result1 = s1.getSum();
		System.out.println("result1 = " + result1); // soll: 5
	
		
		System.out.println("\n*** A2");
		
		Container c1 = new ContainerImpl();
		
		System.out.println("size: " + c1.getSize()); // 0
		System.out.println("c1: " + c1);
		
		c1.add(2, 3);
		
		System.out.println("size: " + c1.getSize()); // 2
		System.out.println("c1: " + c1);
		
		System.out.println("\n*** A3");
		
		SumContainerImpl sc1 = new SumContainerImpl();
		System.out.println("1. size = " + sc1.getSize()); // 0
		System.out.println("1. sum = " + sc1.getSum()); // 0
		System.out.println("1. sc = " + sc1); // Elemente: [], Summe = 0
		
		sc1.add(1);
		sc1.add(2, 3);
		
		System.out.println("2. size = " + sc1.getSize()); // 3
		System.out.println("2. sum = " + sc1.getSum()); // 6
		System.out.println("2. sc = " + sc1); // Elemente: [1, 2, 3], Summe = 6

	}

}

class SumContainerImpl implements Sum, Container {

	private Sum sum = new SumImpl();
	private Container container = new ContainerImpl();
	
	public void add(int a) {
		sum.add(a);
		container.add(a);
	}
	
	public void add(int a, int b) {
		sum.add(a, b);
		container.add(a, b);
	}
	
	public int getSum() {
		return sum.getSum();
	}
	
	public int getSize() {
		return container.getSize();
	}
	
	@Override
	public String toString() {
		return "Elemente: " + container + ", Summe: " + getSum();
	}
}
