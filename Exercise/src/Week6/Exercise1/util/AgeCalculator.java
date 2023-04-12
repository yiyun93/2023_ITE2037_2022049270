package Week6.Exercise1.util;

import Week6.Exercise1.Person;

import java.util.Calendar;
import java.util.Date;

public class AgeCalculator {
    public static int calAge(Person p) {
        Calendar today = Calendar.getInstance();
        Date birth = new Date(p.getBorn().getYear(), p.getBorn().getMonth(), p.getBorn().getDate());

        int age = today.get(Calendar.YEAR) - birth.getYear();
        if((today.get(Calendar.MONTH)+1)*100+today.get(Calendar.DAY_OF_MONTH) < birth.getMonth() * 100 + birth.getDay())
            age--;

        return age;
    }
    public static int isOlder(Person p1, Person p2){
        int p1_age = calAge(p1);
        int p2_age = calAge(p2);

        if(p1_age > p2_age) return 1;
        else if(p1_age == p2_age) return 0;
        else return -1;
    }
}
