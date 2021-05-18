import java.util.ArrayList;

public class Piece {
    private Case pos;
    private ArrayList<Case> listeCoups;
    private boolean moved;  //en public pour y avoir accès dans les classes qui héritent de Piece
    private boolean isWhite;
    private char type;

    public boolean GetIsWhite(){
        return this.isWhite;
    }

    public char GetType(){
        return this.type;
    }

    public ArrayList<Case> GetListeCoups(){
        return this.listeCoups;
    }

    public Case GetPose(){
        return this.pos;
    }
}
