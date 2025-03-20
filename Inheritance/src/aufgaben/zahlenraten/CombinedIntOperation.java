package aufgaben.zahlenraten;

public class CombinedIntOperation implements IntOperation {

	private IntOperation firstOp;
	private IntOperation secondOp;
	
	public CombinedIntOperation(IntOperation firstOp, IntOperation secondOp) {
		this.firstOp = firstOp;
		this.secondOp = secondOp;
	}

	@Override
	public int execute(int x) {
		int result = firstOp.execute(x);
		return secondOp.execute(result);
	}

}
