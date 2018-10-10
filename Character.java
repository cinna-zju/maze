package sample;

import java.io.File;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.GroupBuilder;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Character extends HBox{
	
	public String choice;
	public int cl1,cl2,cl3,cl4;
	public VBox v1, v2, v3, v4;
	
	public Character() {
		this.setPadding(new Insets(10,10,10,10));
		this.setSpacing(10);
		this.setPrefSize(50,50);
		cl1 = 0;
		cl2 = 0;
		cl3 = 0;
		cl4 = 0;
		init();
		
	}
	
	public void init() {
		// HBox for 4 characters
		choice = "";
	//Professor
		//cl1 = 0;
		v1 = new VBox(); //Name and imgae
		v1.setSpacing(10);
		v1.setPadding(new Insets(10,10,10,10));
		v1.setStyle("-fx-background-color: #eff144"); //yellow
		v1.setOnMouseClicked(event->{
			//Characteristics
				choice = "prof";
			Label life1 = new Label("Life : 100");
			Label Skill1 = new Label("Skill : jump");
			Label power1 = new Label("Power : 200");
			Label defense1 = new Label("Defense : 50");
			if(cl1== 0) {
			v1.getChildren().addAll(life1,Skill1,power1,defense1);
			}
			v1.setStyle("-fx-background-color: #8df144"); // green
			v2.setStyle("-fx-background-color: #eff144"); //yellow
			v3.setStyle("-fx-background-color: #eff144"); //yellow
			v4.setStyle("-fx-background-color: #eff144"); //yellow
			cl1 = 1;
			});
		
		Label name1 = new Label("Professor");
		// image...
		Image prof = new Image("/professor.png",30,30,false,false);
		ImageView iv1 = new ImageView();

		iv1.setImage(prof);
		v1.getChildren().addAll(name1,iv1);

	//Warrior	
		cl2 = 0;
		v2 = new VBox();
		v2.setSpacing(10);
		v2.setPadding(new Insets(10,10,10,10));
		v2.setStyle("-fx-background-color: #eff144"); 
		v2.setOnMouseClicked(event->{
			//Characteristics
				choice = "warrior";
					Label life2 = new Label("Life : 180");
					Label Skill2 = new Label("Skill : climb");
					Label power2 = new Label("Power : 100");
					Label defense2 = new Label("Defense : 300");
					if(cl2 == 0) {
						v2.getChildren().addAll(life2,Skill2,power2,defense2);
					}
					v2.setStyle("-fx-background-color: #8df144"); //green
					v1.setStyle("-fx-background-color: #eff144"); //yellow
					v3.setStyle("-fx-background-color: #eff144"); //yellow
					v4.setStyle("-fx-background-color: #eff144"); //yellow
					cl2 = 1;
					});
			
		Label name2 = new Label("Warrior");
		// image...
		Image warrior = new Image("/warrior.png",30,30,false,false);
		ImageView iv2 = new ImageView();
		v2.getChildren().addAll(name2,iv2);
		iv2.setImage(warrior);

	//King
		cl3 = 0;
		v3 = new VBox();
		v3.setSpacing(10);
		v3.setPadding(new Insets(10,10,10,10));
		v3.setStyle("-fx-background-color: #eff144"); 
		v3.setOnMouseClicked(event->{
			choice = "king";
		//Characteristics
				Label life3 = new Label("Life : 150");
				Label Skill3 = new Label("Skill : sword");
				Label power3 = new Label("Power : 80");
				Label defense3 = new Label("Defense : 50");
				if(cl3 == 0) { 
				v3.getChildren().addAll(life3,Skill3,power3,defense3);
				}
				v3.setStyle("-fx-background-color: #8df144"); // green
				v1.setStyle("-fx-background-color: #eff144"); //yellow
				v2.setStyle("-fx-background-color: #eff144"); //yellow
				v4.setStyle("-fx-background-color: #eff144"); //yellow
				cl3 = 1;
				});
		Label name3 = new Label("King");
		// image...
		Image king = new Image("/king.png",30,30,false,false);
		ImageView iv3 = new ImageView();
		v3.getChildren().addAll(name3,iv3);
		iv3.setImage(king);

	//Soldier
		cl4 = 0;
		v4 = new VBox();
		v4.setSpacing(10);
		v4.setPadding(new Insets(10,10,10,10));
		v4.setStyle("-fx-background-color: #eff144"); 
		v4.setOnMouseClicked(event->{
		//Characteristics
			choice = "soldier";
			
				Label life4 = new Label("Life : 200");
				Label Skill4 = new Label("Skill : jump");
				Label power4 = new Label("Power : 250");
				Label defense4 = new Label("Defense : 150");
				if(cl4 == 0) {
				v4.getChildren().addAll(life4,Skill4,power4,defense4);
				}
				v4.setStyle("-fx-background-color: #8df144"); 
				v1.setStyle("-fx-background-color: #eff144"); //yellow
				v2.setStyle("-fx-background-color: #eff144"); //yellow
				v3.setStyle("-fx-background-color: #eff144"); //yellow
				cl4 = 1;
				});
		Label name4 = new Label("Soldier");
		// image...
		Image soldier = new Image("/soldier.png",30,30,false,false);
		ImageView iv4 = new ImageView();
		v4.getChildren().addAll(name4,iv4);
		iv4.setImage(soldier);
		
		this.getChildren().addAll(v1,v2,v3,v4);
		}
}
