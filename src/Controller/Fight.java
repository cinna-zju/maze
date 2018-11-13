package Controller;

import Model.Maze;
import View.Rotation;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Fight {
    Rotation view;
    private Maze data;
    Fight(Rotation fv, Maze data){
        this.view = fv;
        this.data = data;

    }

    public void init(Scene f, int x, int y){
        TranslateTransition transCh = new TranslateTransition(Duration.millis(300), view.ch);
        transCh.setByX(200);
        transCh.setCycleCount(2);
        transCh.setAutoReverse(true);

        TranslateTransition transMon = new TranslateTransition(Duration.millis(300), view.monster);
        transMon.setByX(-200);
        transMon.setCycleCount(2);
        transMon.setAutoReverse(true);

        f.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                if(event.getCode()== KeyCode.SPACE) {
                    view.secondTime.stop();
                    System.out.println(checkAngle());

                    if(checkAngle()){
                        transCh.play();
                        data.src[y][x] = "";

                        ImageView grass = new ImageView(new Image("/img/grass.png"));
                        grass.setFitHeight(32);
                        grass.setFitWidth(32);

                        PlayController.pp.grid[y][x].setGraphic(grass);

                    }else{
                        transMon.play();
                        data.ch.setLife(data.ch.getLife()-1);
                    }
                    transCh.setOnFinished(e -> Game.ppCtrl.stage.close());
                    transMon.setOnFinished(e -> Game.ppCtrl.stage.close());


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
