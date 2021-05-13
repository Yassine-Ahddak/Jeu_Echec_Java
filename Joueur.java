import java.util.Scanner;

public class Joueur {
    
    private String nom_coup;

    public String SaisirCoup(){
        Scanner nom_coup = new Scanner();
        nom_coup.nextString();
        return nom_coup;
    }
}
