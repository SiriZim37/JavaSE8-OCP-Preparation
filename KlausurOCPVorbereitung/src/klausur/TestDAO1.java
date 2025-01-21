package klausur;

/*
 
Das Interface DozentDAO wird entworfen. Welche Methoden wären in dem Interface sinnvoll? Eine oder mehrere richtige Antworten sind möglich.
 
[   ] void setAlter(int alter)
[ X ] Dozent findById(int  id)
[ X ] void create(Dozent d)
[   ] void create(Connection c, Dozent d)
 */
public class TestDAO1 {

	
//	 interface DozentDAO {
//
//	    // Create
//	    void create(Dozent d);
//
//	    // Read
//	    Dozent findById(int id);
//	    List<Dozent> findAll();
//
//	    // Update
//	    void update(Dozent d);
//
//	    // Delete
//	    boolean deleteById(int id);
//	}
	
	public static void main(String[] args) {

		
    /*	erklären 
 	 * 		void create(Person p);	    <-create			// ok
	 * 		void removeOnId(int id , Connection c);			// nicht sinnvoll: verrät Details der Realisierung
	 * 		List<Person> getAll();	    <- Read				// ok
	 * 		void setName(String name);						// nicht sinnvoll: ist sinnvoll in einer einfachen Klasse 'Person'
	 * 		Person getOnId(int id);		<-Read				// ok
	 * 		boolean deleteOnId(int id)  <-Delete			// ok 
	 */
	}
}
