//package li.tmj.db.sql;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import li.tmj.app.Application;
//import li.tmj.db.exception.DBConnectException;
//import org.pmw.tinylog.Logger;
//
////public final class DBConnect {//Singleton
//public final class DBConnect {
//	private static DBConnect instance = null;
//	private Connection con;// TODO con.close
//	private static String dbname=Application.confMainGet("dbname");
//	
//	private  DBConnect() {
//		try {
//			Class.forName( "com.mysql.jdbc.Driver" ).newInstance();///!!!!Tomcat
//			con  = DriverManager.getConnection(	Application.confMainGet("url")+Application.confMainGet("db"),
//						Application.confMainGet("usr"),
//						Application.confMainGet("pwd")
//					);
//		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static DBConnect getInstance(){
//		if(instance == null){
//			instance = new DBConnect();
//		}
//		return instance;
//	}
//	
//	public Connection getConnection(){
//		return con;
//	}
//	
//	public static String getDbname(){
//		return dbname;
//	}
//}
//
////	private static Connection connection;
////	
////	private  DBConnect() throws DBConnectException {
////		Logger.trace("connect...");
////		// Falls die Connection außerhalb geschlossen wird, kann sie aufgrund des Singleton nicht mehr geöffnet werden.
////			connect( createUrl(),Application.confMainGet("dbname"),Application.confMainGet("user"),Application.confMainGet("password") );
////	}
////
////	public static String createUrl() {
////		Logger.trace("createUrl...");
////		return Application.confMainGet("driver") + ":" + Application.confMainGet("protocol") + "://" + Application.confMainGet("host") 
////		+ (Application.confMainGet("port").equals("") ? "" : ":" + Application.confMainGet("port")) +"/";
////	}
////	
////	private static void connect(String url, String db, String user, String password) throws DBConnectException {
////		Logger.trace("url={}, db={}, user={}, password={}",url,db,user,password);
////		try { 
//////			con  = DriverManager.getConnection(	url +"", user, password );
////			con  = DriverManager.getConnection(	url + db, user, password );
//////			Logger.debug("con={}",con);
////		} catch (SQLException e) {
////			// TODO error log
////			throw new DBConnectException(e.getMessage()); // e.printStackTrace();
////		}
////	}
////	
////	public static DBConnect getInstance() throws DBConnectException{
////		Logger.trace("getInstance: instance={}",instance);
////		if(instance == null){
////			instance = new DBConnect();
////		}
////		return instance;
////	}
////	
////	public static Connection getConnection(){
////		Logger.trace("getConnection: connection={}", connection);
////		if(null==connection) {
////			connect(url, db, user, password);
////		}
////		return connection;
////	}
////}
