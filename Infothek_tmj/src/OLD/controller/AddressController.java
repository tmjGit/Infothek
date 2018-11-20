package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import conf.Conf;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import model.Person;
import tmj.db.dao.MySQLPersonDAO;
import tmj.db.dao.PersonDAO;
import tmj.ui.controller.FieldsController;
import tmj.ui.controller.TableController;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class AddressController {
	@FXML TableView<Person> tableView;
	@FXML AnchorPane inputPane;
	@FXML Label feedbackT;
	private static final DateTimeFormatter DATETIME_FORMAT=DateTimeFormatter.ofPattern(Conf.get("datetimeformat"));
	private PersonDAO personDAO;
	private TextField[] fields;

	@FXML void initialize(){
		personDAO=new MySQLPersonDAO();
		TableController.createBoundColumns(tableView, new String[]{"id" ,"vorname" ,"nachname" ,"plz" ,"ort" ,"strasse" ,"telefon" ,"mobil" ,"email" },
		e-> {
			int id=e.getRowValue().getId();
			String fieldName=e.getTableColumn().getText();
			if( personDAO.updatePerson(id, fieldName, e.getNewValue()))
				giveFeedback("Person ("+id+") Feld "+fieldName+" aktualisiert.", true);
			else
				giveFeedback("Person ("+id+") Feld "+fieldName+" konnte nicht aktualisiert werden.", false);
		} );
		
		fields=FieldsController.createTextfields(inputPane, new String[]{"Vorname" ,"Nachname" ,"PLZ" ,"Ort" ,"Straße/Nr." ,"Telefon" ,"Mobil" ,"E-Mail" });
		FieldsController.setNodeIds(fields, new String[]{"vornameFld" ,"nachnameFld" ,"plzFld" ,"ortFld" ,"strasseFld" ,"telefonFld" ,"mobil.Fld" ,"emailFld" });
		
		// Kontextmenü
		ContextMenu cMenu= new ContextMenu();
		MenuItem deleteItm = new MenuItem("Löschen");
		deleteItm.setOnAction(e->{
			ObservableList<Person> persons=tableView.getSelectionModel().getSelectedItems();
			if (persons.size()==1)
				if(personDAO.deletePerson(persons.get(0).getId()))
					giveFeedback("Person (id="+persons.get(0).getId()+") aus der Datenbank gelöscht.",true);
				else
					giveFeedback("Person (id="+persons.get(0).getId()+") konnte nicht aus der Datenbank gelöscht werden!",false);
			else
				if(personDAO.deletePersons(personIds(persons)))
					giveFeedback(persons.size()+" Personen aus der Datenbank gelöscht.",true);
				else
					giveFeedback("Löschen von " + persons.size() + " Personen aus der Datenbank fehlgeschlagen!",false);

//			b.setOnAction(new EventHandler<ActionEvent>() {
//
//		        @Override
//		        public void handle(ActionEvent arg0) {
//		            List items =  new ArrayList (treeTable.getSelectionModel().getSelectedItems());  
//		            data.removeAll(items);
//		            table.getSelectionModel().clearSelection();
//
//		        }
//		    });

//			Person p=tableView.getSelectionModel().getSelectedItem();
//			System.out.println(p);
//			if(personDAO.deletePerson(p.getId()))
//				giveFeedback("Person (id="+p.getId()+") aus der Datenbank gelöscht.",true);
//			else
//				giveFeedback("Person (id="+p.getId()+") konnte nicht aus der Datenbank gelöscht werden.",false);
		});
		cMenu.getItems().add(deleteItm);
		tableView.setContextMenu(cMenu);

tableview  multi rows selection?
		
		refreshView();
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
				switch(t.getId()) {
					case "vornameFld": p.setVorname(t.getText()); break;
					case "nachnameFld": p.setNachname(t.getText()); break;
					case "plzFld": p.setPlz(t.getText()); break;
					case "ortFld": p.setOrt(t.getText()); break;
					case "strasseFld": p.setStrasse(t.getText()); break;
					case "telefonFld": p.setTelefon(t.getText()); break;
					case "mobil.Fld": p.setMobil(t.getText()); break;
					case "emailFld": p.setEmail(t.getText()); break;
				default: {//TODO sicherheitshalber exception handling?
					}
				}
			}
			if(personDAO.savePerson(p))
				giveFeedback("Person in der Datenbank gespeichert.",true);
			else
				giveFeedback("Person konnte nicht in der Datenbank gespeichert werden.",false);
		}
	}
	
	@FXML public void refreshBtAction() {
		refreshView();
		giveFeedback("Anzeige aktualisiert.", true);
	}
	
}

