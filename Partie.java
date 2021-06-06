import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;

public class Partie {
    private Echiquier echiquier;
    private boolean isTourBlanc;
    private Joueur JoueurBlanc;
    private Joueur JoueurNoir;

    public Partie() {
        this.echiquier = new Echiquier();
        this.isTourBlanc = true;
        this.JoueurBlanc = new Joueur(true);
        this.JoueurNoir = new Joueur(false);
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

    public boolean EstCoupCorrectSyntax(String coup){
        if(coup.length() != 4){
            return false;
        }
        int valasciichar0 = (int)coup.toLowerCase().charAt(0);
        int valasciichar1 = (int)coup.toLowerCase().charAt(1);
        int valasciichar2 = (int)coup.toLowerCase().charAt(2);
        int valasciichar3 = (int)coup.toLowerCase().charAt(3);
        return( (valasciichar0 >= 97 && valasciichar0 <= 104 && 
                valasciichar1 >= 49 && valasciichar1 <= 56 && 
                valasciichar2 >= 97 && valasciichar2 <= 104 && 
                valasciichar3 >= 49 && valasciichar3 <= 56) || coup.toLowerCase().equals("save") || coup.toLowerCase().equals("load"));
    }

    public void ActuListePieceJoueur(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getPartieEchiquier().getEchiquier()[i][j].getPiece() != null) {
                    if(this.getPartieEchiquier().getEchiquier()[i][j].getPiece().GetIsWhite() == JoueurBlanc.GetIsWhite()){
                        JoueurBlanc.GetListePieces().add(this.getPartieEchiquier().getEchiquier()[i][j].getPiece());
                    } else{
                        JoueurNoir.GetListePieces().add(this.getPartieEchiquier().getEchiquier()[i][j].getPiece());
                    }
                }
            }
        }
    }
    public boolean EstBonCampChoisi(Case casedep){
        if(casedep.getPiece() == null){
            return false;
        }
        return(casedep.getPiece().GetIsWhite() == this.isTourBlanc);
    }

    public void sauvegarde() {
        //File file = new File("C:\\Users\\yahdd\\Documents\\IUT\\Semestre 2\\projet\\prgm_jeu_echec\\Jeu_Echec_Java\\sauvegarde.txt");
        File file = new File("C:\\Users\\tehre\\Desktop\\IUT\\gooboz\\Jeu_Echec_Java\\sauvegarde.txt");
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
        } else {
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
        }
        // return false;
    }

    public void restaurer() {
        // File file = new File("C:\\Users\\yahdd\\Documents\\IUT\\Semestre
        // 2\\projet\\prgm_jeu_echec\\Jeu_Echec_Java\\sauvegarde.txt");
        File file = new File("C:\\Users\\tehre\\Desktop\\IUT\\gooboz\\Jeu_Echec_Java\\sauvegarde.txt");
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
        ///////////////////PROGRAMME PRINCIPAL///////////////////
        /////////////////////////////////////////////////////////
        /////////////////////////////////////////////////////////

        System.out.println("Bienvenue dans ce simulateur de jeu d'echec, que souhaitez vous faire ? \n \n");
        System.out.println("1 : Créer une nouvelle partie");
        System.out.println("2 : En charger une déjà existante");





    }
}
