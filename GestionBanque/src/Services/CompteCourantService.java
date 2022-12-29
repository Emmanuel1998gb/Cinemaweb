//CLASSE COMPTE COURANT 

 package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import DAO.CompteCourantDAO;
import modeles.CompteCourant;
import modeles.DBConnexion;

public class CompteCourantService implements CompteCourantDAO{
	
			


			@Override
			public double getDecouvert(int code) {
				double dec=0;
				Statement st=DBConnexion.st;
				Connection connexion=DBConnexion.connexion;
				ResultSet resultSet=DBConnexion.resultSet;
				try {
				connexion=DBConnexion.ConnexionToDB();
				resultSet=st.executeQuery("SELECT * FROM users WHERE code='"+code+"'");
				System.out.println("Connexion etablie avec la base de donne");
					while(resultSet.next()) {
						dec=(resultSet.getDouble("decouvert"));
										
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
					if(st!=null) {
						try {
							st.close();
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
			
				return dec;
			}


			public CompteCourantService() {
				super();
				// TODO Auto-generated constructor stub
			}


			@Override
			public CompteCourant get(Integer id) {
				// TODO Auto-generated method stub
				return null;
			}


			@Override
			public List<CompteCourant> getAll() {
				// TODO Auto-generated method stub
				return null;
			}


			@Override
			public void alter(Integer id) {
				// TODO Auto-generated method stub
				
			}


			@Override
			public boolean save(CompteCourant o) {
				// TODO Auto-generated method stub
			return false;	
			}


			@Override
			public void update(Integer id, CompteCourant o) {
				// TODO Auto-generated method stub
				
			}


			@Override
			public void delete(CompteCourant o) {
				// TODO Auto-generated method stub
				
			}
			
	
}