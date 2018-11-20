package li.tmj.ui.fx;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.hibernate.Session;
import org.pmw.tinylog.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import li.tmj.app.Application;
import li.tmj.db.hibernate.DataHiberDAO;
import li.tmj.db.hibernate.HibernateUtil;
import li.tmj.db.model.Address;
import li.tmj.db.model.Data;
import li.tmj.db.model.Email;
import li.tmj.db.model.Person;
import li.tmj.db.model.Fone;
import li.tmj.ui.fx.controls.ObjectCombobox;
import li.tmj.ui.fx.model.Arrange;
import li.tmj.ui.fx.model.Controls;
import li.tmj.ui.fx.model.Place;
import li.tmj.ui.fx.model.PlaceRelation;
import li.tmj.ui.fx.model.Places;
import li.tmj.ui.lang.Localization;

public class PersonController implements Initializable {
	@FXML AnchorPane anchorPane;
	@FXML Button searchBt;
	@FXML Button menuBt;
	@FXML Button newWindowBt;
	@FXML Button submitBt;
	@FXML Label infoT;
	@FXML Label idT;
	@FXML TextField idFld;
	
	Controls controls;
	Places places;
	Person currentPerson;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setFxText();
		makeControls(anchorPane.getChildren());
		objectOut(currentPerson);
	}
	
	private void setFxText() {
		searchBt.setText(Localization.get("Find"));
		menuBt.setText(Localization.get("Menu"));
		newWindowBt.setText(Localization.get("NewWindow"));
		submitBt.setText((Localization.get("Save")));
	}
	
	private void makeControls(ObservableList<Node> list) {
		controls=makeControlsList();
		places=makePlaces();
		Arrange.arrangeControls(controls,places,list);
	}
	
	private Places makePlaces() {
		Places places=new Places();
		Place p;
		int i,j,k;
		
		p=new Place(Application.FX_CONTROLS_DISTANCE,Application.FX_CONTROLS_DISTANCE,40,Application.FX_LINE_HEIGHT);//nameLabelT
		p.setHeightRelation(PlaceRelation.ABSOLUTE);
		k=places.add(p)-1;// ArrayList.add does not return the index as documented! It returns the index+1 or the new size or something like that!
		
		p=Place.createPlaceRightOf(k);//indivLabelT
		p.setWidth(70);
		i=places.add(p)-1;
		
		p=Place.createPlaceRightOf(i);//nameIndivFld
		p.setWidth(200);
		j=places.add(p)-1;
		
		p=Place.createPlaceRightOf(j,Application.FX_CONTROLS_DISTANCE);//sexLabelT
		p.setWidth(60);
		j=places.add(p)-1;

		p=Place.createPlaceRightOf(j);//   sexCb
		p.setWidth(80);
		j=places.add(p)-1;

		p=Place.createPlaceRightOf(j,Application.FX_CONTROLS_DISTANCE);//categoryLabelT;
		p.setWidth(55);
		j=places.add(p)-1;
		
		p=Place.createPlaceRightOf(j);//categoryCb;
		p.setWidth(90);
		places.add(p);
		
		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//familyLabelT
		p.setHeight(Application.FX_LINE_HEIGHT);
		p.setHeightRelation(PlaceRelation.ABSOLUTE);
		i=places.add(p)-1;

        p=Place.createPlaceRightOf(i);//nameFamPreCb
		p.setWidth(30);
		i=places.add(p)-1;

		p=Place.createPlaceRightOf(i);//nameFamFld
		p.setWidth(places.get(2).getWidth()-places.get(8).getWidth()); //nameIndivFld - nameFamPreCb
		i=places.add(p)-1;
		
		p=Place.createPlaceRightOf(i,Application.FX_CONTROLS_DISTANCE);//birthLabelT;
		p.setWidth(places.get(3).getWidth());//sexLabelT
		i=places.add(p)-1;
		
		p=Place.createPlaceRightOf(i);//birthDayFld;
		p.setWidth(35);
		i=places.add(p)-1;
		
		p=Place.createPlaceRightOf(i);//dot
		p.setWidth(10);
		i=places.add(p)-1;
		
		p=Place.createPlaceRightOf(i);//birthMonthFld;
		p.setWidth(35);
		i=places.add(p)-1;
		
		p=Place.createPlaceRightOf(i);//dot
		p.setWidth(10);
		i=places.add(p)-1;
		
		p=Place.createPlaceRightOf(i);//birthYearFld;
		p.setWidth(45);
		places.add(p);
		
		p=new Place(k,i,600,100);//addressView;
		p.setLeftRelation(PlaceRelation.BENEATH);
		p.setTopRelation(PlaceRelation.BENEATH,Application.FX_CONTROLS_DISTANCE);
		p.setHeightRelation(PlaceRelation.ABSOLUTE);
		i=places.add(p)-1;
		
		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//phoneView;
		p.setHeight(100);
		p.setHeightRelation(PlaceRelation.ABSOLUTE);
		i=places.add(p)-1;
		
		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//personView;
		p.setHeight(100);
		p.setHeightRelation(PlaceRelation.ABSOLUTE);
		i=places.add(p)-1;
		
		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//emailView;
		p.setHeight(80);
		p.setHeightRelation(PlaceRelation.ABSOLUTE);
		i=places.add(p)-1;
		
		
		
		
		
//		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//mediaView;
//		p.setHeight(80);
//		p.setHeightRelation(PlaceRelation.ABSOLUTE);
//		i=places.add(p)-1;


//		controls.add(new  Label());//infoLabel;
//		controls.add(new  TextField());//plzField;
//		controls.add(new  TextField());//ortField;
//		controls.add(new  TextField());//strasseField;
//		controls.add(new  TextField());//telfonField;
//		controls.add(new  TextField());//mobilField;
//		controls.add(new  TextField());//emailField;
		

		
//      <TextField fx:id="telfonField" layoutX="602.0" layoutY="440.0" promptText="Telefon" />
//      <TextField fx:id="mobilField" layoutX="441.0" layoutY="440.0" promptText="Mobil" />
//      <TextField fx:id="emailField" layoutX="267.0" layoutY="440.0" promptText="email" />
//        <TextField fx:id="plzField" layoutX="353.0" layoutY="492.0" promptText="PLZ" />
//        <TextField fx:id="ortField" layoutX="518.0" layoutY="480.0" promptText="Ort" />
//        <TextField fx:id="strasseField" layoutX="180.0" layoutY="505.0" promptText="Straße" />
//        <Button fx:id="saveBt" layoutX="28.0" layoutY="505.0" mnemonicParsing="false" text="Save" />

		return places;
	}
	
	private Controls makeControlsList(){
		Controls controls=new Controls();
		
		controls.add(new  Label()// nameLabelT
				,"Name");//language key
		
		controls.add(new Label(), "Individual");//indivLabelT;
		
		controls.add(new  TextField());//nameIndivFld;
		
		controls.add(new Label(Localization.get("Sex")) );//sexLabelT;

		controls.add(new  ObjectCombobox());//sexCb;

		controls.add(new Label(Localization.get( "Category")));//categoryLabelT;
		
		controls.add(new  ObjectCombobox());//categoryCb;
		
		controls.add(new Label(Localization.get( "Family")));//familyLabelT;

		controls.add(new  ObjectCombobox());//nameFamPreCb;	

		controls.add(new  TextField());//nameFamFld;
		
		controls.add(new Label(Localization.get("Birthday" )));//birthLabelT;
		
		controls.add(new  TextField());//birthDayFld;
		
		controls.add(new Label(Localization.get(".")));//dot
		
		controls.add(new  TextField());//birthMonthFld;
		
		controls.add(new Label(Localization.get(".")));//dot

		controls.add(new  TextField());//birthYearFld;
		
		controls.add(new  TableView<Address>());//addressView;
		
		controls.add(new  TableView<Fone>());//phoneView;
		
		controls.add(new  TableView<Person>());//personView;
		
		controls.add(new  TableView<Email>());//emailView;
	
		
		
		
		
		
//		controls.add(new  TableView<Media>());//mediaView;

//		controls.add(new  Label());//infoLabel;
//		controls.add(new  TextField());//plzField;
//		controls.add(new  TextField());//ortField;
//		controls.add(new  TextField());//strasseField;
//		controls.add(new  TextField());//telfonField;
//		controls.add(new  TextField());//mobilField;
//		controls.add(new  TextField());//emailField;
		return controls; 
	}
	

	@FXML
	private void menuBtAction(ActionEvent event)  {
		try {
			FxScene.MAIN.showOnNewStage();
		} catch (IOException e) {
			Logger.error(e,"Could not open new window!");
		}
//		FxManager.closeMyStage(parent);
	}
	
	@FXML private void newWindowBtAction(ActionEvent event)  {
		try {
			FxScene.PERSON.showOnNewStage();
		} catch (IOException e) {
			Logger.error(e,"Could not open new window!");
		}
	}
	
	@FXML private void searchBtAction(ActionEvent event) {
		Button b=(Button) event.getSource();//searchBt
		if(b.getText().equals(Localization.get("Find"))) { // invoking search mode
			idT.setText(Localization.get("Find"));	
			searchBt.setText(Localization.get("Cancel"));
			submitBt.setText(Localization.get("Search"));
			idFld.setText("");
			controls.clearFields();
			info("Search mode started.");;
			
		}else { // canceling search
			idT.setText(Localization.get("ID"));	
			searchBt.setText(Localization.get("Find"));
			submitBt.setText(Localization.get("Save"));
			if(null!=currentPerson) {
				objectOut(currentPerson);
			}
			info("Search canceled.");
		}
	}
	
	@FXML private void submitBtAction(ActionEvent event) {
		Button b=(Button) event.getSource();//submitBt
		b.setDisable(true);// Disable this function until we finished.
		searchBt.setDisable(true);
		if(b.getText().equals(Localization.get("Search"))) { // do a search
			doSearch();
		}else if(b.getText().equals(Localization.get("Save"))) { // save information
			doSave();
		}
		submitFinished();
	}
	
	private void doSearch() {
//		Thread t=new Thread(()->{
		System.out.println("if -> bla");
		submitBt.setText("bla");
		submitBt.setText(Localization.get("Searching"+"..."));
//		});
//		t.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Platform.runLater(() -> {
		
//		Runnable r=new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//			}
//		};
//		Task t=new Task<V>() {
//		info("Searching...");
//		DataHiberDAO dao=new DataHiberDAO(); // We want the visible feedback, first. 
//		Person person = objectIn();          // So this cannot be outside the if.
//		System.out.println("Reading by example person="+person);
//		List<Data> persons=dao.read(person);
//		System.out.println("Found " + persons.size() + " persons="+persons);
//		currentPerson=(Person) persons.get(0);//erster Datensatz des Suchergebnisses
//		objectOut(currentPerson);		
//		});
//		t.start();
		

		Runnable r=new Runnable() {
			
			@Override
			public void run() {
				info("Searching...");
				DataHiberDAO dao=new DataHiberDAO(); // We want the visible feedback, first. 
				Person person = objectIn();          // So this cannot be outside the if.
				System.out.println("Reading by example person="+person);
				List<Data> persons=dao.read(person);
				System.out.println("Found " + persons.size() + " persons="+persons);
				currentPerson=(Person) persons.get(0);//erster Datensatz des Suchergebnisses
				objectOut(currentPerson);	
			}
		};
		r.run(); // debug eigentlich im Thread ausführen!

		searchBt.setText(Localization.get("Find"));
		info("Searched.");
	}
	
	private void doSave() {
		submitBt.setText(Localization.get("Saving"+"..."));
		info("Saving...");
		DataHiberDAO dao=new DataHiberDAO(); // We want the visible feedback, first.
		Person person = objectIn();          // So this cannot be outside the if.
		System.out.println("Saving person="+person);
		dao.save(person);
		info("Saved.");
	}
	
	private void submitFinished() {
		submitBt.setText(Localization.get("Save"));
		submitBt.setDisable(false);// We finished.
		searchBt.setDisable(false); 		
	}
	
	private void objectOut(Person person) {
		idT.setText("ID");
		if(null==person) {
			idFld.setText("");
			controls.setText(2, "");//nameIndivFld;
			controls.setText(8, "");//nameFamPreCb
			controls.setText(9, "");//nameFamFld;
			controls.setText(4, "");//sexCb;
			controls.setText(6, "");//categoryCb;
			controls.setText(11, "");//birthDayFld;
			controls.setText(13, "");//birthMonthFld;
			controls.setText(15, "");//birthYearFld;			
		}else {
			idFld.setText(Integer.toString(person.getId()));
			controls.setText(2, person.getNameIndividual());//nameIndivFld;
			controls.setText(8, person.getNameFamilyPre());//nameFamPreCb
			controls.setText(9, person.getNameFamily());//nameFamFld;
			controls.setText(4, person.getSex());//nameFamPreCb
			controls.setText(6, person.getCategory());//nameFamPreCb
			controls.setText(11, Integer.toString(person.getBirthDay()));//birthDayFld;
			controls.setText(13, Integer.toString(person.getBirthMonth()));//birthMonthFld;
			controls.setText(15, Integer.toString(person.getBirthYear()));//birthYearFld;
		}
//		p=new Place(k,i,600,100);//addressView;
//		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//phoneView;
//		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//personView;
//		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//emailView;
	}

	private Person objectIn() {
		Person person=new Person();
		String s;
		s=idFld.getText();
		if(!"".equals(s)) {
			person.setId(Integer.parseInt(s));
		}
		s=controls.getText(2);//nameIndivFld
		if(!"".equals(s)) {
			person.setNameIndividual(s);
		}
		s=controls.getText(8);//nameFamPreFld
		if(!"".equals(s)) {
			person.setNameFamilyPre(s);
		}
		s=controls.getText(9);//nameFamFld
		if(!"".equals(s)) {
			person.setNameFamily(s);
		}
		s=controls.getText(4);//sexCb
		if(!"".equals(s)) {
			person.setSex(s);
		}
		s=controls.getText(6);//categoryCb
		if(!"".equals(s)) {
			person.setCategory(s);
		}
		s=controls.getText(11);//birthDayFld
		if(!"".equals(s)) {
			person.setBirthDay(Integer.parseInt(s));
		}
		s=controls.getText(11);//birthMonthFld
		if(!"".equals(s)) {
			person.setBirthMonth(Integer.parseInt(s));
		}
		s=controls.getText(11);//birthYearFld
		if(!"".equals(s)) {
			person.setBirthYear(Integer.parseInt(s));
		}
//		p=new Place(k,i,600,100);//addressView;
//		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//phoneView;
//		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//personView;
//		p=Place.createPlaceBeneath(i,Application.FX_CONTROLS_DISTANCE);//emailView;
		return person;
	}
	
	private void info(String msg) {
		infoT.setText(LocalDateTime.now().toString()+" "+msg);
	}
}


