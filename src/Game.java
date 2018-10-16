import Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {


    public void start(Stage pStage){
        try {

//            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/View/CreateMaze.fxml"));
//            maze = new MazeCreation();
//            maze.init();

            Controller st = new Controller(pStage);
            Scene firstScene = new Scene(st, 800, 800);

            pStage.setTitle("Maze");
            pStage.setScene(firstScene);
            pStage.show();


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
