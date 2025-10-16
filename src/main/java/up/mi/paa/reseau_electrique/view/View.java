package up.mi.paa.reseau_electrique.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import up.mi.paa.reseau_electrique.controller.Controller;
import up.mi.paa.reseau_electrique.model.Connexion;
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
            choix = sc.nextInt();
            sc.nextLine(); 

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
                    do {
                        System.out.println(" Entrez une connexion (ex: gen1 maison1) :");
                        nouvC = scs.nextLine();

                        if (controller.ajouterConnexion(nouvC,connexions)) {
                            System.out.println(" Connexion ajoutée !");
                            break;
                        } else {
                            System.out.println(" Format invalide ou noms inexistants. Réessayez !");
                        }

                    } while (true);
                    break;
                case 4:
                	
                	if(controller.ajouterConnexionsRx(connexions))
                		System.out.println("reseau crée avec succes");
                       
                	break;
                case 0:
                    System.out.println(" Fin du programme");
                    break;

                default:
                    System.out.println(" Choix invalide, veuillez réessayer !");
                    break;
            }

        } while (choix != 0);

        reseau.affihcerRx();
        sc.close();
        scs.close();
    }
}
