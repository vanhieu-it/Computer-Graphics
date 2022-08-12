package menuLoader;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


import coordinateSystem.Point;
import coordinateSystem.Point3D;
import drawableObject.DashLine;
import drawableObject.Line;
import drawer.Drawer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Scene;

class Box{
	public Point3D A = new Point3D();
	public int length, width, height;
	
	public Box(Point3D p, int dai, int rong, int cao) {
		this.A.x = p.x;
		this.A.y = p.y;
		this.A.z = p.z;
		
		this.length = dai;
		this.width = rong;
		this.height = cao;
	}
	
	public ArrayList<Point3D> createListOf3DPoints(Point3D left_down_point){
		ArrayList<Point3D> list_of_points = new ArrayList<Point3D>();
		this.A.x = left_down_point.x;
		this.A.y = left_down_point.y;
		this.A.z = left_down_point.z;
		
		list_of_points.add(A);
		int x_A, y_A, z_A;
		x_A = this.A.x; y_A = this.A.y; z_A = this.A.z;
		
		// Generate points from the first left-down point
		Point3D B = new Point3D(x_A, y_A + this.width, z_A);
		Point3D C = new Point3D(x_A + this.length, y_A + this.width, z_A);
		Point3D D = new Point3D(x_A + this.length, y_A, z_A);
		Point3D E = new Point3D(x_A, y_A, z_A + this.height);
		Point3D F = new Point3D(x_A, y_A + this.width, z_A + this.height);
		Point3D G = new Point3D(x_A + this.length, y_A + this.width, z_A + this.height);
		Point3D H = new Point3D(x_A + this.length, y_A, z_A + this.height);
		
		// Add the rest points to the list in order to draw
		list_of_points.add(list_of_points.size(), B);
		list_of_points.add(list_of_points.size(), C);
		list_of_points.add(list_of_points.size(), D);
		list_of_points.add(list_of_points.size(), E);
		list_of_points.add(list_of_points.size(), F);
		list_of_points.add(list_of_points.size(), G);
		list_of_points.add(list_of_points.size(), H);
		
		return list_of_points;
	}
	
	public void show_point3D() {
		ArrayList<Point3D> list3D = createListOf3DPoints(this.A);
		for (Point3D point3d : list3D) {
			System.out.print(point3d.x + "; ");
			System.out.print(point3d.y + "; ");
			System.out.print(point3d.z);
			System.out.println();
		}
	}
	
	public Point convertPoint3DToPoint2D(Point3D point) {
		int X_p, Y_p, Z_p ;
		X_p = point.x; Y_p = point.y; Z_p = point.z;
		
		// Kill the Oy coordinate
		int X_p_2D = (int) (X_p - (Y_p * Math.sqrt(2) / 2));
		int Y_p_2D = (int) (Z_p - (Y_p * Math.sqrt(2) / 2));
		
		Point new_2D_point = new Point(X_p_2D, Y_p_2D);
		
		return new_2D_point;
	}
	
	public ArrayList<Point> convertList3DtoList2D(ArrayList<Point3D> list3D){
		ArrayList<Point> list2D= new ArrayList<Point>();
		
		for (Point3D point3d : list3D) {
			Point point2d = convertPoint3DToPoint2D(point3d);
			if(list2D.size() >= 0){
				list2D.add(list2D.size(), point2d);
			}
		}
		
		return list2D;
	}
	
	public void show_point2D() {
		ArrayList<Point> list2d = convertList3DtoList2D(createListOf3DPoints(this.A));
		for (Point point : list2d) {
			System.out.print(point.x + "; ");
			System.out.print(point.y);
			System.out.println();
		}
	}
}

public class Loader3D extends MenuLoaderInterface{
	public Loader3D(VBox content_box,Drawer drawer, ColorPicker color_picker) {
		super(content_box, drawer, color_picker);
		// TODO Auto-generated constructor stub
		//Contructor phai ke thua tu MenuLoaderInterface
	}

	public static String convertCoordinate3DToString(int x, int y, int z) {
		return "(" + x + "; " + y + "; " + z + ")";
	}
	
