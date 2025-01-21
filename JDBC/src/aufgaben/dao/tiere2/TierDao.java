package aufgaben.dao.tiere2;

import java.util.List;


public interface TierDao  {

	static TierDao getInstance() {
		return new TestDerbyTierDAO();
	}

	List<Tier> getAllTiere();
	
	/**
	 * @param id
	 * @return false, falls kein Tier mit der id gefunden war
	 */
	boolean deleteOnId(int id);
	
	/**
	 * 
	 * @param t
	 * @throws IllegalArgumentException wenn es Tier mit der id bereits existiert
	 */
	void add(Tier t) throws IllegalArgumentException;

}
