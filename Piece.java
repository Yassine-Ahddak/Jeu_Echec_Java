import java.util.ArrayList;

public class Piece {
    private ArrayList<Case> listeCoups;
    private boolean moved;  //en public pour y avoir accès dans les classes qui héritent de Piece
    private boolean isWhite;
    private int idPiece;

    public Piece(){
        this.idPiece = 0;
        this.isWhite = false;
    }

    public Piece(int idPiece){
        this.idPiece= idPiece;
        this.isWhite= (idPiece < 7);
    }

    public boolean GetIsWhite(){
        return this.isWhite;
    }

    public int GetidPiece(){
        return this.idPiece;
    }

    public ArrayList<Case> GetListeCoups(){
        return this.listeCoups;
    }

    public void setidPiece(int idPiece){
        this.idPiece = idPiece;
    }

    public void setisWhite(boolean iswhite){
        this.isWhite = iswhite;
    }
}
