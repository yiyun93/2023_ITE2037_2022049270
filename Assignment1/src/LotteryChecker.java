public class LotteryChecker {

    public String checkPlace(int[] winNums, int[] nums){
        int count = 0;
        int bonus = 0;
        String res = "";

        for(int i=0; i<6; i++){
            if(nums[i] == winNums[6]) bonus = 1;

            for(int j=0; j<6; j++){
                if(nums[i] == winNums[j]) count++;
            }
        }
        if(count == 3) res = "4th place";
        else if(count == 4){
            if(bonus == 1) res = "2nd place";
            else res = "3rd place";
        }
        else if(count == 5){
            if(bonus == 1) res = "1st place";
            else res = "2nd place";
        }
        else if(count == 6) res = "1st place";

        return res;
    }
}
