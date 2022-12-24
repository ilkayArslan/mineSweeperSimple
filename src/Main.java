import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Lütfen Satır Sayısı Giriniz : ");
        int newrow= input.nextInt();
        System.out.print("Lütfen Sütun Sayısı Giriniz : ");
        int newColomn = input.nextInt();
        MineSweeper game = new MineSweeper(newrow,newColomn);
        System.out.println(game.mayinSayisi);
        game.gameStart();
        System.out.println("--------------- Game Start");
        while (game.isWin){
            System.out.println("--------------- new Choose");
            System.out.print("Lütfen Bir Satır numarası Seçiniz : ");
            int chosenrow = input.nextInt()-1;
            System.out.print("Lütfen bir Kolon numarası seçiniz : ");
            int chosencol = input.nextInt()-1;
            game.UserChosen(chosenrow,chosencol);
        }

    }
}