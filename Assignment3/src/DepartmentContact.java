import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DepartmentContact extends ContactInfo {
    private String department;
    public DepartmentContact(String name, String phoneNumber, String department) {
        super(name, phoneNumber);
        this.department = department;
    }

    public String getDepartment(){
        return department;
    }

    @Override
    public HashMap<String, String> getInfo() {
        HashMap<String, String> infoMap = new HashMap<>(3);
        infoMap.put("name", getName());
        infoMap.put("phone number", getPhoneNumber());
        infoMap.put("department", department);

        return infoMap;
    }

    @Override
    public String toString() {
        return String.format("name: %s / phone number: %s / department: %s",
                getName(), getPhoneNumber(), department);
    }

    @Override
    public void setDetail(String keyword) {
        department = keyword;
    }
}
