package Controller;

import View.MazeCreation;
import View.PlayPane;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.stage.Stage;


public class MyButton {
    Stage stage;

    public MyButton(Stage stage){
        this.stage = stage;

    }

    public void initDragSource(Button btn){
        btn.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = btn.startDragAndDrop(TransferMode.MOVE);
                ClipboardContent content = new ClipboardContent();

                if(btn.getText().equals("monster")){
//                    db.setDragView(new Image("/img/monster.png"));
                    content.putString("monster");

                }


                if(btn.getText().equals("treasure")){
//                    db.setDragView(new Image("/img/treasure.png"));
                    content.putString("treasure");
                }

                if(btn.getText().equals("potion")){
//                    db.setDragView(new Image("/img/potion.png"));
                    content.putString("potion");
                }

                //content.putImage(db);
                db.setContent(content);
                event.consume();
            }
        });


    }

    public void initDragTarget(Button btn){
        btn.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                //System.out.println(btn.getHeight()+" "+btn.getWidth());
                String src = event.getDragboard().getContent(DataFormat.PLAIN_TEXT).toString();
                if(src.equals("monster")){
                    btn.setGraphic(new ImageView(new Image("/img/monster.png")));
                    btn.setId("monster");
                }

                if(src.equals("treasure")){
                    btn.setGraphic(new ImageView(new Image("/img/treasure.png")));
                    btn.setId("treasure");
                }

                if(src.equals("potion")){
                    btn.setGraphic(new ImageView(new Image("/img/potion.png")));
                    btn.setId("potion");
                }



                //System.out.println(btn.getHeight()+" "+btn.getWidth());
                event.consume();
                event.setDropCompleted(true);

            }
        });

        btn.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != btn) {
                    event.acceptTransferModes(TransferMode.MOVE);
                    //btn.setStyle("-fx-background-color: #AAAAAA;");
                    //btn.setDisable(true);
                }
                event.consume();

            }
        });

        btn.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                if (event.getGestureSource() != btn){
                    event.acceptTransferModes(TransferMode.MOVE);
//                            btn.setStyle("-fx-background-color: #FFFFFF;");
                    //btn.setDisable(false);
                }
                event.consume();

            }
        });

        btn.setOnDragOver(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                event.acceptTransferModes(TransferMode.MOVE);
                event.consume();
            }
        });
    }

    public void toPlay(Button btn){
        btn.setOnMouseClicked(event -> {


        });


    }







}
