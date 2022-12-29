package controleurs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class Scenecontroler {
	
	public static void changescene(ActionEvent event, String ficherfxml,String title, String username,String password, String comptes, String depots, String retrait) {
		Parent racine = null;
			if(username !=null && password !=null) {
				try {
					FXMLLoader loader=new FXMLLoader(Scenecontroler.class.getResource("/vues/"+ficherfxml));
					racine = loader.load();
					//TableaubordController tableaubordController=loader.getController();
					//tableaubordController.updateuserinfo(username, c.getDepot(), c.getRetrait());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else {
				try {
				racine=FXMLLoader.load(Scenecontroler.class.getResource("/vues/"+ficherfxml));
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			Stage stage= (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setTitle(title);
			stage.setScene(new Scene(racine));
			stage.show();
		}
	
	public static void Connecter(ActionEvent event, String username,String password) {
		Connection connexion = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
		connexion= modeles.DBConnexion.ConnexionToDB();
		System.out.println("Connexion etablie avec la base de donne");
		preparedStatement=connexion.prepareStatement("SELECT password FROM users WHERE username='"+username+"'");
		//preparedStatement.setString(1, username);
		resultSet=preparedStatement.executeQuery();
		System.out.println("effectue");
			if (!resultSet.isBeforeFirst()) {
				System.out.println("Username n'est pas dans la BD");
				Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Information sont incorrect! verifier et reessayer !");
				alert.setTitle("Information incorrect");
				alert.show();
			}else {
				while(resultSet.next()) {
					String Password=resultSet.getString("password");
					if(Password.equals(password)) {
						//loaddata(username);
						changescene(event, "dashbord.fxml", "DashBord", null, null, null, null, null);
					 
					}else {
						System.out.println("Mot de passe de correspond pas");
						Alert alert= new Alert(Alert.AlertType.INFORMATION);
						alert.setContentText("Information incorrect");
						alert.show();
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(resultSet!=null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
			if(preparedStatement!=null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
			if(connexion!=null) {
				try {
					connexion.close();
				} catch (SQLException e) {
					// TODO: handle exception
				}
			}
		}
		
	}

}
