import java.util.Random;
public class LotteryGenerator {
    private Random rnd = new Random();

    public int[] generateWinNumbers(){
        int[] nums = new int[7];

        for(int i=0; i<7; i++){
            int num = 0;

            boolean flag = true;
            while(flag){
                flag = false;
                num = rnd.nextInt(1,21);
                for(int j=0; j<i; j++)
                    if(nums[j] == num) flag = true;
            }

            nums[i] = num;
        }
        return nums;
    }

    public int[] generateNumbers(){
        int[] nums = new int[6];

        for(int i=0; i<6; i++){
            int num = 0;

            boolean flag = true;
            while(flag){
                flag = false;
                num = rnd.nextInt(1,21);
                for(int j=0; j<i; j++)
                    if(nums[j] == num) flag = true;
            }

            nums[i] = num;
        }
        return nums;
    }
}
