import java.io.Console;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;
import javax.swing.text.StyleConstants.ColorConstants;

public class Echiquier {
    private boolean estALendroit;
    private Case[][] echiquier;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[90m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Echiquier() {
        echiquier = new Case[8][8];
        this.estALendroit = true;
        init();
    }

    public Echiquier(boolean estALendroit) {
        echiquier = new Case[8][8];
        this.estALendroit = estALendroit;
        init();
    }

    public Echiquier(int[][] echiquier, boolean estALendroit) {
        this.echiquier = new Case[8][8];
        this.estALendroit = estALendroit;
        this.init(echiquier);
    }

    public Case[][] getEchiquier() {
        return this.echiquier;
    }

    public boolean getEstALendroit() {
        return this.estALendroit;
    }

    public void Afficher() {
        System.out.println("  +---+---+---+---+---+---+---+---+");
        int i = 0;
        int j = 0;
        int pas = 1;
        int nbligne = 8;
        if (!this.estALendroit) {
            i = 7;
            j = 7;
            pas = -1;
            nbligne = 1;
        }
        // System.out.println(" i : " + i + ";pas : " + pas + ";nbligne : " + nbligne);
        System.out.print(nbligne + " ");
        while (i < 8 && i >= 0 && j < 8 && j >= 0) {
            while (j < 8 && j >= 0) {
                if (echiquier[i][j].getPiece() == null) {
                    System.out.print("| " + " " + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 7) {
                    System.out.print("| " + String.format(ANSI_BLACK + "%c" + ANSI_RESET, 0x2659) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 8) {
                    System.out.print("| " + String.format(ANSI_BLACK + "%c" + ANSI_RESET, 0x2656) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 9) {
                    System.out.print("| " + String.format(ANSI_BLACK + "%c" + ANSI_RESET, 0x2658) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 10) {
                    System.out.print("| " + String.format(ANSI_BLACK + "%c" + ANSI_RESET, 0x2657) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 11) {
                    System.out.print("| " + String.format(ANSI_BLACK + "%c" + ANSI_RESET, 0x2655) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 12) {
                    System.out.print("| " + String.format(ANSI_BLACK + "%c" + ANSI_RESET, 0x2654) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 1) {
                    System.out.print("| " + String.format(ANSI_WHITE + "%c" + ANSI_RESET, 0x265F) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 2) {
                    System.out.print("| " + String.format(ANSI_WHITE + "%c" + ANSI_RESET, 0x265C) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 3) {
                    System.out.print("| " + String.format(ANSI_WHITE + "%c" + ANSI_RESET, 0x265E) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 4) {
                    System.out.print("| " + String.format(ANSI_WHITE + "%c" + ANSI_RESET, 0x265D) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 5) {
                    System.out.print("| " + String.format(ANSI_WHITE + "%c" + ANSI_RESET, 0x265B) + " ");
                } else if (echiquier[i][j].getPiece().GetidPiece() == 6) {
                    System.out.print("| " + String.format(ANSI_WHITE + "%c" + ANSI_RESET, 0x265A) + " ");
                }
                j += pas;
            }

            if (estALendroit) {
                System.out.println("|");
                System.out.println("  +---+---+---+---+---+---+---+---+");
                if (nbligne > 1) {
                    nbligne += -pas;
                    System.out.print(nbligne + " ");
                }
            } else {
                System.out.println("|");
                System.out.println("  +---+---+---+---+---+---+---+---+");
                if (nbligne < 8) {
                    nbligne += -pas;
                    System.out.print(nbligne + " ");
                }
            }
            if (estALendroit) {
                j = 0;
            } else {
                j = 7;
            }
            i += pas;
        }
        if (estALendroit) {
            System.out.println("    A   B   C   D   E   F   G   H ");
        } else {
            System.out.println("    H   G   F   E   D   C   B   A ");
        }
        // System.out.println(" i : " + i + ";pas : " + pas + ";nbligne : " + nbligne);
    }

    public void ActuCoups() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.echiquier[i][j].getPiece() != null) {
                    int idPiece = this.echiquier[i][j].getPiece().GetidPiece();
                    this.echiquier[i][j].getPiece().setListeCoups(CalculerCoup(this.echiquier[i][j], idPiece));
                }
            }
        }
    }

    public void init() {
        int i = 0;
        int j = 0;
        Piece piecetmp;
        while (j < 5) {
            int idPiece = 8 + j;
            piecetmp = new Piece((idPiece));
            // piecetmp.setListeCoups(CalculerCoup(this.echiquier[i][j], idPiece));
            this.echiquier[i][j] = new Case(i, j, (new Piece(idPiece)));

            j += 1;
        }
        while (j < 8) {
            int idPiece = 10 - (j - 5);
            piecetmp = new Piece(idPiece);
            // piecetmp.setListeCoups(CalculerCoup(this.echiquier[i][j], idPiece));
            this.echiquier[i][j] = new Case(i, j, piecetmp);

            j += 1;
        }
        i = 1;
        j = 0;
        while (j < 8) {
            piecetmp = new Piece(7);
            // piecetmp.setListeCoups(CalculerCoup(this.echiquier[i][j], 7));
            this.echiquier[i][j] = new Case(i, j, piecetmp);
            j += 1;
        }
        i = 2;
        j = 0;
        while (i < 6) {
            while (j < 8) {
                this.echiquier[i][j] = new Case(i, j);
                j++;
            }
            j = 0;
            i += 1;
        }
        i = 6;
        j = 0;
        while (j < 8) {
            this.echiquier[i][j] = new Case(i, j, (new Piece(1)));
            j += 1;
        }
        i = 7;
        j = 0;
        while (j < 5) {
            this.echiquier[i][j] = new Case(i, j, (new Piece(2 + j)));
            j += 1;
        }
        while (j < 8) {
            this.echiquier[i][j] = new Case(i, j, (new Piece(4 - (j - 5))));
            j += 1;
        }

        this.ActuCoups();
    }

    public void init(int[][] echiquier) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (echiquier[i][j] != 0) {
                    this.echiquier[i][j] = new Case(i, j, (new Piece(echiquier[i][j])));
                } else {
                    this.echiquier[i][j] = new Case(i, j);
                }
            }
        }

        this.ActuCoups();
    }

    public void AfficheString() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                System.out.println(this.echiquier[i][j].toString() + "\n");
                // if (this.echiquier[i][j].getPiece() != null) {
                // System.out.println(
                // } else {
                // System.out.println("Ligne : " + this.echiquier[i][j].GetLigne() + "; Colonne
                // : "
                // + this.echiquier[i][j].GetColonne() + " ; IsWhite : " + false + " ; Valeur :
                // " + 0);
                // }
            }
        }
    }

    public ArrayList<Case> CalculerCoupTour(Case casedep) {
        ArrayList<Case> res = new ArrayList<Case>();
        int colonne = casedep.GetColonne();
        int ligne = casedep.GetLigne();
        // int colonne = (int) casedep.toLowerCase().charAt(0) - 97;
        // int ligne = 8 - Character.getNumericValue(casedep.charAt(1));
        int i = ligne + 1;
        boolean estblanc = casedep.getPiece().GetIsWhite();
        while (i < 8) {
            if (this.echiquier[i][colonne].getPiece() != null) {
                boolean iswhite = this.echiquier[i][colonne].getPiece().GetIsWhite();
                if (iswhite != estblanc) {
                    res.add(echiquier[i][colonne]);
                    break;
                } else {
                    break;
                }
            } else {
                res.add(echiquier[i][colonne]);
            }
            i += 1;
        }
        i = ligne - 1;
        while (i >= 0) {
            if (this.echiquier[i][colonne].getPiece() != null) {
                boolean iswhite = this.echiquier[i][colonne].getPiece().GetIsWhite();
                if (iswhite != estblanc) {
                    res.add(echiquier[i][colonne]);
                    break;
                } else {
                    break;
                }
            } else {
                res.add(echiquier[i][colonne]);
            }
            i -= 1;
        }
        i = colonne + 1;
        while (i < 8) {
            if (this.echiquier[ligne][i].getPiece() != null) {
                boolean iswhite = this.echiquier[ligne][i].getPiece().GetIsWhite();
                if (iswhite != estblanc) {
                    res.add(echiquier[ligne][i]);
                    break;
                } else {
                    break;
                }
            } else {
                res.add(echiquier[ligne][i]);
            }
            i += 1;
        }
        i = colonne - 1;
        while (i >= 0) {
            if (this.echiquier[ligne][i].getPiece() != null) {
                boolean iswhite = this.echiquier[ligne][i].getPiece().GetIsWhite();
                if (iswhite != estblanc) {
                    res.add(echiquier[ligne][i]);
                    break;
                } else {
                    break;
                }
            } else {
                res.add(echiquier[ligne][i]);
            }
            i -= 1;
        }
        return res;
    }

    public ArrayList<Case> CalculerCoupFou(Case casedep) {
        ArrayList<Case> res = new ArrayList<Case>();
        int colonne = casedep.GetColonne();
        int ligne = casedep.GetLigne();
        // int colonne = (int) casedep.toLowerCase().charAt(0) - 97;
        // int ligne = 8 - Character.getNumericValue(casedep.charAt(1));
        int i = ligne + 1;
        int j = colonne + 1;
        while (i < 8 && j < 8 && j >= 0 && i >= 0) {
            if (this.echiquier[i][j].getPiece() != null) {
                boolean estblanc = casedep.getPiece().GetIsWhite();
                if (this.echiquier[i][j].getPiece().GetIsWhite() != estblanc) {
                    res.add(echiquier[i][j]);
                    break;
                } else {
                    break;
                }
            }
            if (this.echiquier[i][j].getPiece() == null) {
                res.add(echiquier[i][j]);
            }
            i++;
            j++;
        }
        i = ligne - 1;
        j = colonne - 1;
        while (i < 8 && j < 8 && j >= 0 && i >= 0) {
            if (this.echiquier[i][j].getPiece() != null) {
                boolean estblanc = casedep.getPiece().GetIsWhite();
                if (this.echiquier[i][j].getPiece().GetIsWhite() != estblanc) {
                    res.add(echiquier[i][j]);
                    break;
                } else {
                    break;
                }
            }
            if (this.echiquier[i][j].getPiece() == null) {
                res.add(echiquier[i][j]);
            }
            i -= 1;
            j -= 1;
        }
        i = ligne + 1;
        j = colonne - 1;
        while (i < 8 && j < 8 && j >= 0 && i >= 0) {
            if (this.echiquier[i][j].getPiece() != null) {
                boolean estblanc = casedep.getPiece().GetIsWhite();
                if (this.echiquier[i][j].getPiece().GetIsWhite() != estblanc) {
                    res.add(echiquier[i][j]);
                    break;
                } else {
                    break;
                }
            }
            if (this.echiquier[i][j].getPiece() == null) {
                res.add(echiquier[i][j]);
            }
            i += 1;
            j -= 1;
        }
        i = ligne - 1;
        j = colonne + 1;
        while (i < 8 && j < 8 && j >= 0 && i >= 0) {
            if (this.echiquier[i][j].getPiece() != null) {
                boolean estblanc = casedep.getPiece().GetIsWhite();
                if (this.echiquier[i][j].getPiece().GetIsWhite() != estblanc) {
                    res.add(echiquier[i][j]);
                    break;
                } else {
                    break;
                }
            }
            if (this.echiquier[i][j].getPiece() == null) {
                res.add(echiquier[i][j]);
            }
            i -= 1;
            j += 1;
        }

        return res;

    }

    public ArrayList<Case> CalculerCoupDame(Case casedep) {
        ArrayList<Case> res = new ArrayList<Case>();
        // int colonne = casedep.GetColonne();
        // int ligne = casedep.GetLigne();
        res.addAll(CalculerCoupFou(casedep));
        res.addAll(CalculerCoupTour(casedep));
        return res;
    }

    public boolean CoupMetEnEchec(Case casedep, Case casearr) {
        // int ligne = casedep.GetLigne();
        // int colonne = casedep.GetColonne();
        boolean estblanc = casedep.getPiece().GetIsWhite();

        int ligne2 = casearr.GetLigne();
        int colonne2 = casearr.GetColonne();

        Case[][] simulechiquier = this.echiquier;
        Piece tmpPiece = casedep.getPiece();
        casedep.setPiece(null);;
        casearr.setPiece(tmpPiece);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (simulechiquier[i][j].getPiece() != null) {
                    if (simulechiquier[i][j].getPiece() != null && simulechiquier[i][j].getPiece().GetIsWhite() != estblanc
                            && (simulechiquier[i][j].getPiece().GetListeCoups() != null)) {
                        if (simulechiquier[i][j].getPiece().GetListeCoups()
                                .contains(simulechiquier[ligne2][colonne2])) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean EstEnEchecRoi(Case casedep) {
        // int ligne = casedep.GetLigne();
        // int colonne = casedep.GetColonne();
        boolean estblanc = casedep.getPiece().GetIsWhite();

        int ligne2 = casedep.GetLigne();
        int colonne2 = casedep.GetColonne();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.echiquier[i][j].getPiece() != null) {
                    if (this.echiquier[i][j].getPiece().GetIsWhite() != estblanc
                            && (this.echiquier[i][j].getPiece().GetListeCoups() != null)) {
                        if (this.echiquier[i][j].getPiece().GetListeCoups()
                                .contains(this.echiquier[ligne2][colonne2])) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean EstEnEchecEtMat(Case casedep) {
        // int ligne = casedep.GetLigne();
        // int colonne = casedep.GetColonne();
        if(casedep.getPiece() == null){
            return false;
        }
        if(casedep.getPiece().GetListeCoups() == null){
            return true;
        }
        return (EstEnEchecRoi(casedep)) && (casedep.getPiece().GetListeCoups().size() == 0);

        
    }

    public ArrayList<Case> CalculerCoupRoi(Case casedep) {
        ArrayList<Case> res = new ArrayList<Case>();
        // int colonne = (int) casedep.toLowerCase().charAt(0) - 97;
        // int ligne = 8 - Character.getNumericValue(casedep.charAt(1));
        int colonne = casedep.GetColonne();
        int ligne = casedep.GetLigne();
        boolean estblanc = casedep.getPiece().GetIsWhite();
        int i = 0;
        int j = 0;
        int[][] listedecalages = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 },
                { 0, -1 } };
        for (int ind = 0; ind < 8; ind++) {
            i = ligne + listedecalages[ind][0];
            j = colonne + listedecalages[ind][1];
            if (0 <= i && i < 8 && 0 <= j && j < 8) {
                if (this.echiquier[i][j].getPiece() == null) {
                    if (!CoupMetEnEchec(casedep, this.echiquier[i][j])) {
                        res.add(this.echiquier[i][j]);
                    }
                } else if ((this.echiquier[i][j].getPiece().GetIsWhite() != estblanc)
                        && (!CoupMetEnEchec(casedep, this.echiquier[i][j]))) {
                    res.add(this.echiquier[i][j]);
                }

            }
        }
        return res;
    }

    public ArrayList<Case> CalculerCoupCavalier(Case casedep) {
        ArrayList<Case> res = new ArrayList<Case>();
        int colonne = casedep.GetColonne();
        int ligne = casedep.GetLigne();
        // int colonne = (int) casedep.toLowerCase().charAt(0) - 97;
        // int ligne = 8 - Character.getNumericValue(casedep.charAt(1));
        boolean estblanc = casedep.getPiece().GetIsWhite();
        int i = 0;
        int j = 0;
        int[][] listedecalages = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 },
                { -1, -2 } };
        for (int ind = 0; ind < 8; ind++) {
            i = ligne + listedecalages[ind][0];
            j = colonne + listedecalages[ind][1];
            if (0 <= i && i < 8 && 0 <= j && j < 8) {
                if (this.echiquier[i][j].getPiece() == null) {
                    res.add(this.echiquier[i][j]);
                } else if (this.echiquier[i][j].getPiece().GetIsWhite() != estblanc) {
                    res.add(this.echiquier[i][j]);
                }

            }
        }
        return res;
    }

    public ArrayList<Case> CalculerCoupPion(Case casedep) {
        ArrayList<Case> res = new ArrayList<Case>();
        int colonne = casedep.GetColonne();
        int ligne = casedep.GetLigne();
        // int colonne = (int) casedep.toLowerCase().charAt(0) - 97;
        // int ligne = 8 - Character.getNumericValue(casedep.charAt(1));
        boolean estblanc = casedep.getPiece().GetIsWhite();

        int pas = -1;
        // int[][] listedecalages = { { -1, -1 }, { -1, 0 }, { -2, 0 }, { -1, 1 } };
        if (!estblanc) {
            // for (int x = 0; x < 4; x++) {
            // for (int y = 0; x < 2; x++) {
            // listedecalages[x][y] = -listedecalages[x][y];
            // }
            // }
            pas = 1;
        }
        int i = ligne + pas;
        int j = colonne + pas;

        if (0 <= i && i < 8 && 0 <= j && j < 8) {
            if (this.echiquier[i][j].getPiece() != null) {
                if (this.echiquier[i][j].getPiece().GetIsWhite() != estblanc) {
                    res.add(this.echiquier[i][j]);
                }
            }
        }

        i = ligne + pas;
        j = colonne;

        if (0 <= i && i < 8 && 0 <= j && j < 8) {
            if (this.echiquier[i][j].getPiece() == null) {
                res.add(this.echiquier[i][j]);
            }
        }

        if (!this.echiquier[ligne][colonne].getPiece().getMoved()) {
            i = ligne + (2 * pas);
            if (this.echiquier[i][j].getPiece() == null) {
                res.add(this.echiquier[i][j]);
            }
        }

        i = ligne + pas;
        j = colonne - pas;

        if (0 <= i && i < 8 && 0 <= j && j < 8) {
            if (this.echiquier[i][j].getPiece() != null) {
                if (this.echiquier[i][j].getPiece().GetIsWhite() != estblanc) {
                    res.add(this.echiquier[i][j]);
                }
            }
        }
        return res;
    }

    public ArrayList<Case> CalculerCoup(Case casedep, int idPiece) {

        if (idPiece == 1 || idPiece == 7) {
            return CalculerCoupPion(casedep);
        } else if (idPiece == 2 || idPiece == 8) {
            return CalculerCoupTour(casedep);
        } else if (idPiece == 9 || idPiece == 3) {
            return CalculerCoupCavalier(casedep);
        } else if (idPiece == 10 || idPiece == 4) {
            return CalculerCoupFou(casedep);
        } else if (idPiece == 11 || idPiece == 5) {
            return CalculerCoupDame(casedep);
        } else if (idPiece == 12 || idPiece == 6) {
            return CalculerCoupRoi(casedep);
        }
        return (new ArrayList<Case>());
    }

    // for (int ind = 0; ind < 4; ind++) {
    // i = ligne + listedecalages[ind][0];
    // j = colonne + listedecalages[ind][1];
    // if (0 <= i && i < 8 && 0 <= j && j < 8) {
    // if (this.echiquier[i][j].getPiece() == null) {
    // res.add(this.echiquier[i][j]);
    // } else if (this.echiquier[i][j].getPiece().GetIsWhite() != estblanc) {
    // res.add(this.echiquier[i][j]);
    // }

    // }
    // }
    // return res;
    // }

    public boolean EstCoupValide(Case casedep, Case casearr) {
        // On verifiera si le coup entré correspont au bon camp dans la classe Game
        // (boucle principale)
        // int colonne = (int)coup.toLowerCase().charAt(0) - 97 ;
        // int ligne = 8 - Character.getNumericValue(coup.charAt(1));
        // int colonne2 = (int) coup.toLowerCase().charAt(2) - 97;
        // int ligne2 = 8 - Character.getNumericValue(coup.charAt(3));
        // String coupdep = coup.charAt(0) + "" + coup.charAt(1);
        // String coupfin = coup.charAt(2) + "" + coup.charAt(3);
        // String substring(int beginIndex, int endIndex)
        // utiliser la méthode contains

        int ligne = casedep.GetLigne();
        int colonne = casedep.GetColonne();
        int ligne2 = casearr.GetLigne();
        int colonne2 = casearr.GetColonne();

        if (this.echiquier[ligne][colonne].getPiece().GetidPiece() == 1
                || this.echiquier[ligne][colonne].getPiece().GetidPiece() == 7) {
            ArrayList<Case> listecoup = CalculerCoupPion(casedep);
            return listecoup.contains(this.echiquier[ligne2][colonne2]);
        }

        else if (this.echiquier[ligne][colonne].getPiece().GetidPiece() == 2
                || this.echiquier[ligne][colonne].getPiece().GetidPiece() == 8) {
            ArrayList<Case> listecoup = CalculerCoupTour(casedep);
            return listecoup.contains(this.echiquier[ligne2][colonne2]);
        } else if (this.echiquier[ligne][colonne].getPiece().GetidPiece() == 9
                || this.echiquier[ligne][colonne].getPiece().GetidPiece() == 3) {
            ArrayList<Case> listecoup = CalculerCoupCavalier(casedep);
            return listecoup.contains(this.echiquier[ligne2][colonne2]);
        } else if (this.echiquier[ligne][colonne].getPiece().GetidPiece() == 10
                || this.echiquier[ligne][colonne].getPiece().GetidPiece() == 4) {
            ArrayList<Case> listecoup = CalculerCoupFou(casedep);
            return listecoup.contains(this.echiquier[ligne2][colonne2]);
        } else if (this.echiquier[ligne][colonne].getPiece().GetidPiece() == 11
                || this.echiquier[ligne][colonne].getPiece().GetidPiece() == 5) {
            ArrayList<Case> listecoup = CalculerCoupDame(casedep);
            return listecoup.contains(this.echiquier[ligne2][colonne2]);
        } else if (this.echiquier[ligne][colonne].getPiece().GetidPiece() == 12
                || this.echiquier[ligne][colonne].getPiece().GetidPiece() == 6) {
            ArrayList<Case> listecoup = CalculerCoupRoi(casedep);
            return listecoup.contains(this.echiquier[ligne2][colonne2]);
        }
        return false;
    }

    public void SetEchiquier(Case[][] echiquier) {
        this.echiquier = echiquier;
    }

    public void SetEstALEndroit(boolean estALendroit) {
        this.estALendroit = estALendroit;
    }
}