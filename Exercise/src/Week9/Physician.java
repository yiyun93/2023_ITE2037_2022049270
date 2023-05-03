package Week9;

import java.util.Date;

public class Physician extends Doctor{
    public Physician(String name, Date born, Date died, String hospital) {
        super(name, born, died, hospital);
    }

    @Override
    void examination(Patient p){
        if(p.getDepartment().equals("internal"))
            System.out.println("I'll take care or you!");
        else
            System.out.println("Sorry, but it's not my major");
    }
}
