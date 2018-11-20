package generic;

import java.util.Collections;

import generic.DbField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tmj.db.DBConnect;
import tmj.db.DBConnectException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbDataSQLDAO implements DbDataDAO{ // hier DBConnect verwenden.
	private DBConnect dbconnect;
	public static final String DBNAME="adressen";
	 
	public DbDataSQLDAO() throws DBConnectException { // alternativ hier Fehlerlogging + throw new DaoException
//		DbDataCollection.createFields(9);
//		DbDataCollection.setField(0, "id", "ID", Integer.class, false);
//		DbDataCollection.setField(1, new DbField("vorname", "Vorname", String.class, true));
		DbDataCollection.setFields( //(name, displayname, type, editable);
				new DbField("id", "ID", Integer.class, false),
				new DbField("vorname", "Vorname", String.class, false),
				new DbField("nachname", "Nachname", String.class, false),
				new DbField("plz", "PLZ", String.class, false),
				new DbField("ort", "Ort", String.class, false),
				new DbField("strasse", "Straße/Nr.", String.class, false),
				new DbField("telefon", "Telefon", String.class, true),
				new DbField("mobil", "Mobil", String.class, true),
				new DbField("email", "E-Mail", String.class, true)
		);
					 
		dbconnect=DBConnect.getInstance();
	}
		
		public void setData(DbData data, String variableName, DbValue value) {
			for (int i=0; i<DbDataCollection.countFields()-1; i++) { // -1 because the id is not editable!
					if(DbDataCollection.getField(i).name.equals(variableName)) {
						data.setValue(i, value);
						return;
					}
				 //TODO not found: exception handling
				}
		}
		
		public void setData(DbData data, int Index, DbValue value) {
			data.setValue(Index, value);
		}

		@Override public ObservableList<DbData> findAll() {
			ObservableList<DbData> dataList=FXCollections.observableArrayList();//DbDataCollection c=new DbDataCollection();
			final String q = "select * from "+DBNAME;
			
			try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { 
				ResultSet result = statement.executeQuery();
				while(result.next()) { // auch vor dem ersten Zugriff nötig!
					DbData data=new DbData(DbDataCollection.countFields());
						for(int i=0; i<DbDataCollection.countFields(); i++) {
							if(DbDataCollection.getField(i).type==Integer.class) {
								DbIntValue iValue=new DbIntValue();
								iValue.setValue(result.getInt(DbDataCollection.getField(i).name));
								data.setValue(0, iValue);
							}else if(DbDataCollection.getField(i).type==String.class) {
						}	DbStringValue sValue=new DbStringValue();
							sValue.setValue(result.getString(DbDataCollection.getField(i).name));
							data.setValue(1, sValue);
//						}else {
							//wrong type exception
						}
						dataList.add(data);                      //.add(data);
				}

			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dataList;
		}
		
		@Override
		public boolean save(DbData data) {
			String q="insert into "+DBNAME+" (";
			if (DbDataCollection.countFields()>0) {
				q=q+DbDataCollection.getField(0).name;
				for (int i=1; i<DbDataCollection.countFields(); i++) {
					q=q+","+DbDataCollection.getField(0).name;
				}
				q=q+") values(?" + String.join("", Collections.nCopies(DbDataCollection.countFields()-1, ",?")) + ")";				
				// 	"insert into " + DBNAME + " (vorname,nachname,ort,plz,strasse, telefon,mobil,email) VALUES (?,?,?,?,?,?,?,?)";
			}
			try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
				for(int i=0; i<DbDataCollection.countFields(); i++) {
					statement.setString(i+1, data.getValue(i).getValue().toString());
				}

				return statement.executeUpdate()==1; // erfolgreich der eine Datensatz eingefügt.
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}	
		
		@Override
		public boolean delete(int id) {//TODO
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
		public boolean delete(int[] ids) {//TODO
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
		public boolean update(int id, String fieldName, DbValue newValue) {//TODO
			final String q = "update " + DBNAME + " set " + fieldName + "=? where id=?";
			try (PreparedStatement statement = dbconnect.getConnection().prepareStatement(q)) { // mit Autoclose
				statement.setString(1, newValue.getValue().toString());
				statement.setInt(2, id);
				return statement.executeUpdate()==1; // erfolgreich der eine Datensatz geändert.
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		
	}
