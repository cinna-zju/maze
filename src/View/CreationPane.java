package View;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class CreationPane extends BorderPane {

    public Button Monster;
    public Button Treasure;
    public Button Potion;
    public Button next;
    public Button back;

    Label title;


    public Button[][] grid;

    int size;



    public CreationPane(){
        size = 8;

    }

    public void init(){
        title = new Label("- Create Your Maze -");
        this.setTop(title);


        Monster = new Button("monster");
        Treasure = new Button("treasure");
        Potion = new Button("potion");


        Monster.setGraphic(new ImageView(new Image("/img/monster.png")));
        Treasure.setGraphic(new ImageView(new Image("/img/treasure.png")));
        Potion.setGraphic(new ImageView(new Image("/img/potion.png")));

        Monster.setStyle("-fx-pref-width: 180px; -fx-pref-height: 64px;-fx-padding: 0;");
        Treasure.setStyle("-fx-pref-width: 180px; -fx-pref-height: 64px;-fx-padding: 0;");
        Potion.setStyle("-fx-pref-width: 180px; -fx-pref-height: 64px;-fx-padding: 0;");



        this.setLeft(new VBox(Monster, Treasure, Potion));

        next = new Button("next");
        back = new Button("back");

        this.setBottom(new HBox(back, next));

        grid = new Button[size][size];


        GridPane gp = new GridPane();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                grid[i][j] = new Button();
                grid[i][j].setId("");

                grid[i][j].setStyle("-fx-pref-width: 64px; -fx-pref-height: 64px;-fx-padding: 0;");

                gp.add(grid[i][j], j, i);



            }
        }
        //TODO 0,0?
//        System.out.println(grid[0][0].getHeight()+" "+grid[0][0].getWidth());

        this.setCenter(gp);
        this.setStyle("-fx-spacing: 20px; -fx-padding: 30px");



    }



}
