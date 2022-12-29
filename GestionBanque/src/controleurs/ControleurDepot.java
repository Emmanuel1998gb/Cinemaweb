package controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import Services.CompteCourantService;
import Services.CompteService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControleurDepot implements Initializable {
	
	  @FXML
	    private Button buttondeposer;

	    @FXML
	    private TextField iddepot;

	    @FXML
	    private TextField idmontant;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 
		buttondeposer.setOnAction(new EventHandler<ActionEvent>() {
		  		@Override
		  		public void handle(ActionEvent event) {
		  			int code=0; double montant=0;
		  			code= Integer.parseInt(iddepot.getText());
		  			montant=Double.parseDouble(idmontant.getText());
		  			
		  			CompteService cs = new CompteService();
		  			boolean terminer=cs.verser(code, montant);
		  			if (terminer) {
		  			
			  			System.out.println("Depot effectue avec succes");
						Alert alert= new Alert(Alert.AlertType.INFORMATION);
						alert.setContentText("Transaction effectue avec succes");
						alert.show();
						Scenecontroler.changescene(event, "dashbord.fxml", "Dashbord", null, null, null, null, null);
		  			}
		  		
		  			}
		  	});
		
	}

}
