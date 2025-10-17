package up.mi.paa.reseau_electrique.model;

public class Maison {
private String nom;
private TypeMaison type;

public Maison(String nom, TypeMaison type) {
    this.nom = nom;
    this.type = type;
    }


public String getNom() {
	return nom;
}


public void setNom(String nom) {
	this.nom = nom;
}


public TypeMaison getType() {
	return type;
}


public void setType(TypeMaison type) {
	this.type = type;
}


public double getConsommation() {
    return type.getConsommationKW();
}
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Maison maison = (Maison) o;
    return nom.equalsIgnoreCase(maison.nom);
}

@Override
public int hashCode() {
    return nom.toLowerCase().hashCode();
}
}
