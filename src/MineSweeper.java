import java.util.Arrays;
import java.util.Random;

public class MineSweeper {
    int row,colomn,safearea=0;
    int mayinSayisi;
    String[][] mayinSahasi;
    boolean isWin = true ;

    public  MineSweeper(int row,int colomn){
        this.row=row;
        this.colomn=colomn;
        this.mayinSayisi= (int)(row*colomn)/4;
        this.mayinSahasi = new String[this.row][this.colomn];
    }

    public void gameStart(){
            Random random = new Random();
            for(int i =0;i<mayinSayisi;i++){
                int mayinrow = random.nextInt(this.row);
                int mayincolomn = random.nextInt(this.colomn);
                if (mayinSahasi[mayinrow][mayincolomn]== " * "){
                    i--;
                }else {
                    mayinSahasi[mayinrow][mayincolomn] = " * ";
                }
            }
            for (int i = 0 ; i< this.row ; i++){
                for(int j =0; j<this.colomn; j++){
                    if (mayinSahasi[i][j] != " * " ){
                        mayinSahasi[i][j] = " - ";
                        this.safearea ++;
                    }
                }
            }
            PrintBoard();

    }
    public void PrintBoard(){
        for (String [] r : this.mayinSahasi){
            for (String c : r){
                System.out.print(c == " * "?" - ":c);

            }
            System.out.println();
        }
    }
    public void UserChosen(int chosenrow , int chosencol ){
        int minecounter=0;
        if (this.mayinSahasi[chosenrow][chosencol] == " * "){
            System.out.println("boom");
            this.isWin= false;
        }else{
            if (chosenrow>0){
                if (this.mayinSahasi[chosenrow-1][chosencol] == " * "){
                    minecounter ++;
                }
            }
            if (chosencol>0){
                if (this.mayinSahasi[chosenrow][chosencol-1] == " * "){
                    minecounter ++;
                }
            }
            if (chosenrow>0 && chosencol>0){
                if (this.mayinSahasi[chosenrow-1][chosencol-1] == " * "){
                    minecounter ++;
                }
            }
            if (chosenrow>0 && chosencol<this.colomn-1){
                if (this.mayinSahasi[chosenrow-1][chosencol+1] == " * "){
                    minecounter ++;
                }
            }
            if (chosenrow<this.row-1){
                if (this.mayinSahasi[chosenrow+1][chosencol] == " * "){
                    minecounter ++;
                }
            }
            if (chosencol<this.colomn-1){
                if (this.mayinSahasi[chosenrow][chosencol+1] == " * "){
                    minecounter ++;
                }
            }
            if (chosenrow<this.row-1 && chosencol<this.colomn-1){
                if (this.mayinSahasi[chosenrow+1][chosencol+1] == " * "){
                    minecounter ++;
                }
            }
            if (chosenrow<this.row-1 && chosencol>0){
                if (this.mayinSahasi[chosenrow+1][chosencol-1] == " * "){
                    minecounter ++;
                }
            }
            this.mayinSahasi[chosenrow][chosencol] = " " + minecounter + " ";
            this.safearea--;
            if (this.safearea==0){
                isWin=false;
                System.out.println("Tebrikler Kazandınız");
            }
            PrintBoard();

        }
    }


}
