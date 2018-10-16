package View;

import Controller.PlayController;
import Model.Maze;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class PlayPane extends BorderPane {
    public GridPane gp;
    public PlayController play;
    public int size;
    public Maze mazeData = new Maze();


    public void init(){

        gp = new GridPane();
        play = new PlayController(mazeData);


        this.setCenter(gp);

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {

                play.handle(e);
                drawCharacter();
            }
        });
    }


    public void drawCharacter(){
        mazeData.grid[mazeData.ch.posY][mazeData.ch.posX].setGraphic(new ImageView(new Image("/img/warrior.png")));
    }



    public void setMap(String[][] maps){
        size = mazeData.size;
        mazeData.grid = new Button[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                mazeData.grid[i][j] = new Button();
                switch(maps[i][j]){
                    case "monster": {
                        mazeData.grid[i][j].setGraphic(new ImageView(new Image("/img/monster.png")));
                        mazeData.grid[i][j].setId("monster");

                        break;
                    }
                    case "treasure": {
                        mazeData.grid[i][j].setGraphic(new ImageView(new Image("/img/treasure.png")));
                        mazeData.grid[i][j].setId("treasure");

                        break;
                    }
                    case "potion": {
                        mazeData.grid[i][j].setGraphic(new ImageView(new Image("/img/potion.png")));
                        mazeData.grid[i][j].setId("potion");

                        break;
                    }
                    case "wall": {
                        mazeData.grid[i][j].setGraphic(new ImageView(new Image("/img/wall.png")));
                        mazeData.grid[i][j].setId("wall");

                        break;
                    }
                }
                mazeData.grid[i][j].setStyle("-fx-pref-width: 64px; -fx-pref-height: 64px;-fx-padding: 0;");
                gp.add(mazeData.grid[i][j], j, i);


            }
        }

    }


}
