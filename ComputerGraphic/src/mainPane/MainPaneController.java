package mainPane;

import coordinateSystem.CoordinateSystem;
import coordinateSystem.Point;
import drawableObject.Line;
import drawer.Drawer;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Menu;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import menuLoader.DemoLoader2D;
import menuLoader.Loader2D;
import menuLoader.Loader3D;

public class MainPaneController {
	@FXML Canvas canvas_content;
	@FXML VBox fuction_content;
	@FXML ColorPicker color_picker;
	
	@FXML Button button_2d;
	@FXML Button button_demo2d;
	@FXML Button button_3d;

	
	
	
	
	@FXML
	private void initialize() {
		//Static init//
		CoordinateSystem.init(canvas_content);
		Frame.deltaTime=0;
		
		
		
		
		//Drawer
		Drawer drawer=new Drawer(canvas_content.getGraphicsContext2D());
		
		
		
		button_2d.setOnAction((e)->{new Loader2D(fuction_content,drawer,color_picker);});
		button_demo2d.setOnAction((e)->{new DemoLoader2D(fuction_content,drawer,color_picker);});
		button_3d.setOnAction((e)->{new Loader3D(fuction_content,drawer,color_picker);});
		
	
		//Start render
		new AnimationTimer() {
		       @Override public void handle(long currentNanoTime) {
		    	   canvas_content.getGraphicsContext2D().clearRect(0, 0, canvas_content.getWidth(),canvas_content.getHeight());
		    	   
		    	   
			    	 //For testing
			   		for(int i=0;i<(int)canvas_content.getWidth()/ CoordinateSystem.SPACE_SCREEN_RATIO;i++) {
			   			if(i==(int)canvas_content.getWidth()/ CoordinateSystem.SPACE_SCREEN_RATIO/2) {
			   				canvas_content.getGraphicsContext2D().setStroke(Color.YELLOW);
			   			}
			   			else
			   			{
			   				canvas_content.getGraphicsContext2D().setStroke(Color.AZURE);
			   			}
			   			canvas_content.getGraphicsContext2D().strokeLine(i*CoordinateSystem.SPACE_SCREEN_RATIO,0,i*CoordinateSystem.SPACE_SCREEN_RATIO,canvas_content.getHeight());
			   		}
			   		for(int i=0;i<(int)canvas_content.getHeight()/5;i++) {
			   			if(i==(int)canvas_content.getHeight()/ CoordinateSystem.SPACE_SCREEN_RATIO/2) {
			   				canvas_content.getGraphicsContext2D().setStroke(Color.YELLOW);
			   			}
			   			else
			   			{
			   				canvas_content.getGraphicsContext2D().setStroke(Color.AZURE);
			   			}
			   			
			   			canvas_content.getGraphicsContext2D().strokeLine(0,i*CoordinateSystem.SPACE_SCREEN_RATIO,canvas_content.getWidth(),i*CoordinateSystem.SPACE_SCREEN_RATIO);
			   		}
		   		
		   		
			   		
		    	   	
		    	   	if(Frame.deltaTime==0) Frame.deltaTime=0.001;
		    	   	else Frame.deltaTime=(currentNanoTime-Frame.lastFrameTime)/1e9;
		    	   	
		        	drawer.render();
		            
		        
		           
		            
		        	//update time frame
		        	Frame.lastFrameTime=currentNanoTime;
		       } 
		 }.start();
		
	}
}
