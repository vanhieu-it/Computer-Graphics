package menuLoader;

import coordinateSystem.Point;
import drawableObject.Circle;
import drawableObject.Ellipse;
import drawableObject.Line;
import drawableObject.Text;
import drawableObject.*;
import drawer.Drawer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import mainPane.Frame;
import coordinateSystem.*;



public class Loader2D extends MenuLoaderInterface{
	public Loader2D(VBox content_box,Drawer drawer, ColorPicker color_picker) {
		super(content_box,drawer, color_picker);
		// TODO Auto-generated constructor stub
		//Contructor phai ke thua tu MenuLoaderInterface
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		Line l1 = new Line(new Point(32,-20), new Point(47,-35), Color.rgb(223, 0, 41));
		Line l2 = new Line(new Point(47,-35), new Point(67,-15), Color.rgb(223, 0, 41));
		
		Line line = new Line(new Point(20,-45), new Point(80,-45), Color.rgb(223, 0, 41));
		Line lineL= new Line(new Point(20,-45), new Point(20,5), Color.rgb(223, 0, 41));
		Line lineR= new Line(new Point(80,5), new Point(80,-45), Color.rgb(223, 0, 41));
		Line lineX= new Line(new Point(20,5), new Point(80,5), Color.rgb(223, 0, 41));
		Line lineX1= new Line(new Point(20,-45), new Point(80,5), Color.rgb(223, 0, 41));
		Line lineX2= new Line(new Point(20,5), new Point(80,-45), Color.rgb(223, 0, 41));
		
		Line lineN1=new Line(new Point(30,40), new Point(23,40), Color.rgb(60, 50, 0));
		Line lineN2=new Line(new Point(50,40),new Point(57,40),Color.rgb(60, 50, 0));
		Line lineD1=new Line(new Point(40,50),new Point(40,57),Color.rgb(60, 50, 0));
		Line lineD2=new Line(new Point(40,30),new Point(40,23),Color.rgb(60, 50, 0));

		Circle circle = new Circle(new Point(40,40),10,Color.rgb(54, 117, 23));
		
		Ellipse elipD1=new Ellipse(new Point(40,20),8,3,Color.rgb(226, 135, 14));
		Ellipse elipD2=new Ellipse(new Point(40,60),8,3,Color.rgb(226, 135, 14));
		Ellipse elipD3=new Ellipse(new Point(20,40),8,3,Color.rgb(226, 135, 14));
		Ellipse elipD4=new Ellipse(new Point(60,40), 8, 3, Color.rgb(226, 135, 14));
		
//		drawer.remove(draw_object); Xoa ra khoi danh sach ve
		Text text =new Text(new Point(45,-47),"CORONA",Color.rgb(0, 0, 0)) ;//Ve text 
		int n=-200;
		float[][] trai =new float[][] {{1,0,0},{0,1,0},{-1,0,1}};
		float[][] phai =new float[][] {{1,0,0},{0,1,0},{1,0,1}};
		float[][] roi =new float[][] {{(float)Math.cos((Math.PI)/n),(float)Math.sin((Math.PI)/n),0},{(float)-Math.sin((Math.PI)/n),(float)Math.cos((Math.PI)/n),0},{0,0,1}};
		float[][] roi1 =new float[][] {{1,0,0},{0,1,0},{0,-1,1}};
		float[][] phongto = new float[][] {{(float) 0.988,0,0},{0,(float)1,0},{0,0,1}};
		float[][] doixungOy = new float[][] {{-1,0,0},{0,1,0},{0,0,1}};
		//Animation
		Timeline demoAnimate=new Timeline();
		demoAnimate.getKeyFrames().addAll(
				new KeyFrame(Duration.seconds(1),e -> {
					
					circle.addTimelineTranform(doixungOy);
					lineD1.addTimelineTranform(doixungOy);
					lineD2.addTimelineTranform(doixungOy);
					lineN1.addTimelineTranform(doixungOy);
					lineN2.addTimelineTranform(doixungOy);
					
					elipD1.addTimelineTranform(doixungOy);
					elipD2.addTimelineTranform(doixungOy);
					elipD3.addTimelineTranform(doixungOy);
					elipD4.addTimelineTranform(doixungOy);
					
				}),
					
				new KeyFrame(Duration.seconds(1.8),e ->   {
					
					circle.removeTimelineTransform(0);
					lineD1.removeTimelineTransform(0);
					lineD2.removeTimelineTransform(0);
					lineN1.removeTimelineTransform(0);
					lineN2.removeTimelineTransform(0);
					elipD1.removeTimelineTransform(0);
					elipD2.removeTimelineTransform(0);
					elipD3.removeTimelineTransform(0);
					elipD4.removeTimelineTransform(0);		

				})
				,
				new KeyFrame(Duration.seconds(2),e -> {
			
					circle.addTimelineTranform(trai);
					lineD1.addTimelineTranform(trai);
					lineD2.addTimelineTranform(trai);
					lineN1.addTimelineTranform(trai);
					lineN2.addTimelineTranform(trai);
					
					elipD1.addTimelineTranform(trai);
					elipD2.addTimelineTranform(trai);
					elipD3.addTimelineTranform(trai);
					elipD4.addTimelineTranform(trai);
				
				})
				,
				new KeyFrame(Duration.seconds(3.5),e ->   {
					
					circle.removeTimelineTransform(0);
					lineD1.removeTimelineTransform(0);
					lineD2.removeTimelineTransform(0);
					lineN1.removeTimelineTransform(0);
					lineN2.removeTimelineTransform(0);
					elipD1.removeTimelineTransform(0);
					elipD2.removeTimelineTransform(0);
					elipD3.removeTimelineTransform(0);
					elipD4.removeTimelineTransform(0);		

				})
				,
				
				new KeyFrame(Duration.seconds(3.5),e -> {

					circle.addTimelineTranform(phai);
					lineD1.addTimelineTranform(phai);
					lineD2.addTimelineTranform(phai);
					lineN1.addTimelineTranform(phai);
					lineN2.addTimelineTranform(phai);

					elipD1.addTimelineTranform(phai);
					elipD2.addTimelineTranform(phai);
					elipD3.addTimelineTranform(phai);
					elipD4.addTimelineTranform(phai);

				})
				,
				new KeyFrame(Duration.seconds(5),e ->   {
					
					circle.removeTimelineTransform(0);
					lineD1.removeTimelineTransform(0);
					lineD2.removeTimelineTransform(0);
					lineN1.removeTimelineTransform(0);
					lineN2.removeTimelineTransform(0);
					
					elipD1.removeTimelineTransform(0);
					elipD2.removeTimelineTransform(0);
					elipD3.removeTimelineTransform(0);
					elipD4.removeTimelineTransform(0);

				})
				,
				// test
				new KeyFrame(Duration.seconds(5),e -> {


//					circle.addTimelineTranform(phongto);
					lineD1.addTimelineTranform(phongto);
					lineD2.addTimelineTranform(phongto);
					lineN1.addTimelineTranform(phongto);
					lineN2.addTimelineTranform(phongto);

					elipD1.addTimelineTranform(phongto);
					elipD2.addTimelineTranform(phongto);
					elipD3.addTimelineTranform(phongto);
					elipD4.addTimelineTranform(phongto);
					System.out.print("Maximize");

				}),
				
				new KeyFrame(Duration.seconds(6),e ->   {
					
//					circle.removeTimelineTransform(0);
					lineD1.removeTimelineTransform(0);
					lineD2.removeTimelineTransform(0);
					lineN1.removeTimelineTransform(0);
					lineN2.removeTimelineTransform(0);
					
					elipD1.removeTimelineTransform(0);
					elipD2.removeTimelineTransform(0);
					elipD3.removeTimelineTransform(0);
					elipD4.removeTimelineTransform(0);
					System.out.print("Remove");

				})
				,
				//
				new KeyFrame(Duration.seconds(6),e -> {


					circle.addTimelineTranform(roi);
					lineD1.addTimelineTranform(roi);
					lineD2.addTimelineTranform(roi);
					lineN1.addTimelineTranform(roi);
					lineN2.addTimelineTranform(roi);

					elipD1.addTimelineTranform(roi);
					elipD2.addTimelineTranform(roi);
					elipD3.addTimelineTranform(roi);
					elipD4.addTimelineTranform(roi);
				
				})
				,
				new KeyFrame(Duration.seconds(7),e ->   {
					
					circle.removeTimelineTransform(0);
					lineD1.removeTimelineTransform(0);
					lineD2.removeTimelineTransform(0);
					lineN1.removeTimelineTransform(0);
					lineN2.removeTimelineTransform(0);
					
					elipD1.removeTimelineTransform(0);
					elipD2.removeTimelineTransform(0);
					elipD3.removeTimelineTransform(0);
					elipD4.removeTimelineTransform(0);

				})
				,
				new KeyFrame(Duration.seconds(7),e -> {


					circle.addTimelineTranform(roi1);
					lineD1.addTimelineTranform(roi1);
					lineD2.addTimelineTranform(roi1);
					lineN1.addTimelineTranform(roi1);
					lineN2.addTimelineTranform(roi1);

					elipD1.addTimelineTranform(roi1);
					elipD2.addTimelineTranform(roi1);
					elipD3.addTimelineTranform(roi1);
					elipD4.addTimelineTranform(roi1);

				})
				,
				new KeyFrame(Duration.seconds(8),e ->   {
					
					circle.removeTimelineTransform(0);
					lineD1.removeTimelineTransform(0);
					lineD2.removeTimelineTransform(0);
					lineN1.removeTimelineTransform(0);
					lineN2.removeTimelineTransform(0);
					
					elipD1.removeTimelineTransform(0);
					elipD2.removeTimelineTransform(0);
					elipD3.removeTimelineTransform(0);
					elipD4.removeTimelineTransform(0);

				})
				,

				new KeyFrame(Duration.seconds(7.8),e ->   {
					drawer.remove(elipD1);
					drawer.remove(elipD2);
					drawer.remove(elipD3);
					drawer.remove(elipD4);
					drawer.remove(circle);

					drawer.remove(lineD1);
					drawer.remove(lineD2);
					drawer.remove(lineN2);
					drawer.remove(lineN1);
					drawer.remove(lineX1);
					drawer.remove(lineX2);
					
					drawer.draw(l1);
					drawer.draw(l2);
					
				})
				,
				new KeyFrame(Duration.seconds(7),e -> {
					drawer.draw(lineX);
					drawer.draw(lineX1);
					drawer.draw(lineX2);
					
				})
					
		);
	

//		elipD3.rotate(20,40, (Math.PI)/2);
//		elipD4.rotate(60, 40, (Math.PI)/2);
		drawer.draw(circle);
		drawer.draw(text);
		
		drawer.draw(elipD1);
		drawer.draw(elipD2);
		drawer.draw(elipD3);
		drawer.draw(elipD4);
		drawer.draw(lineN1);
		drawer.draw(lineN2);
		drawer.draw(lineD1);
		drawer.draw(lineD2);

		drawer.draw(line);
		drawer.draw(lineR);
		drawer.draw(lineL);
	
		demoAnimate.play();
		
//		
		
		//Code o day 
	}

	

}