package up.mi.paa.reseau_electrique.controller;

public class Controller {

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
}
