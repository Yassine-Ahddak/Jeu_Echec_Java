public class Dame extends Piece{
    public boolean EstCoupPossible(String coup){
        int colonne = (int) coup.toLowerCase().charAt(0) - 97;
        int ligne = Character.getNumericValue(coup.charAt(1));
        int indexcasedep = 8 * (8 - ligne) + colonne;
        int colonne2 = (int) coup.toLowerCase().charAt(2) - 97;
        int ligne2 = Character.getNumericValue(coup.charAt(3));
        int indexcasefin = 8 * (8 - ligne2) + colonne2;
        String coupdep = coup.charAt(0) + "" + coup.charAt(1);
        String coupfin = coup.charAt(2) + "" + coup.charAt(3);
        return(Math.abs(indexcasedep - indexcasefin) % 7 == 0);

        // A déterminer : comment faire en sorte que c'est bien dans la bonne diagonale
    };
}
