import java.io.Console;
import java.util.*;

import javax.print.event.PrintEvent;

public class salut {
    public static void main(String[] args) {
        // code ici xd
        // System.out.println("salut");
        // Echiquier testechiquier = new Echiquier();
        // testechiquier.Afficher();
        // int nbligne = 8;
        // System.out.print(nbligne + " ");
        // for(int i=0;i<64;i++){
        // System.out.print("| " + i + " ");
        // if(i < 10){
        // System.out.print(" ");
        // }
        // if((i+1)%8 == 0){
        // System.out.println("|");
        // System.out.println(" +----+----+----+----+----+----+----+----+");
        // if(nbligne > 1){
        // nbligne--;
        // System.out.print(nbligne + " ");
        // }
        // }
        // }
        // System.out.println(" A B C D E F G H ");
        // String test = "A5";
        // char oui = test.toLowerCase().charAt(0);
        // System.out.print(test.toLowerCase().charAt(0));
        // System.out.print((int)oui);
        // String coup = "H1";
        // int colonne = (int)coup.toLowerCase().charAt(0) - 97 ;
        // int ligne = Character.getNumericValue(coup.charAt(1));
        // int res = 8 * (8 - ligne) + colonne;
        // System.out.println(res);

        // int[] chiffres = {1,2,3,4,5,6,7,8};
        // String[] lettres = {"A","B","C","D","E","F","G","H"};
        // int test = 24;
        // int indlettre = test / 8
        // String lettre = Character.toString((char)((int)'a' + test % 8));
        // int chiffre = 8 - (test /8);
        // System.out.println(lettre + chiffre);

        // int i = 55;
        // int chiffre = 8 - (i /8);
        // System.out.print(chiffre);

        // int[] listeindices = {-1,-9,-8,-7,1,9,8,7};
        // for (int i : listeindices) {
        // System.out.println(i);

        // }

        // int colonne = (int)coup.toLowerCase().charAt(0) - 97 ;
        // int ligne = Character.getNumericValue(coup.charAt(1));
        // int indexcasedep = 8 * (8 - ligne) + colonne;
        // int colonne2 = (int)coup.toLowerCase().charAt(2) - 97 ;
        // int ligne2 = Character.getNumericValue(coup.charAt(3));
        // int indexcasefin = 8 * (8 - ligne2) + colonne2;
        // String coupdep = coup.charAt(0) + "" + coup.charAt(1);
        // String coupfin = coup.charAt(2) + "" + coup.charAt(3);

        // System.out.println("case : " + coupdep + "; Ligne : " + ligne + "; colonne :
        // " + colonne + " ; Id dans l'echiquier " + indexcasedep);
        // System.out.println("case : " + coupfin + "; Ligne : " + ligne2 + "; colonne :
        // " + colonne2 + " ; Id dans l'echiquier " + indexcasefin);

        // Echiquier testechiquier = new Echiquier();
        // System.out.println(String.format("%c", 0x2659));
        // int test = (int)'a';
        // System.out.println(test);

        // String coup = "e6";
        // int[] res = new int[2];
        // int colonne = (int)coup.toLowerCase().charAt(0) - 97 ;
        // int ligne = 8 - Character.getNumericValue(coup.charAt(1));
        // res[0] = ligne;
        // res[1] = colonne;
        // System.out.println("ligne : " + res[0] + "; colonne : " + res[1]);

        // Echiquier test = new Echiquier();
        // test.Afficher();

        /*
         * String coup = "f5b8";
         * 
         * int colonne = (int)coup.toLowerCase().charAt(0) - 97 ; int ligne = 8 -
         * Character.getNumericValue(coup.charAt(1)); int colonne2 =
         * (int)coup.toLowerCase().charAt(2) - 97; int ligne2 = 8 -
         * Character.getNumericValue(coup.charAt(3));
         * 
         * String coupdep = coup.charAt(0) + "" + coup.charAt(1); String coupfin =
         * coup.charAt(2) + "" + coup.charAt(3);
         * 
         * System.out.println("case : " + coupdep + "; Ligne : " + ligne +
         * "; colonne : " + colonne); System.out.println("case : " + coupfin +
         * "; Ligne : " + ligne2 + "; colonne : " + colonne2);
         * System.out.println(colonne2 - colonne); System.out.println(ligne2 - ligne);
         * System.out.println((Math.abs(colonne2 - colonne)) == (Math.abs(ligne2 -
         * ligne)));
         */

        Partie test1 = new Partie();
        test1.restaurer();
        Echiquier echiquerqrfqeqesf = test1.getPartieEchiquier();
        test1.getPartieEchiquier().Afficher();
        echiquerqrfqeqesf.getEchiquier()[5][2].getPiece().setMoved(true);
        ArrayList<Case> listecoup = echiquerqrfqeqesf.CalculerCoupRoi("c3");
        for(Case cases : listecoup){
            System.out.println(cases.toString() + "\n");
            
        }

        System.out.println(echiquerqrfqeqesf.EstCoupValide("c3b5"));
        //test1.sauvegarde();
        // test1.getPartieEchiquier().Afficher();
        // for (int i = 0; i < 8; i++) {
        //     for (int j = 0; j < 8; j++) {
        //         if (test1.getEchiquier()[i][j].getPiece() != null) {
        //             System.out.print(test1.getEchiquier()[i][j].getPiece().GetidPiece() + " ");
        //         } else {
        //             System.out.print(0 + " ");
        //         }
        //     }
        //     System.out.println("");
        // }
        // System.out.print("\u001B[30mERROR \033[0m salut");

        // int[][] listedecalages = {{-1,-1},{-1,0},{-2,0},{-1,1}};
        //     for (int x = 0; x < 4; x++) {
        //         for (int y = 0; y < 2; y++) {
        //             listedecalages[x][y] = - listedecalages[x][y];
        //         }
        //     }
        
        //     for (int i = 0; i < 4; i++) {
        //         for (int j = 0; j < 2; j++) {
        //             System.out.println(listedecalages[i][j] + " ");
        //     }
        // }

            
        // Dame dame = new Dame(false);
        // Case case1 = new Case(0,5,dame);
        // Case case2 = new Case(0,6);

        // if(case2.getPiece() == null){
        // System.out.println("Salut");
        // }

        // if(case1.getPiece() != null){
        // System.out.println("Salut case 1 n'est pas vide");
        // }

        // Piece piecetmp = case1.getPiece();

        // case1.setPiece(case2.getPiece());
        // case2.setPiece(piecetmp);

        // if(case1.getPiece() == null){
        // System.out.println("Salut case 1 est devenue vide");
        // }

        // boolean saluet = dame.GetIsWhite();
        // int toucouy = dame.GetidPiece();
        // System.out.println(" blanc ? : " + saluet + " ; id : " + toucouy);
        // if(estblanc){
        //     listedecalages[0][0]= -1;
        //     listedecalages[0][1]= -1;
        //     listedecalages[1][0] = -1;
        //     listedecalages[1][1] = 0;
        //     listedecalages[2][0] = -2;
        //     listedecalages[2][1] = 0;
        //     listedecalages[3][0] = -1;
        //     listedecalages[3][1] = 1;
        // }else{            
        //     // listedecalages[0][0]= 1;
        //     // listedecalages[0][1]= 1;
        //     // listedecalages[1][0] = 1;
        //     // listedecalages[1][1] = 0;
        //     // listedecalages[2][0] = 2;
        //     // listedecalages[2][1] = 0;
        //     // listedecalages[3][0] = 1;
        //     // listedecalages[3][1] = -1;;
        // }
        // Case case1 = new Case(ligne, colonne, iscasewhite, valcase)

        // testechiquier.Afficher();
        // testechiquier.SetEstALEndroit(false);
        // testechiquier.Afficher();

    }
}
