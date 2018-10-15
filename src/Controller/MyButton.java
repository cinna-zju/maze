package Controller;

import View.MazeCreation;
import View.PlayPane;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;


public class MyButton {

    public void initDragSource(Button btn){
        btn.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Dragboard db = btn.startDragAndDrop(TransferMode.MOVE);
                if(btn.getText().equals("monster"))
                    db.setDragView(new Image("/img/monster.png"));

                if(btn.getText().equals("treasure"))
                    db.setDragView(new Image("/img/treasure.png"));

                if(btn.getText().equals("potion"))
                    db.setDragView(new Image("/img/potion.png"));


                ClipboardContent content = new ClipboardContent();
                content.putImage(db.getDragView());
                db.setContent(content);
                event.consume();
            }
        });


    }

    public void initDragTarget(Button btn){
        btn.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                System.out.println(btn.getHeight()+" "+btn.getWidth());

                btn.setGraphic(new ImageView(event.getDragboard().getImage()));
                System.out.println(btn.getHeight()+" "+btn.getWidth());
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
