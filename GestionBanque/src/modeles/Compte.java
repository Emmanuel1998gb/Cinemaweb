package modeles;

import java.util.ArrayList;
import java.util.List;




public abstract class Compte {
	private int code;
	protected double solde;
	protected double interet_due;
	protected List<Operation> operations =new ArrayList<>();
	protected Proprietaire proprietaire;
		
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	

	public Compte(int code, double solde, double interet_due, Proprietaire proprietaire) {
		super();
		this.code = code;
		this.solde = solde;
		this.interet_due = interet_due;
		this.proprietaire = proprietaire;
	}
	
	
	
	

	public double getSolde() {
		return solde;
	}


	public double getInteret_due() {
		return interet_due;
	}


	public String getProprietaire() {
		return this.proprietaire.getIdPro();
	}


	public void setCode(int code) {
		this.code = code;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public void setInteret_due(double interet_due) {
		this.interet_due = interet_due;
	}


	public void setProprietaire(String idPro) {
		this.proprietaire.setIdPro(idPro);
	}


	public int getCode() {
		return code;
	}
	
	
}

	  
