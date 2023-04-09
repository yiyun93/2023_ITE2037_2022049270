import java.util.Scanner;

public class LotterySimulator {

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        LotteryGenerator generator = new LotteryGenerator();
        LotteryChecker checker = new LotteryChecker();

        int money = 0;

        while(true){
            int[] winNums = new int[7];
            int[] nums = new int[6];
            int place1 = 0;
            int place2 = 0;
            int place3 = 0;
            int place4 = 0;

            int depo, tickets;

            System.out.println("Input your money and number of lottery tickets:");
            depo = keyboard.nextInt();
            tickets = keyboard.nextInt();

            if(depo==0 || tickets == 0) break;
            if(money+depo < tickets*10) continue;

            money += depo;
            money -= 10*tickets;


            winNums = generator.generateWinNumbers();
            System.out.printf("Round Winning number : %d %d %d %d %d %d + %d\n",
                    winNums[0], winNums[1], winNums[2], winNums[3], winNums[4],
                    winNums[5], winNums[6]);

            for(int i=0 ; i<tickets; i++){
                nums = generator.generateNumbers();
                String result;

                result = checker.checkPlace(winNums, nums);

                switch(result){
                    case "1st place": place1++; break;
                    case "2nd place": place2++; break;
                    case "3rd place": place3++; break;
                    case "4th place": place4++; break;
                }

                System.out.printf("Lottery number : %d %d %d %d %d %d ",
                        nums[0], nums[1], nums[2], nums[3], nums[4], nums[5]);

                if(!result.isEmpty())
                    System.out.printf("Winner (%s)\n", result);
                else
                    System.out.printf("Lose\n");
            }

            System.out.println("Remaining money : " + money);
            System.out.printf("1st place: %d\n2nd place: %d\n3rd place: %d\n4th place: %d\n",
                    place1, place2, place3, place4);
        }
        System.out.println("End of program");
    }

}
