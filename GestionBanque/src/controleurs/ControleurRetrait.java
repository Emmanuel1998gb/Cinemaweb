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
import javafx.scene.control.TextField;

public class ControleurRetrait implements Initializable {
	
	@FXML
    private Button buttonretr;

    @FXML
    private TextField idretrait;

    @FXML
    private TextField montantretr;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		buttonretr.setOnAction(new EventHandler<ActionEvent>() {
	  		@Override
	  		public void handle(ActionEvent event) {
	  			int code=0; double montant=0;
	  			code= Integer.parseInt(idretrait.getText());
	  			montant=Double.parseDouble(montantretr.getText());
	  			
	  			CompteService cs = new CompteService();
	  			int codemessage=cs.retirer(code, montant);
	  			if(codemessage==2) {
	  				
	  				Scenecontroler.changescene(event,"dashbord.fxml", "Dashbord", null, null, null, null, null);
	  				Alert alert= new Alert(Alert.AlertType.INFORMATION);
	 				alert.setContentText("Retrait est effectuer avec succ�s");
	 				alert.setTitle("Information");
	 				alert.show();
	  			}
	  			else if(codemessage==3) {
	  				Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Le votre solde est insuffisant!. Solde actuelle :"+cs.get(code).getSolde());
					alert.setTitle("Information");
					alert.show();
	  			}
	  			else if(codemessage==1) {
	  				Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Il n'y a aucun compte portant le numero :"+code);
					alert.setTitle("Information");
					alert.show();
	  			}
	  			
	  		}
	  	});	
	}

}
