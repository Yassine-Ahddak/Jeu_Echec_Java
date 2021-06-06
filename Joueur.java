import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    
    private String nom_coup;
    private boolean isWhite;
    private ArrayList<Piece> listepieces; 

    public Joueur(boolean iswhite){
        this.isWhite = iswhite;
    }

    public String SaisirCoup(){
        Scanner nom_coup = new Scanner();
        nom_coup.nextString();
        return nom_coup;
    }
    
    public boolean GetIsWhite(){
        return this.isWhite;
    }

    public ArrayList<Piece> GetListePieces(){
        return this.GetListePieces();
    }

}
