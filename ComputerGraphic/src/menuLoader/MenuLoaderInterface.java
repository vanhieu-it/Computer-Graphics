package menuLoader;

import drawer.Drawer;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;

public abstract class MenuLoaderInterface {
	protected Drawer drawer;
	protected ColorPicker colorPicker;
	protected VBox contentBox;
	
	//Must Override
	protected MenuLoaderInterface(VBox content_box,Drawer drawer, ColorPicker color_picker) {
		this.drawer=drawer;
		this.colorPicker=color_picker;
		this.contentBox=content_box;
		
		drawer.clear();
		content_box.getChildren().clear();		
		
		init();
	};
	public abstract void init();
}
