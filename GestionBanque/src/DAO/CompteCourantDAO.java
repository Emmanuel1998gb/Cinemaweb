package DAO;

import modeles.CompteCourant;

public interface CompteCourantDAO extends BankManagerDAO<CompteCourant, Integer>{
	double getDecouvert(int code);

}
