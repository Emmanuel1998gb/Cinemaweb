package modeles;


import java.util.Date;

public class Operation {
	private int numero;
	private Date dateoperation;
	private double montant;
	private String username;
	private int codeCompte;
	private Users users0;
	private Compte compte;
	
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Operation(int numero, Date dateoperation, double montant, String username, int codeCompte) {
		super();
		this.numero = numero;
		this.dateoperation = dateoperation;
		this.montant = montant;
		this.username=username;
		this.codeCompte=codeCompte;
		
	}


	public int getNumero() {
		return numero;
	}
	public Date getDateoperation() {
		return dateoperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setDateoperation(Date dateoperation) {
		this.dateoperation = dateoperation;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	public String getUsername() {
		return username;
	}
	public void setCode(int code) {
		this.codeCompte=code;
	}
	public int getCode() {
		return codeCompte;
	}


	public Users getUsers0() {
		return users0;
	}


	public Compte getCompte() {
		return compte;
	}


	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
}
