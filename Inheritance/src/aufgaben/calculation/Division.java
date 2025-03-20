package aufgaben.calculation;

public class Division extends Operation{
	
	@Override
	public double execute(double... operands) {
				
		return operands[0] / operands[1];
	}

}