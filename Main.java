package sample;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {


	public BorderPane bp;
	public Character ch;
	public HBox hb;
	
	public static void main (String[] args) {
		launch(args);		
	}
	
	@Override
	public void start (Stage prStage) throws Exception {
		//Styles st = new Styles();
		bp = new BorderPane();
		bp.setPadding(new Insets(10,10,10,10));
		bp.setStyle("-fx-background-color: #8fbc8f");
		//Layout
		// HBox fot the title
				hb = new HBox();
				hb.setPadding(new Insets(10,10,10,10));
				hb.setAlignment(Pos.BASELINE_CENTER);
				Label title = new Label("Crazy Maze!");
				hb.setStyle("-fx-background-color: #C0C0C0");
						
				hb.getChildren().add(title);
				bp.setTop(hb);
				
				// VBox containing start and exit button
		VBox vb = new VBox();
		vb.setPadding(new Insets(10,10,10,10));
		vb.setSpacing(10);
		// Button to start or exit the game
		Button start = new Button("Play");
		String styBtn = "-fx-background-color: \n" + "        #c3c4c4,\n"
				+ "        linear-gradient(#d6d6d6 50%, white 100%),\n"
				+ "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n"
				+ "    -fx-background-radius: 30;\n" + "    -fx-background-insets: 0,1,1;\n"
				+ "    -fx-text-fill: black;\n"
				+ "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );";
	start.setStyle(styBtn);
		start.setOnMouseClicked(event -> {
				ch = new Character();
				ch.setAlignment(Pos.BASELINE_CENTER);
				title.setText("Choose your charater!");
				Button map = new Button("Maps");
				map.setStyle(styBtn);
				map.setAlignment(Pos.BOTTOM_RIGHT);
				bp.setBottom(map);
				bp.setCenter(ch);
			});
		
		Button exit = new Button("Exit");
			exit.setOnMouseClicked(event ->{
				System.exit(0);
			});
		
		exit.setStyle("-fx-background-color: \n" + 
				"        #c3c4c4,\n" + 
				"        linear-gradient(#d6d6d6 50%, white 100%),\n" + 
				"        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" + 
				"    -fx-background-radius: 30;\n" + 
				"    -fx-background-insets: 0,1,1;\n" + 
				"    -fx-text-fill: black;\n" + 
				"    -fx-effect: dropshadow( three-pass-box , rgba(10,5,79,0.6) , 3, 0.0 , 0 , 1 );");
		
		vb.getChildren().addAll(start,exit);
		vb.setAlignment(Pos.BASELINE_CENTER);
		bp.setCenter(vb);
		
		
		Scene scene = new Scene(bp,400,200);
		prStage.setScene(scene);
		prStage.show();
		
	}
	
	
}