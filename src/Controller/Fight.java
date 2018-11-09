package Controller;

import Model.Maze;
import View.Rotation;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Fight {
    Rotation view;
    private Maze data;
    Fight(Rotation fv, Maze data){
        this.view = fv;
        this.data = data;

    }

    public void init(Scene f, int x, int y){
        System.out.println("in0");

        f.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                Scene temp = Game.stage.getScene();
                System.out.println(temp);

                if(event.getCode()== KeyCode.SPACE) {
                    view.secondTime.stop();
                    if(checkAngle()){
                        data.src[y][x] = "";
                        PlayController.pp.grid[y][x].setGraphic(null);

                    }else{
                        data.ch.setLife(data.ch.getLife()-1);
                    }

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
