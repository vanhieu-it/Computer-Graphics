package drawableObject;

import coordinateSystem.Point;
import coordinateSystem.Transform;
import drawer.Drawer;
import javafx.scene.paint.Color;

public class Ellipse extends DrawableObject{
	private Point center;
	private int rx,ry;
	private Color color;
	public Ellipse(Point center, int rx, int ry, Color color) {
		this.center=center;
		this.rx=rx;
		this.ry=ry;
		this.color=color;
	}
	@Override
	public void drawSelf(Drawer drawer) {
		super.drawSelf(drawer);
		
		int xc=center.x;
		int yc=center.y;
		
		float dx, dy, d1, d2, x, y; 
		x = 0; 
		y = ry; 

		// Initial decision parameter of region 1 
		d1 = (float) ((ry * ry) - (rx * rx * ry) + 
						(0.25 * rx * rx)); 
		dx = 2 * ry * ry * x; 
		dy = 2 * rx * rx * y; 

		// For region 1 
		while (dx < dy) 
		{ 
			
			float[] ret=Transform.transform3x3(x+xc,y+yc, tranformMatrix);
			drawer.putPixel(ret[0],ret[1],this.color);
			
			ret=Transform.transform3x3(-x+xc,y+yc, tranformMatrix);
			drawer.putPixel(ret[0],ret[1],this.color);
			
			ret=Transform.transform3x3(x+xc,-y+yc, tranformMatrix);
			drawer.putPixel(ret[0],ret[1],this.color);
			
			ret=Transform.transform3x3(-x+xc,-y+yc, tranformMatrix);
			drawer.putPixel(ret[0],ret[1],this.color);
			
			// Print points based on 4-way symmetry 
//			cout << x + xc << " , " << y + yc << endl; 
//			cout << -x + xc << " , " << y + yc << endl; 
//			cout << x + xc << " , " << -y + yc << endl; 
//			cout << -x + xc << " , " << -y + yc << endl; 

			// Checking and updating value of 
			// decision parameter based on algorithm 
			if (d1 < 0) 
			{ 
				x++; 
				dx = dx + (2 * ry * ry); 
				d1 = d1 + dx + (ry * ry); 
			} 
			else
			{ 
				x++; 
				y--; 
				dx = dx + (2 * ry * ry); 
				dy = dy - (2 * rx * rx); 
				d1 = d1 + dx - dy + (ry * ry); 
			} 
		} 

		// Decision parameter of region 2 
		d2 = (float) (((ry * ry) * ((x + 0.5) * (x + 0.5))) + 
			((rx * rx) * ((y - 1) * (y - 1))) - 
			(rx * rx * ry * ry)); 

		// Plotting points of region 2 
		while (y >= 0) 
		{ 
			
			float[] ret=Transform.transform3x3(x+xc,y+yc, tranformMatrix);
			drawer.putPixel(ret[0],ret[1],this.color);
			
			ret=Transform.transform3x3(-x+xc,y+yc, tranformMatrix);
			drawer.putPixel(ret[0],ret[1],this.color);
			
			ret=Transform.transform3x3(x+xc,-y+yc, tranformMatrix);
			drawer.putPixel(ret[0],ret[1],this.color);
			
			ret=Transform.transform3x3(-x+xc,-y+yc, tranformMatrix);
			drawer.putPixel(ret[0],ret[1],this.color);
	         
			// Print points based on 4-way symmetry 
//			cout << x + xc << " , " << y + yc << endl; 
//			cout << -x + xc << " , " << y + yc << endl; 
//			cout << x + xc << " , " << -y + yc << endl; 
//			cout << -x + xc << " , " << -y + yc << endl; 

			// Checking and updating parameter 
			// value based on algorithm 
			if (d2 > 0) 
			{ 
				y--; 
				dy = dy - (2 * rx * rx); 
				d2 = d2 + (rx * rx) - dy; 
			} 
			else
			{ 
				y--; 
				x++; 
				dx = dx + (2 * ry * ry); 
				dy = dy - (2 * rx * rx); 
				d2 = d2 + dx - dy + (rx * rx); 
			} 
		} 
	} 


}
