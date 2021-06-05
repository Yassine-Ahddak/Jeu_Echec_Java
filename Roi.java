public class Roi extends Piece{

    public Roi(boolean iswhite){
        super((iswhite) ?6:12);

    }

    public boolean EstCoupValide(String coup){
        int colonne = (int)coup.toLowerCase().charAt(0) -  97 ;
        int ligne = 8 - Character.getNumericValue(coup.charAt(1));
        int colonne2 = (int)coup.toLowerCase().charAt(2) - 97;
        int ligne2 = 8 - Character.getNumericValue(coup.charAt(3));

        //{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}}

        boolean cond1 = ((ligne == ligne2 - 1) && (colonne == colonne2 - 1));
        boolean cond2 = ((ligne == ligne2 - 1) && (colonne == colonne2));
        boolean cond3 = ((ligne == ligne2 - 1) && (colonne == colonne2 + 1));
        boolean cond4 = ((ligne == ligne2) && (colonne == colonne2 + 1));
        boolean cond5 = ((ligne == ligne2 + 1) && (colonne == colonne2 + 1));
        boolean cond6 = ((ligne == ligne2 + 1) && (colonne == colonne2));
        boolean cond7 = ((ligne == ligne2 + 1) && (colonne == colonne2 - 1));
        boolean cond8 = ((ligne == ligne2) && (colonne == colonne2 - 1));

        return (cond1 || cond2 || cond3 || cond4 || cond5 || cond6 || cond7 || cond8);
    };
}
