package Week5;

import java.util.StringTokenizer;
import java.util.Scanner;
public class Practice {

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        String name1, name2;
        String birth;

        name1 = keyboard.next();
        birth = keyboard.next();
        name2 = keyboard.next();

        StringTokenizer stk = new StringTokenizer(birth, ".");

        int year, month, day;
        year = Integer.parseInt(stk.nextToken());
        month = Integer.parseInt(stk.nextToken());
        day = Integer.parseInt(stk.nextToken());

        Student stu1 = new Student(name1, year, month, day);
        Student stu2 = new Student(name2, year);

        if(!stu1.checkDate(stu1.getYear(), stu1.getMonth(), stu1.getDay())) {
            System.out.println("invalid input");
            return;
        }

        System.out.printf("%s %d/%d/%d age: %d\n", stu1.getName(), stu1.getYear(), stu1.getMonth(), stu1.getDay(), stu1.calAge());
        System.out.printf("%s %d/%d/%d age: %d\n", stu2.getName(), stu2.getYear(), stu2.getMonth(), stu2.getDay(), stu2.calAge());

        String old, young;
        if(stu1.isOlder(stu2)){
            old = stu1.getName();
            young = stu2.getName();
        }
        else{
            old = stu2.getName();
            young = stu1.getName();
        }
        System.out.printf("%s is older than %s", old, young);
    }
}
