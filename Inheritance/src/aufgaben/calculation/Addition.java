package aufgaben.calculation;

public class Addition extends Operation{
	
	@Override
	public double execute(double... operands) {
		return operands[0] + operands[1];
	}

}
