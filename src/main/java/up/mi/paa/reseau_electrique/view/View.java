package up.mi.paa.reseau_electrique.view;
import java.util.*;

import up.mi.paa.reseau_electrique.controller.Controller;
import up.mi.paa.reseau_electrique.model.*;
public class View {
public static void lancerProg() {
	int chois = 1;
	Reseau r = new Reseau();
	Scanner sc = new Scanner(System.in);
	Scanner scs = new Scanner(System.in);
	do {
		System.out.println("taper 1 pour ajouter une maison format(nom type)");
		System.out.println("taper 2 pour ajouter un generateur format(nom capacité)");
		System.out.println("taper 3 pour ajouter une connexion format(nomGenerateur nomMaison)");
		System.out.println("taper 0 pour quitter");
		chois = sc.nextInt();
		switch (chois) {
		case 1:
			String nouvM = "omar";
			do {
				System.out.println("donner votre maison");
				nouvM = scs.nextLine();
				if(Controller.formatAjoutMaison(nouvM)) {
					 String[] parties = nouvM.trim().split("\\s+");
					 r.ajouterMaison(new Maison(parties[0],TypeMaison.stringToTypeMaison(parties[1])));
				}else {
					System.out.println("mauvais format M");
				}
			}while(!Controller.formatAjoutMaison(nouvM));
			break;
		case 2:
			String nouvG;
			do {
				nouvG = scs.nextLine();
				if(Controller.formatAjoutGenerateur(nouvG)) {
					 String[] parties = nouvG.trim().split("\\s+");
					 r.ajouterGenerateur(new Generateur(parties[0], Integer.parseInt(parties[1])));
				}else {
					System.out.println("mauvais format G");
				}
			}while(!Controller.formatAjoutGenerateur(nouvG));
			break;
		case 3:
		    String nouvC;
		    String[] parties = null;

		    do {
		        System.out.println("Donner la connexion (format: nomGenerateur nomMaison)");
		        nouvC = scs.nextLine().trim();

		        
		        if (!Controller.formatAjoutConnexion(nouvC)) {
		            System.out.println("Mauvais format C");
		            continue; 
		        }

		        
		        parties = nouvC.split("\\s+");

		       
		        Generateur g = r.recupererGenerateur(parties[0]);
		        Maison m = r.recupererMaison(parties[1]);

		        if (g == null || m == null) {
		            System.out.println("La maison ou le générateur n'existe pas");
		            continue;
		        }

		        
		        r.ajouterConnexion(new Connexion(m, g));
		        System.out.println("Connexion ajoutée : " + g.getNom() + " → " + m.getNom());
		        break; 

		    } while (true);
		    break;

		case 0:
			break;
		default:
			break;

		}
		
	}while(chois != 0);
	r.affihcerRx();
	sc.close();
}
}
