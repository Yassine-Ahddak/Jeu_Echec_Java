public class Dame extends Piece{

    public Dame(int idPiece){
        super(idPiece);
    }

    public Dame(boolean iswhite){
        super((iswhite) ?5:11);

    }

    public boolean EstCoupPossible(String coup){
        int colonne = (int)coup.toLowerCase().charAt(0) -  97 ;
        int ligne = 8 - Character.getNumericValue(coup.charAt(1));
        int colonne2 = (int)coup.toLowerCase().charAt(2) - 97;
        int ligne2 = 8 - Character.getNumericValue(coup.charAt(3));

        return (colonne == colonne2 || ligne == ligne2) || (Math.abs(colonne2 - colonne)) == (Math.abs(ligne2 - ligne));
    };
}


    // 8 9 10 11 12 10 9 8
    // 7 7 7 7 7 7 7 7
    // 0 0 0 0 0 0 0 0
    // 0 0 0 0 0 0 0 0
    // 0 0 0 0 0 0 0 0
    // 0 0 0 0 0 0 0 0
    // 1 1 1 1 1 1 1 1
    // 2 3 4 5 6 4 3 2
