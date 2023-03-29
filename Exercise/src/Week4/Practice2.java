package Week4;

import java.util.Scanner;
import java.util.Random;
public class Practice2 {
    public static void main(String[] args){
        Scanner Keyboard = new Scanner(System.in);
        Random rnd = new Random();

        boolean gameEnd = false;
        int pScore = 0;
        int cScore = 0;
        while(!gameEnd){
            String input;
            String cinput;
            int point = 0;
            int dice = 0;

            while(true){
                System.out.print("(You) insert action r(roll), h(hold): ");
                input = Keyboard.nextLine();
                if(input.equals("h")) break;
                else if(!input.equals("r")) continue;

                dice = rnd.nextInt(6)+1;
                System.out.println("(You) dice rolled : "+dice);

                point += dice;
                if(dice==1) {
                    point = 0;
                    break;
                }
            }
            pScore += point;
            System.out.println("(You) "+point+" added to You");
            System.out.println("(You) Your score "+pScore+" Computer Score "+cScore);
            System.out.println();

            point = 0;
            while(true){
                if(point<20) cinput = "r";
                else cinput = "h";

                System.out.println("(Computer) insert action r(roll), h(hold): "+cinput);
                if(cinput.equals("h")) break;

                dice = rnd.nextInt(6)+1;
                System.out.println("(Computer) dice rolled : "+dice);

                point += dice;
                if(dice==1) {
                    point = 0;
                    break;
                }
            }
            cScore += point;
            System.out.println("(Computer) "+point+" added to Computer");
            System.out.println("(Computer) Your score "+pScore+" Computer Score "+cScore);
            System.out.println();

            if(pScore>=100 || cScore>=100) gameEnd=true;
        }
        if(pScore>cScore)
            System.out.printf("(Game) Your score %d, Computer score %d\nCongratulations! You win!",
                    pScore, cScore);
        else if(pScore<cScore)
            System.out.printf("(Game) Your score %d, Computer score %d\nSorry, the computer wins!",
                    pScore, cScore);
        else
            System.out.printf("(Game) Your score %d, Computer score %d\ndraw", pScore, cScore);
    }
}
