package Week9;

import java.util.Date;

import java.util.Random;
public class Main {

    public static void main(String[] args){
        Random rnd = new Random();

        Date p1_Date = new Date(rnd.nextInt(1950, 2022), rnd.nextInt(1, 13), rnd.nextInt(1,29));
        Date p2_Date = new Date(rnd.nextInt(1950, 2022), rnd.nextInt(1, 13), rnd.nextInt(1,29));
        Date p3_Date = new Date(rnd.nextInt(1950, 2022), rnd.nextInt(1, 13), rnd.nextInt(1,29));
        Date p4_Date = new Date(rnd.nextInt(1950, 2022), rnd.nextInt(1, 13), rnd.nextInt(1,29));


        Doctor mark = new Doctor("Mark", p1_Date, null, "Hanyang Hospital");
        Physician jack = new Physician("Jack", p2_Date, null, "Hanyang Hospital");
        Patient cris = new Patient("Cris", p3_Date, null, "Dental");
        Patient eddi = new Patient("Eddi", p4_Date, null, "internal");

        System.out.println(mark.toString());
        System.out.println(jack.toString());
        System.out.println(cris.toString());
        System.out.println(eddi.toString());
        System.out.println();

        mark.examination(cris);
        jack.examination(cris);
        jack.examination(eddi);
    }

}
