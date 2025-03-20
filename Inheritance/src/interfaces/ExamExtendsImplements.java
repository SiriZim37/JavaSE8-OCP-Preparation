package interfaces;

class Job { }
class Service { }

/*
 *  eine Klasse darf nur von einer anderen Klasse erben.
 */

//class MyClassA extends Job , extends Service { }	// cf
//class MyClassB extends Job  extends Service { }	// cf
//class MyClassC extends Job , Service { }			// cf

/*
 *  eine Klasse darf mehrere Interfaces implementieren
 */

interface Source{}
interface Target{}

class MyClassD implements Source , Target {}
class MyClassE extends Service implements Source, Target {}

/*
 * 	zuerst extends , dann implements
 */
// class MyClassF extends Source , Target implements Service {} // cf !! 


public class ExamExtendsImplements {

	public static void main(String[] args) {
	

	}

}
