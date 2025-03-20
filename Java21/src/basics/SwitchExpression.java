package basics;

public class SwitchExpression {

	public static void main(String[] args) {

		int day = 3;
		
		int result = switch(day) {
			case 1 -> 1000 ;
//			case 2: { yield 2000; }
			case 3 -> { yield 3000; }
			default -> -1;
		};
		
		System.out.println(result);

		result = switch(day) {
			case 1: { yield 1000; }
			case 2: { yield 2000; }
			default: { yield -1; }
		};

		System.out.println(result);

	}

}
