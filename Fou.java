public class Fou extends Piece{

    public Fou(boolean iswhite){
        super((iswhite) ?4:10);

    }
    public boolean EstCoupValide(String coup){
        int colonne = (int)coup.toLowerCase().charAt(0) -  97 ;
        int ligne = 8 - Character.getNumericValue(coup.charAt(1));
        int colonne2 = (int)coup.toLowerCase().charAt(2) - 97;
        int ligne2 = 8 - Character.getNumericValue(coup.charAt(3));

        return ((Math.abs(colonne2 - colonne)) == (Math.abs(ligne2 - ligne)));
    }
}
