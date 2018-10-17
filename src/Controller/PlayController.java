package Controller;


import Model.Maze;
import View.PlayPane;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PlayController {
    
    private Maze data;
    private PlayPane pp;
    
    public PlayController(PlayPane pp, Maze data){
        this.pp = pp;
        this.data = data;

    }

    public void init(){
        pp.head.setGraphic(new ImageView(data.ch.avatar));
        pp.name.setText(data.ch.name);
        pp.gp.setOnKeyPressed(event -> {

            handle(event);
            drawCharacter();
        });


    }

    public void handle(KeyEvent e) {

        if(e.getCode() == KeyCode.UP){
            checkAndMove(0, -1);

        }
        if(e.getCode()== KeyCode.LEFT){
            checkAndMove(-1, 0);
        }
        if(e.getCode()== KeyCode.DOWN){
            checkAndMove(0, 1);
        }
        if(e.getCode()== KeyCode.RIGHT){
            checkAndMove(1, 0);
        }
        
    }

    private void checkAndMove(int dx, int dy){
        int x = data.ch.posX+dx;
        int y = data.ch.posY+dy;
        System.out.println(x+" "+y);

        if( x < 0 || x >= data.size || y < 0 || y >= data.size) return;
        if(data.src[y][x] != "") return;

        pp.grid[data.ch.posY][data.ch.posX].setGraphic(null);

        data.ch.posX = x;
        data.ch.posY = y;

    }

    public void setMap(String[][] maps){

        int size = data.size;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                pp.grid[i][j] = new Button();
                switch(maps[i][j]){
                    case "monster": {
                        pp.grid[i][j].setGraphic(new ImageView(new Image("/img/monster.png")));
                        pp.grid[i][j].setId("monster");

                        break;
                    }
                    case "treasure": {
                        pp.grid[i][j].setGraphic(new ImageView(new Image("/img/treasure.png")));
                        pp.grid[i][j].setId("treasure");

                        break;
                    }
                    case "potion": {
                        pp.grid[i][j].setGraphic(new ImageView(new Image("/img/potion.png")));
                        pp.grid[i][j].setId("potion");

                        break;
                    }
                    case "wall": {
                        pp.grid[i][j].setGraphic(new ImageView(new Image("/img/wall.png")));
                        pp.grid[i][j].setId("wall");

                        break;
                    }
//                    default: {
//                        data.grid[i][j].setGraphic(new ImageView(new Image("/img/cracks.png")));
//                    }
                }
                pp.grid[i][j].setStyle("-fx-pref-width: 64px; -fx-pref-height: 64px;-fx-padding: 0;");
                pp.gp.add(pp.grid[i][j], j, i);


            }
        }

    }

    public void drawCharacter(){
//        System.out.println("Y"+data.ch.posY + "x"+ data.ch.posX);
//        System.out.println("id" +pp.grid[data.ch.posY][data.ch.posX]);
        pp.grid[data.ch.posY][data.ch.posX].setGraphic(new ImageView(data.ch.avatar));
        pp.pos.setText("(x:"+data.ch.posX+" , y:" + data.ch.posY+")");
    }




}
