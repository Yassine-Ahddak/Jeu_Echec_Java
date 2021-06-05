public class Tour extends Piece{

    public Tour(boolean iswhite){
        super((iswhite) ?2:8);

    }

    public boolean EstCoupValide(String coup){
        int colonne = (int)coup.toLowerCase().charAt(0) -  97 ;
        int ligne = 8 - Character.getNumericValue(coup.charAt(1));
        int colonne2 = (int)coup.toLowerCase().charAt(2) - 97;
        int ligne2 = 8 - Character.getNumericValue(coup.charAt(3));

        return (colonne == colonne2 || ligne == ligne2);
    }
}
