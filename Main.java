package cours2.menuRestau;

import java.util.Scanner;

public class Main {
    
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        byte option;
        char poursuivre = 'n';
        String commande;
        String chaine = "";

        FichierCommande F = new FichierCommande();
        F.ouvrir("W");

        do {
            option = menuPrincipal();
            switch (option) {
                case 1 :
                    do {
                        System.out.println("Quelle entrée souhaitez-vous commander ? ");
                        in.nextLine();
                        commande = in.nextLine();
                        F.ecrire(commande);
                        System.out.println("Souhaitez-vous une autre entrée ? (o/n) ");
                        poursuivre = in.next().toLowerCase().charAt(0);
                    } while (poursuivre != 'n');
                    break;
                
                case 2 :
                    do {
                        System.out.println("Quel plat souhaitez-vous commander ? ");
                        in.nextLine();
                        commande = in.nextLine();
                        F.ecrire(commande);
                        System.out.println("Souhaitez-vous un autre plat ? (o/n) ");
                        poursuivre = in.next().toLowerCase().charAt(0);
                    } while (poursuivre != 'n');
                    break;

                case 3 :
                    do {

                        System.out.println("Quel dessert souhaitez-vous commander ? ");
                        in.nextLine();
                        commande = in.nextLine();
                        F.ecrire(commande);
                        System.out.println("Souhaitez-vous ajouter une entrée ? (o/n) ");
                        poursuivre = in.next().toLowerCase().charAt(0);
                    } while (poursuivre != 'n');
                    break;
                
                case 4 :
                    F.fermer();
                    System.out.println("Nous avons bien enregistré votre commande, voici un récapitulatif : ");
                    F.ouvrir("R");
                    do {
                        chaine = F.lire();
                        if (chaine != null) System.out.println(chaine);
                    } while (chaine != null);
                    F.fermer();
                    sortir();
                    break;

                default :
					System.out.println("Cette option n'existe pas ");
            }
        } while (option != 4);
    }

    public static byte menuPrincipal() {
		byte tmp;
		
		System.out.println("1. Commander une entrée");
		System.out.println("2. Commander un plat");
		System.out.println("3. Commander un dessert");
		System.out.println("4. Sortir");
		System.out.println();
		System.out.println("Votre choix : ");
		tmp = in.nextByte();
		
		return tmp;
	}

    public static void sortir() {
		System.exit(0);
	}
}
