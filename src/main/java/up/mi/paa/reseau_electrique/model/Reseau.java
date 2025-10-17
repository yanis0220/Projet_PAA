package up.mi.paa.reseau_electrique.model;
import java.util.*;


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


	public boolean generateurExistant(String g) {
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
	    if (parties.length != 2) return false;

	    String p1 = parties[0];
	    String p2 = parties[1];

	    
	    if (!generateurExistant(p1) && !generateurExistant(p2)) return false;
	    if (!maisonExistante(p1) && !maisonExistante(p2)) return false;

	    for (Connexion i : connexions) {
	        String nomG = i.getGenerateur().getNom();
	        String nomM = i.getMaison().getNom();
	        if ((nomG.equalsIgnoreCase(p1) && nomM.equalsIgnoreCase(p2)) ||
	            (nomG.equalsIgnoreCase(p2) && nomM.equalsIgnoreCase(p1))) {
	            return true;
	        }
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
			System.out.println(m.getNom() +" "+ m.getConsommation());
		}
		
		System.out.println("les generateurs sont : ");
		for(Generateur g : generateurs) {
			System.out.println(g.getNom() +" "+ g.getCapacite());
		}
		
		System.out.println("les connexion sont : ");
		for(Connexion c : connexions) {
			System.out.println(c.getMaison().getNom()+" -> "+c.getGenerateur().getNom());
		}
	}
}
