package view;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class FieldsController {
	public static final double CONTROL_DISTANCE=12;
	public static final double CONTROL_HEIGHT=30;
	private FieldsController() {	}
	
	public static TextField[] createTextfields(AnchorPane inputPane,String[] header) {
		TextField[] fields=new TextField[header.length];
		for (int i=0; i<header.length; i++) {
			fields[i]=createTextfield(inputPane,header[i]);
		}
		return fields;
	}

	public static TextField createTextfield(AnchorPane inputPane,String prompt) {
		String s=prompt.toLowerCase()+"Fld";
		TextField t=new TextField();
		t.setId(s);
		t.setPromptText(prompt);
		AnchorPane.setLeftAnchor(t, CONTROL_DISTANCE);
		t.setLayoutY( CONTROL_DISTANCE + (inputPane.getChildren().size()-1)*CONTROL_HEIGHT );
		AnchorPane.setRightAnchor(t, CONTROL_DISTANCE);
		if(inputPane.getChildren().add(t))
			return t;
		return null;
	}	
	
	public static boolean setNodeIds(Node[] nodes,String ids[]) {//should have same length!
		for(int i=0; i<ids.length; i++) {
			if (i>=nodes.length)
				return false;
			if(nodes[i]!=null && ids[i]!=null)
				nodes[i].setId(ids[i]);
		}
		
		return true;
	}
}