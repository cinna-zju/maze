package View;


import javafx.geometry.Insets;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class CharacterPane extends HBox{
	
	public int cl;
	public VBox[] basic, add, v;

 	public Model.Character[] ch;

    public Label[] life, skill, power;




	public CharacterPane() {
		this.setPadding(new Insets(10,10,10,10));
		this.setSpacing(10);


		life = new Label[4];
		//skill = new Label[4];
		power = new Label[4];

		v = new VBox[3];
		basic = new VBox[3];
		add = new VBox[3];

		ch = new Model.Character[3];

	}

	public void init(){

	    String pros[] = {"hunter", "soldier", "rider"} ;

	    for (int i = 0; i < 3; i++){
	        ch[i] = new Model.Character(3,1,pros[i]);
            life[i] = new Label("Life : ");
            HBox vb = new HBox(life[i]);

            for(int j = 0; j < ch[i].getLife(); j++){
            	ImageView imgv = new ImageView(new Image("/img/heart.png"));
            	imgv.setFitWidth(15);
            	imgv.setFitHeight(15);
            	vb.getChildren().add(imgv);

			}


            power[i] = new Label("Power : " +ch[i].getPower());

            v[i] = new VBox();
            basic[i] = new VBox();
            add[i] = new VBox();

            v[i].setStyle("-fx-background-color: #eff144; ");
            v[i].setPrefWidth(150);




            basic[i].getChildren().addAll(new ImageView(ch[i].avatar) ,new Label(ch[i].name));

            this.getChildren().add(v[i]);

            add[i].getChildren().addAll(vb, power[i]);
            add[i].setVisible(false);

            v[i].getChildren().addAll(basic[i], add[i]);

        }



    }


}
	
