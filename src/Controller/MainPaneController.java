package Controller;

import Model.Maze;

import View.MainPane;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;


public class MainPaneController {
	
	private MainPane mp;
    private Maze data;

    public MainPaneController(MainPane view, Maze model){
        mp = view;
        data = model;
        mp.map.setDisable(true);

    }

    public void init() {
        mp.map.setOnMouseClicked(event -> {

            Game.cp.init();
            Game.cpCtrl.init();

            Scene scene = new Scene(Game.cp, 600, 600);
            Game.stage.setScene(scene);


        });


        mp.exit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        for(int i = 0; i < 3; i++){
            int t = i;
            mp.characterPane.v[t].setOnMouseClicked(event -> {

                int x = t;

                mp.characterPane.cl = x;

                choose(x);
                mp.characterPane.add[t].setVisible(true);

            });
        }

    }

    public void choose(int x){
        for(int i = 0; i < 3; i++){
            mp.characterPane.v[i].setStyle("-fx-background-color: #eff144"); //yellow
            mp.characterPane.add[i].setVisible(false);
        }
        mp.characterPane.v[x].setStyle("-fx-background-color: #8df144");
        mp.characterPane.add[x].setVisible(true);
        data.ch = mp.characterPane.ch[x];

        if(mp.sp.getChildren().size() > 1) {
            mp.sp.getChildren().remove(1);
        }
        ImageView chv = new ImageView(data.ch.ava64);
        chv.setFitWidth(128);
        chv.setFitHeight(128);

        mp.sp.getChildren().add(chv);
        mp.sp.setAlignment(Pos.BOTTOM_CENTER);
        mp.map.setDisable(false);


    }
}
