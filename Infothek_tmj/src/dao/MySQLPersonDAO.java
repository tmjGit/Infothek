package dao;

import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.array.Person;
import tmj.db.DBConnect;
import tmj.db.DBConnectException;
import tmj.db.dao.PersonDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;


public class MySQLPersonDAO implements PersonDAO{ // hier DBConnect verwenden.
	private DBConnect dbconnect;
	
	public static final String DBNAME="adressen";
//	private static FieldDAO[] fields;
	
	 
	public MySQLPersonDAO() throws DBConnectException { // alternativ hier Fehlerlogging + throw new DaoException
//		fields=new FieldDAO[9];
//		fields= new FieldDAO[]{
//				new FieldDAO("vorname", "Vorname", "vorname", String.class, false),
//				new FieldDAO("nachname", "Nachname", "nachname", String.class, false),
//				new FieldDAO("plz", "PLZ", "plz", String.class, false),
//				new FieldDAO("ort", "Ort", "ort", String.class, false),
//				new FieldDAO("strasse", "Straße/Nr.", "strasse", String.class, false),
//				new FieldDAO("telefon", "Telefon", "telefon", String.class, true),
//				new FieldDAO("mobil", "Mobil", "mobil", String.class, true),
//				new FieldDAO("email", "E-Mail", "email", String.class, true),
//				new FieldDAO("id", "ID", "id", Integer.class, false),
//		};
					 
		dbconnect=DBConnect.getInstance();
	}
	
	public static final FieldDAO[] getFields() {
		return fields;
	}
	
	public void setPersonData(Person person, String variableName, String newValue) {
		for (int i=0; i<fields.length-1; i++) { // -1 because the id is not editable!
			if(fields[i].name.equals(variableName)) {
				person.setValue(i, newValue);
				return;
			}
		 //TODO not found: exception handling
		}
	}

	public void setPersonData(Person person, int Index, String newValue) {
		person.setValue(Index, newValue);
	}

	@Override public List<Person> findAllPersons() {
		ObservableList<Person> persons=FXCollections.observableArrayList();
		final String q = "select * from "+DBNAME;
		
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			ResultSet result = statement.executeQuery(); 
			while(result.next()) { // auch vor dem ersten Zugriff nötig!
				Person person=new Person();
				for(int i=0; i<fields.length-1; i++) {
					person.setValue(i, result.getString(fields[i].name));
				}
				person.setId(result.getInt(fields[fields.length].name));//TODO currently we know this is int id
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
		final String q = "insert into " + DBNAME + " (vorname,nachname,ort,plz,strasse, telefon,mobil,email) VALUES (?,?,?,?,?,?,?,?)";
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			for(int i=0; i<fields.length-1; i++) {
				statement.setString(i+1, person.getValue(i));
			}
			return statement.executeUpdate()==1; // erfolgreich der eine Datensatz eingefügt.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}	
	
	@Override
	public boolean deletePerson(int id) {
		final String q = "delete from " + DBNAME + " where id=?";
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
		final String q = "delete from " + DBNAME + " where id in (?" + String.join("", Collections.nCopies(ids.length-1, ",?")) + ")";
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			for(int i=0; i<ids.length; i++) 
				statement.setInt(i+1, ids[i]);//PreparedStatement placeholder are 1-based, java arrays 0-based
			return statement.executeUpdate()==ids.length; // erfolgreich Datensätze gelöscht.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePerson(int id, String fieldName, String newValue) {
		final String q = "update " + DBNAME + " set " + fieldName + "=? where id=?";
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			statement.setString(1, newValue);
			statement.setInt(2, id);
			return statement.executeUpdate()==1; // erfolgreich der eine Datensatz geändert.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	

	private DBConnect db = DBConnect.getInstance();

	public PersonDAO() {
		try {
			db.connectDB();
		} catch (DBConnectException e) {
			throw e;
		}

	}

	public List<Person> findAllPersons() {
		List<Person> list = null;

		try {

			Statement st = db.getConnection().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM adressen");

			list = createPersonList(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean savePerson(Person p) {
		// Insert--------------------------
		try {

			String query = "INSERT INTO adressen (vorname, nachname, plz, ort, strasse, telefon, mobil, email) "
					+ "VALUES (?,?,?,?,?,?,?,?)";
			PreparedStatement insertStatement = db.getConnection()
					.prepareStatement(query);
			insertStatement.setString(1, p.getVorname());
			insertStatement.setString(2, p.getNachname());
			insertStatement.setString(3, p.getPlz());
			insertStatement.setString(4, p.getOrt());
			insertStatement.setString(5, p.getStrasse());
			insertStatement.setString(6, p.getTelefon());
			insertStatement.setString(7, p.getMobil());
			insertStatement.setString(8, p.getEmail());

			int row = insertStatement.executeUpdate();

			return row == 1;// 1 Datensatz wurde gespeichert
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param id
	 * @param fxIdColumn
	 *            - fx:id der Tabellenspalte (TableView)
	 * @param newValue
	 *            - neuer Wert der Tabellenzelle
	 * @return true, wenn update erfolgreich
	 */
	public boolean updatePerson(int id, String fxIdColumn, String newValue) {
		try {
			String q = "UPDATE adressen SET " + DBProp.get(fxIdColumn)
					+ "= ? WHERE id = ?";
			PreparedStatement ps = db.getConnection().prepareStatement(q);
			ps.setString(1, newValue);
			ps.setInt(2, id);
			ps.executeUpdate();
			return ps.getUpdateCount() == 1;// wenn ein Datensatz ge�ndert
											// wurde: true
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deletePerson(ObservableList<Person> oList) {
		String idset = "?";
		for (int i = 1; i < oList.size(); i++) {
			idset += ",?"; // -> WHERE id IN (?,?,?) PreparedStatement
		}
		try {
			PreparedStatement deleteStatement = db.getConnection()
					.prepareStatement(
							"DELETE FROM adressen WHERE id IN (" + idset + ")");//(?,?,?)

			for (int i = 0; i < oList.size(); i++) {
				deleteStatement.setInt(i+1, oList.get(i).getId());// Person.id
			}
			deleteStatement.executeUpdate();
			return deleteStatement.getUpdateCount() > 0;  // wenn l�schen erfolgreich
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<Person> findByField(String columnFxId, String text) {
		List<Person> list = null;
		try {

			// DBProp.get(columnFxId) -> columnFXId zu DB-Feld
			String q = "SELECT *  FROM adressen WHERE " + DBProp.get(columnFxId)
					+ " LIKE ?";
			PreparedStatement ps = db.getConnection().prepareStatement(q);
			ps.setString(1, text + "%");
			ResultSet rs = ps.executeQuery();
			list = createPersonList(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// TODO
	private List<Person> createPersonList(ResultSet rs) throws SQLException {
		List<Person> list = new ArrayList<>();
		while (rs.next()) {
			Person p = new Person();
			p.setId(rs.getInt("id"));
			p.setVorname(rs.getString("vorname"));
			p.setNachname(rs.getString("nachname"));
			p.setPlz(rs.getString("plz"));
			p.setOrt(rs.getString("ort"));
			p.setStrasse(rs.getString("strasse"));
			p.setTelefon(rs.getString("telefon"));
			p.setMobil(rs.getString("mobil"));
			p.setEmail(rs.getString("email"));
			list.add(p);
		}

		return list;
	}

	public static void main(String[] args) {
		PersonDAO dao = new PersonDAO();
		System.out.println(dao.findAllPersons());
	}

}
