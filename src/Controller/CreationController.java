package Controller;

import Model.Maze;
import View.CreationPane;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;


public class CreationController {

    CreationPane view;
    Maze data;
    public static Scene ps;

    CreationController(CreationPane cp, Maze maze){
        view = cp;
        data = maze;

    }

    public void init(){

        view.next.setOnMouseClicked(e -> {
            Game.pp.init();
            Game.ppCtrl.init();

            generateMap();
            Game.ppCtrl.setMap(data.src);
            Game.ppCtrl.drawCharacter();

            ps = new Scene(Game.pp, 600, 600);
            Game.stage.setScene(ps);

        });


        view.Monster.setOnDragDetected(event -> {
            Dragboard db = view.Monster.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString("monster");
            db.setContent(content);
            db.setDragView(new Image("/img/monster.png"));

            event.consume();
        });

        view.Treasure.setOnDragDetected(event -> {
            Dragboard db = view.Treasure.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString("treasure");
            db.setContent(content);
            db.setDragView(new Image("/img/treasure.png"));
            event.consume();
        });

        view.Potion.setOnDragDetected(event -> {
            Dragboard db = view.Potion.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString("potion");
            db.setContent(content);
            db.setDragView(new Image("/img/potion.png"));
            event.consume();
        });


        for(int i = 0; i < view.grid.length; i++){
            for (int j = 0; j < view.grid[i].length; j++){
                int x = i;
                int y = j;
                ImageView grass = new ImageView(new Image("/img/grass.png"));
                grass.setFitHeight(32);
                grass.setFitWidth(32);
                view.grid[x][y].setGraphic(grass);

                if (data.isOpen[i][j] == 0){
                    ImageView tree = new ImageView(new Image("/img/tree.png"));
                    tree.setFitWidth(32);
                    tree.setFitHeight(32);

                    view.grid[i][j].setGraphic(tree);
                    view.grid[i][j].setId("tree");
                }

                if (data.isOpen[i][j] == 2){
                    ImageView mtn = new ImageView(new Image("/img/mountain.png"));
                    mtn.setFitWidth(32);
                    mtn.setFitHeight(32);

                    view.grid[i][j].setGraphic(mtn);
                    view.grid[i][j].setId("mtn");

                }

                if (data.isOpen[i][j] == 3){
                    ImageView sword = new ImageView("/img/sword.png");
                    view.grid[i][j].setGraphic(sword);
                    view.grid[i][j].setId("sword");
                }

                if(data.isOpen[i][j] == 4){
                    ImageView npc = new ImageView("/img/npc.png");
                    view.grid[i][j].setGraphic(npc);
                    view.grid[i][j].setId("npc");
                }

                if(data.isOpen[i][j] == 5){
                    ImageView r = new ImageView("/img/river.png");
                    view.grid[i][j].setGraphic(r);
                    view.grid[i][j].setId("river");
                }

                view.grid[x][y].setOnDragOver(event -> {
                    event.acceptTransferModes(TransferMode.MOVE);
                    event.consume();
                });

                view.grid[i][j].setOnDragDropped(event -> {

                    String src = event.getDragboard().getContent(DataFormat.PLAIN_TEXT).toString();
                    ImageView img = new ImageView();
                    img.setFitHeight(32);
                    img.setFitWidth(32);

                    if(data.isOpen[x][y]==1){
                        if(src.equals("monster")){
                            img.setImage(new Image("/img/mon_bg.png"));
                            view.grid[x][y].setGraphic(img);
                            view.grid[x][y].setId("monster");
                        }

                        if(src.equals("treasure")){
                            img.setImage(new Image("/img/treasure_bg.png"));
                            view.grid[x][y].setGraphic(img);
                            view.grid[x][y].setId("treasure");
                        }

                        if(src.equals("potion")){
                            img.setImage(new Image("/img/potion_bg.png"));
                            view.grid[x][y].setGraphic(img);
                            view.grid[x][y].setId("potion");
                        }

                    }



                    event.consume();
                    event.setDropCompleted(true);

                });

            }
        }


    }

    public void generateMap(){
        for(int i = 0; i < view.grid.length; i++){
            for(int j = 0; j < view.grid[i].length; j++){
                data.src[i][j] = view.grid[i][j].getId();
            }
        }

    }






}
