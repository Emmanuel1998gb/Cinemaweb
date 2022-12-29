package modeles;

import java.util.List;


public class Proprietaire {
private String IdPro;
private String Noms;
private String Adresse;
private List<Compte> comptes;
public String getIdPro() {
	return IdPro;
}

//Generation de Getter and Setter
public String getNoms() {
	return Noms;
}
public void setNoms(String noms) {
	Noms = noms;
}
public String getAdresse() {
	return Adresse;
}
public void setAdresse(String adresse) {
	Adresse = adresse;
}

public Proprietaire() {
	super();
	// TODO Auto-generated constructor stub
}

public Proprietaire(String idPro, String noms, String adresse) {
	super();
	IdPro = idPro;
	Noms = noms;
	Adresse = adresse;
}

public List<Compte> getComptes() {
	return comptes;
}

public void setIdPro(String idPro) {
	IdPro = idPro;
}




}

