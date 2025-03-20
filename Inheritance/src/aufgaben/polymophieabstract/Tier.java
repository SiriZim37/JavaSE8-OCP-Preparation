package aufgaben.polymophieabstract;

// abstract class :
// die Methode müssen nicht abstract sein.
// aber wenn die Mothode Abstract ist , die Klasse muss abstract.

abstract class Tier {

	private String name ;
	private int alter;
	private boolean gesund  ;
	
	public Tier(String name, int alter) {
		this(name,alter,true);
	}
	
	public Tier(String name, int alter, boolean gesund) {
	    this.name = name;
	    this.alter = alter;
	    this.gesund = gesund;
	}
	   
    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public int getAlter() {  return alter;}

    public void setAlter(int alter) {  this.alter = alter; }

    public boolean isGesund() {  return gesund;}

    public void setGesund(boolean gesund) {  this.gesund = gesund; }
    

//    abstract static void laufen(); //The abstract method laufen in type Tier can only set a visibility modifier, 
    								 //one of public or protected
    
    abstract public void laufen(); 
    
    abstract public void print();
    

    
    @Override
    public String toString() {
    	return "Name: " + name + ", Alter: " + alter;
    }
	
}
