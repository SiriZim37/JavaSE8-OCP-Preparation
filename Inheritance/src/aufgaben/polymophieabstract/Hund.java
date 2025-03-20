package aufgaben.polymophieabstract;

public class Hund extends Tier {

	public Hund(   ) {
		super("",0 ) ;
	}
	
	// Der Hund muss public void laufen aufrufen!  
		
	
	public Hund(String name, int alter, boolean gesund) {
		super(name, alter, gesund);
		
	}

	@Override
    public void laufen() {
        System.out.println("Hund " + getName() + " läuft.");
    }
	

    @Override
    public void print() {
        System.out.println("Hund. " + super.toString());
    }

}
