package Controller;


import Model.Maze;
import View.PlayPane;
import View.Rotation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class PlayController {
    
    private Maze data;
    static public PlayPane pp;

    public PlayController(PlayPane pp, Maze data){
        this.pp = pp;
        this.data = data;

    }

    public void init(){
        pp.head.setGraphic(new ImageView(data.ch.avatar));
        pp.name.setText(data.ch.name);
        pp.jump.setText("Jump Left: " + Integer.toString(data.ch.jumpTimes));
        pp.gp.setOnKeyPressed(event -> {

            handle(event);
            drawCharacter();
        });





    }

    public void initDragCharacter(){
        int size = data.size;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                int x = i;
                int y = j;
                pp.grid[j][i].setOnDragDetected(event -> {
                    if(x == data.ch.posX && y == data.ch.posY){
                        Dragboard db = pp.grid[y][x].startDragAndDrop(TransferMode.MOVE);
                        ClipboardContent content = new ClipboardContent();
                        content.putImage(data.ch.avatar);
                        db.setContent(content);
                        event.consume();
                    }
                });

                pp.grid[j][i].setOnDragOver(event -> {
                    event.acceptTransferModes(TransferMode.MOVE);
                    event.consume();
                });

                pp.grid[j][i].setOnDragDropped(event -> {


                    if( (Math.abs(x - data.ch.posX) == 2 && y - data.ch.posY == 0)
                    || (Math.abs(y - data.ch.posY) == 2 && x - data.ch.posX == 0) ){
                        if(data.src[y][x].equals("") && data.ch.jumpTimes > 0){
                            pp.grid[data.ch.posY][data.ch.posX].setGraphic(null);
                            data.ch.posX = x;
                            data.ch.posY = y;
                            data.ch.jumpTimes--;
                            pp.jump.setText("Jump Left: " + Integer.toString(data.ch.jumpTimes));
                            drawCharacter();
                        }

                    }
                });
            }
        }
    }

    public void handle(KeyEvent e) {

        if(e.getCode() == KeyCode.W){
            checkAndMove(0, -1);

        }
        if(e.getCode()== KeyCode.A){
            checkAndMove(-1, 0);
        }
        if(e.getCode()== KeyCode.S){
            checkAndMove(0, 1);
        }
        if(e.getCode()== KeyCode.D){
            checkAndMove(1, 0);
        }
        
    }

    private void checkAndMove(int dx, int dy){
        int x = data.ch.posX+dx;
        int y = data.ch.posY+dy;
        System.out.println(x+" "+y);

        if( x < 0 || x >= data.size || y < 0 || y >= data.size) return;

        if(data.src[y][x] == "monster"){
            Rotation fightp = new Rotation();
            fightp.init();
            Fight fightCtrl = new Fight(fightp, data);

            Scene fight = new Scene(fightp, 800, 600);
            fightCtrl.init(fight, x, y);


            Game.stage.setScene(fight);

        }
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

        initDragCharacter();

    }

    public void drawCharacter(){
//        System.out.println("Y"+data.ch.posY + "x"+ data.ch.posX);
//        System.out.println("id" +pp.grid[data.ch.posY][data.ch.posX]);
        pp.grid[data.ch.posY][data.ch.posX].setGraphic(new ImageView(data.ch.avatar));
        pp.pos.setText("(x:"+data.ch.posX+" , y:" + data.ch.posY+")");
    }




}
