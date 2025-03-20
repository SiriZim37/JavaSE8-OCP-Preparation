package aufgaben.zahlenraten;

public interface IntOperation {
	
	int execute(int i);
	
	default IntOperation andThen(IntOperation nextOp) {
		return new CombinedIntOperation(this, nextOp);
	}

}

class Multiply implements IntOperation {
	
	private int multiplier = 1;
	
	Multiply(int m) {
		multiplier = m;
	}
	
	public int execute(int i) {
		return multiplier * i;
	}
	
}

class Divide implements IntOperation {
	
	private int divider = 1;
	
	Divide(int d) {
		divider = d;
	}
	
	public int execute(int i) {
		return i / divider;
	}
	
}

class Subtract implements IntOperation {
	
	private int minus = 0;
	
	Subtract(int m) {
		minus = m;
	}
	
	public int execute(int i) {
		return i - minus;
	}
}

class Add implements IntOperation {
	
	private int plus = 0;
	
	Add(int p) {
		plus = p;
	}
	
	public int execute(int i) {
		return i + plus;
	}
}

class ChangeSign implements IntOperation {
	
	public int execute(int i) {
		return -i;
	}
}




