import java.util.HashMap;

public abstract class ContactInfo {
    private String name;
    private String phoneNumber;

    public ContactInfo(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPhoneNumber(String number){
        phoneNumber = number;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public abstract HashMap<String, String> getInfo();

    public abstract String toString();

    public abstract void setDetail(String keyword);

}
