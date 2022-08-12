package menuLoader;



import coordinateSystem.Point;
import drawableObject.Circle;
import drawableObject.Circle2;
import drawableObject.Ellipse;
import drawableObject.Line;
import drawableObject.LineWithCircle;
import drawableObject.Text;
import drawer.Drawer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import mainPane.Frame;



public class DemoLoader2D extends MenuLoaderInterface{
	public DemoLoader2D(VBox content_box,Drawer drawer, ColorPicker color_picker) {
		super(content_box,drawer, color_picker);
		// TODO Auto-generated constructor stub
		//Contructor phai ke thua tu MenuLoaderInterface
	}

	@Override
	public void init() {
		// init
		int n=-200;
		Text text =new Text(new Point(-55,-5),"VIỆT NAM", Color.rgb(255, 0, 0)) ;
		Text textToaDoTruoc1 =new Text(new Point(-65,-20),"(-65,-20)", Color.rgb(0, 0, 0)) ;
		Text textToaDoTruoc2 =new Text(new Point(40,40),"(40,40)", Color.rgb(0, 0, 0));
		
		Line lineHat1 = new  Line(new Point(-60,5),new Point(-40,5), Color.rgb(0,0,0));
		Line lineHat2 = new  Line(new Point(-60,5),new Point(-50,15), Color.rgb(0,0,0));
		Line lineHat3 = new  Line(new Point(-40,5),new Point(-50,15), Color.rgb(0,0,0));
		
		
		Circle head = new Circle(new Point(-50,-5), 10, Color.rgb(255, 0, 0));
		Circle2 bullet = new Circle2(new Point(-65,-20),null, 3, Color.rgb(0, 255, 255));
		Line lineGround = new Line(new Point(-70,-55), new Point(-20,-55),Color.rgb(185,122,7));
		Line lineBody=new Line(new Point(-50,-15),new Point(-50,-45), Color.rgb(0,0,0));
		Line lineHand11=new Line(new Point(-50,-20),new Point(-60,-25), Color.rgb(0,0,0));
		Line lineHand12=new Line(new Point(-60,-25),new Point(-65,-20), Color.rgb(0,0,0));
		Line lineHand2=new Line(new Point(-50,-20),new Point(-30,-5), Color.rgb(0,0,0));
		Line lineLeg1=new Line(new Point(-50,-45),new Point(-45,-55), Color.rgb(0,0,0));
		Line lineLeg2=new Line(new Point(-50,-45),new Point(-55,-55), Color.rgb(0,0,0));
		
		Line line1 = new  Line(new Point(-26,-2),new Point(-29,-2), Color.rgb(0,0,0));
		Line line2 = new  Line(new Point(-26,-2),new Point(-26,-12), Color.rgb(0,0,0));
		Line line3 = new  Line(new Point(-29,-2),new Point(-29,-12), Color.rgb(0,0,0));
		Line line4 = new  Line(new Point(-26,-12),new Point(-29,-12), Color.rgb(0,0,0));
		Line line5 = new  Line(new Point(-26,-2),new Point(-24,1), Color.rgb(0,0,0));
		Line line6 = new  Line(new Point(-29,-2),new Point(-31,1), Color.rgb(0,0,0));
		LineWithCircle line7 = new  LineWithCircle(new Point(-24,1),bullet, Color.rgb(0,0,0));
		LineWithCircle line8 = new  LineWithCircle(new Point(-31,1),bullet, Color.rgb(0,0,0));
		float moveXSpeedPerSec=30;
		float moveYSpeedPerSec=20;
		float radianPerSec=1f;
		// animation
		Timeline demoAnimate=new Timeline();
		demoAnimate.getKeyFrames().addAll(
				new KeyFrame(Duration.seconds(1),e -> {
					bullet.addTimelineTranform(new float[][] {
						{1,0,0},
						{0,1,0},
						{(float) (Frame.deltaTime*moveXSpeedPerSec),(float) (Frame.deltaTime*moveYSpeedPerSec),1}
					});
				}),
				new KeyFrame(Duration.seconds(2),e -> {
					drawer.remove(line7);
					drawer.remove(line8);
				}),
				new KeyFrame(Duration.seconds(3.4),e -> {
					bullet.clearTimelineTransform();
					bullet.addTimelineTranform(new float[][] {
						{1,0,0},
						{0,1,0},
						{(float) (Frame.deltaTime*0),(float) (Frame.deltaTime*-25),1}
					});
				}),
				new KeyFrame(Duration.seconds(5),e -> {
					bullet.clearTimelineTransform();
				})
		);
		// draw
		drawer.draw(head);
		drawer.draw(lineBody);
		drawer.draw(lineHand11);
		drawer.draw(lineHand12);
		drawer.draw(lineHand2);
		drawer.draw(lineLeg1);
		drawer.draw(lineLeg2);
		drawer.draw(bullet);
		drawer.draw(lineGround);
		drawer.draw(line1);
		drawer.draw(line2);
		drawer.draw(line3);
		drawer.draw(line4);
		drawer.draw(line5);
		drawer.draw(line6);
		drawer.draw(line7);
		drawer.draw(line8);
		drawer.draw(text);
		drawer.draw(lineHat1);
		drawer.draw(lineHat2);
		drawer.draw(lineHat3);
		drawer.draw(textToaDoTruoc1);
		drawer.draw(textToaDoTruoc2);
		demoAnimate.play();
		
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

		Circle2 circle = new Circle2(new Point(40,40),null,10,Color.rgb(54, 117, 23));
		
		Ellipse elipD1=new Ellipse(new Point(40,20),8,3,Color.rgb(226, 135, 14));
		Ellipse elipD2=new Ellipse(new Point(40,60),8,3,Color.rgb(226, 135, 14));
		Ellipse elipD3=new Ellipse(new Point(20,40),8,3,Color.rgb(226, 135, 14));
		Ellipse elipD4=new Ellipse(new Point(60,40), 8, 3, Color.rgb(226, 135, 14));
		
//		drawer.remove(draw_object); Xoa ra khoi danh sach ve
		Text text2 =new Text(new Point(45,-47),"CORONA",Color.rgb(0, 0, 0)) ;//Ve text 
		float[][] trai =new float[][] {{1,0,0},{0,1,0},{-1,0,1}};
		float[][] phai =new float[][] {{1,0,0},{0,1,0},{1,0,1}};
		float[][] roi =new float[][] {{(float)Math.cos((Math.PI)/n),(float)Math.sin((Math.PI)/n),0},{(float)-Math.sin((Math.PI)/n),(float)Math.cos((Math.PI)/n),0},{0,0,1}};
		float[][] roi1 =new float[][] {{1,0,0},{0,1,0},{0,-1,1}};
		//Animation
		Timeline demoAnimate1=new Timeline();
		demoAnimate1.getKeyFrames().addAll(
		new KeyFrame(Duration.seconds(1),e -> {
		
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
				new KeyFrame(Duration.seconds(2.5),e ->   {
					
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
				
				new KeyFrame(Duration.seconds(2.5),e -> {

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
				new KeyFrame(Duration.seconds(3.8),e ->   {
					
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
				new KeyFrame(Duration.seconds(3.8),e -> {


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
				new KeyFrame(Duration.seconds(5),e -> {


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
				new KeyFrame(Duration.seconds(5.2),e ->   {
					
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
				new KeyFrame(Duration.seconds(5.5),e -> {
					drawer.draw(lineX);
					drawer.draw(lineX1);
					drawer.draw(lineX2);
					drawer.draw(line);
					drawer.draw(lineR);
					drawer.draw(lineL);
					drawer.draw(text2);
					
					Text textToaDoSau1 =new Text(new Point((int)bullet.x,(int)bullet.y),"("+String.valueOf((int)bullet.x)+","+String.valueOf((int)bullet.y)+")", Color.rgb(0, 0, 0)) ;
					Text textToaDoSau2 =new Text(new Point((int)circle.x,(int)circle.y),"("+String.valueOf((int)circle.x)+","+String.valueOf((int)circle.y)+")", Color.rgb(0, 0, 0));
					
					drawer.draw(textToaDoSau1);
					drawer.draw(textToaDoSau2);
				})
					
		);
	

//		elipD3.rotate(20,40, (Math.PI)/2);
//		elipD4.rotate(60, 40, (Math.PI)/2);
		drawer.draw(circle);
		
		
		drawer.draw(elipD1);
		drawer.draw(elipD2);
		drawer.draw(elipD3);
		drawer.draw(elipD4);
		drawer.draw(lineN1);
		drawer.draw(lineN2);
		drawer.draw(lineD1);
		drawer.draw(lineD2);

		
	
		demoAnimate1.play();;
	}

}