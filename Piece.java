public class Piece {
    private Case pos;
    private Case [] listeCoups;
    public boolean moved;  //en public pour y avoir accès dans les classes qui héritent de Piece
    private boolean isWhite;
    private char type;
}
