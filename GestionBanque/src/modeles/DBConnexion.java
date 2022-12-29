package modeles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnexion {
public static Connection connexion;
public static Statement st ;
public static ResultSet resultSet;
	public static Connection ConnexionToDB() {
	String BDD = "db_bank";
	String lien = "jdbc:mysql://localhost:3306/" + BDD;
	String user = "root";
	String passwd = "";
	try {
		connexion=DriverManager.getConnection(lien,user,passwd);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return connexion;
	}
}
