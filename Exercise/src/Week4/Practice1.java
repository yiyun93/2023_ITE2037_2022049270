package Week4;

import java.util.Scanner;
public class Practice1 {

    public static void main(String[] args){
        Scanner Keyboard = new Scanner(System.in);

        System.out.println("Input string S:");
        String str = Keyboard.nextLine();

        String substr;
        String res = str.substring(0,1);
        for(int i=2; i<=str.length(); i++){
            for(int j=0; j<=str.length()-i; j++){
                substr = str.substring(j, j+i);
                StringBuffer sb = new StringBuffer(substr);
                String reverse = sb.reverse().toString();

                if(substr.equals(reverse)) res = substr;
            }
        }

        System.out.println("Longest Palindrome: " + res);
    }
}
