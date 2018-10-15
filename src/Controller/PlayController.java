package Controller;

import Model.Character;
import View.PlayPane;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PlayController {
    public void update(int dx, int dy, Character ch){
        ch.posX += dx;
        ch.posY += dy;
    }

    public void handle(KeyEvent e, Character ch){
        if(e.getCode()== KeyCode.W){
            update(0,1, ch);
        }
        if(e.getCode()== KeyCode.A){
            update(-1,0, ch);
        }
        if(e.getCode()== KeyCode.S){
            update(0,-1, ch);
        }
        if(e.getCode()== KeyCode.D){
            update(1,0, ch);
        }



    }
}
