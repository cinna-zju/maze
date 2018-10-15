import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main (String[] args) {
		launch(args);		
	}
	
	@Override
	public void start (Stage prStage) throws Exception {
		Controller st = new Controller();
		Scene scene = new Scene(st,400,200);
		prStage.setScene(scene);
		prStage.show();
		
	}	
}
