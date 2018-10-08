import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage pStage){
        try {
            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/View/CreateMaze.fxml"));

            Scene scene = new Scene(root, 500, 500);
            pStage.setTitle("Maze");
            pStage.setScene(scene);
            pStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
