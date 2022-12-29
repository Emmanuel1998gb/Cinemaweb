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

public class ControleurVirement implements Initializable {

	@FXML
    private Button buttonvirer;

    @FXML
    private TextField codevir;

    @FXML
    private TextField montantvir;

    @FXML
    private TextField destvir;

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		buttonvirer.setOnAction(new EventHandler<ActionEvent>() {
	  		@Override
	  		public void handle(ActionEvent event) {
	  			int code1=0,code2=0; double montant=0;
	  			code1= Integer.parseInt(codevir.getText());
	  			code2= Integer.parseInt(destvir.getText());
	  			montant=Double.parseDouble(montantvir.getText());
	  			
	  			CompteService cs = new CompteService();
	  			int message=cs.virement(montant, code1, code2);
	  			if (message==2) {
	  			Scenecontroler.changescene(event, "dashbord.fxml", "Dashbord", null, null, null, null, null);
		  			System.out.println("Depot effectue avec succes");
					Alert alert= new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("Transaction effectue avec succes");
					alert.show();
	  			}else if(message==1) {
	  				Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Solde insufissant du compte numero :"+code1+" est inferieur au montant de virement. Le solde actuelle du compte "+code1+" est de:"+cs.consulterSolde(code1));
					alert.show();	
	  			}else if(message==3) {
	  				Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Le virement n'effectue qu'entre le compte de m�me type. Le compte compte1 est "+cs.checktype(code1)+"et le compte2 est "+cs.checktype(code2)+" ");
					alert.show();
	  			}else if(message==4) {
	  				Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Le virement n'effectue qu'entre deux compte different");
					alert.show();
	  			}
	  		
	  			}
	  	});
		
	}

}
