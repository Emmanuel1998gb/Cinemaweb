package controleurs;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class ControleurDashbord  implements Initializable{
	
	 @FXML
	    private Button idretirer;

	    @FXML
	    private Button idemprunt;

	    @FXML
	    private Button idexit;

	    @FXML
	    private Button iddeposer;

	    @FXML
	    private Button idvirement;

	    @FXML
	    private Button idconsult;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		idexit.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			Scenecontroler.changescene(event, "Login.fxml", "Login", null, null, null, null, null);
				
			}
		});
		
		iddeposer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			Scenecontroler.changescene(event, "depot.fxml", "Formulaire depot", null, null, null, null, null);
				
			}
		});
		
      idretirer.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			Scenecontroler.changescene(event, "retrait.fxml", "Formulaire retrait", null, null, null, null, null);
				
			}
		});
      
       idemprunt.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			Scenecontroler.changescene(event, "emprunt.fxml", "Formulaire d'emprunt", null, null, null, null, null);
				
			}
		});
       
       idconsult.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			Scenecontroler.changescene(event, "ConsulterSolde.fxml", "Formulaire consultation solde", null, null, null, null, null);
				
			}
		});
       
       idvirement.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
			Scenecontroler.changescene(event, "virement.fxml", "Formulaire de virement", null, null, null, null, null);
				
			}
		});
		
	}

}
