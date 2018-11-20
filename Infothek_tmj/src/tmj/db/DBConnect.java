package tmj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.pmw.tinylog.Logger;

import tmj.app.Application;

public final class DBConnect {//Singleton
//	static final String TREIBER = "jdbc";
//	static final String PROTOCOL = "mysql";
//	static final String HOST = "localhost";
//	static final String PORT = "3306";
//	static final String DBNAME = "InfoThek";
//	static final String USER = "root";
	static final String PW = "";
	private static DBConnect instance = null;
	private Connection con;
	
	public static String createUrl() {
		Logger.trace("createUrl...");
		return Application.confMainGet("driver") + ":" + Application.confMainGet("protocol") + "://" + Application.confMainGet("host") 
		+ (Application.confMainGet("port").equals("") ? "" : ":" + Application.confMainGet("port")) +"/";
	}
	
	private  DBConnect() throws DBConnectException {
		Logger.trace("connect...");
		// Falls die Connection außerhalb geschlossen wird, kann sie aufgrund des Singleton nicht mehr geöffnet werden.
			connect( createUrl(),Application.confMainGet("dbname"),Application.confMainGet("user"),Application.confMainGet("password") );
	}

	private void connect(String url, String db, String user, String password) throws DBConnectException {
		Logger.trace("url={}, db={}, user={}, password={}",url,db,user,password);
		try { 
//			con  = DriverManager.getConnection(	url +"", user, password );
			con  = DriverManager.getConnection(	url + db, user, password );
//			Logger.debug("con={}",con);
		} catch (SQLException e) {
			// TODO error log
			throw new DBConnectException(e.getMessage()); // e.printStackTrace();
		}
	}
	
	public static DBConnect getInstance() throws DBConnectException{
		Logger.trace("getInstance: instance={}",instance);
		if(instance == null){
			instance = new DBConnect();
		}
		return instance;
	}
	
	public Connection getConnection(){
		return con;
	}

}
