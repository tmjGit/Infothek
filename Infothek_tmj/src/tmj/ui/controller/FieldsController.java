package tmj.ui.controller;

import generic.DbField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FieldsController {
	public static final double CONTROL_DISTANCE=12;
	public static final double CONTROL_HEIGHT=30;
	private FieldsController() {	}
	
	public static TextField[] createTextfields(AnchorPane inputPane,DbField[] dbFields) {
		if(inputPane==null || dbFields==null)
			return null;
		TextField[] fields=new TextField[dbFields.length];
		for (int i=0; i<fields.length; i++) {
			fields[i]=createTextfield(inputPane,dbFields[i]);
		}
		return fields;
	}

	public static TextField createTextfield(AnchorPane inputPane, DbField field) {
		TextField t=new TextField();
		t.setId(field.name);
		t.setPromptText(field.displayName);
		AnchorPane.setLeftAnchor(t, CONTROL_DISTANCE);
		t.setLayoutY( CONTROL_DISTANCE + (inputPane.getChildren().size()-1)*CONTROL_HEIGHT );
		AnchorPane.setRightAnchor(t, CONTROL_DISTANCE);
		if(inputPane.getChildren().add(t))
			return t;
		return null;
	}	

}