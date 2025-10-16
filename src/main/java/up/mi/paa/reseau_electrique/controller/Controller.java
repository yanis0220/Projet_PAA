package up.mi.paa.reseau_electrique.controller;

import java.util.ArrayList;
import java.util.List;

import up.mi.paa.reseau_electrique.model.Connexion;
import up.mi.paa.reseau_electrique.model.Generateur;
import up.mi.paa.reseau_electrique.model.Maison;
import up.mi.paa.reseau_electrique.model.Reseau;
import up.mi.paa.reseau_electrique.model.TypeMaison;

public class Controller {
private Reseau reseau;

	public Controller(Reseau reseau) {

	this.reseau = reseau;
}
	public static boolean typeMaisonValide(String type) {
		if(type.equalsIgnoreCase("BASSE") ||type.equalsIgnoreCase("MOYENNE") ||type.equalsIgnoreCase("FORTE"))
			return true;
		else
			return false;
	}
	public static boolean formatAjoutMaison(String nouvM) {
	    if (nouvM == null) 
	    	return false;

	    
	    String[] parties = nouvM.trim().split("\\s+");

	    
	    if (parties.length != 2) 
	    	return false;

	    String nom = parties[0];
	    String type = parties[1].toUpperCase();

	    
	    return typeMaisonValide(type);
	}

	
	public static boolean formatAjoutGenerateur(String nouvG) {
	    if (nouvG == null) 
	    	return false;

	    
	    String[] parties = nouvG.trim().split("\\s+");

	    
	    if (parties.length != 2) 
	    	return false;

	    String nom = parties[0];
	    String capacite = parties[1];

	    try {
	        Integer.parseInt(capacite);
	        return true; 
	    } catch (NumberFormatException e) {
	        return false; 
	    }
	}
	
	public static boolean formatAjoutConnexion(String nouvC) {
		  if (nouvC == null) 
		    	return false;

		    
		    String[] parties = nouvC.trim().split("\\s+");

		    
		    if (parties.length != 2) 
		    	return false;
		    else
		    	return true;

	}
    public boolean ajouterMaison(String saisie) {
        if (!formatAjoutMaison(saisie)) return false;

        String[] parts = saisie.trim().split("\\s+");
        Maison maison = new Maison(parts[0], TypeMaison.stringToTypeMaison(parts[1]));
        reseau.ajouterMaison(maison);
        return true;
    }

    public boolean ajouterGenerateur(String saisie) {
        if (!formatAjoutGenerateur(saisie)) return false;

        String[] parts = saisie.trim().split("\\s+");
        Generateur gen = new Generateur(parts[0], Integer.parseInt(parts[1]));
        reseau.ajouterGenerateur(gen);
        return true;
    }

    public boolean ajouterConnexion(String saisie,List<Connexion> connexions) {
        if (!formatAjoutConnexion(saisie)) return false;
        

        String[] parts = saisie.trim().split("\\s+");
        Generateur g = reseau.recupererGenerateur(parts[0]);
        Maison m = reseau.recupererMaison(parts[1]);

        if (g == null || m == null) return false;

        connexions.add(new Connexion(m,g));
        return true;
    }
    public boolean ajouterListeConnexion(List<Connexion> connexions) {
    	int i;
    	for(Connexion c : connexions) {
    		i = 0;
    		for(Connexion c1 : connexions) {
    			if(c.getMaison().equals(c1.getMaison()))
    				 i++;
    		}
    		if(i >= 2) {
    			System.out.println("la maison " + c.getMaison().getNom()+ " a trop de generateurs");
    			return false;
    		}
    			
    	}
    	return true;
    }
    public boolean ajouterConnexionsRx(List<Connexion> connexions) {
    	if(!ajouterListeConnexion(connexions))
    		return false;
    	
    	this.reseau.setConnexions(connexions);
    	return true;
    	
    }
}
