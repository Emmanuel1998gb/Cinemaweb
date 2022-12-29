package DAO;

import java.util.List;

public interface BankManagerDAO<O, ID> {
	
	O get(ID id);
	List<O> getAll();
	void alter(ID id);
	boolean save(O o);
	void update(ID id,O o);
	void delete(O o);
}