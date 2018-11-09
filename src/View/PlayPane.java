package View;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PlayPane extends BorderPane {
    public GridPane gp;
    public int size;

    private ImageView avatar;
    public Label heart1;
    public Label heart2;
    public Label heart3;

    public Label pos;
    public Label head;
    public Label name;
    public Button[][] grid;
    public Label jump;

    public PlayPane() {
        size = 8;
        heart1 = new Label();
        heart2 = new Label();
        heart3 = new Label();

        pos = new Label();
        gp = new GridPane();
        head = new Label();
        name = new Label();

        jump = new Label();

        grid = new Button[size][size];

    }


    public void init(){

        HBox lifeBar = new HBox(heart1, heart2, heart3);
        VBox sideInfo = new VBox(name, head, lifeBar, pos, jump);

        heart1.setGraphic(new ImageView(new Image("/img/heart.png")));
        heart2.setGraphic(new ImageView(new Image("/img/heart.png")));
        heart3.setGraphic(new ImageView(new Image("/img/heart.png")));

        head.setGraphic(avatar);

        this.setLeft(sideInfo);
        this.setCenter(gp);
        sideInfo.setStyle("-fx-spacing: 20px; -fx-padding: 10px; -fx-pref-width: 100px;");





    }








}
