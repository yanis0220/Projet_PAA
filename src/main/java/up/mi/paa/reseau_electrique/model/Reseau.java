package up.mi.paa.reseau_electrique.model;
import java.util.*;

import up.mi.paa.reseau_electrique.controller.Controller;
public class Reseau {
	    private List<Maison> maisons = new ArrayList<>();
	    private List<Generateur> generateurs = new ArrayList<>();
	    private List<Connexion> connexions = new ArrayList<>();
	    public Reseau() {
	        maisons = new ArrayList<>();
	        generateurs = new ArrayList<>();
	        connexions = new ArrayList<>();
	    }

	public void ajouterMaison(Maison m) {
		maisons.add(m);
	}
	public void ajouterGenerateur(Generateur g) {
		generateurs.add(g);
	}
	public void ajouterConnexion(Connexion c) {
		connexions.add(c);
	}
	
	
	public List<Connexion> getConnexions() {
		return connexions;
	}

	public void setConnexions(List<Connexion> connexions) {
		this.connexions = connexions;
	}


	public boolean gererateurExistant(String g) {
		for(Generateur i : generateurs) {
			if(i.getNom().equals(g))
				return true;
		}
		return false;
	}
	public boolean maisonExistante(String m) {
		for(Maison i : maisons) {
			if(i.getNom().equals(m))
				return true;
		}
		return false;
	}
	public boolean connexionExistante(String c) {
	
			 String[] parties = c.trim().split("\\s+");
			 String g = parties[0];
			 String m = parties[1];
			 
			 if(!gererateurExistant(g))
				 return false;
			 if(!maisonExistante(m))
				 return false;
			 
			 for(Connexion i : connexions) {
				 if(i.getGenerateur().equals(g) && i.getMaison().equals(m))
					 return true;
			 }
			 return false;

	}
	
	public Maison recupererMaison(String nom) {
		for (Maison m : maisons) {
			if(m.getNom().equals(nom))
				return m;
		}
		return null;
	}
	public Generateur recupererGenerateur(String nom) {
		for (Generateur g : generateurs) {
			if(g.getNom().equals(nom))
				return g;
		}
		return null;
	}

	
	
	public void affihcerRx() {
		System.out.println("les maisons sont : ");
		for(Maison m : maisons) {
			System.out.println(m.getNom());
		}
		
		System.out.println("les generateurs sont : ");
		for(Generateur g : generateurs) {
			System.out.println(g.getNom());
		}
		
		System.out.println("les connexion sont : ");
		for(Connexion c : connexions) {
			System.out.println(c.getMaison().getNom()+" -> "+c.getGenerateur().getNom());
		}
	}
}
