import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainPane.MainPaneController;

public class MainApplication extends Application {
	public static void main(String args[]) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainPane/MainPane.fxml"));
		fxmlLoader.setController(new MainPaneController());
		arg0.setScene(new Scene(fxmlLoader.load()));
		arg0.setTitle("Computer Graphic");
		arg0.show();
	}
}	