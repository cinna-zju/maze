package View;

import Model.Maze;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.Random;


public class Rotation extends BorderPane {

	public static double x, y;
	public static Rotate rot;
	public static Group root;
	public static Timeline secondTime, target;
	public static double alpha, beta;
	public ImageView ch, monster;

	public Rotation() {

		x = 100;
		y = 200;
		rot = new Rotate();
		secondTime = new Timeline();
		target = new Timeline();
		alpha =-110;
		beta = -70;
		


		
	}

	public void init(){
        HBox hb = new HBox();
        hb.setPadding(new Insets(10,10,10,10));
        hb.setAlignment(Pos.BASELINE_CENTER);

        Text legend = new Text();
        legend.setText("Press SPACE when the line passes the orange part!");
        legend.setStrokeWidth(10);

        ch = new ImageView(Maze.ch.ava64);
        monster = new ImageView(new Image("/img/monster.png"));


        HBox imgs = new HBox(ch, monster);
        imgs.setSpacing(180);


        hb.getChildren().add(legend);

        this.setTop(new VBox(hb, imgs));

        root = new Group();
//		primaryStage.setTitle("FIGHT");

        final Line line = new Line(x, y, 200, 200);
        line.setFill(Color.RED);
        line.setStrokeWidth(3);

        rot.setPivotX(200);
        rot.setPivotY(200);

        line.getTransforms().add(rot);

        animation(line);

//		primaryStage.setScene(scene);
//		primaryStage.show();

        double angle = 0;

    }
	

	
	public void animation(Line line) {
		
	    final KeyValue kv = new KeyValue(rot.angleProperty(),360);
	    KeyFrame kf = new KeyFrame (Duration.millis(1500),kv);	
	    
	    Canvas canvas = new Canvas(400,400);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawCercle(gc);
		root.getChildren().addAll(canvas, line);
		this.setCenter(root);
	       
	    
	  secondTime.getKeyFrames().addAll(kf);
	  secondTime.setCycleCount(secondTime.INDEFINITE);
	  secondTime.play();

	}
	
	public void drawCercle(GraphicsContext gc) {
		
		Random r = new Random();
		Random rInt = new Random();
		gc.setFill(Color.ALICEBLUE);
		gc.fillArc(100, 100, 200, 200, beta, 320, ArcType.ROUND);
		
		//Target
		gc.setFill(Color.CORAL);
		gc.setLineWidth(3);
		gc.fillArc(100, 100, 200, 200, alpha, 40, ArcType.ROUND);
		
		// Trying to do random changes here...
		//
		//KeyValue kvTarget = new KeyValue(alpha, alpha + r.nextDouble());
		//KeyFrame kfTarge = new KeyFrame(Duration.seconds(r.nextInt()),kvTarget, Interpolator.DISCRETE);
		
		
		gc.setFill(Color.BLACK);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(4);
		
	}
}
