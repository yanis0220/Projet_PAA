package up.mi.paa.reseau_electrique.model;

public class Connexion {
private Maison maison;
private Generateur generateur;

public Connexion(Maison maison, Generateur generateur) {
	
	this.maison = maison;
	this.generateur = generateur;
}

public Maison getMaison() {
	return maison;
}
public void setMaison(Maison maison) {
	this.maison = maison;
}
public Generateur getGenerateur() {
	return generateur;
}
public void setGenerateur(Generateur generateur) {
	this.generateur = generateur;
}

}
