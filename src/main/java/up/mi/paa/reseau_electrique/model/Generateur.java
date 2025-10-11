package up.mi.paa.reseau_electrique.model;

public class Generateur {
private int capacite;
private String nom;
public Generateur(String nom,int capacite) {
	this.capacite = capacite;
	this.nom = nom;
}
public int getCapacite() {
	return capacite;
}
public void setCapacite(int capacite) {
	this.capacite = capacite;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}



}
