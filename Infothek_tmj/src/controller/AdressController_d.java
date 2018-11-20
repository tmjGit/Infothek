//package controller;
//
//
//
//import dao.MySQLPersonDAO_d;
//import dao.PersonDAO;
//import javafx.collections.FXCollections;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import model.Person_d;
//import javafx.scene.control.ContextMenu;
//import javafx.scene.control.Label;
//import javafx.scene.control.MenuItem;
//
//public class AdressController_d {
//
//
//	
//	@FXML
//	private TableView<Person_d> adressTableView;
//	
//   
//
//    @FXML
//    private TableColumn<Person_d, Integer> idCol;
//
//    @FXML
//    private TableColumn<Person_d,String> vornameCol;
//
//    @FXML
//    private TableColumn<Person_d,String> nachnameCol;
//
//    @FXML
//    private TableColumn<Person_d,String> plzCol;
//
//    @FXML
//    private TableColumn<Person_d,String> ortCol;
//
//    @FXML
//    private TableColumn<Person_d,String> strasseCol;
//
//    @FXML
//    private TableColumn<Person_d,String> telefonCol;
//
//    @FXML
//    private TableColumn<Person_d,String> mobilCol;
//
//    @FXML
//    private TableColumn<Person_d,String> emailCol;
//    
//    @FXML
//    private TextField vornameFiled;
//
//    @FXML
//    private TextField nachnameField;
//
//    @FXML
//    private TextField plzField;
//
//    @FXML
//    private TextField ortField;
//
//    @FXML
//    private TextField strasseField;
//
//    @FXML
//    private TextField telfonField;
//
//    @FXML
//    private TextField mobilField;
//
//    @FXML
//    private TextField emailField;
//
//    //-----------------Member
//    
//    private PersonDAO dao;
//
//
//
//	@FXML Label infoLabel;
//
//    @FXML
//    void saveAction(ActionEvent event) {
//    	boolean saved = dao.savePerson(new Person_d(	vornameFiled.getText(),
//    								nachnameField.getText(),
//    								ortField.getText(), 
//    								plzField.getText(), 
//    								strasseField.getText(), 
//    								telfonField.getText(),
//    								mobilField.getText(),
//    								emailField.getText()));
//    	
//    	System.out.println("saved? "+saved);
//    }
//	@FXML public void refreshAction(ActionEvent event) {}
//    
//	@FXML
//	void initialize() {
//		dao = new MySQLPersonDAO_d();
//		// oder im FXML
//		idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
//		vornameCol.setCellValueFactory(new PropertyValueFactory<>("vorname"));
//		nachnameCol.setCellValueFactory(new PropertyValueFactory<>("nachname"));
//		plzCol.setCellValueFactory(new PropertyValueFactory<>("plz"));
//		ortCol.setCellValueFactory(new PropertyValueFactory<>("ort"));
//		strasseCol.setCellValueFactory(new PropertyValueFactory<>("strasse"));
//		telefonCol.setCellValueFactory(new PropertyValueFactory<>("telefon"));
//		mobilCol.setCellValueFactory(new PropertyValueFactory<>("mobil"));
//		emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
//		
//		adressTableView.setItems(FXCollections.observableArrayList(dao.findAllPersons()));//ArrayList zu ObservableList
//		
//		
//		//ContextMenu
//		
//		ContextMenu cm = new ContextMenu();
//		MenuItem deleteItem = new MenuItem("Delete");
//		
//		deleteItem.setOnAction(e->{
//			
//			Person_d p = adressTableView.getSelectionModel().getSelectedItem();
//			System.out.println(p);
//		});
//		cm.getItems().add(deleteItem);
//		
//		adressTableView.setContextMenu(cm);
//		
//	}
//}
