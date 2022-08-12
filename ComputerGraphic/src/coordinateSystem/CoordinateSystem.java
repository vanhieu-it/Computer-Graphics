package coordinateSystem;

import javafx.scene.canvas.Canvas;

public class CoordinateSystem {
	public static Point center;
	public static int width, height;
	public static final int SPACE_SCREEN_RATIO=5;
	public static CoordinateSystem instance;
	private CoordinateSystem(Canvas root) {
		width=(int)root.getWidth();
		height=(int)root.getHeight();
		center=new Point(width/2,height/2);
	}
	public static void init(Canvas root) {
		instance=new CoordinateSystem(root);
	}
	
	public static int round(float val) {
		int ret=(int)Math.round(val);
	    return ret;
	}
	
	public static  Point spaceToScreen(float x ,float y) {
		int retX=round(center.x+x*SPACE_SCREEN_RATIO);
		int retY=round(center.y-y*SPACE_SCREEN_RATIO);
		return new Point(retX,retY);
	}
	public static  Point screenToSpace(Point p) {
		return new Point((p.x-center.x)/SPACE_SCREEN_RATIO,(-p.y+center.y)/SPACE_SCREEN_RATIO);
	}
	

	
	
}
