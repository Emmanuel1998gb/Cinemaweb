//CLASSE COMPTE COURANT 

 package modeles;




public class CompteCourant extends Compte{
	private double decouvert;

	
		
	

	
	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

		
	public CompteCourant(int code, double solde, double interet_due,
			Proprietaire proprietaire, double decouvert) {
		super(code, solde, interet_due, proprietaire);
		this.setDecouvert(decouvert);
	}


	public double getDecouvert() {
		return decouvert;
	}


	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	




		
	}