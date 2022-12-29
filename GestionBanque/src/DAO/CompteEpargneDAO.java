package DAO;

import modeles.CompteEpargne;

public interface CompteEpargneDAO extends BankManagerDAO<CompteEpargne, Integer>{

	int getTauxInteret(int code);
}
