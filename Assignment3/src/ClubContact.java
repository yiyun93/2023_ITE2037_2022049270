import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ClubContact extends ContactInfo {
    private String clubName;
    public ClubContact(String name, String phoneNumber, String clubName) {
        super(name, phoneNumber);
        this.clubName = clubName;
    }

    public String getClubName(){
        return clubName;
    }

    @Override
    public HashMap<String, String> getInfo() {
        HashMap<String, String> infoMap = new HashMap<>(3);
        infoMap.put("name", getName());
        infoMap.put("phone number", getPhoneNumber());
        infoMap.put("club name", clubName);

        return infoMap;
    }

    @Override
    public String toString() {
        return String.format("name: %s / phone number: %s / club name: %s",
                getName(), getPhoneNumber(), clubName);
    }

    @Override
    public void setDetail(String keyword) {
        clubName = keyword;
    }
}