	public void createForm() {
		List<Window> open =  Stage.getWindows().stream().filter(Window::isShowing).collect(Collectors.toList());
		
		if(open.size() > 1) {
			return;
		}
		
		Button draw_b = new Button("Draw");
		Button reset_b = new Button("Reset");
		GridPane pane = new GridPane();
		
		Text left_point_t = new Text("Point A:");
		Text length_t = new Text("Length: ");
		Text width_t = new Text("Width: ");
		Text height_t = new Text("Height: ");
		Text points_info_t = new Text("Points info here:");
		Text Point_A = new Text("A: ");
		Text Point_B = new Text("B: ");
		Text Point_C = new Text("C: ");
		Text Point_D = new Text("D: ");
		Text Point_E = new Text("E: ");
		Text Point_F = new Text("F: ");
		Text Point_G = new Text("G: ");
		Text Point_H = new Text("H: ");
		
		
		TextField left_point_tf = new TextField();		left_point_tf.setPromptText("(x; y; z)");
		TextField length_tf = new TextField();			length_tf.setPromptText("Integer > 0");
		TextField width_tf = new TextField();			width_tf.setPromptText("Integer  > 0");
		TextField height_tf = new TextField();			height_tf.setPromptText("Integer > 0");
		
		TextField Point_A_tf = new TextField();	Point_A_tf.setEditable(false);	Point_A_tf.setPromptText("x; y; z");
		TextField Point_B_tf = new TextField();	Point_B_tf.setEditable(false);	Point_B_tf.setPromptText("x; y; z");
		TextField Point_C_tf = new TextField();	Point_C_tf.setEditable(false);	Point_C_tf.setPromptText("x; y; z");
		TextField Point_D_tf = new TextField();	Point_D_tf.setEditable(false);	Point_D_tf.setPromptText("x; y; z");
		TextField Point_E_tf = new TextField();	Point_E_tf.setEditable(false);	Point_E_tf.setPromptText("x; y; z");
		TextField Point_F_tf = new TextField();	Point_F_tf.setEditable(false);	Point_F_tf.setPromptText("x; y; z");
		TextField Point_G_tf = new TextField();	Point_G_tf.setEditable(false);	Point_G_tf.setPromptText("x; y; z");
		TextField Point_H_tf = new TextField();	Point_H_tf.setEditable(false);	Point_H_tf.setPromptText("x; y; z");
		
		pane.setMinSize(300, 400);
		pane.setPadding(new Insets(25, 25, 25, 25));
		pane.setVgap(10);
		pane.setHgap(10);
		pane.setAlignment(Pos.CENTER);
		
		pane.add(left_point_t, 0, 0);	pane.add(left_point_tf, 1, 0);
		pane.add(length_t, 0, 1);		pane.add(length_tf, 1, 1);
		pane.add(width_t, 0, 2);		pane.add(width_tf, 1, 2);
		pane.add(height_t, 0, 3);		pane.add(height_tf, 1, 3);
		pane.add(draw_b, 1, 4);			pane.add(points_info_t, 0, 5);
		pane.add(Point_A, 0, 6);		pane.add(Point_A_tf, 1, 6);
		pane.add(Point_B, 0, 7);		pane.add(Point_B_tf, 1, 7);
		pane.add(Point_C, 0, 8);		pane.add(Point_C_tf, 1, 8);
		pane.add(Point_D, 0, 9);		pane.add(Point_D_tf, 1, 9);
		pane.add(Point_E, 0, 10);		pane.add(Point_E_tf, 1, 10);
		pane.add(Point_F, 0, 11);		pane.add(Point_F_tf, 1, 11);
		pane.add(Point_G, 0, 12);		pane.add(Point_G_tf, 1, 12);
		pane.add(Point_H, 0, 13);		pane.add(Point_H_tf, 1, 13);
		
		pane.add(reset_b, 1, 14);
		draw_b.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		reset_b.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
		
		Scene scence = new Scene(pane);		
		Stage stage = new Stage();
		stage.setTitle("Box Properties");
		stage.setScene(scence);
		stage.show();
		
		draw_b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
            		if (left_point_tf.getText().trim().equals("") || length_tf.getText().trim().equals("") || 
                			width_tf.getText().trim().equals("") || height_tf.getText().trim().equals("")) {
                		Alert alert = new Alert(AlertType.WARNING);
                		alert.setContentText("Please fill all the information into the form");
                		alert.show();
                	}
            		if (Integer.parseInt(length_tf.getText())<= 0 ||Integer.parseInt(width_tf.getText())<= 0 || 
            		Integer.parseInt(height_tf.getText())<= 0){
            			Alert alert = new Alert(AlertType.WARNING);
                		alert.setContentText("Value must be integer that greater than 0 !");
                		alert.show();
            		}
                	else {
                		drawer.clear();
                    	contentBox.getChildren().clear();
                    	Color c = Color.YELLOW;
                    	drawer.draw(new Line(new Point(-70,-70),new Point(70,70), c));
                    	
                    	List<Integer> coordinate = extractNumbersRegexStyle(left_point_tf.getText());
                    	Point3D left_point_in = new Point3D(coordinate.get(0), coordinate.get(1), coordinate.get(2));
                    	int length = Integer.parseInt(length_tf.getText()), width = Integer.parseInt(width_tf.getText())
                    			, height = Integer.parseInt(height_tf.getText());
                    	
                    	Box box3d = new Box(left_point_in, length, width, height);
                    	ArrayList<Point3D> list3d = box3d.createListOf3DPoints(box3d.A);
                    	
                    	// display point 3d coordinate into form
                    	Point_A_tf.setText(convertCoordinate3DToString(list3d.get(0).x, list3d.get(0).y, list3d.get(0).z));
                		Point_B_tf.setText(convertCoordinate3DToString(list3d.get(1).x, list3d.get(1).y, list3d.get(1).z));
                		Point_C_tf.setText(convertCoordinate3DToString(list3d.get(2).x, list3d.get(2).y, list3d.get(2).z));
                		Point_D_tf.setText(convertCoordinate3DToString(list3d.get(3).x, list3d.get(3).y, list3d.get(3).z));
                		Point_E_tf.setText(convertCoordinate3DToString(list3d.get(4).x, list3d.get(4).y, list3d.get(4).z));
                		Point_F_tf.setText(convertCoordinate3DToString(list3d.get(5).x, list3d.get(5).y, list3d.get(5).z));
                		Point_G_tf.setText(convertCoordinate3DToString(list3d.get(6).x, list3d.get(6).y, list3d.get(6).z));
                		Point_H_tf.setText(convertCoordinate3DToString(list3d.get(7).x, list3d.get(7).y, list3d.get(7).z));
                    	
                		ArrayList<Point> list2d = box3d.convertList3DtoList2D(list3d);
                		
                		Point A = list2d.get(0);	Point B = list2d.get(1);
                		Point C = list2d.get(2);	Point D = list2d.get(3);
                		Point E = list2d.get(4);	Point F = list2d.get(5);
                		Point G = list2d.get(6);	Point H = list2d.get(7);
                		
                		// Execute drawing
                		drawer.draw(new DashLine(A, B,colorPicker.getValue()));
                		drawer.draw(new DashLine(A, D,colorPicker.getValue()));
                		drawer.draw(new DashLine(A, E,colorPicker.getValue()));
                		drawer.draw(new Line(B, C,colorPicker.getValue()));
                		
                		drawer.draw(new Line(B, F,colorPicker.getValue()));
                		
                		drawer.draw(new Line(C, D,colorPicker.getValue()));
                		drawer.draw(new Line(C, G,colorPicker.getValue()));
                		
                		drawer.draw(new Line(D, H,colorPicker.getValue()));
                		
                		drawer.draw(new Line(E, F,colorPicker.getValue()));
                		drawer.draw(new Line(E, H,colorPicker.getValue()));
                		
                		drawer.draw(new Line(F, G,colorPicker.getValue()));
                		
                		drawer.draw(new Line(G, H,colorPicker.getValue()));
                		
                		drawer.draw(new drawableObject.Text(new Point(A.x + 3, A.y + 3), "A", Color.BLACK));
                		drawer.draw(new drawableObject.Text(new Point(B.x - 3, B.y - 3), "B", Color.BLACK));
                		drawer.draw(new drawableObject.Text(new Point(C.x - 3, C.y - 3), "C", Color.BLACK));
                		drawer.draw(new drawableObject.Text(new Point(D.x + 3, D.y + 3), "D", Color.BLACK));
                		drawer.draw(new drawableObject.Text(new Point(E.x + 3, E.y + 3), "E", Color.BLACK));
                		drawer.draw(new drawableObject.Text(new Point(F.x - 3, F.y - 3), "F", Color.BLACK));
                		drawer.draw(new drawableObject.Text(new Point(G.x - 3, G.y - 3), "G", Color.BLACK));
                		drawer.draw(new drawableObject.Text(new Point(H.x + 3, H.y + 3), "H", Color.BLACK));
                    }
            	}
            	catch (IndexOutOfBoundsException e) {
					// TODO: handle exception
            		Alert alert = new Alert(AlertType.WARNING);
            		alert.setContentText("Please give the valid format value");
            		alert.show();
				}
            	catch (NumberFormatException e) {
					// TODO: handle exception
            		Alert alert = new Alert(AlertType.WARNING);
            		alert.setContentText("Value must be integer that greater than 0");
            		alert.show();
				}
            }
        });
		reset_b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	left_point_tf.setText(""); length_tf.setText("");
            	width_tf.setText(""); 	height_tf.setText("");
            	Point_A_tf.setText(""); Point_B_tf.setText("");
            	Point_C_tf.setText(""); Point_D_tf.setText("");
            	Point_E_tf.setText(""); Point_F_tf.setText("");
            	Point_G_tf.setText(""); Point_H_tf.setText("");
            }	
        });
	}
	
	public static List<Integer> extractNumbersRegexStyle(String str) {
		// Match either positive or negative numbers
	    List<String> arr = new ArrayList<>();
	    Pattern p = Pattern.compile("-?\\d+");
	    Matcher m = p.matcher(str);
	    while (m.find()) {
	        arr.add(m.group());
	    }
	    return arr.stream().map(Integer::parseInt).collect(Collectors.toList());
	}
	
	@Override
	public void init() {	
		// TODO Auto-generated method stub
		
		Color c = Color.YELLOW;
		drawer.draw(new Line(new Point(-70,-70),new Point(70,70),c));
		//Code o day 
		
		createForm();
	}
}