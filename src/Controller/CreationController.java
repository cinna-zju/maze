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

            ps = new Scene(Game.pp, 800, 800);
            Game.stage.setScene(ps);

        });


        view.Monster.setOnDragDetected(event -> {
            Dragboard db = view.Monster.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString("monster");
            db.setContent(content);
            event.consume();
        });

        view.Treasure.setOnDragDetected(event -> {
            Dragboard db = view.Treasure.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString("treasure");
            db.setContent(content);
            event.consume();
        });

        view.Potion.setOnDragDetected(event -> {
            Dragboard db = view.Potion.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();
            content.putString("potion");
            db.setContent(content);
            event.consume();
        });


        for(int i = 0; i < view.grid.length; i++){
            for (int j = 0; j < view.grid[i].length; j++){
                int x = i;
                int y = j;

                if (data.isOpen[i][j] == 0){

                    view.grid[i][j].setGraphic(new ImageView(new Image("/img/wall.png")));
                    view.grid[i][j].setId("wall");
                    data.src[i][j] = "wall";
                }

                view.grid[x][y].setOnDragOver(event -> {
                    event.acceptTransferModes(TransferMode.MOVE);
                    event.consume();
                });

                view.grid[i][j].setOnDragDropped(event -> {

                    String src = event.getDragboard().getContent(DataFormat.PLAIN_TEXT).toString();
                    if(src.equals("monster")){
                        view.grid[x][y].setGraphic(new ImageView(new Image("/img/monster.png")));
                        view.grid[x][y].setId("monster");
                    }

                    if(src.equals("treasure")){
                        view.grid[x][y].setGraphic(new ImageView(new Image("/img/treasure.png")));
                        view.grid[x][y].setId("treasure");
                    }

                    if(src.equals("potion")){
                        view.grid[x][y].setGraphic(new ImageView(new Image("/img/potion.png")));
                        view.grid[x][y].setId("potion");
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
