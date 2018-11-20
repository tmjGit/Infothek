package li.tmj.ui.fx.model;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import li.tmj.ui.lang.Localization;

public class Arrange {
	public static void arrangeControls(Controls controls, Places places,ObservableList<Node> list) {
		int count=controls.size();
		for(int i=0; i<count; i++) {
			Control c=controls.get(i);
			list.add(c); // adding control to fx Object
			places.arrangeControl(c,i);
//			if(null!=c.getId()) {// loading visible text
//				controls.setText(i,Localization.get(c.getId()));
//			}
			c.setDisable(false);
			c.setVisible(true);
		}
	}
	
	

}
