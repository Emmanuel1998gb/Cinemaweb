package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import DAO.ComptesDAO;
import DAO.VersementDAO;
import controleurs.ControleurLogin;
import javafx.scene.control.Alert;
import modeles.Compte;
import modeles.CompteCourant;
import modeles.CompteEpargne;
import modeles.DBConnexion;
import modeles.Emprunter;
import modeles.Retrait;
import modeles.Versement;

public class CompteService implements ComptesDAO{
	
		public VersementDAO versementDAO;
		public ComptesDAO comptesDAO; 
	
	//verser et mettre a jour le sode dans la base de donnee // Deja fini
	@Override	
	public boolean verser(int code,double montant) {
			VersementService service= new VersementService();
			UsersService us = new UsersService();
		  Compte c=get(code);
		  if (c!=null){
		  c.setSolde(c.getSolde()+montant);
		  updateSolde(code, c.getSolde());
		  Versement v = new Versement(0, new Date(), montant, ControleurLogin.username0, code);
		  service.save(v);
		  return true;
		  }
		return false;
	  }
	//virement d'un compte a un autre
	@Override
	public int virement(double montant, int code1, int code2) {
		int message=0;
		if(checktype(code1).equals(checktype(code2)) && code1!=code2) {
			int message1=retirer(code1, montant);
		  boolean message2=verser(code2, montant);
			  if (message1==2 && message2==true) {
				  message=2;
				  System.out.println("Virement effectue");
			  }else {
				  System.out.println("Le solde du premier compte est inferieur au montant a virer");
				  message=1;
				    }
			  
			}else if(code1==code2) {
				message=4;
			}
			else {
			 System.out.println("Le virement ne s'effectue que deux compte diffrent de meme type identique");
			 message=3; 
		  }
		  return message;  
	  }
	//consulter le solde depuis la BD   
	@Override
	  public double consulterSolde(int code) {
		  Connection connexion = null;
			Statement st1=DBConnexion.st;
			ResultSet resultSet=DBConnexion.resultSet;
			double soldeBD=0;
			try {
			connexion=modeles.DBConnexion.ConnexionToDB();
			st1=connexion.createStatement();
			resultSet=st1.executeQuery("SELECT * FROM compte WHERE compte.code="+code+"");
			
			while(resultSet.next()) {
				soldeBD=resultSet.getDouble("solde");
					
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
					
					if(st1!=null) {
						try {
							st1.close();
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
			return soldeBD;
	  }
	  
	
	 
	 
	//Avoir le total des interet du
	@Override
	  public double getInteret_due(int code) {
		  	Connection connexion =DBConnexion.connexion;
		  	Statement st1=DBConnexion.st;
			ResultSet resultSet=DBConnexion.resultSet;
			double interet_due=0;
			try {
			connexion=modeles.DBConnexion.ConnexionToDB();
			st1=connexion.createStatement();
			resultSet=st1.executeQuery("SELECT * FROM compte WHERE compte.code="+code+"");
			
			while(resultSet.next()) {
				interet_due=resultSet.getDouble("interet_due");
					
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
					
					if(st1!=null) {
						try {
							st1.close();
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
		return interet_due;
	}

	//Mettre a jour les interets
	@Override
	public void updateInteret_du(int code,double interet_due) {
		Connection connexion=DBConnexion.ConnexionToDB();
		Statement st=DBConnexion.st;
		double interet_dueBD=comptesDAO.getInteret_due(code);
		try {
		st=connexion.createStatement();
		st.executeUpdate("UPDATE compte SET 'solde'="+(interet_dueBD+interet_due)+"WHERE compte.code="+code+";");
		System.out.println("Interet_du mis a jours");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
									
							
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
		
}	
	
	@Override
	public List<Compte> getAll() {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override	
	public double calculinteret (double dette) {
		double interet_due=0;
	
		if (dette>1&&dette<=100) {
			interet_due=(dette)*0.05;
		}
		else if (dette>100&&dette<=500) {
			interet_due=(dette)*0.03;
		}
		else if (dette>500&&dette<=1000) {
			interet_due=(dette)*0.02;
		}
		else if (dette>=1001) {
			interet_due=(dette)*0.01;
		}
		return interet_due;
	}

	@Override
	public void alter(Integer id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Integer id, Compte o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Compte o) {
		// TODO Auto-generated method stub
		
	}
	public CompteService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Compte get(Integer id) {
		Compte cc=null;
		Connection connexion=null;
		Statement st=null;
		ResultSet resultSet=null;
		try {
			connexion=DBConnexion.ConnexionToDB();
			st=connexion.createStatement();
			resultSet=st.executeQuery("SELECT * FROM compte WHERE code='"+id+"'");
			 if (!resultSet.isBeforeFirst()) {
					System.out.println("Ce compte n'est pas dans la base de donnee");
					Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Il n'existe pas de compte portant le numero "+id+"!");
					alert.setTitle("Information incorrect");
					alert.show();
			}						
				while(resultSet.next()) {
					String type=resultSet.getString("dtype");
					
					if(!type.isEmpty() && type.equals("CompteCourant")) {
						cc=new CompteCourant(0, 0, 0, null, 0);
					cc.setCode(resultSet.getInt("code"));
					((CompteCourant) cc).setDecouvert(resultSet.getDouble("decouvert"));
					cc.setInteret_due(resultSet.getDouble("interet_due"));
					cc.setSolde(resultSet.getDouble("solde"));
					}else if(!type.isEmpty() && type.equals("CompteEpargne")) {
						cc= new CompteEpargne(0, 0, 0, null, 0);
						cc.setCode(resultSet.getInt("code"));
						((CompteEpargne) cc).setTaux(resultSet.getFloat("taux"));
						cc.setInteret_due(resultSet.getDouble("interet_due"));
						cc.setSolde(resultSet.getDouble("solde"));
		
					
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
		return cc;
	
	}
	
	public String checktype(int code) {
		String type = null;
		Connection connexion = null;
		Statement st1=DBConnexion.st;
		ResultSet resultSet=DBConnexion.resultSet;
		try {
		connexion=modeles.DBConnexion.ConnexionToDB();
		st1=connexion.createStatement();
		resultSet=st1.executeQuery("SELECT * FROM compte WHERE code="+code+"");
		
		while(resultSet.next()) {
			type=resultSet.getString("dtype");
				
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
				
				if(st1!=null) {
					try {
						st1.close();
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
		return type;
	}

	@Override
	public int retirer(int code, double montant) {
		RetraitService rt= new RetraitService();
		String type=checktype(code);
		int message=0;
		if( type!=null && type.equals("CompteCourant")) {
			System.out.println(type);
			Compte cc=get(code);
			double solde =(cc.getSolde()),decouvert=(((CompteCourant) cc).getDecouvert());
			
			if (montant>solde+decouvert) {
				System.out.println("Compte courant solde insuffisant pour le retrait");
				message=3;
			}else{
			
			Retrait r= new Retrait(0, null, montant, ControleurLogin.username0, code);
			rt.save(r);
			solde-=montant;
			message=2;
			System.out.println("Retrait compte courant effetue CC ");
			cc.setSolde(solde);
			updateSolde(code, solde);
			}
		} else if (type!=null && type.equals("CompteEpargne")){
			Retrait r =new Retrait(0, null, 0, null, 0);
			rt.save(r);
			Compte ce = get(code);
			if(montant>ce.getSolde()) {
				ce.setSolde(ce.getSolde()-montant);
				message=2;
				System.out.println("Retrait compte epargne effetue CE");
				updateSolde(code, ce.getSolde());
			}
			else {
				message=3;
			}
		}else if(type==null) {
			message=1;
		}
		return message;
	}

	@Override			
	public void updateSolde(int code, double solde) {
		Connection connexion=DBConnexion.ConnexionToDB();
		Statement st=DBConnexion.st;
		double soldeBD=consulterSolde(code);
		System.out.println(soldeBD);
		try {
		st=connexion.createStatement();
		st.executeUpdate("UPDATE compte SET solde="+(solde)+" WHERE code="+code+";");
		System.out.println("Solde mis a jours.Le nouveau solde est "+solde);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
									
							
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
		
}

	@Override
	public void emprunter(int code,double montant) {
		Compte db= new CompteCourant(0, 0, 0, null, 0); 
		db=(comptesDAO.get(code));
		CompteCourant cc= (CompteCourant) db;
		double solde=cc.getSolde(), decouvert=cc.getDecouvert();
		
		if (montant<solde) {
			System.out.println("Nous ne pretons que des montants superieur au solde, Merci de retirer de votre solde ou d'emprunter plus");
			 Alert alert= new Alert(Alert.AlertType.ERROR);
				alert.setContentText("Nous ne pretons que des montants superieur au solde, Merci de retirer de votre solde ou d'emprunter plus.Votre solde actuelle est de "+solde);
				alert.setTitle("Information");
				alert.show();
		}
		else {
				if (solde<0) {
				System.out.print("Vous ne pouvez pas enmprunter car vous n'avez pas encore payer votre dernier emprunt.\n Merci de payer et reessayer\n");
				 Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Vous ne pouvez pas enmprunter car vous n'avez pas encore payer votre dernier emprunt.Votre solde est de :"+solde);
					alert.setTitle("Information");
					alert.show();
				}
				else if(montant>((decouvert*0.2)+solde)) {
					System.out.println("Vous n'etes autorise a emprunter plus de 20% de votre decouvert");
					Alert alert= new Alert(Alert.AlertType.ERROR);
					alert.setContentText("Vous n'etes autorise a emprunter plus de 20% de votre decouvert.Votre decouvert :"+cc.getDecouvert());
					alert.setTitle("Information");
					alert.show();
				}
					
				else {
					double interet_due=0,dette=0;
					dette=montant-solde;
					interet_due=calculinteret(dette);
					cc.setInteret_due(interet_due);
					Emprunter e= new Emprunter(code, null, montant, null, code, interet_due);
					EmprunterService es= new EmprunterService();
					es.save(e);
					solde-=montant-interet_due;
					cc.setSolde(solde);
					Alert alert= new Alert(Alert.AlertType.INFORMATION);
					alert.setContentText("Operation effectuer avec succès");
					alert.setTitle("Information");
					alert.show();
				}
				}
		update(cc.getCode(), cc);
	}	



	@Override
	public boolean save(Compte o) {
	
		return false;
	}
	
}

	  
