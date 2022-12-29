package controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import Services.CompteService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ControleurConsulterSolde implements Initializable {
	
	
	  @FXML
	    private TextField codeconsult;

	    @FXML
	    private Button buttonconsul;

	    @FXML
	    private Label soldeact;
 

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		buttonconsul.setOnAction(new EventHandler<ActionEvent>() {
	  		@Override
	  		public void handle(ActionEvent event) {
	  			int code=0;
	  			code= Integer.parseInt(codeconsult.getText());
	  			CompteService cs = new CompteService();
	  			soldeact.setText(""+cs.consulterSolde(code));
	  		}
	  	});	
	}

}
