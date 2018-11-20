package generic;

import java.util.List;

import model.Person;

public interface DbDataDAO {
	public List<DbData> findAll();
	public boolean save(DbData data);
	public boolean delete(int id);
	public boolean delete(int[] ids);
	public boolean update(int id, String fieldName, DbValue newValue);
	public void setData(DbData data, String fieldName, DbValue newValue);
}





