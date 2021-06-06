import java.util.ArrayList;

public class Piece {
    private ArrayList<Case> listeCoups;
    private boolean isWhite;
    private int idPiece;
    private boolean moved;

    public Piece(){
        this.idPiece = 0;
        this.isWhite = false;
    }

    public Piece(int idPiece){
        this.idPiece= idPiece;
        this.isWhite= (idPiece < 7);
        this.moved = false;
        this.listeCoups = new ArrayList<Case>();
    }

    public Piece(int idPiece, boolean moved){
        this.idPiece= idPiece;
        this.isWhite= (idPiece < 7);
        this.moved = moved;
        this.listeCoups = new ArrayList<Case>();
        
    }

    public boolean getMoved(){
        return this.moved;
    }


    public boolean GetIsWhite(){
        return this.isWhite;
    }

    public int GetidPiece(){
        return this.idPiece;
    }

    public void setMoved(boolean moved){
        this.moved = moved;
    }

    public ArrayList<Case> GetListeCoups(){
        return this.listeCoups;
    }

    public void setidPiece(int idPiece){
        this.idPiece = idPiece;
    }

    public void setListeCoups(ArrayList<Case> listecoups){
        this.listeCoups= listecoups;
    }

    public void setisWhite(boolean iswhite){
        this.isWhite = iswhite;
    }

    public String AfficheListeCoups(){
        String res = "Liste de coups de la piece : \n";
        for(int i = 0 ; i < this.listeCoups.size() ; i++){
            res += this.listeCoups.get(i).GetCoo() + "\n";
        }
        return res;
    }

    public String toString(){
        return("; Id de la piece : " + this.idPiece + " ; isWhite : " + this.isWhite + "\n" + AfficheListeCoups()) + "\n -------------------------------------------- \n ";
    }
}
