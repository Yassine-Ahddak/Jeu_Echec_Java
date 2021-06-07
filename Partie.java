import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Partie {
    private Echiquier echiquier;
    private boolean isTourBlanc;
    private Joueur JoueurBlanc;
    private Joueur JoueurNoir;
    private String historiquecoups;

    public Partie() {
        this.echiquier = new Echiquier();
        this.isTourBlanc = true;
        this.JoueurBlanc = new Joueur(true);
        JoueurBlancInit();
        this.JoueurNoir = new Joueur(false);
        JoueurNoirInit();
        this.historiquecoups = "";
    }
    /*
     * public void init(){
     * 
     * }
     */
    // objet échiquier
    // fonction valider coups /deplacement
    // verifier la couleur
    // public main(){

    // }

    // public EstValide(){

    // }

    public Echiquier getPartieEchiquier() {
        return this.echiquier;
    }

    public String getHistoriqueCoups() {
        return this.historiquecoups;
    }

    public void JoueurBlancInit() {
        ArrayList<Piece> res = new ArrayList<Piece>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.echiquier.getEchiquier()[i][j].getPiece() != null) {
                    if (this.echiquier.getEchiquier()[i][j].getPiece().GetIsWhite()) {
                        res.add(this.echiquier.getEchiquier()[i][j].getPiece());
                    }
                }
            }
        }
    }

    public void JoueurNoirInit() {
        ArrayList<Piece> res = new ArrayList<Piece>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.echiquier.getEchiquier()[i][j].getPiece() != null) {
                    if (!this.echiquier.getEchiquier()[i][j].getPiece().GetIsWhite()) {
                        res.add(this.echiquier.getEchiquier()[i][j].getPiece());
                    }
                }
            }
        }
    }

    public boolean EstCoupCorrectSyntax(String coup) {
        if (coup.length() != 4) {
            return false;
        }
        int valasciichar0 = (int) coup.toLowerCase().charAt(0);
        int valasciichar1 = (int) coup.toLowerCase().charAt(1);
        int valasciichar2 = (int) coup.toLowerCase().charAt(2);
        int valasciichar3 = (int) coup.toLowerCase().charAt(3);
        return ((valasciichar0 >= 97 && valasciichar0 <= 104 && valasciichar1 >= 49 && valasciichar1 <= 56
                && valasciichar2 >= 97 && valasciichar2 <= 104 && valasciichar3 >= 49 && valasciichar3 <= 56)
                || coup.toLowerCase().equals("save") || coup.toLowerCase().equals("load"));
    }

    public void setTourBlanc(boolean isTourBlanc) {
        this.isTourBlanc = isTourBlanc;
    }

    public void ActuListePieceJoueur() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getPartieEchiquier().getEchiquier()[i][j].getPiece() != null) {
                    if (this.getPartieEchiquier().getEchiquier()[i][j].getPiece().GetIsWhite() == JoueurBlanc
                            .GetIsWhite()) {
                        JoueurBlanc.GetListePieces().add(this.getPartieEchiquier().getEchiquier()[i][j].getPiece());
                    } else {
                        JoueurNoir.GetListePieces().add(this.getPartieEchiquier().getEchiquier()[i][j].getPiece());
                    }
                }
            }
        }
    }

    public boolean EstBonCampChoisi(Case casedep) {
        if (casedep.getPiece() == null) {
            return false;
        }
        return (casedep.getPiece().GetIsWhite() == this.isTourBlanc);
    }

    public void sauvegarde(String nomfichier) {
        // File file = new File("C:\\Users\\yahdd\\Documents\\IUT\\Semestre
        // 2\\projet\\prgm_jeu_echec\\Jeu_Echec_Java\\sauvegarde.txt");
        File file = new File("C:\\Users\\tehre\\Desktop\\IUT\\gooboz\\Jeu_Echec_Java\\Sauvegardes\\" + nomfichier);
        // String testsauver = "test en cours";
        if (!file.exists()) {
            try {
                file.createNewFile();
                // testsauver = "marche";
                // return true;
            } catch (IOException e) {
                e.printStackTrace();
                // System.out.println(e);
                // testsauver = "marche pas";
            }
        }
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);

            /*
             * for(int ligne1=0; ligne1 < echiquier1.length;ligne1++) { for(int colonne1=0;
             * colonne1 < echiquier1.length;colonne1++) { if
             * (echiquier1[ligne1][colonne1].GetValCase() != -1){
             * 
             * } } }
             */
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    // bw.write("salut");
                    if (this.echiquier.getEchiquier()[i][j].getPiece() != null) {
                        bw.write(this.echiquier.getEchiquier()[i][j].getPiece().GetidPiece() + " ");
                    } else {
                        bw.write(0 + " ");
                    }
                }
                bw.write("\n");
            }
            bw.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return false;
    }

    public void restaurer(String nomfichier) {
        // File file = new
        // File("C:\\Users\\yahdd\\Documents\\IUT\\Semestre2\\projet\\prgm_jeu_echec\\Jeu_Echec_Java\\sauvegarde.txt");
        // File file = new
        // File("C:\\Users\\tehre\\Desktop\\IUT\\gooboz\\Jeu_Echec_Java\\sauvegarde.txt");
        File file = new File("C:\\Users\\tehre\\Desktop\\IUT\\gooboz\\Jeu_Echec_Java\\Sauvegardes\\" + nomfichier);
        // File file = new
        // File("C:\\Users\\yahdd\\Documents\\IUT\\Semestre2\\projet\\prgm_jeu_echec\\Jeu_Echec_Java\\Sauvegardes\\"
        // + nomfichier);
        // File file = new File("C:\\Users\\yahdd\\Documents\\IUT\\Semestre
        // 2\\projet\\prgm_jeu_echec\\Jeu_Echec_Java\\Sauvegardes\\" + nomfichier);
        // System.out.println("C:\\Users\\yahdd\\Documents\\IUT\\Semestre2\\projet\\prgm_jeu_echec\\Jeu_Echec_Java\\Sauvegardes\\"
        // + nomfichier);
        if (!file.exists()) {
            System.out.println("Chargement impossible : fichier inexistant");
        } else {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                String line = reader.readLine();
                int[][] res = new int[8][8];
                int lignetab = 0;
                while (line != null) {
                    // System.out.println(line);
                    int colonnetab = 0;
                    int indexstring = 0;
                    while (indexstring < line.length()) {
                        String elementtableau = "";
                        while (indexstring < line.length() && line.charAt(indexstring) != (char) 32) {
                            elementtableau = elementtableau + Character.toString(line.charAt(indexstring));
                            // System.out.println("J'ajoute l'element : " +
                            // Character.toString(line.charAt(indexstring)));
                            indexstring += 1;
                        }
                        // System.out.println("Element tableau : " + elementtableau);
                        res[lignetab][colonnetab] = Integer.parseInt(elementtableau);
                        elementtableau = "";
                        if (indexstring < line.length()) {
                            indexstring += 1;
                        }
                        colonnetab += 1;
                    }
                    lignetab += 1;
                    line = reader.readLine();
                    indexstring = 0;
                }
                reader.close();
                this.echiquier.init(res);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean estPartieFinie() {
        boolean estroiblancvivant = false;
        boolean estroinoirvivant = false;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getPartieEchiquier().getEchiquier()[i][j].getPiece() != null) {
                    if (this.getPartieEchiquier().getEchiquier()[i][j].getPiece().GetidPiece() == 6) {
                        estroiblancvivant = true;
                    }
                    if (this.getPartieEchiquier().getEchiquier()[i][j].getPiece().GetidPiece() == 12) {
                        estroinoirvivant = true;
                    }
                    if (estroiblancvivant && estroinoirvivant) {
                        return false;
                    }
                }

            }
        }
        return !(estroiblancvivant && estroinoirvivant);

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void setHistoriqueCoups(String historique) {
        this.historiquecoups = historique;
    }

    public static void main(String[] args) {

        // int ligne1 = 0;
        // int colonne1 = 0;
        // parcourir chaque ligne de l'échiquier puis récup valeur + ajouter espace
        /*
         * for(int ligne1=0; ligne1 < echiquier1.length;ligne1++) { for(int colonne1=0;
         * colonne1 < echiquier1.length;colonne1++) { if
         * (echiquier1[ligne1][colonne1].GetValCase() != -1){ echiquier1.sauvegarde(); }
         * 
         * } }
         */

        /////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////
        /////////////////// PROGRAMME PRINCIPAL///////////////////
        /////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////

        Scanner scan = new Scanner(System.in);
        clearScreen();
        System.out.println("Bienvenue dans ce simulateur de jeu d'echec, que souhaitez vous faire ? \n \n");
        System.out.println("1 : Créer une nouvelle partie");
        System.out.println("2 : En charger une déjà existante\n");

        String userinput = scan.nextLine();
        while (!(userinput.equals("1") || (userinput.equals("2")))) {
            clearScreen();
            System.out.println("Action incorrecte veuillez saisir 1 ou 2");
            System.out.println("1 : Créer une nouvelle partie");
            System.out.println("2 : En charger une déjà existante\n");
            userinput = scan.nextLine();

        }

        Partie partie;

        if (userinput.equals("2")) {
            clearScreen();
            System.out.println("Veuillez saisir le nom du fichier (avec l'extension .txt).\n");
            userinput = scan.nextLine();
            File file = new File("C:\\Users\\tehre\\Desktop\\IUT\\gooboz\\Jeu_Echec_Java\\Sauvegardes\\" + userinput);
            while (!file.exists()) {
                clearScreen();
                System.out.println("Le fichier est introuvable.");
                System.out.println("Veuillez saisir le nom du fichier (avec l'extension .txt).\n");
                userinput = scan.nextLine();
                file = new File("C:\\Users\\tehre\\Desktop\\IUT\\gooboz\\Jeu_Echec_Java\\Sauvegardes\\" + userinput);
            }

            partie = new Partie();
            partie.restaurer(userinput);
            System.out.println("La partie a été chargée avec succes.");
            System.out.println("Veuillez indiquer à qui était le tour de jouer.");
            System.out.println("1 : Blanc.");
            System.out.println("2 : Noir.\n");
            while (!(userinput.equals("1") || (userinput.equals("2")))) {
                clearScreen();
                System.out.println("Action incorrecte veuillez saisir 1 ou 2.");
                System.out.println("Veuillez indiquer à qui était le tour de jouer.");
                System.out.println("1 : Blanc");
                System.out.println("2 : Noir\n");
                userinput = scan.nextLine();

            }
            if (userinput.equals("2")) {
                partie.setTourBlanc(false);
            }

        } else {
            clearScreen();
            System.out.println("Début d'une nouvelle partie !");
            System.out.println(
                    "Vous pouvez à tout moment de la partie écrire save afin de sauvegarder la partie (Cela y mettra un terme).");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clearScreen();
            partie = new Partie();
        }
        while (!partie.estPartieFinie()) {
            clearScreen();
            partie.getPartieEchiquier().Afficher();
            if (partie.isTourBlanc) {
                System.out.println("C'est au tour des blancs de jouer veuillez saisir votre coup\n");
            } else {
                System.out.println("C'est au tour des noirs de jouer veuillez saisir votre coup\n");
            }
            userinput = scan.nextLine();
            if (userinput.equals("quit")) {
                System.out.println("Partie interrompue");
                break;
            }
            if (userinput.toLowerCase().equals("historique")) {
                clearScreen();
                System.out.println("Historique des coups :\n");
                System.out.println(partie.getHistoriqueCoups());
                System.out.println("\n \n");
                partie.getPartieEchiquier().Afficher();
                if (partie.isTourBlanc) {
                    System.out.println("C'est au tour des blancs de jouer veuillez saisir votre coup\n");
                } else {
                    System.out.println("C'est au tour des noirs de jouer veuillez saisir votre coup\n");
                }
                userinput = scan.nextLine();
            }
            if (userinput.equals("save")) {
                System.out.println("Veuillez saisir le nom du fichier (avec l'extension .txt)\n");
                userinput = scan.nextLine();
                partie.sauvegarde(userinput);
                System.out.println("Partie sauvegardée, merci d'avoir joué");
                break;
            }
            while (!partie.EstCoupCorrectSyntax(userinput)) {
                System.out.println(
                        "Le coup est syntaxiquement incorrect veuillez taper case de départ puis case d'arrivée");
                System.out.println("ex : e5e3\n");
                userinput = scan.nextLine();
            }
            int colonne = (int) userinput.toLowerCase().charAt(0) - 97;
            int ligne = 8 - Character.getNumericValue(userinput.charAt(1));
            int colonne2 = (int) userinput.toLowerCase().charAt(2) - 97;
            int ligne2 = 8 - Character.getNumericValue(userinput.charAt(3));
            while (!(partie.getPartieEchiquier().EstCoupValide(
                    partie.getPartieEchiquier().getEchiquier()[ligne][colonne],
                    partie.getPartieEchiquier().getEchiquier()[ligne2][colonne2])
                    && partie.EstBonCampChoisi(partie.getPartieEchiquier().getEchiquier()[ligne][colonne]))) {
                System.out.println("Le coup n'est pas valide veuillez en saisir un nouveau\n");
                userinput = scan.nextLine();
                colonne = (int) userinput.toLowerCase().charAt(0) - 97;
                ligne = 8 - Character.getNumericValue(userinput.charAt(1));
                colonne2 = (int) userinput.toLowerCase().charAt(2) - 97;
                ligne2 = 8 - Character.getNumericValue(userinput.charAt(3));

            }
            if (!partie.getPartieEchiquier().getEchiquier()[ligne][colonne].getPiece().getMoved()) {
                partie.getPartieEchiquier().getEchiquier()[ligne][colonne].getPiece().setMoved(true);
            }
            if (partie.getPartieEchiquier().getEchiquier()[ligne2][colonne2].getPiece() != null) {
                if (partie.isTourBlanc) {
                    partie.JoueurNoir.GetListePieces()
                            .remove(partie.getPartieEchiquier().getEchiquier()[ligne2][colonne2].getPiece());
                } else {
                    partie.JoueurBlanc.GetListePieces()
                            .remove(partie.getPartieEchiquier().getEchiquier()[ligne2][colonne2].getPiece());
                }
            }
            Piece tmpPiece = partie.getPartieEchiquier().getEchiquier()[ligne][colonne].getPiece();
            partie.getPartieEchiquier().getEchiquier()[ligne][colonne].setPiece(null);
            partie.getPartieEchiquier().getEchiquier()[ligne2][colonne2].setPiece(tmpPiece);
            partie.getPartieEchiquier().ActuCoups();
            partie.JoueurBlancInit();
            partie.JoueurNoirInit();
            partie.setTourBlanc(!partie.isTourBlanc);
            partie.setHistoriqueCoups(partie.getHistoriqueCoups() + userinput + "\n");
            clearScreen();
            partie.getPartieEchiquier().Afficher();
            partie.getPartieEchiquier().PromotionPions();
        }
        System.out.println("\n La partie est finie merci d'avoir joué");
        for (Piece lpPiece : partie.JoueurBlanc.GetListePieces()) {
            if (lpPiece.GetidPiece() == 6) {
                System.out.println("Le joueur blanc l'emporte");
            }
        }

        for (Piece lpPiece : partie.JoueurNoir.GetListePieces()) {
            if (lpPiece.GetidPiece() == 12) {
                System.out.println("Le joueur Noir l'emporte");
            }
        }
    }
}
