package tmj.ui.controls;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ObjectListView<T extends FxControlable> extends ListView<T> {	
	public ObjectListView() {
		super();
		init();
	}
	
	public ObjectListView(ObservableList<T> items) {
		super(items);
		init();
	}
	
	public void init() {
		this.setCellFactory(param->new MyCell());
//		this.setButtonCell(new ComboBoxCell());
	}
	private class MyCell extends ListCell<T> {
		@Override
		public void updateItem(T p, boolean empty) {
			super.updateItem(p, empty);
			if (p != null)
				setText(p.getDisplayName());
//			HBox hbox = new HBox();
//			Label label = new Label(p.getName());
//			System.out.println(p);
//			ImageView iv = new ImageView(new Image("file:./"+p.getImagePath()));
//			iv.setFitWidth(50);
//			iv.setPreserveRatio(true);
//			hbox.getChildren().addAll(label, iv);
//			setGraphic(hbox);
		}
	}	

}
