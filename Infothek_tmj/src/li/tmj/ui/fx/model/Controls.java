package li.tmj.ui.fx.model;

import java.util.ArrayList;

import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import li.tmj.ui.fx.controls.ObjectCombobox;
import li.tmj.ui.lang.Localization;

public class Controls {
	ArrayList<Control> controls=new ArrayList<>();
	
	public void add(Control c) {
		controls.add(c);
		
	}
	
	public void add(Control c, String caption) {
//		c.setId(caption);
		setText(c, caption);
		add(c);
	}
	
	public Control get(int index) {
		return controls.get(index);
	}
	
	public void setLocaleText(int index, String text) {
		String s=Localization.get(text);
		setText(index,s);
	}
	
	public void setText(int index, String text) {
		if(controls.get(index) instanceof Label) {
			((Label) controls.get(index)).setText(text);
		}else if(controls.get(index) instanceof TextField) {
			((TextField) controls.get(index)).setText(text);
//		}else if(controls.get(index) instanceof ObjectCombobox) {
//			((ObjectCombobox) controls.get(index)).setText(text);
		}
	}
	
	public String getText(int index) {
		String s=null;
		if(controls.get(index) instanceof Label) {
			s=((Label) controls.get(index)).getText();
		}else if(controls.get(index) instanceof TextField) {
			s=((TextField) controls.get(index)).getText();
//		}else if(controls.get(index) instanceof ObjectCombobox) {
//			s=((ObjectCombobox) controls.get(index)).getText();
		}
		return s;
	}
	
	private void setText(Control control, String text) {
		if(control instanceof Label) {
			((Label) control).setText(text);
		}else if(control instanceof TextField) {
			((TextField) control).setText(text);
//		}else if(control instanceof ObjectCombobox) {
//			((ObjectCombobox) control).setText(text);
		}
	}
	
	public void clearFields() {
		for(Control c:controls) {
			if(c instanceof TextField) {
				((TextField) c).setText("");
			}else if (c instanceof ObjectCombobox) {
//				((ObjectCombobox)c).setText("");
			}
		}
	}
	
	public int size() {
		return controls.size();
	}
}
