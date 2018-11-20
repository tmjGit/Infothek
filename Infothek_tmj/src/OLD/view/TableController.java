package view;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Person;

public class TableController {
	private TableController() {	}
	
	public static int createBoundColumns(TableView<Person> tableView,String[] header, EventHandler<CellEditEvent<Person, String>> event) {
		int count=0;
		for(String s:header)
			if( createBoundColumn(tableView,s,event) )
				count++;
		return count;
	}


	public static boolean createBoundColumn(TableView<Person> tableView, String name, EventHandler<CellEditEvent<Person, String>> event) {
		TableColumn<Person,String> c=new TableColumn<>(name);
//		prefWidth="100.0"
//		c.setUserData(value);	// interne Daten bspw. Datenbank Feldname setzen, etc.
		c.setCellValueFactory(new PropertyValueFactory<>(name));
		switch(name) {
		case "telefon":
		case "mobil":
		case "email":
			c.setCellFactory(TextFieldTableCell.forTableColumn());
			c.setOnEditCommit(event);
			break;
//			default:{}; // we don't want to modify other fields
		}
		
		return tableView.getColumns().add(c);
	}
}