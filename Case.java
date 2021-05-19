public class Case {
    private int ligne;
    private int colonne;
    private boolean iscasewhite;
    private int idCase;
    private int valcase;

    public Case(int idcase,boolean iscasewhite,int valcase){
        this.idCase = idcase;
        this.iscasewhite = iscasewhite;
        this.valcase = valcase;
        String coo = TabIndexToCoo(idcase);
        this.colonne = (int)coo.charAt(0);
        this.ligne = coo.charAt(1);
    }

    public Case(int idcase){
        this.idCase = idcase;
        this.iscasewhite = false;
        this.valcase = 0;
    }

    public int GetValCase(){
        return this.valcase;
    }
    public int GetIdCase(){
        return this.idCase;
    }
    public boolean GetIsCaseWhite(){
        return this.iscasewhite;
    }

    public int GetColonne(){
        return this.colonne;
    }

    public int GetLigne(){
        return this.ligne;
    }

    public String TabIndexToCoo(int i){
        String lettre = Character.toString((char)((int)'a' + i % 8));
        int chiffre = 8 - (i /8);
        return (lettre + chiffre);
    };

    public int CooToTabIndex(String coup){
        int colonne = (int)coup.toLowerCase().charAt(0) -  97 ;
        int ligne = Character.getNumericValue(coup.charAt(1));
        int res = 8 * (8 - ligne) + colonne;
        return res;
    };
}
