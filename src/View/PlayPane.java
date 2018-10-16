package View;

import Controller.PlayController;
import Model.Maze;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PlayPane extends BorderPane {
    private GridPane gp;
    private PlayController play;
    private Maze mazeData;

    private Label avatar;
    private Label heart;
    private Label HP;
    private Label pos;

    public PlayPane() {
        mazeData = new Maze();
        avatar = new Label();
        avatar.setGraphic(new ImageView(new Image("/img/warrior.png")));
        heart = new Label();
        heart.setGraphic(new ImageView(new Image("/img/heart.png")));
        HP = new Label("100");
        pos = new Label();
        gp = new GridPane();
        play = new PlayController(mazeData);
    }


    public void init(){

        HBox lifeBar = new HBox(heart, HP);
        VBox sideInfo = new VBox(avatar, lifeBar, pos);

        this.setLeft(sideInfo);
        sideInfo.setStyle("-fx-spacing: 20px; -fx-padding: 10px; -fx-pref-width: 100px;");




        this.setCenter(gp);

        this.setOnKeyPressed(event -> {
            play.handle(event);
            drawCharacter();
        });


    }


    public void drawCharacter(){
        mazeData.grid[mazeData.ch.posY][mazeData.ch.posX].setGraphic(new ImageView(new Image("/img/warrior.png")));
        pos.setText("(x:"+mazeData.ch.posX+" , y:" + mazeData.ch.posY+")");
    }



    public void setMap(String[][] maps){
        int size = mazeData.size;
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
