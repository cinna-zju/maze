package Controller;


import Model.Maze;
import View.PlayPane;
import View.Rotation;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.Stage;

public class PlayController {
    
    private Maze data;
    static public PlayPane pp;

    public PlayController(PlayPane pp, Maze data){
        this.pp = pp;
        this.data = data;

    }

    public void init(){
        ImageView av = new ImageView(data.ch.avatar);
        av.setFitWidth(64);
        av.setFitHeight(64);
        pp.head.setGraphic(av);
        pp.name.setText(data.ch.name);

        pp.jump.setVisible(false);

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
                            ImageView grass = new ImageView(new Image("/img/grass.png"));
                            grass.setFitHeight(32);
                            grass.setFitWidth(32);
                            pp.grid[data.ch.posY][data.ch.posX].setGraphic(grass);
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

        if( x < 0 || x >= data.size || y < 0 || y >= data.size) return;
        if(data.src[y][x] == "tree" || data.src[y][x] == "mtn") return;

        if(data.src[y][x] == "treasure"){
            data.src[y][x] = "";
            data.ch.jumpTimes += 1;
            pp.jump.setText("Jump Left: " + Integer.toString(data.ch.jumpTimes));
            pp.jump.setVisible(true);

        }

        if(data.src[y][x] == "monster"){
            Rotation fightp = new Rotation();
            fightp.init();
            Fight fightCtrl = new Fight(fightp, data);

            Scene fight = new Scene(fightp, 400, 500);
            fightCtrl.init(fight, x, y);

//            Game.stage.setScene(fight);
            Stage stage = new Stage();
            stage.setTitle("Fighting!");
            stage.setScene(fight);
            stage.show();


        }

        if(data.src[y][x] == "potion"){

            System.out.println(data.ch.getLife());
            data.src[y][x] = "";

            if(data.ch.getLife() < 3){
                data.ch.setLife(data.ch.getLife()+1);
            }
        }

        if(data.src[y][x] == ""){

            ImageView grass = new ImageView(new Image("/img/grass.png"));
            grass.setFitHeight(32);
            grass.setFitWidth(32);

            pp.grid[data.ch.posY][data.ch.posX].setGraphic(grass);

            data.ch.posX = x;
            data.ch.posY = y;

        }



    }

    public void setMap(String[][] maps){

        int size = data.size;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                pp.grid[i][j] = new Button();
                switch(maps[i][j]){
                    case "monster": {
                        ImageView monster = new ImageView(new Image("/img/mon_bg.png"));
                        monster.setFitHeight(32);
                        monster.setFitWidth(32);
                        pp.grid[i][j].setGraphic(monster);
                        pp.grid[i][j].setId("monster");

                        break;
                    }
                    case "treasure": {
                        ImageView tre = new ImageView(new Image("/img/treasure_bg.png"));
                        tre.setFitHeight(32);
                        tre.setFitWidth(32);
                        pp.grid[i][j].setGraphic(tre);
                        pp.grid[i][j].setId("treasure");

                        break;
                    }
                    case "potion": {
                        ImageView potion = new ImageView(new Image("/img/potion_bg.png"));
                        potion.setFitWidth(32);
                        potion.setFitHeight(32);
                        pp.grid[i][j].setGraphic(potion);
                        pp.grid[i][j].setId("potion");

                        break;
                    }
                    case "tree": {
                        ImageView tree = new ImageView(new Image("/img/tree.png"));
                        tree.setFitWidth(32);
                        tree.setFitHeight(32);


                        pp.grid[i][j].setGraphic(tree);
                        pp.grid[i][j].setId("tree");

                        break;
                    }
                    case "mtn":{
                        ImageView mtn = new ImageView(new Image("/img/mountain.png"));
                        mtn.setFitHeight(32);
                        mtn.setFitWidth(32);

                        pp.grid[i][j].setGraphic(mtn);
                        pp.grid[i][j].setId("mtn");
                        break;
                    }
                    default: {
                        ImageView grass = new ImageView(new Image("/img/grass.png"));
                        grass.setFitHeight(32);
                        grass.setFitWidth(32);

                        pp.grid[i][j].setGraphic(grass);
                    }
                }
                pp.grid[i][j].setStyle("-fx-pref-width: 32px; -fx-pref-height: 32px;-fx-padding: 0;");
                pp.gp.add(pp.grid[i][j], j, i);


            }
        }

        initDragCharacter();

    }

    public void drawCharacter(){
//        System.out.println("Y"+data.ch.posY + "x"+ data.ch.posX);
//        System.out.println("id" +pp.grid[data.ch.posY][data.ch.posX]);
        pp.grid[data.ch.posY][data.ch.posX].setGraphic(new ImageView(data.ch.avatarbg));
        pp.pos.setText("(x:"+data.ch.posX+" , y:" + data.ch.posY+")");
    }




}
