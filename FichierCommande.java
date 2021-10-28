package cours2.menuRestau;

import java.io.*;

public class FichierCommande {
    private BufferedWriter fW;
    private BufferedReader fR;
    private String nomDuFichier = "Commande.txt";
    private char mode;

    public void ouvrir(String s) {
        try {
            mode = s.toUpperCase().charAt(0);
            if (mode == 'R' || mode =='L') 
                fR = new BufferedReader(new FileReader(new File(nomDuFichier)));
            else if (mode == 'W' || mode == 'E')
                fW = new BufferedWriter(new FileWriter(new File(nomDuFichier)));
        }
        catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur lors de l'ouverture ");
        }
    }

    public void ecrire(String cmd) {
        try {
            if (cmd != null) {
                fW.write(cmd, 0, cmd.length());
                fW.newLine();
            }
        }
        catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur lors de l'écriture ");
        }
    }

    public String lire() {
        try {
            String cmd = fR.readLine();
            return cmd;
        }
        catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur de lecture ");
        }
        return null;
    }

    public void fermer() {
        try {
            if (mode == 'R' || mode == 'L') fR.close();
            else if (mode == 'W' || mode == 'E') fW.close();
        }
        catch (IOException e) {
            System.out.println(nomDuFichier + " : Erreur à la fermeture ");
        }
    }
}