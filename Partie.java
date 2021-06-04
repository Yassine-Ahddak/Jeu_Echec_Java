import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Partie extends Echiquier{
    private Echiquier echiquier;

    public Partie(){
        this.echiquier = new Echiquier();
    }
    /*public void init(){

    }*/
//objet échiquier 
//fonction valider coups /deplacement
//verifier la couleur
    //public main(){

    //}

   // public EstValide(){

    //}

    public void sauvegarde(){
        File file = new File("C:\\Users\\yahdd\\Documents\\IUT\\Semestre 2\\projet\\prgm_jeu_echec\\Jeu_Echec_Java\\sauvegarde.txt");
        //String testsauver = "test en cours";
        if(!file.exists())
        {
            try{
                file.createNewFile();
                //testsauver = "marche";
                //return true;
            } catch (IOException e){
                e.printStackTrace();
                //System.out.println(e);
                //testsauver = "marche pas";
            }
        }
        else{
            try{
                FileWriter writer = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(writer);
                
                /*for(int ligne1=0; ligne1 < echiquier1.length;ligne1++) {
                    for(int colonne1=0; colonne1 < echiquier1.length;colonne1++) {
                        if (echiquier1[ligne1][colonne1].GetValCase() != -1){
                            
                        }
                    }
                }*/
                for(int i = 0; i < 8; i++){
                    for(int j = 0; j < 8; j++){
                        //bw.write("salut");
                        bw.write(this.echiquier.getEchiquier()[i][j].GetValCase() + " ");
                    }
                    bw.write("\n");
                }
                bw.close();
                writer.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        //return false;
    }

    public void restaurer(){
        File file = new File("C:\\Users\\yahdd\\Documents\\IUT\\Semestre 2\\projet\\prgm_jeu_echec\\Jeu_Echec_Java\\sauvegarde.txt");
        if(!file.exists())
        {
            System.out.println("Chargement impossible : fichier inexistant");
        }
        else{
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
                String line = reader.readLine();
                String line1 = reader.read();
                while(line != null)
                {
                    System.out.println(line);
                    line = reader.readLine();
                    line = reader.readLine();
                }
                reader.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        
        //int ligne1 = 0;
        //int colonne1 = 0;
        //parcourir chaque ligne de l'échiquier puis récup valeur + ajouter espace
        /*for(int ligne1=0; ligne1 < echiquier1.length;ligne1++) {
            for(int colonne1=0; colonne1 < echiquier1.length;colonne1++) {
                if (echiquier1[ligne1][colonne1].GetValCase() != -1){
                    echiquier1.sauvegarde();
                }

            }
        }*/
        
    }
}
