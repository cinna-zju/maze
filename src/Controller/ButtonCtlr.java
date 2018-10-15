package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.*;


public class ButtonCtlr {

    @FXML
    private Button Monster;


    @FXML
    private void onClick(MouseEvent e){
        System.out.println(e.getSource());
        if(e.getSource() == Monster){
            Monster.setDisable(true);
        }

    }

    @FXML
    private void onDragDetected(MouseEvent e){
        //Dragboard db =
        if(e.getSource() == Monster){
            Monster.startDragAndDrop(TransferMode.MOVE);
        }
        //ClipboardContent content = new ClipboardContent();
        //content.putString(e.getSource().getText());
        //db.setContent(content);
        e.consume();
    }

    @FXML
    private void onDragOver(DragEvent e){
        e.acceptTransferModes(TransferMode.MOVE);

    }

    @FXML
    private void onDragEntered(DragEvent e){


            e.acceptTransferModes(TransferMode.MOVE);
            Button t = (Button) e.getSource();
            t.setStyle("-fx-background-color: #AAAAAA;");

    }





}
