package modeles;

import java.util.Date;

public class Emprunter extends Operation{
	
	protected double interet_due;

	public Emprunter() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Emprunter(int numero, Date dateoperation, double montant, String username, int codeCompte,
			double interet_due) {
		super(numero, dateoperation, montant, username, codeCompte);
		this.interet_due = interet_due;
	}



	public double getInteret_due() {
		return interet_due;
	}

	public void setInteret_due(double interet_due) {
		this.interet_due = interet_due;
	}
	
	

}
