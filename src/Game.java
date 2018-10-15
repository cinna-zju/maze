import Controller.Controller;
import Model.Maze;
import View.MazeCreation;
import View.PlayPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Game extends Application {
    public static Stage shareStage;
    MazeCreation maze;

    public void start(Stage pStage){
        try {
            shareStage = pStage;

            //BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("/View/CreateMaze.fxml"));
//            maze = new MazeCreation();
//            maze.init();

            Controller st = new Controller();
            Scene firstScene = new Scene(st, 800, 800);

            //scene.getStylesheets().add("/View/maze.css");
            pStage.setTitle("Maze");
            pStage.setScene(firstScene);
            pStage.show();

            st.layout.map.setOnMouseClicked(event -> {
                maze = new MazeCreation();
                maze.init();

                maze.next.setOnMouseClicked(e -> {

                    PlayPane play = new PlayPane();
                    play.init();
                    play.setMap(maze.generateMap(maze.grid));
                    play.drawCharacter();
                    Scene scene = new Scene(play, 800, 800);
                    pStage.setScene(scene);
                });

                Scene scene = new Scene(maze, 800, 800);
                pStage.setScene(scene);
            });



        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
