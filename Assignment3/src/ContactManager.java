import java.util.ArrayList;
import java.util.Arrays;


public class ContactManager {

    private class MyStorage<T>{
        private ArrayList<T> normalContactList;
        private ArrayList<T> clubContactList;
        private ArrayList<T> departmentContactList;
        private int size ;

        public MyStorage(){
            normalContactList = new ArrayList<>();
            clubContactList = new ArrayList<>();
            departmentContactList = new ArrayList<>();
            size = -1;
        }

        public void setSize(int n){
            size = n;
        }

        public void addContact(T contact){
            if(contact instanceof NormalContact)
                normalContactList.add(contact);
            else if(contact instanceof ClubContact)
                clubContactList.add(contact);
            else
                departmentContactList.add(contact);
        }

        public ArrayList<T> getNormalContactList(){
            return new ArrayList<>(normalContactList);
        }
        public ArrayList<T> getDepartmentContactList(){
            return new ArrayList<>(departmentContactList);
        }
        public ArrayList<T> getClubContactList(){
            return new ArrayList<>(clubContactList);
        }

        public ArrayList<T> getAllContactList(){
            ArrayList<T> temp;
            temp = new ArrayList<>(normalContactList);
            temp.addAll(clubContactList);
            temp.addAll(departmentContactList);

            return temp;
        }

        public boolean isFull(){
            if(size==0) return false;
            int AllContacts = getAllContactList().size();
            return AllContacts >= size;
        }

        public int getSize(){
            return size;
        }

        public void deleteContactFromList(T contact) {
            if(contact instanceof NormalContact){
                normalContactList.remove(contact);
            }
            else if(contact instanceof ClubContact){
                clubContactList.remove(contact);
            }
            else{
                departmentContactList.remove(contact);
            }
        }
    }

    private MyStorage<ContactInfo> contactStorage;
    private CommandLineInterface cli;

    public ContactManager(CommandLineInterface cli){
        this.cli = cli;
        contactStorage = new MyStorage<>();
    }

    public void setStorageSize() throws ExcessContactSizeException {
        int n;
        n = cli.getSetSizeMenu();
        int temp = contactStorage.getAllContactList().size();
        if(n!=0 && n<temp) throw new ExcessContactSizeException("new size should be bigger than "+ temp);
        contactStorage.setSize(n);
    }

    public void saveToFile(){
        cli.writeFile(getAllContact());
    }

    public void loadFromFile() throws ExcessContactSizeException {
        if(contactStorage.getSize()<0) throw new ExcessContactSizeException("contact storage size is not determined");
        ArrayList<String>[] arr = cli.readFile();

        int arrSize = arr[0].size() + arr[1].size() + arr[2].size();
        if(contactStorage.getSize()!=0 && contactStorage.getAllContactList().size()+arrSize > contactStorage.getSize()){
            throw new ExcessContactSizeException("contacts in the file are too many");
        }

        String[] words;
        ContactInfo temp;
        for(int i=0; i<3; i++){
            for(String line: arr[i]){
                words = line.split(" ");
                if(i==0)
                    temp = new NormalContact(words[3], words[7], words[10]);
                else if(i==1)
                    temp = new ClubContact(words[3], words[7], words[11]);
                else
                    temp = new DepartmentContact(words[3], words[7], words[10]);

                contactStorage.addContact(temp);
            }
        }

        viewAllContact();
    }

    public void createContact() throws ExcessContactSizeException {
        if(contactStorage.isFull()) throw new ExcessContactSizeException();
        if(contactStorage.getSize()<0) throw new ExcessContactSizeException("contact storage size is not determined");

        ArrayList<String> info = cli.getCreateContactMenu();
        ContactInfo newContact = null;
        switch(info.get(0)){
            case "normal":
                newContact = new NormalContact(info.get(1), info.get(2), info.get(3));
                break;
            case "club":
                newContact = new ClubContact(info.get(1), info.get(2), info.get(3));
                break;
            case "department":
                newContact = new DepartmentContact(info.get(1), info.get(2), info.get(3));
                break;
        }

        contactStorage.addContact(newContact);
    }

    public ContactInfo searchContact() {
        String[] temp = cli.getSearchContactMenu();
        ArrayList<ContactInfo> searchList = null;
        ContactInfo res = null;

        switch (temp[0]){
            case "1": case "2":
                searchList = contactStorage.getAllContactList();
                break;
            case "3":
                searchList = contactStorage.getNormalContactList();
                break;
            case "4":
                searchList = contactStorage.getClubContactList();
                break;
            case "5":
                searchList = contactStorage.getDepartmentContactList();
                break;
        }

        for(ContactInfo item : searchList){
            if((temp[0].equals("1") && item.getName().equals(temp[1])) ||
                    (temp[0].equals("2") && item.getPhoneNumber().equals(temp[1])) ||
                    (temp[0].equals("3") && item.getInfo().get("relation").equals(temp[1])) ||
                    (temp[0].equals("4") && item.getInfo().get("club name").equals(temp[1])) ||
                    (temp[0].equals("5") && item.getInfo().get("department").equals(temp[1]))){
                res = item;
            }
        }

        if(res==null)
            cli.printNoMatchContact();
        return res;
    }

    public void deleteContact() {
        ContactInfo contact = searchContact();
        if(contact==null) return;

        cli.printContactInfo(contact);
        if(cli.getDeleteContactMenu()){
            contactStorage.deleteContactFromList(contact);
        }
        else return;
    }

    public void editContact() {
        String[] temp;
        ContactInfo contact = searchContact();
        if(contact==null) return;

        cli.printContactInfo(contact);
        temp = cli.getEditContactMenu(contact);
        if(temp==null) return;

        switch (temp[0]){
            case "1":
                contact.setName(temp[1]);
                break;
            case "2":
                contact.setPhoneNumber(temp[1]);
                break;
            case "3":
                contact.setDetail(temp[1]);
                break;
        }

        return;
    }

    public void viewAllContact(){
        cli.printAllContact(getAllContact());
    }

    public  ArrayList<ContactInfo>[] getAllContact(){
        ArrayList<ContactInfo>[] arr = new ArrayList[3];

        arr[0] = contactStorage.getNormalContactList();
        arr[1] = contactStorage.getClubContactList();
        arr[2] = contactStorage.getDepartmentContactList();

        return arr;
    }

}
