public class Pion extends Piece{
    private boolean estPromu;

    public Pion(boolean iswhite){
        super((iswhite) ?1:7);

    }

    public boolean EstCoupValide(String coup){
        int colonne = (int)coup.toLowerCase().charAt(0) -  97 ;
        int ligne = 8 - Character.getNumericValue(coup.charAt(1));
        int colonne2 = (int)coup.toLowerCase().charAt(2) - 97;
        int ligne2 = 8 - Character.getNumericValue(coup.charAt(3));
        int pas;
        if(this.GetIsWhite()){
            boolean cond1 = ((ligne == ligne2 - 1) && (colonne == colonne2 - 1));
            boolean cond2 = ((ligne == ligne2 - 1) && (colonne == colonne2));
            boolean cond3 = ((ligne == ligne2 - 2) && (colonne == colonne2));
            boolean cond4 = ((ligne == ligne2 - 1) && (colonne == colonne2 + 1));

            return (cond1 || cond2 || cond3 || cond4);
        } else if(!this.GetIsWhite()) {
            boolean cond5 = ((ligne == ligne2 + 1) && (colonne == colonne2 + 1));
            boolean cond6 = ((ligne == ligne2 + 1) && (colonne == colonne2));
            boolean cond7 = ((ligne == ligne2 + 2) && (colonne == colonne2));
            boolean cond8 = ((ligne == ligne2 + 1) && (colonne == colonne2 - 1));

            return (cond5 || cond6 || cond7 || cond8);
        }

        return false;

        /*verif 1: 
        *******************PION BLANC******************
        - ligne2 - 1 && colonne2 == - 1
        - ligne2 - 1 && colonne2 == 0
        - ligne2 - 2 && colonne2 == 0
        - ligne2 - 1 && colonne2 == + 1
        */

        /*verif 2: 
        *******************PION NOIR******************
        - ligne2 + 1 && colonne2 == + 1
        - ligne2 + 1 && colonne2 == 0
        - ligne2 + 2 && colonne2 == 0
        - ligne2 + 1 && colonne2 == - 1
        */
        
    }
}
