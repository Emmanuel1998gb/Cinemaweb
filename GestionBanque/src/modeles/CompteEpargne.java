//CLASSE COMPTE EPARGNE


package modeles;


public class CompteEpargne extends Compte{
	private float taux;
		
	

	public CompteEpargne() {
		super();
		// TODO Auto-generated constructor stub
	}
  


	public CompteEpargne(int code, double solde, double interet_due, Proprietaire proprietaire, float taux) {
		super(code, solde, interet_due, proprietaire);
		this.setTaux(taux);
	}



	public float getTaux() {
		return taux;
	}



	public void setTaux(float taux) {
		this.taux = taux;
	}
	
	
}

	