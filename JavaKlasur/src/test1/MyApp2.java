package test1;

interface Foo { String toString();}



class A {
	B b;
	A(){
		b = new B(this);
	}
}

class B  {
	A a;
	B(A a ){
		this.a = a;
	}
}


interface Foos {} 
class Alpha implements Foos {} 
 class Beta extends Alpha {} 

class AAA { 
	void foo() { } 
} 
class SubB2 { 
	void foo() { System.out.println("B "); } 
} 
 

public  class MyApp2  {
	
	public static int	price = 5;
	
	public void MyApp2(int e) {
		this.price = e;
	}

	void foosss() throws Exception  {
		try {
			System.out.println(5);
		} catch (Exception e) {
			throw new RuntimeException("tt");
		}
	
	} 

	 public static void main(String[] args)  {	
		 
		 

		 StringBuilder[] sb = new  StringBuilder[2];
		 String[] s = new  String[2];
		 System.out.println(s.length);
		 System.out.println(sb.length);
		 StringBuilder ssb = new  StringBuilder();
		 System.out.println("ssb : " + ssb.toString());

		 int h = 0 ;
		 for (String string : s) {			
			 s[h].concat("id " + h);
			 h++;
		 }
		 
		 for (int i = 0; i < s.length; i++) {
			 System.out.println( s[i]);
			
		}
//		 System.out.println("h" + h);
//		 for (String string : s) {
//			 System.out.println();
//		 }
		
//		 h = 0 ;
//		for (StringBuilder v : sb) {
//			sb[h].append("CC" + h);
//			h++;	
//		}
//		 System.out.println("h" + h);

		 
//		 AAA a = new SubB2(); 
//		a.foo(); 
			
//		 StringBuilder sb = new StringBuilder("cl").insert(2, "own");
//		 System.out.println(sb);
		System.out.println(new MyApp2().price);

		boolean bbb = false;
		System.out.println(bbb);
//		 new MyApp2().foosss(); // cf 
			 try {
				 new MyApp2().foosss();
			} catch (Throwable e) {
				
			}
//		 new MyApp2().foo();
//		 
//		 	B b = new B();
//		 	b.foo();
//		 	
//		 	A a = new B();
//		 	try {
//				a.foo();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		 
		
	}


}