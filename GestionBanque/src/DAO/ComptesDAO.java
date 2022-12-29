package DAO;

import modeles.Compte;

public interface ComptesDAO extends BankManagerDAO<Compte, Integer> {
	
    boolean verser(int code,double montant);
	int  retirer (int solde,double montant);
	int virement (double montant, int code1, int code2);
	double consulterSolde(int code);
	void updateSolde(int code, double solde);
	void emprunter (int code,double montant);
	void updateInteret_du(int code,double interet_due);
	double getInteret_due(int code);
	double calculinteret(double dette);
}