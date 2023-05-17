package Week11.Practice1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static boolean isCoprime(int a, int b) throws MyException {
        if(a<=1 || b<=1)
            throw new MyException("you entered too small number, please enter the number bigger than 1");
        else if(a == b){
            throw new MyException("two numbers are same, please enter two different numbers");
        }
        else if(a>10000 && b>10000){
            throw new MyException("both of your two numbers are too big, please enter at least one number less than 10000");
        }

        int minNum = Math.min(a, b);

        for(int i = 2; i<=minNum; i++){
            if(a%i==0 && b%i==0) return false;
        }

        return true;
    }
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        try {
            int a = keyboard.nextInt();
            int b = keyboard.nextInt();

            if(isCoprime(a, b)){
                System.out.println("a and b are Coprime");
            } else{
                System.out.println("a and b are not Coprime");
            }
        }
        catch (InputMismatchException e){
            System.out.println("[InputMismatchException] you number is not integer, please enter two 'integers'");
        }
        catch (MyException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println("Some Exception happens");
        }

    }


}
