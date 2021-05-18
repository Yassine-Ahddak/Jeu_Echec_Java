import java.io.Console;

public class Echiquier{
    private boolean estALendroit;
    private Case[] echiquier;

    public Echiquier(){
        echiquier = new Case[64];
        init();
    }
    public void Afficher(){
        System.out.println("  +---+---+---+---+---+---+---+---+");
        int nbligne = 1;
        System.out.print(nbligne + " ");
        for(int i=0;i<64;i++){
            if(echiquier[i].GetValCase() == 0){
            System.out.print("| " + " " + " ");
            }     
            else if(echiquier[i].GetValCase() == 7){
                System.out.print("| " + String.format("%c",0x2659) + " ");
            }
            else if(echiquier[i].GetValCase() == 8){
                System.out.print("| " + String.format("%c",0x2656) + " ");
            }
            else if(echiquier[i].GetValCase() == 9){
                System.out.print("| " + String.format("%c",0x2658) + " ");
            }
            else if(echiquier[i].GetValCase() == 10){
                System.out.print("| " + String.format("%c",0x2657) + " ");
            }            
            else if(echiquier[i].GetValCase() == 11){
                System.out.print("| " + String.format("%c",0x2655) + " ");
            }            
            else if(echiquier[i].GetValCase() == 12){
                System.out.print("| " + String.format("%c",0x2654) + " ");
            }            
            else if(echiquier[i].GetValCase() == 1){
                System.out.print("| " + String.format("%c",0x265F) + " ");
            }
            else if(echiquier[i].GetValCase() == 2){
                System.out.print("| " + String.format("%c",0x265C) + " ");
            }
            else if(echiquier[i].GetValCase() == 3){
                System.out.print("| " + String.format("%c",0x265E) + " ");
            }
            else if(echiquier[i].GetValCase() == 4){
                System.out.print("| " + String.format("%c",0x265D) + " ");
            }
            else if(echiquier[i].GetValCase() == 5){
                System.out.print("| " + String.format("%c",0x265B) + " ");
            }
            else if(echiquier[i].GetValCase() == 6){
                System.out.print("| " + String.format("%c",0x265A) + " ");
            }
            if((i+1)%8 == 0){
                System.out.println("|");
                System.out.println("  +---+---+---+---+---+---+---+---+");
                if(nbligne < 8){
                nbligne++;
                System.out.print(nbligne + " ");
            }
            }
        }
        System.out.println("    A   B   C   D   E   F   G   H ");
    }

    public void init(){
        int i = 0;
        while(i<5){
            this.echiquier[i] = new Case(i, false, 8+i);
            i +=1;
        }
        while(i<8){
            this.echiquier[i] = new Case(i, false, 10 - (i-5));
            i +=1;
        }
        while(i<16){
            this.echiquier[i] = new Case(i, false, 7);
            i+=1;
        }
        while(i<48){
            this.echiquier[i] = new Case(i, false, 0);
            i+=1;
        }
        while(i<56){
            this.echiquier[i] = new Case(i, true, 1);
            i+=1;
        }
        int tmp = 0;
        while(tmp<5){
            this.echiquier[i] = new Case(i, true, 2 + tmp);
            tmp +=1;
            i+=1;
        }
        tmp = 0;
        while(i<64){
            this.echiquier[i] = new Case(i, true, 4 - tmp);
            tmp +=1;
            i+=1;
        }
    }

    public void AfficheString(){
        for(int i = 0;i<64;i++){
            System.out.println("Id Case : " + this.echiquier[i].GetIdCase() + " ; IsWhite : " + this.echiquier[i].GetIsCaseWhite() + " ; Valeur : " + this.echiquier[i].GetValCase());
        }
    }
    public void Update(){
        // todo
    }
}