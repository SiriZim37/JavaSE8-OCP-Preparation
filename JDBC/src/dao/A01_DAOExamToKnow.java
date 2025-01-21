package dao;

public class A01_DAOExamToKnow {

	/*
	1. DAO Methods Design
	Analyze the following DAO interface. Which methods are appropriate, and which ones violate the principles of DAO design? Provide reasons for your answers.

	interface CarDAO {
	    void save(Car car);                // Correct: This is a valid Create method.
	    Car getCarByLicense(String license); // Correct: This is a valid Read method.
	    void updateEngineSpecs(Car car);   // Not appropriate: Update methods should be named more generically like `update(Car car)` without specific details like `updateEngineSpecs`.
	    void deleteAllCars();              // Not appropriate: This violates the principle of focusing on one entity (Car). It could be a different method or part of another interface.
	    List<Car> getAllCars();            // Correct: This is a valid Read method.
	}
	Explanation:

	- `save` and `getAllCars` are valid for standard CRUD operations.
	- `updateEngineSpecs` is too specific; use a more generic `update`.
	- `deleteAllCars` is not commonly used in DAO, as it deletes the entire dataset. DAO typically handles individual entities.
	- `getCarByLicense` is valid as it fetches a specific car based on its unique attribute.

	*/
//------------------------------------------------------------------------------------------//
	/*
	2. Transactional Operations in DAO
	The following method is designed for batch deletion of records in a DAO. Identify potential issues and suggest improvements.

	default void deleteMultiple(List<Integer> ids) {
	    for (int id : ids) {
	        deleteOnId(id);
	    }
	}
	Explanation:

	Problem: The method performs multiple delete operations one after the other, but if one delete fails, previous deletions are committed, leading to inconsistent database state. Also, multiple connections are opened inefficiently.

	Solution:

	Use transactions to ensure atomicity (either all deletions succeed or none).
	Suggested Implementation:

	default void deleteMultiple(List<Integer> ids) {
	    try (Connection conn = DriverManager.getConnection(URL)) {
	        conn.setAutoCommit(false); // Start transaction
	        for (int id : ids) {
	            deleteOnId(id, conn); // Pass connection to the method
	        }
	        conn.commit(); // Commit the transaction if all delete operations succeed
	    } catch (SQLException e) {
	        e.printStackTrace();
	        try {
	            conn.rollback(); // Rollback if an error occurs
	        } catch (SQLException rollbackEx) {
	            rollbackEx.printStackTrace();
	        }
	    }
	}
	*/
	//------------------------------------------------------------------------------------------//
	/*
	3. Error Handling in DAO
	You have implemented a DAO method for inserting a record into a database. Examine the code below and determine if it adheres to best practices for error handling:

	@Override
	public void create(Person person) {
	    try (Connection conn = DriverManager.getConnection(URL);
	         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Person VALUES (?, ?)")) {
	        stmt.setInt(1, person.getId());
	        stmt.setString(2, person.getName());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace(); // Not ideal, sensitive info may be exposed.
	    }
	}

	Explanation:

	Issue: Using `e.printStackTrace()` is not recommended in production code. It may expose sensitive information and doesn't provide user-friendly error handling.

	Suggested Fix:

	Use proper logging (e.g., SLF4J or Logback) and throw a custom exception for better error handling.

	Correct Answer:

	@Override
	public void create(Person person) {
	    try (Connection conn = DriverManager.getConnection(URL);
	         PreparedStatement stmt = conn.prepareStatement("INSERT INTO Person VALUES (?, ?)")) {
	        stmt.setInt(1, person.getId());
	        stmt.setString(2, person.getName());
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        logger.error("Error inserting person: " + person, e); // Log error
	        throw new DataAccessException("Failed to insert person", e); // Custom exception
	    }
	}
	*/
	//------------------------------------------------------------------------------------------//
	/*
	4. Generic DAO Interface
	Correct Answer:

	interface GenericDAO<T> {
	    void create(T entity);  // Valid: General method for creating an entity.
	    T getById(int id);      // Valid: Fetch an entity by its ID.
	    List<T> getAll();       // Valid: Fetch all entities.
	    boolean delete(int id); // Valid: Delete an entity by its ID.
	}
	Explanation:

	This interface is generic and can be used for any entity type (e.g., Person, Car, Product). The methods are applicable to any entity.
	*/
	//------------------------------------------------------------------------------------------//
	
	/*
	5. Database Connection Management
	In the DAO design pattern, how should database connections be managed for efficiency and reusability? Choose the correct approach:

	A. Create a new connection for each method in the DAO.
	B. Use a connection pool to manage database connections.
	C. Maintain a single static connection throughout the application's lifecycle.
	D. Allow the client code to provide the connection to the DAO methods.

	Correct Answer: B. Use a connection pool to manage database connections.

	Explanation:

	- A: Creating a new connection for each method is inefficient and leads to resource exhaustion.
	- B: A connection pool is the most efficient way to manage database connections, as it reuses connections.
	- C: A static connection can lead to resource leaks and is not scalable.
	- D: Allowing client code to manage connections mixes responsibilities and is not recommended.
	*/
	//------------------------------------------------------------------------------------------//
	
	/*
	6. Examining DAO Implementation
	You are given a DAO implementation that violates the principle of encapsulation. Identify the problem:

	class ProductDAO {
	    Connection connection = DriverManager.getConnection(URL); // Problem: Connection management violates encapsulation.
	    
	    public ProductDAO() throws SQLException {
	        this.connection = DriverManager.getConnection(URL);
	    }
	    
	    public void create(Product product) {
	        // Implementation
	    }
	    
	    public void closeConnection() throws SQLException {
	        connection.close();
	    }
	}

	Explanation:

	Problem: This implementation hardcodes a single connection object and exposes it outside the DAO, violating the encapsulation principle.

	Solution:

	Connections should be managed by a connection pool or passed as parameters, rather than being instantiated inside the DAO.
	Correct Implementation:

	class ProductDAO {
	    private Connection connection;
	    
	    public ProductDAO(Connection connection) {
	        this.connection = connection; // Connection passed from the caller
	    }
	    
	    public void create(Product product) {
	        // Implementation
	    }
	    
	    public void closeConnection() throws SQLException {
	        // Let connection be managed elsewhere
	    }
	}
	*/
	//------------------------------------------------------------------------------------------//
	
	/*
	7. Integration Testing of DAO
	Suggested Tools for DAO Testing:

	- Use JUnit with an in-memory database (e.g., H2 or HSQLDB) for testing. These databases run in memory and are quick to set up.
	- JUnit assertions are used to verify query results.
	- Use `@Before` and `@After` annotations for setting up and cleaning up test data. Optionally, use `@Transactional` for automatic rollback after tests.

	Example:

	@RunWith(SpringRunner.class)
	@SpringBootTest
	public class PersonDAOTest {
	    
	    @Autowired
	    private PersonDAO personDAO;

	    @Before
	    public void setup() {
	        // Setup database schema or test data
	    }

	    @Test
	    public void testCreate() {
	        Person person = new Person(1, "John");
	        personDAO.create(person);
	        assertTrue(personDAO.getById(1).getName().equals("John"));
	    }

	    @After
	    public void cleanup() {
	        // Cleanup after tests
	    }
	}
	*/

	//------------------------------------------------------------------------------------------//

}
