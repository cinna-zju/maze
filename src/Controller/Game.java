package Controller;

import Model.Maze;
import View.CreationPane;
import View.MainPane;
import View.PlayPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Game extends Application {

    static Stage stage;

    MainPane mp;
    MainPaneController mpCtrl;

    //Model
    Maze maze;

    //Maze creation part
    static CreationPane cp;
    static CreationController cpCtrl;

    //playpane
    static PlayPane pp;
    static PlayController ppCtrl;



    public void start(Stage pStage){
        try {
            maze = new Maze();
            stage = pStage;


            mp = new MainPane();
            mpCtrl = new MainPaneController(mp, maze);


            cp = new CreationPane();
            cpCtrl = new CreationController(cp, maze);

            pp = new PlayPane();
            ppCtrl = new PlayController(pp, maze);

            mp.init();
            mpCtrl.init();


            Scene firstScene = new Scene(mp, 800, 800);

            pStage.setTitle("Maze");
            pStage.setScene(firstScene);
            pStage.show();


        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
