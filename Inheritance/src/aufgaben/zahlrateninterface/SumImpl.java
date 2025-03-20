package aufgaben.zahlrateninterface;

public class SumImpl implements Sum{
	
	private int value;

	@Override
	public void add(int a) {
		value += a;
		
	}

	@Override
	public int getSum() {
		// TODO Auto-generated method stub
		return value;
	}

}
