package Week3;

import java.util.Scanner;
public class Practice1 {
    public static void main(String[] args){
        Scanner Keyboard = new Scanner(System.in);

        String str = Keyboard.next();
        int n1 = Integer.parseInt(str.substring(0,str.indexOf(",")));
        int n2 = Integer.parseInt(str.substring(str.indexOf(",")+1));

        System.out.println("dividend: "+ n1);
        System.out.println("divisor: " + n2);
        System.out.println("quotient: " + n1/n2);
        System.out.println("remainder: " + n1%n2);
    }
}
