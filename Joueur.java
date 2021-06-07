import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    private boolean isWhite;
    private ArrayList<Piece> listepieces; 

    public Joueur(boolean iswhite){
        this.isWhite = iswhite;
        this.listepieces = new ArrayList<Piece>();
    }
    
    public boolean GetIsWhite(){
        return this.isWhite;
    }

    public ArrayList<Piece> GetListePieces(){
        return this.listepieces;
    }

}
