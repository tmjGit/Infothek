package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Person;
import tmj.db.dao.MySQLPersonDAO;
import tmj.db.dao.PersonDAO;

public class AdressController_d {
	@FXML private TableView<Person> adressTableView;
    @FXML private TableColumn<Person, Integer> idCol;
    @FXML private TableColumn<Person,String> vornameCol;
    @FXML private TableColumn<Person,String> nachnameCol;
    @FXML private TableColumn<Person,String> plzCol;
    @FXML private TableColumn<Person,String> ortCol;
    @FXML private TableColumn<Person,String> strasseCol;
    @FXML private TableColumn<Person,String> telefonCol;
    @FXML private TableColumn<Person,String> mobilCol;
    @FXML private TableColumn<Person,String> emailCol;
    @FXML private TextField vornameFiled;
    @FXML private TextField nachnameField;
    @FXML private TextField plzField;
    @FXML private TextField ortField;
    @FXML private TextField strasseField;
    @FXML private TextField telfonField;
    @FXML private TextField mobilField;
    @FXML private TextField emailField;
    private PersonDAO dao;

    @FXML
    void initialize() {
    	dao = new MySQLPersonDAO();

    	idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    	vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
    	nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
    	plzCol.setCellValueFactory(new PropertyValueFactory<>("plz"));
    	ortCol.setCellValueFactory(new PropertyValueFactory<>("ort"));
    	strasseCol.setCellValueFactory(new PropertyValueFactory<>("strasse"));
    	telefonCol.setCellValueFactory(new PropertyValueFactory<>("telefon"));
    	mobilCol.setCellValueFactory(new PropertyValueFactory<>("mobil"));
    	emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
    	
    	adressTableView.setItems(FXCollections.observableArrayList(dao.findAllPersons()));//ArrayList zu ObservableList
       
    	emailCol.setCellFactory(TextFieldTableCell.forTableColumn());

    }
    
    @FXML
    public void editCommit(CellEditEvent<Person, String> c){
    String newValue = c.getNewValue();
    Person p=c.getRowValue();
    TableColumn<Person, String> col=c.getTableColumn();
    String fieldName=col.getText();
    boolean updateOk =dao.updatePerson(p.getId(), fieldName, newValue);
    }
    
    @FXML
    void saveAction(ActionEvent event) {
    	boolean saved = dao.insert(new Person(	vornameFiled.getText(),
    								nachnameField.getText(),
    								ortField.getText(), 
    								plzField.getText(), 
    								strasseField.getText(), 
    								telfonField.getText(),
    								mobilField.getText(),
    								emailField.getText()));
    }
    
}
