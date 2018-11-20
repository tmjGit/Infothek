package tmj.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.pmw.tinylog.Logger;

import model.Person;

public class DbInfo {
	private DBConnect dbconnect;
	public static final String TABLENAME="Personen";
	
	public DbInfo() {
		try {
			dbconnect=DBConnect.getInstance();
		} catch (DBConnectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public String[] getDatabases(){
//		final String q = "insert into " + TABLENAME + " (namFam,namIndiv,GebJahr, GebMonat,GebTag,stop,Geschlecht) VALUES (?,?,?,?,?,?,?)";
//		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
//		// SHOW DATABASES // databases (aka directories) on that server
//		// SELECT DATABASE(); // current database
//			// SELECT DATABASE();
//			// show tables
//			
//		return String[]
//				
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return null;
//		}	

//	@Override
//	public boolean insert(Person person) {
//		final String q = "insert into " + TABLENAME + " (namFam,namIndiv,GebJahr, GebMonat,GebTag,stop,Geschlecht) VALUES (?,?,?,?,?,?,?)";
//		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
//			
////			System.out.print(result.getInt("id") + " - ");
//			statement.setString(1,"namFam1") ;
//			statement.setString(2,"namIndiv1");
////			statement.setTimestamp(3,"localdate") + " - ");
////			statement.setTimestamp(4,"changed") + " - ");
//			statement.setInt(3,1970);
//			statement.setInt(4,8);
//			statement.setInt(5,12);
//			statement.setInt(6,0);
//			statement.setString(7,"weiblich");
//			
////			Statement statement = dbconnect.getConnection().createStatement();
////			int n = statement.executeUpdate();//	int n=statement.executeUpdate(q);
//			return statement.executeUpdate()==1; // erfolgreich der eine Datensatz eingefügt.
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return false;
//	}	
	
	public void showDatabases() {
//		final String q = "insert into " + TABLENAME + " (namFam,namIndiv,GebJahr, GebMonat,GebTag,stop,Geschlecht) VALUES (?,?,?,?,?,?,?)";
		final String q="show databases";
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			Logger.trace("execute statement={}",statement);
			ResultSet result = statement.executeQuery();
			while (result.next()) { // auch vor dem ersten Zugriff nötig!
				Object o=result.getRow();
				System.out.println( o );
			}
//			return statement.executeUpdate()==1; // erfolgreich der eine Datensatz eingefügt.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}	
	
	public void showTables() {
//		final String q = "insert into " + TABLENAME + " (namFam,namIndiv,GebJahr, GebMonat,GebTag,stop,Geschlecht) VALUES (?,?,?,?,?,?,?)";
		final String q="show full tables";
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			Logger.trace("execute statement={}",statement);
			ResultSet result = statement.executeQuery();
			while (result.next()) { // auch vor dem ersten Zugriff nötig!
				Object o=result.getRow();
				System.out.println( o );
			}
//			return statement.executeUpdate()==1; // erfolgreich der eine Datensatz eingefügt.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ;
	}	
	
}