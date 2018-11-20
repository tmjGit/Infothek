package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import conf.Conf;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import model.Person;
import tmj.db.DBConnectException;
import tmj.db.dao.MySQLPersonDAO;
import tmj.db.dao.PersonDAO;
import tmj.ui.controller.FieldsController;
import tmj.ui.controller.TableController;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn.CellEditEvent;

public class AddressController {
//	private static final String[] FXIDS = new String[]{"vornameFld" ,"nachnameFld" ,"plzFld" ,"ortFld" ,"strasseFld" ,"telefonFld" ,"mobil.Fld" ,"emailFld" };
//	private static final String[] LABEL = new String[]{"Vorname" ,"Nachname" ,"PLZ" ,"Ort" ,"Straße/Nr." ,"Telefon" ,"Mobil" ,"E-Mail" };
//	private static final String[] FIELDS = new String[]{"id" ,"vorname" ,"nachname" ,"plz" ,"ort" ,"strasse" ,"telefon" ,"mobil" ,"email" };
	@FXML TableView<Person> tableView;
	@FXML AnchorPane inputPane;
	@FXML Label feedbackT;
	private static final DateTimeFormatter DATETIME_FORMAT=DateTimeFormatter.ofPattern(Conf.get("datetimeformat"));
	private PersonDAO personDAO;
	private TextField[] fields;

	@FXML void initialize(){
		try {
			personDAO=new MySQLPersonDAO();
			TableController.createBoundColumns(tableView, MySQLPersonDAO.getFields(), createTableActionEvent() );
			
			fields=FieldsController.createTextfields(inputPane, MySQLPersonDAO.getFields());
//			FieldsController.setNodeIds(fields, FXIDS);
			
			makeContextMenu();
			tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			
			refreshView();
		} catch (DBConnectException e) {
			System.out.println("initialize: Fehler: "+e.getMessage());
			Alert alert=new Alert(AlertType.ERROR); //	e.printStackTrace();
			alert.setContentText("Fehler: "+e.getMessage());
			alert.showAndWait();
			Platform.exit();
		}
	}

	private EventHandler<CellEditEvent<Person, String>> createTableActionEvent() {
		return e-> { // Action Event for table cells
			int id=e.getRowValue().getId();
			String fieldName=e.getTableColumn().getId();// We stored the DB field name here
			if( personDAO.updatePerson(id, fieldName, e.getNewValue()))
				giveFeedback("Data ("+id+") Feld "+fieldName+" aktualisiert.", true);
			else
				giveFeedback("Data ("+id+") Feld "+fieldName+" konnte nicht aktualisiert werden.", false);
		};
	}

	private void makeContextMenu() {
		ContextMenu cMenu= new ContextMenu();
		MenuItem deleteItm = new MenuItem("Löschen");
		deleteItm.setOnAction(e->{
			ObservableList<Person> persons=tableView.getSelectionModel().getSelectedItems();
			if (persons.size()==1)
				if(personDAO.deletePerson(persons.get(0).getId()))
					giveFeedback("Data (id="+persons.get(0).getId()+") aus der Datenbank gelöscht.",true);
				else
					giveFeedback("Data (id="+persons.get(0).getId()+") konnte nicht aus der Datenbank gelöscht werden!",false);
			else
				if(personDAO.deletePersons(personIds(persons)))
					giveFeedback(persons.size()+" Personen aus der Datenbank gelöscht.",true);
				else
					giveFeedback("Löschen von " + persons.size() + " Personen aus der Datenbank fehlgeschlagen!",false);

		});
		cMenu.getItems().add(deleteItm);
		tableView.setContextMenu(cMenu);
	}
	
	private int[] personIds(ObservableList<Person> persons) {
		int[] ids=new int[persons.size()];
		for(int i=0; i<ids.length; i++) {
			ids[i]=persons.get(i).getId();
		}
		return ids;
	}	
	
	
	private void refreshView() {
		ObservableList<Person> persons=(ObservableList<Person>) personDAO.findAllPersons();
		tableView.setItems(persons);
	}
	
	private void giveFeedback(String s,boolean isPositive) {
		feedbackT.setTextFill(isPositive ? Color.BLACK : Color.RED);
		feedbackT.setText(LocalDateTime.now().format(DATETIME_FORMAT)+" "+s);
	}

	@FXML public void saveBtAction() {
		if(fields!=null) {
			Person p=new Person();
			for (TextField t:fields) {
				personDAO.setPersonData(p,t.getId(),t.getText()); // p.set(fields.getID(), t.getText());
//				switch(t.getId()) {
//					case "vornameFld": p.setVorname(t.getText()); break;
//					case "nachnameFld": p.setNachname(t.getText()); break;
//					case "plzFld": p.setPlz(t.getText()); break;
//					case "ortFld": p.setOrt(t.getText()); break;
//					case "strasseFld": p.setStrasse(t.getText()); break;
//					case "telefonFld": p.setTelefon(t.getText()); break;
//					case "mobil.Fld": p.setMobil(t.getText()); break;
//					case "emailFld": p.setEmail(t.getText()); break;
//				default: {//TODO sicherheitshalber exception handling?
//					}
//				}
			}
			if(personDAO.insert(p))
				giveFeedback("Data in der Datenbank gespeichert.",true);
			else
				giveFeedback("Data konnte nicht in der Datenbank gespeichert werden.",false);
		}
	}
	
	@FXML public void refreshBtAction() {
		refreshView();
		giveFeedback("Anzeige aktualisiert.", true);
	}
	
}

