package Controller;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;


public class MyButton {

    public void initDragSource(Button btn){
        btn.setOnDragDetected(event ->  {

            Dragboard db = btn.startDragAndDrop(TransferMode.MOVE);
            ClipboardContent content = new ClipboardContent();

            if(btn.getText().equals("monster")){
//                   db.setDragView(new Image("/img/monster.png"));
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

        });


    }

    public void initDragTarget(Button btn){
        btn.setOnDragDropped(event ->  {

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


        });

        btn.setOnDragEntered(event -> {
            if (event.getGestureSource() != btn) {
                event.acceptTransferModes(TransferMode.MOVE);
                //btn.setStyle("-fx-background-color: #AAAAAA;");
                //btn.setDisable(true);
            }
            event.consume();


        });

        btn.setOnDragExited(event ->  {
                if (event.getGestureSource() != btn){
                    event.acceptTransferModes(TransferMode.MOVE);
//                            btn.setStyle("-fx-background-color: #FFFFFF;");
                    //btn.setDisable(false);
                }
                event.consume();


        });

        btn.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.MOVE);
            event.consume();

        });
    }


}
