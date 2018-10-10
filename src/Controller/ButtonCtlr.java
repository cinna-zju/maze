package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;


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


}
