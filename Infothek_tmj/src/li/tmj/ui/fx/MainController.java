package li.tmj.ui.fx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import li.tmj.app.Application;
import li.tmj.ui.fx.controls.ObjectCombobox;
import li.tmj.ui.lang.Localization;

public class MainController implements Initializable {
//	@FXML ObjectCombobox<LanguageBAK> langCb;
	@FXML Button personenBt;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setFxText();
	}
	
	private void setFxText() {
		personenBt.setText(Localization.get("Persons"));
	}
	
	
	@FXML
	private void personenBtAction(javafx.event.ActionEvent event) throws IOException {
		FxScene.PERSON.showOnNewStage();
		FxManager.closeMyStage(personenBt);
	}
}


