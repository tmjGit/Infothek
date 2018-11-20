package li.tmj.db.dao;

import java.util.List;

public interface GenericDAO<T> {
	public List<T> read(T obj); // searches db for all records mathing the fields set in the obj parameter
	public boolean save(T obj);
//	public boolean save(T[] objs);
//	public boolean remove(int id);
	public boolean remove(T obj);
//	public boolean remove(int[] ids);
//	public boolean remove(T[] objs);
	public boolean update(T obj);
//	public boolean update(T[] objs);
}
