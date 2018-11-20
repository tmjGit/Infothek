package tmj.db.dao;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;
import tmj.db.DBConnect;
import tmj.db.DBConnectException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TheSQLPersonDAO implements PersonDAO{ // hier DBConnect verwenden.
	private DBConnect dbconnect;
	public static final String TABLENAME="Personen";
	
	public TheSQLPersonDAO() {
		try {
			dbconnect=DBConnect.getInstance();
		} catch (DBConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override public List<Person> findAllPersons() {
		ObservableList<Person> persons=FXCollections.observableArrayList();//List<Person_d> personList = new ArrayList<>();
		final String q = "select * from "+TABLENAME;
		
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			ResultSet result = statement.executeQuery();//("select * from "+DBNAME); 
			while(result.next()) { // auch vor dem ersten Zugriff nötig!
				Person person=new Person( 
						result.getInt("id"), 
						result.getString("vorname"), 
						result.getString("nachname"),
						result.getString("plz"), 
						result.getString("ort"), 
						result.getString("strasse"), 
						result.getString("telefon"), 
						result.getString("mobil"), 
						result.getString("email") );
				persons.add(person);
			}

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persons;
	}
	
	@Override
	public boolean insert(Person person) {
		final String q = "insert into " + TABLENAME + " (namFam,namIndiv,GebJahr, GebMonat,GebTag,stop,Geschlecht) VALUES (?,?,?,?,?,?,?)";
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			
//			System.out.print(result.getInt("id") + " - ");
			statement.setString(1,"namFam1") ;
			statement.setString(2,"namIndiv1");
//			statement.setTimestamp(3,"localdate") + " - ");
//			statement.setTimestamp(4,"changed") + " - ");
			statement.setInt(3,1970);
			statement.setInt(4,8);
			statement.setInt(5,12);
			statement.setInt(6,0);
			statement.setString(7,"weiblich");
			
//			Statement statement = dbconnect.getConnection().createStatement();
//			int n = statement.executeUpdate();//	int n=statement.executeUpdate(q);
			return statement.executeUpdate()==1; // erfolgreich der eine Datensatz eingefügt.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	
	
	@Override
	public boolean deletePerson(int id) {
		final String q = "delete from " + TABLENAME + " where id=?";
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			statement.setInt(1, id);
			return statement.executeUpdate()==1; // erfolgreich der eine Datensatz gelöscht.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	
	
	@Override
	public boolean deletePersons(int[] ids) {//TODO
		final String q = "delete from " + TABLENAME + " where id=?";
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
//			statement.setInt(1, id);
//			return statement.executeUpdate()==1; // erfolgreich der eine Datensatz gelöscht.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePerson(int id, String fieldName, String newValue) {
		final String q = "update " + TABLENAME + " set " + fieldName + "=? where id=?";
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			statement.setString(1, newValue);
			statement.setInt(2, id);
			System.out.println("MySQLPersonDAO.updatePerson: statement="+statement);
			return statement.executeUpdate()==1; // erfolgreich der eine Datensatz geändert.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void setPersonData(Person person, String fieldName, String newValue) {
		// TODO Auto-generated method stub
		
	}
	
}
