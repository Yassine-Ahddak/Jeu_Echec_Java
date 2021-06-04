import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Partie {
    public void init(){

    }
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
                bw.write("Sauvegarde partie");
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
                while(line != null)
                {
                    System.out.println(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
