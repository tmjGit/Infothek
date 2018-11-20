package tmj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.pmw.tinylog.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Person;
import tmj.app.Application;
import tmj.app.Setup;
import tmj.db.DBConnect;
import tmj.db.DBConnectException;
import tmj.db.DbInfo;
import tmj.db.dao.TheSQLPersonDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;// Nicht mysql trotz mysql DB! Flexibler!
import java.sql.DriverManager;
import java.sql.Statement;

public class DbTest {
	// static final String TREIBER = "jdbc";
	// static final String PROTOCOL = "mysql";
	// static final String HOST = "localhost";
	// static final String PORT = "3306";
	// static final String DBNAME = "InfoThek";
	// static final String USER = "root";
	// static final String PW = "";
	static final String table = "Personen";
	private DBConnect dbconnect;
	private TheSQLPersonDAO dao = new TheSQLPersonDAO();

	public DbTest() throws DBConnectException { // alternativ hier Fehlerlogging + throw new DaoException
		// Logger.trace("DBConnect.getInstance()...");
		dbconnect = DBConnect.getInstance();

		// Person p=new Person();
		// dao.insert(p);

		findAllPersons();
	}

	public static void main(String[] args) {
		Setup.init();

		String url = Application.confMainGet("driver") + ":" + Application.confMainGet("protocol") + "://" + Application.confMainGet("host")
				+ (Application.confMainGet("port").equals("") ? "" : ":" + Application.confMainGet("port")) + "/";
		String db="";//Application.confMainGet("dbname");
		try {
			Connection con = DriverManager.getConnection(url + db ,
				Application.confMainGet("user"), Application.confMainGet("password"));
//			Connection con = DriverManager.getConnection(url + Application.confMainGet("dbname"),
//				Application.confMainGet("user"), Application.confMainGet("password"));
			Logger.debug("con={}", con);
//			System.out.println("con.getCatalog()="+con.getCatalog()); // ""
//			System.out.println("con.getSchema()="+con.getSchema()); // null
//			System.out.println("con.getClientInfo()="+con.getClientInfo()); // {}

			String q;
			PreparedStatement statement;
			ResultSet result;
			


//$link = mysqli_connect('localhost', 'root', '');
//
//if ($res = mysqli_query($link, 'SHOW DATABASES')) {
//    echo 'Connected.';
//} else {
//    echo 'Error occurred', mysqli_error($link);
//}
//
//while ($row = mysqli_fetch_row($res)) {
//    echo $row[0], '<br/>';
//}


//			genericGet( con,"show create table Infothek.Personen" );
//			0.1: Personen [java.lang.String]
//					0.2: CREATE TABLE `Personen` (
//					  `id` int(11) NOT NULL AUTO_INCREMENT,
//					  `namFam` varchar(50) NOT NULL,
//					  `namIndiv` varchar(50) NOT NULL,
//					  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
//					  `changed` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//					  `gebJahr` int(11) NOT NULL,
//					  `gebMonat` int(11) NOT NULL,
//					  `gebTag` int(11) NOT NULL,
//					  `stop` int(11) DEFAULT NULL,
//					  `geschlecht` varchar(19) NOT NULL,
//					  PRIMARY KEY (`id`)
//					) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 [java.lang.String]
						
//			  result = con.prepareStatement("use Infothek").executeQuery();// ("select * from "+DBNAME);
			  
			  
//			genericGet( con,"use Infothek" );
			genericGet( con,"explain Infothek.Personen" );
			
			
//			select column_name, table_name, table_schema from information_schema.columns
//			
//			SHOW COLUMNS FROM ``Infothek`.`MyTables` WHERE IN
//			( SELECT TABLE_NAME FROM information_schema.TABLES WHERE TABLE_SCHEMA = 'Infothek' );
			
			
			
//			q = "select * from information_schema.columns";
//			statement = con.prepareStatement(q);
//			Logger.trace("execute statement={}", statement);
//			result = statement.executeQuery();
//			genericPrint(result);
//
//			q = "show create table Infothek.Personen;";
//			statement = con.prepareStatement(q);
//			Logger.trace("execute statement={}", statement);
//			result = statement.executeQuery();
//			genericPrint(result);

//			q = "show schemas;";
//			statement = con.prepareStatement(q);
//			Logger.trace("execute statement={}", statement);
//			result = statement.executeQuery();
//			while (result.next()) { // auch vor dem ersten Zugriff nötig!
//				Object o = result.getRow();
//				System.out.println(o + " - "+o.getClass().getName());
//			}

//			q = "mysqlshow;";
//			statement = con.prepareStatement(q);
//			Logger.trace("execute statement={}", statement);
//			result = statement.executeQuery();
//			while (result.next()) { // auch vor dem ersten Zugriff nötig!
//				Object o = result.getRow();
//				System.out.println(o);
//			}

//			q = "select "+Application.confMainGet("dbname") + ";";
//			statement = con.prepareStatement(q);
//			Logger.trace("execute statement={}", statement);
//			result = statement.executeQuery();
//			while (result.next()) { // auch vor dem ersten Zugriff nötig!
//				Object o = result.getRow();
//				System.out.println(o);
//			}
			
//			q="select * from Personen;";
//			statement = con.prepareStatement(q);
//			Logger.trace("execute statement={}", statement);
//			result = statement.executeQuery();
//			genericPrint(result);

//			q = "show full tables;";
//			statement = con.prepareStatement(q);
//			Logger.trace("execute statement={}", statement);
//			result = statement.executeQuery();
//			while (result.next()) { // auch vor dem ersten Zugriff nötig!
//				Object o = result.getRow();
//				System.out.println(o);
//			}
			

//			q = "select * from " + table;
//				// Struktur: id(int), namFam, namIndiv, created(Timestamp), changed(Timestamp), GebJahr, GebMonat, GebTag, stop(int), Geschlecht
//
//				statement=con.prepareStatement(q);
//					Logger.trace("execute statement={}", statement);
//					 result = statement.executeQuery();// ("select * from "+DBNAME);
//					while (result.next()) { // auch vor dem ersten Zugriff nötig!
//						System.out.print(result.getInt("id") + " - ");
//						System.out.print(result.getString("namFam") + " - ");
//						System.out.print(result.getString("namIndiv") + " - ");
//						System.out.print(result.getTimestamp("created") + " - ");
//						System.out.print(result.getTimestamp("changed") + " - ");
//						System.out.print(result.getString("GebJahr") + " - ");
//						System.out.print(result.getString("GebMonat") + " - ");
//						System.out.print(result.getString("GebTag") + " - ");
//						System.out.print(result.getInt("stop") + " - ");
//						System.out.print(result.getString("Geschlecht") + " - ");
//						System.out.println("");
//					}

				
			// Logger.trace("create DbTest...");
//			DbTest dbTest = new DbTest();

			// try {
			// Class.forName("com-mysql.jdbc.Driver").newInstance(); // automatisch ab Java
			// 7

			// Server global config file: /Applications/XAMPP/xamppfiles/etc/my.cnf oder
			// /etc/my.cnf
			// Server USER config file: /Applications/XAMPP/xamppfiles/var/mysql oder
			// ~/.my.cnf

			// Connection conn = DriverManager.getConnection(
			// TREIBER + ":" + PROTOCOL + "://" + HOST + (PORT.equals("") ? "" : ":" + PORT)
			// + "/" + DBNAME, USER,
			// PW);
			//
			// String table = "Person";
			// System.out.println("----- Showing... -----");
			// Statement selectStatement = conn.createStatement();
			// ResultSet result = selectStatement.executeQuery("select * from " + table); //
			// Befehle und Tabellennamen etc.
			// nicht case sensitiv

		} catch (SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void genericGet(Connection con,String query) throws SQLException {
		PreparedStatement statement = con.prepareStatement(query);
		Logger.trace("execute statement={}", statement);
		genericPrint( statement.executeQuery() );
	}
	
	public static void genericPrint(ResultSet result) throws SQLException {
		int Index=0;
		while (result.next()) { // auch vor dem ersten Zugriff nötig!
			int i=1;
			boolean b=true;
			while(b) {
				try {
					Object o;
					o=result.getObject(i);
					System.out.println(""+Index+"."+i+": "+o + " ["+o.getClass().getName()+"]");
					i++;
				}catch(SQLException e) {//out of index
					if (isIndexOutOfRangeException(e))
						b=false;
					else
						throw e;
				}
			}
			Index++;
		}
	}
	
	public static boolean isIndexOutOfRangeException(SQLException e) {
		return (e.getErrorCode()==0 && e.getMessage().substring(0,25).equals("Column Index out of range"));
	}

	public List<String> getDatabases(Connection con) {
		List<String> list = new ArrayList<>();
		String q="show databases" ; // = show schemas
		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			Logger.trace("execute statement={}", statement);
			ResultSet result = statement.executeQuery();
			while (result.next()) { // auch vor dem ersten Zugriff nötig!
				list.add( result.getString(1) );
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public List<Person> findAllPersons() {
		ObservableList<Person> persons = FXCollections.observableArrayList();// List<Person_d> personList = new
																				// ArrayList<>();
		final String q = "select * from " + table;
		// Struktur: id(int), namFam, namIndiv, created(Timestamp), changed(Timestamp),
		// GebJahr, GebMonat, GebTag, stop(int), Geschlecht
		// Logger.trace("Create statement...");

		try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
			Logger.trace("execute statement={}", statement);
			ResultSet result = statement.executeQuery();// ("select * from "+DBNAME);
			while (result.next()) { // auch vor dem ersten Zugriff nötig!
				System.out.print(result.getInt("id") + " - ");
				System.out.print(result.getString("namFam") + " - ");
				System.out.print(result.getString("namIndiv") + " - ");
				System.out.print(result.getTimestamp("created") + " - ");
				System.out.print(result.getTimestamp("changed") + " - ");
				System.out.print(result.getString("GebJahr") + " - ");
				System.out.print(result.getString("GebMonat") + " - ");
				System.out.print(result.getString("GebTag") + " - ");
				System.out.print(result.getInt("stop") + " - ");
				System.out.print(result.getString("Geschlecht") + " - ");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return persons;
	}

	private static void show(Connection conn) throws SQLException {
		System.out.println("----- Showing... -----");
		Statement selectStatement = conn.createStatement();
		ResultSet result = selectStatement.executeQuery("select * from Designpattern"); // Befehle und Tabellennamen
																						// etc. nicht case sensitiv
		while (result.next()) { // auch vor dem ersten Zugriff nötig!
			int id = result.getInt("id"); // Spaltenname case sensitiv!
			String name = result.getString("name");
			String description = result.getString("description");
			System.out.printf("%d %s \t %s \n", id, name, description); // format: %d = dezimal,
		}
	}

}
