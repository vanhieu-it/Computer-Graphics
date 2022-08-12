package drawableObject;

import coordinateSystem.Point;
import drawer.Drawer;
import javafx.scene.paint.Color;

public class Text extends DrawableObject{
	private Point start;
	private String text;
	private	Color color; 
	
	public Text(Point start, String text, Color color) {
		this.start=start;
		this.text=text;
		this.color=color;
	}
	
	@Override
	public void drawSelf(Drawer drawer) {
		super.drawSelf(drawer);
		drawer.drawText(text, start.x, start.y,color);
	}
}