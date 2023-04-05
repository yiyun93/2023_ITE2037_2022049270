package Week5;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Student {
    private String name;
    private int year;
    private int month;
    private int day;

    public Student(String name, int year, int month, int day) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
        Random rand = new Random();

        int tmonth = 0, tday = 0;
        while (!checkDate(year, tmonth, tday)) {
            tmonth = rand.nextInt(1, 13);
            tday = rand.nextInt(1, 32);
        }
        this.month = tmonth;
        this.day = tday;
    }

    public boolean checkDate(int year, int month, int day) {
        try {
            GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
            calendar.setLenient(false);

            calendar.getTime();

            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
    int getMonth() {
        return month;
    }
    public int getDay() {
        return day;
    }

    public int calAge() {
        Calendar today = Calendar.getInstance();

        int age = today.get(Calendar.YEAR) - this.year;
        if((today.get(Calendar.MONTH)+1)*100+today.get(Calendar.DAY_OF_MONTH) < this.getMonth() * 100 + this.getDay())
            age--;

        return age;
    }

    public boolean isOlder(Student stu) {
        if (this.calAge() > stu.calAge())
            return true;
        else return (this.getMonth() * 100 + this.getDay() < stu.getMonth() * 100 + stu.getDay());
    }
}
