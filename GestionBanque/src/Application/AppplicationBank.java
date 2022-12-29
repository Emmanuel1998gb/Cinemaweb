package Application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class AppplicationBank extends Application{
	
	@Override
	public void start(Stage stage) {
		try {
			Parent racine = FXMLLoader.load(getClass().getResource("/vues/Login.fxml"));
			Scene scene=new Scene(racine);
			stage.setScene(scene);
			stage.setTitle("login");
			stage.setResizable(false);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		launch(args);  //Starting GUI
	}
}
