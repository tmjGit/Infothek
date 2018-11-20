package li.tmj.ui.fx.model;

import java.util.ArrayList;
import javafx.scene.control.Control;
import li.tmj.app.Application;

import org.pmw.tinylog.Logger;


public class Places {
	private ArrayList<Place> places=new ArrayList<>();
		
	/**
	 * 
	 * @param p	new element
	 * @return	Index of the added element
	 */
	public int add(Place p) {
		places.add(p);
		return places.size();
	}
	
	public Place get(int index) {
		return places.get(index);
	}
	
	public void set(int index,Place p) {
		places.set(index, p);
	}
	
//	public double getLeft(int index) {
//		return places.get(index).getLeft();
//	}
	public void setLeft(int index,double left) {
		places.get(index).setLeft( left );
	}
//	public double getTop(int index) {
//		return places.get(index).getTop();
//	}
	public void setTop(int index, double top) {
		places.get(index).setTop(top);
	}
//	public double getWidth(int index) {
//		return places.get(index).getWidth();
//	}
	public void setWidth(int index, double width) {
		places.get(index).setWidth(width);
	}
//	public double getHeight(int index) {
//		return places.get(index).getHeight();
//	}
	public void setHeight(int index, double height) {
		places.get(index).setHeight(height);
	}
	
	public double left(int index) {
		Logger.debug("Places.left: index={}",index);
		switch(places.get(index).getLeftRelation()) {
		case DEFAULT: return 0;// default is the predefined size of the control, we return 0, because 0 cannot be assigned.
		case ABSOLUTE: return places.get(index).getLeft();
		case RIGHT_OF: {
			int i=(int) places.get(index).getLeft() ;
			double d= left(i)+width(i)+places.get(index).getLeftRelationDistance();//TODO exception falls null. Hier wird rekursiv dasselbe immer wieder berechnet! Besser lösen!
			Logger.debug("Places.left({}): RIGHT_OF i={}, d={}",i,d);
			return d;
		}
		case BENEATH: {
			int i=(int) places.get(index).getLeft() ;
			double d= left(i);//TODO exception falls null
			Logger.debug("Places.left({}): BENEATH i={}, d={}",index,i,d);
			return d;
		}
		default: throw new IllegalArgumentException(); // This could only happen in case of programming error.
		}
	}
	
	public double top(int index) {
		switch(places.get(index).getTopRelation()) {
		case DEFAULT: return 0;// default is the predefined size of the control, we return 0, because 0 cannot be assigned.
		case ABSOLUTE: return places.get(index).getTop();
		case RIGHT_OF: {
			int i=(int) places.get(index).getTop() ;
			double d= top(i);//TODO exception falls null
			Logger.debug("Places.top({}): RIGHT_OF i={}, d={}",index,i,d);
			return d;
		}
		case BENEATH: {
			int i=(int) places.get(index).getTop() ;
			double d= top(i)+height(i)+places.get(index).getTopRelationDistance();//TODO exception falls null. Hier wird rekursiv dasselbe immer wieder berechnet! Besser lösen!
			Logger.debug("Places.top({}): BENEATH i={}, d={}",index,i,d);
			return d;
		}
		default: throw new IllegalArgumentException(); // This could only happen in case of programming error.
		}
	}
	
	public double width(int index) {
		switch(places.get(index).getWidthRelation()) {
		case DEFAULT: return 0;// default is the predefined size of the control, we return 0, because 0 cannot be assigned.
		case ABSOLUTE: return places.get(index).getWidth();
		case RIGHT_OF: //falls through
		case BENEATH: {
			int i=(int) places.get(index).getWidth() ;
			double d= width(i);//TODO exception falls null. Hier wird rekursiv dasselbe immer wieder berechnet! Besser lösen!
			Logger.debug("Places.width({}): BENEATH i={}, d={}",index,i,d);
			return d;
		}
		default: throw new IllegalArgumentException(); // This could only happen in case of programming error.
		}
	}
	
	public double height(int index) {
		switch(places.get(index).getHeightRelation()) {
		case DEFAULT: return 0;// default is the predefined size of the control, we return 0, because 0 cannot be assigned.
		case ABSOLUTE: return places.get(index).getHeight();
		case RIGHT_OF: // falls through
		case BENEATH: {
			int i=(int) places.get(index).getHeight() ;
			double d= height(i);//TODO exception falls null
			Logger.debug("Places.height({}): BENEATH i={}, d={}",index,i,d);
			return d;
		}
		default: throw new IllegalArgumentException(); // This could only happen in case of programming error.
		}
	}
	
	public void arrangeControl(Control control, int placeIndex) {
		Logger.trace("Places.arrangeControl: placeIndex={}",placeIndex);
		if(!places.get(placeIndex).getLeftRelation().equals(PlaceRelation.DEFAULT)) {
			Logger.debug("Places.arrangeControl: placeIndex={}, left not default...",placeIndex);
			double d=left(placeIndex);
			if(0!=d) {
				control.setLayoutX(d);
			}
		}
		if(!places.get(placeIndex).getTopRelation().equals(PlaceRelation.DEFAULT)) {
			Logger.debug("Places.arrangeControl: placeIndex={}, top not default...",placeIndex);
			double d=top(placeIndex);
			if(0!=d) {
				control.setLayoutY(d);
			}
		}
		if(!places.get(placeIndex).getWidthRelation().equals(PlaceRelation.DEFAULT)) {
			Logger.debug("Places.arrangeControl: placeIndex={}, width not default...",placeIndex);
			double d=width(placeIndex);
			if(0!=d) {
				control.setMinWidth(d);
				control.setMaxWidth(d);
			}
		}
		if(!places.get(placeIndex).getHeightRelation().equals(PlaceRelation.DEFAULT)) {
			Logger.debug("Places.arrangeControl: placeIndex={}, height not default...",placeIndex);
			double d=height(placeIndex);
			if(0!=d) {
				control.setMinHeight(d);
				control.setMaxHeight(d);
			}
		}
	}
	
}