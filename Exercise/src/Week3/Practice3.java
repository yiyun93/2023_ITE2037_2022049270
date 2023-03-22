package Week3;

import java.util.Scanner;
public class Practice3 {
    public static void main(String[] args){
        Scanner Keyboard = new Scanner(System.in);

        String i1, i2, i3;
        double p1, p2, p3;
        int q1, q2, q3;

        System.out.println("Enter name of item 1:");
        i1 = Keyboard.nextLine();
        System.out.println("Enter quantity of item 1: ");
        q1 = Keyboard.nextInt();
        System.out.println("Enter price of item 1: ");
        p1 = Keyboard.nextFloat();
        System.out.println("Enter name of item 2: ");
        Keyboard.nextLine();
        i2 = Keyboard.nextLine();
        System.out.println("Enter quantity of item 2: ");
        q2 = Keyboard.nextInt();
        System.out.println("Enter price of item 2: ");
        p2 = Keyboard.nextFloat();
        System.out.println("Enter name of item 3: ");
        Keyboard.nextLine();
        i3 = Keyboard.nextLine();
        System.out.println("Enter quantity of item 3: ");
        q3 = Keyboard.nextInt();
        System.out.println("Enter price of item 3: ");
        p3 = Keyboard.nextFloat();

        System.out.printf("Your bill:\n\n");
        System.out.printf("%-30s%-10s%-10s%-10s\n", "ITEM", "QUANTITY", "PRICE", "TOTAL");
        System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", i1, q1, p1, q1*p1);
        System.out.printf("%-30s%-10d%-10.2f%-10.2f\n", i2, q2, p2, q2*p2);
        System.out.printf("%-30s%-10d%-10.2f%-10.2f\n\n", i3, q3, p3, q3*p3);

        double subtotal = q1*p1+q2*p2+q3*p3;
        System.out.printf("%-50s%-10.2f\n", "SUBTOTAL", subtotal);
        System.out.printf("%-50s%-10.2f\n", "6.25% SALES TAX", subtotal*0.0625);
        System.out.printf("%-50s%-10.2f", "TOTAL", subtotal+subtotal*0.0625);

    }
}
