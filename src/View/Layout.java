package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Layout {

	public HBox hb;
	public VBox vb;
	public Button start, exit, map;
	
	public Layout() {
		hb = new HBox();
		vb = new VBox();
		start = new Button("Play");
		exit = new Button("Exit");
		map = new Button("Maps");
	}
	
	public HBox hbox() {
		
		hb.setPadding(new Insets(10,10,10,10));
		hb.setAlignment(Pos.BASELINE_CENTER);
		Label title = new Label("Crazy Maze!");
		hb.setStyle("-fx-background-color: #C0C0C0");			
		hb.getChildren().add(title);
		
		return hb;		
	}
	
	public VBox vbox() {
		
		vb = new VBox();
		vb.setPadding(new Insets(10,10,10,10));
		vb.setSpacing(10);
		// Button to start or exit the game
		
		String styBtn = "-fx-background-color: \n" + "        #c3c4c4,\n"
				+ "        linear-gradient(#d6d6d6 50%, white 100%),\n"
				+ "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n"
				+ "    -fx-background-radius: 30;\n" + "    -fx-background-insets: 0,1,1;\n"
				+ "    -fx-text-fill: black;\n"
				+ "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );";
	start.setStyle(styBtn);
	map.setStyle(styBtn);
	map.setAlignment(Pos.BOTTOM_RIGHT);
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
	return vb;
	}
}