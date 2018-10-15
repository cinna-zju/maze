package Controller;


import View.Character;
import View.Layout;
import View.MazeCreation;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;


public class Controller extends BorderPane {
	
	public Character ch;
	public Layout layout;




	public Controller() {
	this.setPadding(new Insets(10,10,10,10));
	this.setStyle("-fx-background-color: #8fbc8f");
	layout = new Layout();

	//Layout
	// HBox fot the title
			this.setTop(layout.hbox());
			this.setCenter(layout.vbox());

	layout.start.setOnMouseClicked(event -> {
			ch = new Character();
			ch.setAlignment(Pos.BASELINE_CENTER);
			Label title = new Label();
			title.setText("Choose your charater!");
			this.setBottom(layout.map);
			this.setCenter(ch);
		});	
	
	layout.exit.setOnMouseClicked(event ->{
			System.exit(0);
		});

//	layout.map.setOnMouseClicked(event -> {
//
//
//
//
//
//
//
//	});

	this.setCenter(layout.vbox());
	}
	
}