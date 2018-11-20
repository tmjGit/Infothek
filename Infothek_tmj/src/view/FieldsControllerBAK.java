package view;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import tmj.db.dao.FieldDAO;

public class FieldsControllerBAK {
	public static final double CONTROL_DISTANCE=12;
	public static final double CONTROL_HEIGHT=30;
	private FieldsControllerBAK() {	}
	
	public static TextField[] createTextfields(AnchorPane inputPane,FieldDAO[] dbFields) {
		if(inputPane==null || dbFields==null)
			return null;
		TextField[] fields=new TextField[dbFields.length];
		for (int i=0; i<fields.length; i++) {
			fields[i]=createTextfield(inputPane,dbFields[i]);
		}
		return fields;
	}

//	public static TextField[] createTextfields(AnchorPane inputPane,String[][] header) {
//		TextField[] fields=null;
//		if(inputPane==null || header==null)
//			return fields;
//		fields=new TextField[header[0].length];
//		for (int i=0; i<fields.length; i++) {
//			fields[i]=createTextfield(inputPane,header[0][i],header[1][i]);
//		}
//		return fields;
//	}

//	public static TextField[] createTextfields(AnchorPane inputPane,String[] header) {
//		TextField[] fields=new TextField[header.length];
//		for (int i=0; i<header.length; i++) {
//			fields[i]=createTextfield(inputPane,header[i]);
//		}
//		return fields;
//	}

	public static TextField createTextfield(AnchorPane inputPane, FieldDAO field) {
		TextField t=new TextField();
		t.setId(field.variableName);
		t.setPromptText(field.displayName);
		AnchorPane.setLeftAnchor(t, CONTROL_DISTANCE);
		t.setLayoutY( CONTROL_DISTANCE + (inputPane.getChildren().size()-1)*CONTROL_HEIGHT );
		AnchorPane.setRightAnchor(t, CONTROL_DISTANCE);
		if(inputPane.getChildren().add(t))
			return t;
		return null;
	}	

//	public static TextField createTextfield(AnchorPane inputPane, String prompt, String fieldname) {
//		TextField t=new TextField();
//		t.setId(fieldname);
//		t.setPromptText(prompt);
//		AnchorPane.setLeftAnchor(t, CONTROL_DISTANCE);
//		t.setLayoutY( CONTROL_DISTANCE + (inputPane.getChildren().size()-1)*CONTROL_HEIGHT );
//		AnchorPane.setRightAnchor(t, CONTROL_DISTANCE);
//		if(inputPane.getChildren().add(t))
//			return t;
//		return null;
//	}	

//	public static TextField createTextfield(AnchorPane inputPane,String prompt) {//TODO obsolet
//		return createTextfield(inputPane, prompt, prompt.toLowerCase()+"Fld");
//	}	
	
//	public static boolean setNodeIds(Node[] nodes,String ids[]) {//should have same length! // TODO obsolet
//		for(int i=0; i<ids.length; i++) {
//			if (i>=nodes.length)
//				return false;
//			if(nodes[i]!=null && ids[i]!=null)
//				nodes[i].setId(ids[i]);
//		}
//		
//		return true;
//	}
}