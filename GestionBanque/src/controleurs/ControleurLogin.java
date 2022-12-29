package controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleurLogin implements Initializable {
	
	  @FXML
	    private TextField username;

	    @FXML
	    private PasswordField password;
	    @FXML
	    private Button bLogin;
	    
	    public static String username0;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		System.out.println("Okay");
		bLogin.setOnAction(new EventHandler<ActionEvent>() {
	
			@Override
			public void handle(ActionEvent event) {
			Scenecontroler.Connecter(event, username.getText(), password.getText());
				
			}
		});
		
	
	} 
}
