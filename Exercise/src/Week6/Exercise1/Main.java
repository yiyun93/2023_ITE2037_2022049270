package Week6.Exercise1;

import Week6.Exercise1.util.AgeCalculator;

import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args){
        Random rnd = new Random();

        Date p1_Date = new Date(rnd.nextInt(1950, 2022), rnd.nextInt(1, 13), rnd.nextInt(1,29));
        Date p2_Date = new Date(rnd.nextInt(1950, 2022), rnd.nextInt(1, 13), rnd.nextInt(1,29));

        Person p1 = new Person("John", p1_Date, null);
        Person p2 = new Person("Mark", p2_Date, null);

        System.out.println(p1.toString());
        System.out.println(p2.toString());

        int compare = AgeCalculator.isOlder(p1, p2);

        switch (compare){
            case -1:
                System.out.println(p2.getName()+" is older than "+p1.getName()+".");
                break;
            case 1:
                System.out.println(p1.getName()+" is older than "+p2.getName()+".");
                break;
            case 0:
                System.out.println(p1.getName()+" and "+p2.getName()+" are the same age.");
                break;

        }
    }
}