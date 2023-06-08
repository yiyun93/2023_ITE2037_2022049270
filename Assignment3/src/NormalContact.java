import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NormalContact extends ContactInfo {
    private String relation;

    public NormalContact(String name, String phoneNumber, String relation) {
        super(name, phoneNumber);
        this.relation = relation;
    }

    public String getRelation(){
        return relation;
    }

    @Override
    public HashMap<String, String> getInfo() {
        HashMap<String, String> infoMap = new HashMap<>(3);
        infoMap.put("name", getName());
        infoMap.put("phone number", getPhoneNumber());
        infoMap.put("relation", relation);

        return infoMap;
    }

    @Override
    public String toString() {
        return String.format("name: %s / phone number: %s / relation: %s",
                getName(), getPhoneNumber(), relation);
    }

    @Override
    public void setDetail(String keyword) {
        relation = keyword;
    }
}
