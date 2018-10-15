import Model.Maze;
import View.MazeCreation;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    MazeCreation maze;

    public void start(Stage pStage){
        try {

            //BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/View/CreateMaze.fxml"));
            maze = new MazeCreation();
            maze.init();

            Scene scene = new Scene(maze, 800, 800);
            scene.getStylesheets().add("/View/maze.css");
            pStage.setTitle("Maze");
            pStage.setScene(scene);
            pStage.show();

        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
