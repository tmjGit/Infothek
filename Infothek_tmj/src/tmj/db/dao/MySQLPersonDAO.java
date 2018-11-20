package tmj.db.dao;

import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;
import tmj.db.DBConnect;
import tmj.db.DBConnectException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLPersonDAO implements PersonDAO{ // hier DBConnect verwenden.
	private DBConnect dbconnect;
	
//	 You could pass a Class<T> in.
//
//	 private void foo(Class<?> cls) {
//	     if (cls == String.class) { ... }
//	     else if (cls == int.class) { ... }
//	 }
//
//	 private void bar() {
//	     foo(String.class);
//	 }
//
//	 Update: the OOP way depends on the functional requirement. Best bet would be an interface defining foo() and two concrete implementations implementing foo() and then just call foo() on the implementation you've at hand. Another way may be a Map<Class<?>, Action> which you could call by actions.get(cls). This is easily to be combined with an interface and concrete implementations: actions.get(cls).foo().

	
	
	
//	import java.util.ArrayList;
//	import java.util.List;
//
//	public class PassAClass {
//	    public static void main(String[] args) {
//	        MagicGun gun = new MagicGun();
//	        gun.loadWith(Pebble.class);
//	        gun.loadWith(Bullet.class);
//	        gun.loadWith(NuclearMissle.class);
//	        //gun.loadWith(Object.class);   // Won't compile -- Object is not a Projectile
//	        for(int i=0; i<5; i++){
//	            try {
//	                String effect = gun.shoot().effectOnTarget();
//	                System.out.printf("You've %s the target!\n", effect);
//	            } catch (GunIsEmptyException e) {
//	                System.err.printf("click\n");
//	            }
//	        }
//	    }
//	}
//
//	class MagicGun {
//	    /**
//	     * projectiles holds a list of classes that extend Projectile. Because of erasure, it
//	     * can't hold be a List<? extends Projectile> so we need the SuppressWarning. However
//	     * the only way to add to it is the "loadWith" method which makes it typesafe. 
//	     */
//	    private @SuppressWarnings("rawtypes") List<Class> projectiles = new ArrayList<Class>();
//	    /**
//	     * Load the MagicGun with a new Projectile class.
//	     * @param projectileClass The class of the Projectile to create when it's time to shoot.
//	     */
//	    public void loadWith(Class<? extends Projectile> projectileClass){
//	        projectiles.add(projectileClass);
//	    }
//	    /**
//	     * Shoot the MagicGun with the next Projectile. Projectiles are shot First In First Out.
//	     * @return A newly created Projectile object.
//	     * @throws GunIsEmptyException
//	     */
//	    public Projectile shoot() throws GunIsEmptyException{
//	        if (projectiles.isEmpty())
//	            throw new GunIsEmptyException();
//	        Projectile projectile = null;
//	        // We know it must be a Projectile, so the SuppressWarnings is OK
//	        @SuppressWarnings("unchecked") Class<? extends Projectile> projectileClass = projectiles.get(0);
//	        projectiles.remove(0);
//	        try{
//	            // http://www.java2s.com/Code/Java/Language-Basics/ObjectReflectioncreatenewinstance.htm
//	            projectile = projectileClass.newInstance();
//	        } catch (InstantiationException e) {
//	            System.err.println(e);
//	        } catch (IllegalAccessException e) {
//	            System.err.println(e);
//	        }
//	        return projectile;
//	    }
//	}
//
//	abstract class Projectile {
//	    public abstract String effectOnTarget();
//	}
//
//	class Pebble extends Projectile {
//	    @Override public String effectOnTarget() {
//	        return "annoyed";
//	    }
//	}
//
//	class Bullet extends Projectile {
//	    @Override public String effectOnTarget() {
//	        return "holed";
//	    }
//	}
//
//	class NuclearMissle extends Projectile {
//	    @Override public String effectOnTarget() {
//	        return "obliterated";
//	    }
//	}
//
//	class GunIsEmptyException extends Exception {
//	    private static final long serialVersionUID = 4574971294051632635L;
//	}
	
	public static final String DBNAME="adressen";
//	public static final String[] FXIDS = new String[]{"vornameFld" ,"nachnameFld" ,"plzFld" ,"ortFld" ,"strasseFld" ,"telefonFld" ,"mobil.Fld" ,"emailFld" };
//	public static final String[] LABEL = new String[]{"Vorname" ,"Nachname" ,"PLZ" ,"Ort" ,"Straße/Nr." ,"Telefon" ,"Mobil" ,"E-Mail" };
//	public static final String[][] displayNames = new String[]{"id" ,"vorname" ,"nachname" ,"plz" ,"ort" ,"strasse" ,"telefon" ,"mobil" ,"email" };
//	public static final HashMap<String,Class<?>> fields = new HashMap<>();
	private static FieldDAO[] fields;
	
	 
	public MySQLPersonDAO() throws DBConnectException { // alternativ hier Fehlerlogging + throw new DaoException
//		fields.put("id",Integer.class);
//		fields.put("vorname",String.class);
//		fields.put("nachname",String.class);
//		fields.put("plz",String.class);
//		fields.put("ort",String.class);
//		fields.put("strasse",String.class);
//		fields.put("telefon",String.class);
//		fields.put("mobil",String.class);
//		fields.put("email",String.class);
		
		fields=new FieldDAO[9];
		fields= new FieldDAO[]{
				new FieldDAO("id", "ID", "id", Integer.class, false),
				new FieldDAO("vorname", "Vorname", "vorname", String.class, false),
				new FieldDAO("nachname", "Nachname", "nachname", String.class, false),
				new FieldDAO("plz", "PLZ", "plz", String.class, false),
				new FieldDAO("ort", "Ort", "ort", String.class, false),
				new FieldDAO("strasse", "Straße/Nr.", "strasse", String.class, false),
				new FieldDAO("telefon", "Telefon", "telefon", String.class, true),
				new FieldDAO("mobil", "Mobil", "mobil", String.class, true),
				new FieldDAO("email", "E-Mail", "email", String.class, true),
		};
					 
		dbconnect=DBConnect.getInstance();
	}
	
	public static final FieldDAO[] getFields() {
		return fields;
	}
	
	public void setPersonData(Person person, String variableName, String newValue) {
//		Method method;
//		try {
//		  method = person.getClass().getMethod("set"+variableName.toUpperCase(), String.class);
//		  method.invoke(person, newValue);
//		} catch (SecurityException e) { 
//			e.getStackTrace()
//		} catch (NoSuchMethodException e) { 
//			e.getStackTrace()
//		} catch (IllegalArgumentException e) { 
//			e.getStackTrace()
//		} catch (IllegalAccessException e) { 
//			e.getStackTrace()
//		} catch (InvocationTargetException e) { 
//			e.getStackTrace()
//		}
		switch(variableName) {
			case "vorname": person.setVorname(newValue); break;
			case "nachname": person.setNachname(newValue); break;
			case "plz": person.setPlz(newValue); break;
			case "ort": person.setOrt(newValue); break;
			case "strasse": person.setStrasse(newValue); break;
			case "telefon": person.setTelefon(newValue); break;
			case "mobil.Fld": person.setMobil(newValue); break;
			case "emailFld": person.setEmail(newValue); break;
//			default: {//TODO sicherheitshalber exception handling?
		}
	}

	@Override public List<Person> findAllPersons() {
		ObservableList<Person> persons=FXCollections.observableArrayList();//List<Person_d> personList = new ArrayList<>();
		final String q = "select * from "+DBNAME;
		
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
//			Statement statement = dbconnect.getConnection().createStatement();
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
		final String q = "insert into " + DBNAME + " (vorname,nachname,ort,plz,strasse, telefon,mobil,email) VALUES (?,?,?,?,?,?,?,?)";
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			statement.setString(1, person.getVorname());
			statement.setString(2, person.getNachname());
			statement.setString(3, person.getOrt());
			statement.setString(4, person.getPlz());
			statement.setString(5, person.getStrasse());
			statement.setString(6, person.getTelefon());
			statement.setString(7, person.getMobil());
			statement.setString(8, person.getEmail());
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
//			System.out.println("MySQLPersonDAO.updatePerson: statement="+statement);
			return statement.executeUpdate()==1; // erfolgreich der eine Datensatz geändert.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}
