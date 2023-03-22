package Week3;

import java.util.Scanner;
public class Practice2 {
    public static void main(String[] args){
        Scanner Keyboard = new Scanner(System.in);

        int p = Keyboard.nextInt();
        System.out.printf("(%d/100)*4=%d", p, p/25);
    }
}
