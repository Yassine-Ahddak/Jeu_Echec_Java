public class Case {
    private int ligne;
    private int colonne;
    // private boolean iscasewhite;
    //private int idCase;
    private Piece piece;
    private int valcase;
    private String coo;

    // public Case(int ligne, int colonne, boolean iscasewhite,int valcase){
    //     this.colonne = colonne;
    //     this.ligne = ligne;
    //     this.iscasewhite = iscasewhite;
    //     this.valcase = valcase;
    //     this.coo = TabIndexToCoo(ligne,colonne);
    // }

    public Case(int ligne, int colonne, Piece piece){
        this.colonne = colonne;
        this.ligne = ligne;
        this.piece = piece;
        this.coo = TabIndexToCoo(ligne,colonne);
    }

    public Case(int ligne, int colonne){
        this.colonne = colonne;
        this.ligne = ligne;
        this.coo = TabIndexToCoo(ligne,colonne);
    }

    // public Case(int idcase){
    //     this.idCase = idcase;
    //     this.iscasewhite = false;
    //     this.valcase = 0;
    // }

    // public int GetValCase(){
    //     return this.valcase;
    // }
    // public int GetIdCase(){
    //     return this.idCase;
    // }
    // public boolean GetIsCaseWhite(){
    //     return this.iscasewhite;
    // }

    public int GetColonne(){
        return this.colonne;
    }

    public int GetLigne(){
        return this.ligne;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }

    public String TabIndexToCoo(int ligne,int colonne){
        String lettre = Character.toString((char)((int)'a' + colonne));
        int chiffre = 8 - ligne;
        return (lettre + chiffre);
    };

    public int[] CooToTabIndex(String coup){
        int[] res = new int[2];
        int colonne = (int)coup.toLowerCase().charAt(0) -  97 ;
        int ligne = 8 - Character.getNumericValue(coup.charAt(1));
        //int res = 8 * (8 - ligne) + colonne;
        res[0] = ligne;
        res[1] = colonne;

        return res;
    };
}
