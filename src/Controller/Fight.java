package Controller;

import View.Rotation;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Fight {
    Rotation view;
    Fight(Rotation fv){
        this.view = fv;

    }

    public void init(Scene f){
        System.out.println("in0");

        f.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                Scene temp = Game.stage.getScene();
                System.out.println(temp);

                if(event.getCode()== KeyCode.SPACE) {
                    view.secondTime.stop();
                    checkAngle();
                    Game.stage.setScene(CreationController.ps);

                }
            }
        });

    }

    public boolean checkAngle() {
        System.out.println(view.rot.getAngle());
        if(view.rot.getAngle()>view.alpha+360 && view.rot.getAngle()<view.beta+360) {
            System.out.println(true);
            return true;
        }
        return false;
    }
}
