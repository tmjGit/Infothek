package tmj.ui.controller;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Person;
import tmj.db.dao.FieldDAO;

public class TableController {
	private TableController() {	}
	
	public static int createBoundColumns(TableView<Person> tableView,FieldDAO[] fields, EventHandler<CellEditEvent<Person, String>> event) {
		int count=0;
		for (FieldDAO f: fields) {
			if( createBoundColumn(tableView,f,event) )
				count++;
		}
		
		return count;
	}
	
//	public static int createBoundColumns(TableView<Data> tableView,Set<String> header, EventHandler<CellEditEvent<Data, String>> event) {
//		// TODO Was ist besser/effektiver? header.toArray oder wie? Jedenfalls sind hier zwei fast gleiche Methoden doof.
////		createBoundColumns(tableView, header.toArray(new String[header.size()]), event);
//		int count=0;
//		for (String s : header) {
//			if( createBoundColumn(tableView,s,event) )
//				count++;
//		}
//		
//		return count;
//	}
//	
//	public static int createBoundColumns(TableView<Data> tableView,String[] header, EventHandler<CellEditEvent<Data, String>> event) {
//		int count=0;
//		for(String s:header)
//			if( createBoundColumn(tableView,s,event) )
//				count++;
//		return count;
//	}

	public static boolean createBoundColumn(TableView<Person> tableView, FieldDAO field, EventHandler<CellEditEvent<Person, String>> event) {
		TableColumn<Person,String> c=new TableColumn<>(field.displayName);
		c.setId(field.name);// We store the DB field name here for later use
//		c.setUserData(value);	// interne Daten bspw. Datenbank Feldname setzen, etc.
//		prefWidth="100.0"
		c.setCellValueFactory(new PropertyValueFactory<>(field.variableName)); // This must be the Getter/Setter root name of Data
		if (field.editable){
			c.setCellFactory(TextFieldTableCell.forTableColumn());
			c.setOnEditCommit(event);
		}
		
		return tableView.getColumns().add(c);
	}

//	public static boolean createBoundColumn(TableView<Data> tableView, String name, EventHandler<CellEditEvent<Data, String>> event) {
//		TableColumn<Data,String> c=new TableColumn<>(name);
//		c.setId(name);// We store the DB field name here for later use
////		prefWidth="100.0"
////		c.setUserData(value);	// interne Daten bspw. Datenbank Feldname setzen, etc.
//		c.setCellValueFactory(new PropertyValueFactory<>(name));
//		switch(name) {
//		case "telefon":
//		case "mobil":
//		case "email":
//			c.setCellFactory(TextFieldTableCell.forTableColumn());
//			c.setOnEditCommit(event);
//			break;
////			default:{}; // we don't want to modify other fields
//		}
//		
//		return tableView.getColumns().add(c);
//	}
}