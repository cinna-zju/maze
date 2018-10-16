import Controller.Controller;
import Model.Maze;
import View.MazeCreation;
import View.PlayPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import Controller.MyButton;

public class Game extends Application {

    MyButton btnCtroller;

    public void start(Stage pStage){
        try {

//            BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/View/CreateMaze.fxml"));
//            maze = new MazeCreation();
//            maze.init();

            Controller st = new Controller(pStage);
            Scene firstScene = new Scene(st, 800, 800);

            //scene.getStylesheets().add("/View/maze.css");
            pStage.setTitle("Maze");
            pStage.setScene(firstScene);
            pStage.show();


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
