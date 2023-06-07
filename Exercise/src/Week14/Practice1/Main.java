package Week14.Practice1;

import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        int n;
        n = keyboard.nextInt();

        ArrayList<Integer> plist;
        plist = Eratos.sieve(n);

        Iterator<Integer> iter = plist.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
    }
}
