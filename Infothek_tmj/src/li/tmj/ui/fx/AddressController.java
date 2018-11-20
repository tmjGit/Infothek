package li.tmj.ui.fx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import li.tmj.ui.fx.controls.ObjectCombobox;

public class AddressController implements Initializable {
//	@FXML ObjectCombobox<LanguageBAK> langCb;
	@FXML Button newStageBt;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		setFxText();
	}



	@FXML
	private void newStage(javafx.event.ActionEvent event) throws IOException {
		FxScene.MAIN.showOnNewStage();
//		FxManager.closeMyStage(parent);
	}
}


