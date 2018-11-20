package generic;

import generic.DbField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Contains an array of field values which is a set of database records. 
 * Contains the field properties of the corresponding fields.
 *
 */
public class DbDataCollection {
	private static DbField[] fields;
	public ObservableList<DbData> dataList;
	 
	public static void createFields(int count) {
		fields=new DbField[count];
	}

	public DbDataCollection() {
		dataList=FXCollections.observableArrayList();					 
	}
	
//	public DbDataCollection(DbField... fields) {
//		dataList=FXCollections.observableArrayList();
//		setFields(fields);
//	}
	
	public boolean add(DbData data) {
		return dataList.add(data);
	}
	
	public DbData get(int Index) {
		return dataList.get(Index);
	}
	
	public static void setFields(DbField... fields) { //String name, String displayname, Class<?> type, boolean editable) {
		DbDataCollection.fields= fields;
	}

//	public static void setFields(String name, String displayname, Class<?> type, boolean editable) {
//		fields= new DbField[]{
//				new DbField("id", "ID", Integer.class, false),
//				new DbField("vorname", "Vorname", String.class, false),
//				new DbField("nachname", "Nachname", String.class, false)
//		};
//	}
	
	public static DbField getField(int Index) {
		return fields[Index];
	}
	
	public static void setField(int Index, DbField field) {
		fields[Index]=field;
	}
	
	public static void setField(int Index, String name, String displayname, Class<?> type, boolean editable) {
		fields[Index].name=name;
		fields[Index].displayName=displayname;
		fields[Index].type=type;
		fields[Index].editable=editable;	
	}
	
	public static int countFields() {
		return fields.length;
	}

}
