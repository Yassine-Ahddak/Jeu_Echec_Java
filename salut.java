import java.io.Console;
import java.util.*;
public class salut {
    public static void main(String[] args)	{
        // code ici xd
        //System.out.println("salut");
        //Echiquier testechiquier = new Echiquier();
        //testechiquier.Afficher();
        // int nbligne = 8;
        // System.out.print(nbligne + " ");
        // for(int i=0;i<64;i++){
        //    System.out.print("| " + i + " ");
        //    if(i < 10){
        //        System.out.print(" ");
        //    }
        //    if((i+1)%8 == 0){
        //        System.out.println("|");
        //        System.out.println("  +----+----+----+----+----+----+----+----+");
        //        if(nbligne > 1){
        //        nbligne--;
        //        System.out.print(nbligne + " ");
        //    }
        //    }
        // }
        // System.out.println("    A    B    C    D    E     F    G    H ");
        //String test = "A5";
        //char oui = test.toLowerCase().charAt(0);
        //System.out.print(test.toLowerCase().charAt(0));
        //System.out.print((int)oui);
        //String coup = "H1";
        //int colonne = (int)coup.toLowerCase().charAt(0) -  97 ;
        //int ligne = Character.getNumericValue(coup.charAt(1));
        //int res = 8 * (8 - ligne) + colonne;
        //System.out.println(res);

        //int[] chiffres = {1,2,3,4,5,6,7,8};
        //String[] lettres = {"A","B","C","D","E","F","G","H"};
        //int test = 24;
        //int indlettre = test / 8 
        //String lettre = Character.toString((char)((int)'a' + test % 8));
        //int chiffre = 8 - (test /8);
        //System.out.println(lettre + chiffre);

        // int i = 55;
        // int chiffre = 8 - (i /8);
        // System.out.print(chiffre);

        // int[] listeindices = {-1,-9,-8,-7,1,9,8,7};
        // for (int i : listeindices) {
        //     System.out.println(i);
            
        // }

        String coup = "e1e2";
        int colonne = (int)coup.toLowerCase().charAt(0) -  97 ;
        int ligne = Character.getNumericValue(coup.charAt(1));
        int indexcasedep = 8 * (8 - ligne) + colonne;
        int colonne2 = (int)coup.toLowerCase().charAt(2) -  97 ;
        int ligne2 = Character.getNumericValue(coup.charAt(3));
        int indexcasefin = 8 * (8 - ligne2) + colonne2;
        String coupdep = coup.charAt(0) + "" + coup.charAt(1);
        String coupfin = coup.charAt(2) + "" + coup.charAt(3);

        System.out.println("case : " + coupdep + "; Ligne : " + ligne + "; colonne : " + colonne + " ; Id dans l'echiquier " + indexcasedep);
        System.out.println("case : " + coupfin + "; Ligne : " + ligne2 + "; colonne : " + colonne2 + " ; Id dans l'echiquier " + indexcasefin);

        


    }
}
