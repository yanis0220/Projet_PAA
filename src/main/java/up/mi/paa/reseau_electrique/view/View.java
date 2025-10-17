package up.mi.paa.reseau_electrique.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import up.mi.paa.reseau_electrique.controller.Controller;
import up.mi.paa.reseau_electrique.model.Connexion;
import up.mi.paa.reseau_electrique.model.Generateur;
import up.mi.paa.reseau_electrique.model.Maison;
import up.mi.paa.reseau_electrique.model.Reseau;

public class View {

    public static void lancerProg() {
        Scanner sc = new Scanner(System.in);
        Scanner scs = new Scanner(System.in);

        Reseau reseau = new Reseau();
        Controller controller = new Controller(reseau);
         List<Connexion> connexions = new ArrayList<>();
        int choix;

        do {
            System.out.println("\n=== MENU RÉSEAU ÉLECTRIQUE ===");
            System.out.println("1 - Ajouter une maison (format: nom type)");
            System.out.println("2 - Ajouter un générateur (format: nom capacité)");
            System.out.println("3 - Ajouter une connexion (format: nomGenerateur nomMaison)");
            System.out.println("fin");
            
            System.out.println("0 - Quitter");
            System.out.print("Votre choix : ");
            String saisies = sc.nextLine(); 
            try {
                choix = Integer.parseInt(saisies.trim());
            } catch (NumberFormatException e) {
                choix = -1; 
                System.out.println("Saisie invalide, veuillez entrer un nombre.");
            }

            switch (choix) {

                case 1:
                    String nouvM;
                    do {
                        System.out.println(" Entrez une maison (ex: maison1 moyenne) :");
                        nouvM = scs.nextLine();

                        if (controller.ajouterMaison(nouvM)) {
                            System.out.println("Maison ajoutée !");
                            break; 
                        } else {
                            System.out.println(" Mauvais format ou type inconnu. Réessayez !");
                        }

                    } while (true);
                    break;

                case 2:
                    String nouvG;
                    do {
                        System.out.println(" Entrez un générateur (ex: gen1 100) :");
                        nouvG = scs.nextLine();

                        if (controller.ajouterGenerateur(nouvG)) {
                            System.out.println(" Générateur ajouté !");
                            break;
                        } else {
                            System.out.println(" Format invalide. Réessayez !");
                        }

                    } while (true);
                    break;

                case 3:
                    String nouvC;
                    int x = 1;
                    do {
                    	
                        System.out.println(" Entrez une connexion (ex: gen1 maison1) :");
                        
                        nouvC = scs.nextLine();

                        if (controller.ajouterConnexion(nouvC,connexions)) {
                            System.out.println(" Connexion ajoutée !");
                            break;
                        } else {
                            System.out.println(" Format invalide ou noms inexistants. Réessayez !");
                            
                        }
                        System.out.println(" taper 1 pour ajouter d'autres connexions ou 0 pour quitter");
                        String saisie = sc.nextLine(); 
                        try {
                            x= Integer.parseInt(saisie.trim()); 
                        } catch (NumberFormatException e) {
                            x = 0; 
                            System.out.println("Saisie invalide, retour au menu principal.");
                        }
                    } while (true && x == 1);
                    break;
                case 4:
                    List<Maison> doublons = controller.verifierConnexions(connexions);

                    while (!doublons.isEmpty()) {
                        for (Maison maison : doublons) {
                            System.out.println("La maison " + maison.getNom() + " a trop de générateurs !");
                            
                            List<Connexion> connexionsMaison = new ArrayList<>();
                            System.out.println("Connexions actuelles :");
                            for (Connexion c : connexions) {
                                if (c.getMaison().equals(maison)) {
                                    System.out.println("- Générateur : " + c.getGenerateur().getNom());
                                    connexionsMaison.add(c);
                                }
                            }

                            Generateur garder = null;
                            while (garder == null) {
                                System.out.print("Entrez le nom du générateur à garder : ");
                                String choixGenerateur = sc.nextLine().trim();

                                for (Connexion c : connexionsMaison) {
                                    if (c.getGenerateur().getNom().equalsIgnoreCase(choixGenerateur)) {
                                        garder = c.getGenerateur();
                                        break;
                                    }
                                }

                                if (garder == null) {
                                    System.out.println("Nom invalide, veuillez réessayer !");
                                }
                            }

                           
                            Iterator<Connexion> it = connexions.iterator();
                            while (it.hasNext()) {
                                Connexion c = it.next();
                                if (c.getMaison().equals(maison) && !c.getGenerateur().equals(garder)) {
                                    it.remove();
                                }
                            }
                        }

                       
                        doublons = controller.verifierConnexions(connexions);
                    }

                    
                    controller.ajouterConnexionsRx(connexions);
                    System.out.println("Réseau créé avec succès !");
                    choix = 1; // pour revenir au menu principal
                    break;
            }

        } while (choix != 0);

        reseau.affihcerRx();
        sc.close();
        scs.close();
    }
}
