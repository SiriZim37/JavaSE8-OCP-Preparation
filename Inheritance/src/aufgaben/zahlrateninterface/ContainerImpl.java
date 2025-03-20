package aufgaben.zahlrateninterface;

import java.util.Arrays;

public class ContainerImpl implements Container{

	private int[] values = new int[10];
	
	private int nextFreeIndex;

	@Override
	public void add(int x) {
		values[nextFreeIndex] = x;
		nextFreeIndex++;
	}

	@Override
	public int getSize() {
		return nextFreeIndex;
	}
	
	@Override
	public String toString() {
		return Arrays.toString( Arrays.copyOf(values, getSize()) );
	}

}
