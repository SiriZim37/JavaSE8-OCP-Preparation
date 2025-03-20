package aufgaben.calculation;

public class Power extends Operation{
	
	@Override
	public double execute(double... operands) {
		return Math.pow(operands[0], operands[1]);
	}

}
