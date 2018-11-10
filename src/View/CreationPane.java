package View;


import javafx.geometry.Pos;
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


    public Label[][] grid;

    int size;



    public CreationPane(){
        size = 14;

    }

    public void init(){
        title = new Label("- Create Your Maze -");
        this.setTop(title);


        Monster = new Button("monster");
        Treasure = new Button("treasure");
        Potion = new Button("potion");

        ImageView btnImg;
        btnImg = new ImageView(new Image("/img/monster.png"));

        btnImg.setFitWidth(32);
        btnImg.setFitHeight(32);

        Monster.setGraphic(btnImg);

        btnImg = new ImageView(new Image(("/img/treasure.png")));
        btnImg.setFitWidth(32);
        btnImg.setFitHeight(32);

        Treasure.setGraphic(btnImg);

        btnImg = new ImageView(new Image(("/img/potion.png")));
        btnImg.setFitWidth(32);
        btnImg.setFitHeight(32);

        Potion.setGraphic(btnImg);

        String styBtn = "-fx-background-color: \n" + "        #c3c4c4,\n"
                + "        linear-gradient(#d6d6d6 50%, white 100%),\n"
                + "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n"
                + "    -fx-background-radius: 30;\n" + "    -fx-background-insets: 0,1,1;\n"
                + "    -fx-text-fill: black;\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );";

        Monster.setStyle(styBtn);
        Treasure.setStyle(styBtn);
        Potion.setStyle(styBtn);

        VBox vb = new VBox(Monster, Treasure, Potion);
        vb.setSpacing(20);

        this.setLeft(vb);

        next = new Button("next");
        back = new Button("back");


        next.setStyle(styBtn);
        back.setStyle(styBtn);


        HBox hb = new HBox(back, next);
        hb.setAlignment(Pos.CENTER_RIGHT);
        hb.setSpacing(20);
        this.setBottom(hb);

        grid = new Label[size][size];


        GridPane gp = new GridPane();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++) {
                grid[i][j] = new Label();
                grid[i][j].setId("");

                grid[i][j].setStyle("-fx-pref-width: 32px; -fx-pref-height: 32px;-fx-padding: 0;");

                gp.add(grid[i][j], j, i);



            }
        }
        //TODO 0,0?
//        System.out.println(grid[0][0].getHeight()+" "+grid[0][0].getWidth());

        this.setCenter(gp);
        this.setStyle("-fx-spacing: 20px; -fx-padding: 30px; -fx-hgap: 30px;");



    }



}
