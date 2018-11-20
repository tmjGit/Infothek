package application;

import javafx.application.Application;
import javafx.stage.Stage;
import li.tmj.ui.fx.FxScene;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			li.tmj.app.Application.init();

			FxScene.MAIN.showOnStage(primaryStage);	
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}





//@Override
//public void start(Stage stage) throws Exception {
//    URL location = getClass().getResource("Main.fxml");
//    FXMLLoader fxmlLoader = new FXMLLoader();
//    fxmlLoader.setLocation(location);
//    fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
//    Parent root = (Parent) fxmlLoader.load(location.openStream());
//    Scene scene = new Scene(root);
//    stage.setScene(scene);
//    MainController mainController = fxmlLoader.getController();
//    mainController.setStage(stage);
//    mainController.showStage();
//}