public class Cavalier extends Piece{

    public Cavalier(boolean iswhite){
        super((iswhite) ?3:9);
    }

    public boolean EstCoupPossible(String coup){
        // {-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}

        int colonne = (int)coup.toLowerCase().charAt(0) -  97 ;
        int ligne = 8 - Character.getNumericValue(coup.charAt(1));
        int colonne2 = (int)coup.toLowerCase().charAt(2) - 97;
        int ligne2 = 8 - Character.getNumericValue(coup.charAt(3));
        int pas = 1;

        boolean cond1 = ((ligne == ligne2 + (-2*pas) && (colonne == colonne2  - pas)));
        boolean cond2 = ((ligne == ligne2 + pas) && (colonne == colonne2));
        boolean cond3 = ((ligne == ligne2 + (2*pas)) && (colonne == colonne2));
        boolean cond4 = ((ligne == ligne2 + pas) && (colonne == colonne2 - pas));

        return (cond1 || cond2 || cond3 || cond4);
    };
}
