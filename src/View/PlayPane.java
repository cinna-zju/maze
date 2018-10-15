package View;

import Controller.PlayController;
import Model.Character;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PlayPane extends BorderPane {
    public GridPane gp;
    public Character ch;
    public PlayController play;
    public Button[][] grid;
    public int size;

    public void init(){
        ch = new Character(3,1,1);
        gp = new GridPane();
        play = new PlayController();


        this.setCenter(gp);
//        this.setOnKeyTyped(new EventHandler<KeyEvent>() {
//            @Override
//            public void handle(KeyEvent event) {
//                play.handle(event, ch);
//
//            }
//        });

        this.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {

                //play.handle(event, ch);
                if(e.getCode() == KeyCode.W){
                    checkAndDraw(0, -1);

                }
                if(e.getCode()== KeyCode.A){
                    checkAndDraw(-1, 0);
                }
                if(e.getCode()== KeyCode.S){
                    checkAndDraw(0, 1);
                }
                if(e.getCode()== KeyCode.D){
                    checkAndDraw(1, 0);
                }


            }
        });
    }

    public void setMap(String[][] maps){
        size = maps.length;
        grid = new Button[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                grid[i][j] = new Button();
                switch(maps[i][j]){
                    case "monster": {
                        grid[i][j].setGraphic(new ImageView(new Image("/img/monster.png")));
                        grid[i][j].setId("monster");

                        break;
                    }
                    case "treasure": {
                        grid[i][j].setGraphic(new ImageView(new Image("/img/treasure.png")));
                        grid[i][j].setId("treasure");

                        break;
                    }
                    case "potion": {
                        grid[i][j].setGraphic(new ImageView(new Image("/img/potion.png")));
                        grid[i][j].setId("potion");

                        break;
                    }
                    case "wall": {
                        grid[i][j].setGraphic(new ImageView(new Image("/img/wall.png")));
                        grid[i][j].setId("wall");

                        break;
                    }
                }
                grid[i][j].setStyle("-fx-pref-width: 64px; -fx-pref-height: 64px;-fx-padding: 0;");
                gp.add(grid[i][j], j, i);

            }
        }

    }

    public void drawCharacter(){
        grid[ch.posY][ch.posX].setGraphic(new ImageView(new Image("/img/warrior.png")));
    }

    public void checkAndDraw(int dx, int dy){
        int x = ch.posX+dx;
        int y = ch.posY+dy;
        if( x < 0 || x >= size || y < 0 || y >= size) return;
        if(grid[y][x].getId() != null) return;

        grid[ch.posY][ch.posX].setGraphic(null);

        ch.posX = x;
        ch.posY = y;
        System.out.println(x+" "+y);

        drawCharacter();
    }
}
