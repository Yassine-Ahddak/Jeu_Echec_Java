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
    public MatToCoo(){

    };

    public CooToMat(){

    };
}
