package ocpexam;


//https://www.pass4success.com/oracle/1z0-809/dumps

public class ConcurrencyTest1 {

	/*					>>>> OCP Test ***
	 Given the code fragments: 

	class Caller implements Callable<String> {
	
	String str;
	
	public Caller (String s) {this.str=s;}
	
	public String call()throws Exception { return str.concat (''Caller'');}
	
	}
	
		class Runner implements Runnable {
		
		String str;
		
		public Runner (String s) {this.str=s;}
		
		public void run () { System.out.println (str.concat (''Runner''));}
		
		}
	
	and
	
	public static void main (String[] args) throws InterruptedException, ExecutionException {
	
		ExecutorService es = Executors.newFixedThreadPool(2);
		
		Future f1 = es.submit (new Caller (''Call''));
		
		Future f2 = es.submit (new Runner (''Run''));
		
		String str1 = (String) f1.get();
		
		String str2 = (String) f2.get();//line n1
		
		System.out.println(str1+ '':'' + str2);
	
	}
	
	What is the result?
	
	Options
	A	The program prints:Run RunnerCall Caller : nullAnd the program does not terminate.
	B	The program terminates after printing:Run RunnerCall Caller : Run
	C	A compilation error occurs at line n1.
	D	An Execution is thrown at run time.
	
	
	Answer
	D
	 */
}
