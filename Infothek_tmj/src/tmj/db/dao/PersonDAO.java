package tmj.db.dao;

import java.util.List;

import model.Person;

public interface PersonDAO {
	
	public List<Person> findAllPersons();
	public boolean insert(Person person);
	public boolean deletePerson(int id);
	public boolean deletePersons(int[] ids);
	public boolean updatePerson(int id, String fieldName, String newValue);
	public void setPersonData(Person person, String fieldName, String newValue);
}
