package Controller;


import Model.Maze;
import View.Character;
import View.Layout;
import View.MazeCreation;
import View.PlayPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Controller extends BorderPane {
	
	public Character ch;
	public Layout layout;
	Stage stage;
    MazeCreation maze;





    public Controller(Stage stage) {

        this.stage = stage;

        this.setPadding(new Insets(10, 10, 10, 10));
        this.setStyle("-fx-background-color: #8fbc8f");
        layout = new Layout();

        //Layout
        // HBox fot the title
        this.setTop(layout.hbox());
        this.setCenter(layout.vbox());

        layout.start.setOnMouseClicked(event -> {
            ch = new Character();
            ch.setAlignment(Pos.BASELINE_CENTER);
            Label title = new Label();
            title.setText("Choose your charater!");
            this.setBottom(layout.map);
            this.setCenter(ch);
        });

        layout.exit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        layout.map.setOnMouseClicked(event -> {
            maze = new MazeCreation(stage);

            maze.init();

            maze.next.setOnMouseClicked(e -> {
                PlayPane play = new PlayPane();
                play.init();
                maze.mazeData.src = maze.generateMap(maze.grid);
                play.setMap(maze.mazeData.src);
                play.drawCharacter();
                Scene scene = new Scene(play, 800, 800);
                stage.setScene(scene);
            });

            Scene scene = new Scene(maze, 800, 800);
            stage.setScene(scene);


        });

        this.setCenter(layout.vbox());
    }
	
}
