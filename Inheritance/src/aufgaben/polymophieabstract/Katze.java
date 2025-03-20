package aufgaben.polymophieabstract;

public class Katze extends Tier {

	public Katze(String name, int alter, boolean gesund) {
		super(name, alter, gesund);
		
	}

	
	@Override
    public void laufen() {
        System.out.println("Katze " + getName() + " läuft.");
    }
	
	 @Override
	  public void print() {
	      System.out.println("Katze. " + super.toString());
	  }

}
