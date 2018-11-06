package sample;

import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import java.util.Random;

import org.w3c.dom.events.Event;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Rotation extends Application {

	static double x, y;
	static Stage stage;
	static Rotate rot;
	static BorderPane bp;
	static Group root;
	static Timeline secondTime, target;
	static double alpha, beta;

	@Override
	public void start(Stage primaryStage) throws
	Exception{
		x = 100;
		y = 200;
		rot = new Rotate();
		bp = new BorderPane();
		secondTime = new Timeline();
		target = new Timeline();
		alpha =-110;
		beta = -70;
		
		HBox hb = new HBox();
		hb.setPadding(new Insets(60,10,10,10));
		hb.setAlignment(Pos.BASELINE_CENTER);
		
		Text legend = new Text();
		legend.setText("Press SPACE when the line passes the orange part!");
		legend.setStrokeWidth(10);
	
		
		hb.getChildren().add(legend);
		bp.setTop(hb);

		root = new Group();
		primaryStage.setTitle("FIGHT");
		
		final Line line = new Line(x, y, 200, 200);
		line.setFill(Color.RED);
		line.setStrokeWidth(3);
		
		rot.setPivotX(200);
		rot.setPivotY(200);
	
	    line.getTransforms().add(rot);
	    
	    animation(line);

		Scene scene = new Scene(bp,400,400);	
		primaryStage.setScene(scene);
		primaryStage.show();
		double angle = 0;
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode()== KeyCode.SPACE) {
					secondTime.stop();
					checkAngle();					
				}
			}
		});
		
	}
	
	public boolean checkAngle() {
		System.out.println(rot.getAngle());
		if(rot.getAngle()>alpha+360 && rot.getAngle()<beta+360) {
			System.out.println(true);
			return true;
		}
		return false;
	}
	
	public void animation(Line line) {
		
	    final KeyValue kv = new KeyValue(rot.angleProperty(),360);
	    KeyFrame kf = new KeyFrame (Duration.millis(1500),kv);	
	    
	    Canvas canvas = new Canvas(400,400);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		drawCercle(gc);
		root.getChildren().addAll(canvas, line);
		bp.setCenter(root);		
	       
	    
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
		public static void main (String[] args) {
			launch(args);
		}
}
