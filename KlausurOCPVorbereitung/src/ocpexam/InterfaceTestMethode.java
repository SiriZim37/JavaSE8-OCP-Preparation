package ocpexam;


interface  IntefaceA1 {
	  default Integer run(int n) {return 10+n;}; 
	  Integer walk(Integer s , Integer m);
}



interface  IntefaceB1 {
	  void jump(String s , Integer m);
}

public class InterfaceTestMethode{

	public static void main(String[] args) {
		
		
		IntefaceA1 a = (s, m) -> s + m ;

        int r1 = a.walk(5, 10);
        
        int r2 = a.run(20);
                   
        System.out.println( r1 + " " + r2 + " ");
        
        
        
        /////////////////////////
        
        IntefaceB1 b = (s, m) -> System.out.println(s + " " + m);
       
        b.jump("Jump", 10);
        
        
        
	}
}
