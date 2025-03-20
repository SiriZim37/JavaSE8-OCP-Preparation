package ocpexam;

public class IntFuntionInFunctionTestOCP1 {

	/*
	 Given:  **** IN OCP ***

		IntStream stream = IntStream.of (1,2,3);
		
		IntFunction inFu= x -> y -> x*y; //line n1
		
		IntStream newStream = stream.map(inFu.apply(10)); //line n2
		
		newStream.forEach(System.output::print);
		
		Which modification enables the code fragment to compile?
		
		Options
		A	Replace line n1 with:
			IntFunction<UnaryOperator> inFu = x -> y -> x*y;
		B	Replace line n1 with:
			IntFunction<IntUnaryOperator> inFu = x -> y -> x*y;
		C	Replace line n1 with:
			BiFunction<IntUnaryOperator> inFu = x -> y -> x*y;
		D	Replace line n2 with:
			IntStream newStream = stream.map(inFu.applyAsInt (10));
			
			Answer
			B
	 */
}
