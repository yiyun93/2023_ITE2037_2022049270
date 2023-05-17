package Week11.Practice2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Account account;
        while(true){
            try{
                String id;
                int account_num, balance;

                System.out.println("Please enter ID, account number and balance");

                id = keyboard.next();
                account_num = keyboard.nextInt();
                balance = keyboard.nextInt();

                account = new Account(id, account_num, balance);

                break;
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        System.out.println("[Account information]\n" + account.toString());
    }
}
