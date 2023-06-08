import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
public class CommandLineInterface {
    private Scanner scanner;

    public CommandLineInterface(){
        scanner = new Scanner(System.in);
    }

    public int getMainMenu() throws Exception{
        int input;
        System.out.printf("----<Main Menu>----\n" +
                "1. Set size of total contacts\n" +
                "2. Save the current contact to a file\n" +
                "3. Load the saved contact file\n" +
                "4. Register new contact\n" +
                "5. Search contact\n" +
                "6. Delete contact\n" +
                "7. Edit contact\n" +
                "8. View All Contacts\n" +
                "9. Exit\n" +
                "Select: ");

        input = scanner.nextInt();
        scanner.nextLine();

        return input;
    }

    public int getSetSizeMenu() {
        int input;
        while(true) {
            try {
                System.out.printf("Enter the size to set (inf=0)\n" +
                        "Size: ");
                input = scanner.nextInt();
                scanner.nextLine();

                if (input < 0)
                    throw new MenuChoiceException("invalid size");

                return input;
            }
            catch (Exception e) {
                printErrorMessage(e);
            }
        }
    }

    public ArrayList<String> getCreateContactMenu() {
        int input;
        String detail = null;
        String temp;
        ArrayList<String> info = new ArrayList<>();

        while(true) {
            try {
                System.out.printf("Create contact...\n" +
                        "1. normal contact\n" +
                        "2. club contact\n" +
                        "3. department contact\n" +
                        "Select: ");
                input = scanner.nextInt();
                scanner.nextLine();

                if (input > 3 || input < 1) throw new MenuChoiceException(input);
                break;
            }
            catch (Exception e){
                printErrorMessage(e);
            }
        }

        switch (input){
            case 1:
                info.add("normal");
                detail = "relation";
                break;
            case 2:
                info.add("club");
                detail = "club name";
                break;
            case 3:
                info.add("department");
                detail = "department";
                break;
        }

        while(true){
            try {
                System.out.println("Please enter the contact details");
                System.out.printf("name: ");
                temp = scanner.nextLine();
                if (temp.length() > 20 || temp.length() < 3) throw new InputFormatException();
                info.add(temp);

                System.out.printf("phone number: ");
                temp = scanner.nextLine();
                if (!Pattern.matches("^010-\\d{4}-\\d{4}$", temp))
                    throw new InputFormatException("phone number format should be 010-xxxx-xxxx");
                info.add(temp);

                System.out.printf("%s: ", detail);
                temp = scanner.nextLine();
                if (temp.length() > 20 || temp.length() < 3) throw new InputFormatException();
                info.add(temp);

                return info;
            }
            catch (Exception e){
                printErrorMessage(e);
            }
        }
    }

    public String[] getSearchContactMenu() {
        int input;
        String keyword;

        while(true) {
            try {
                System.out.printf("Search contact...\n" +
                        "Choose the variable\n" +
                        "1. name\n" +
                        "2. phone number\n" +
                        "3. relation\n" +
                        "4. club name\n" +
                        "5. department\n" +
                        "Select: ");
                input = scanner.nextInt();
                scanner.nextLine();
                if (input < 1 || input > 5) throw new MenuChoiceException(input);

                System.out.printf("Keyword: ");
                keyword = scanner.nextLine();
                if(keyword.length() > 20 || keyword.length() < 3)
                    throw new InputFormatException();

                String[] temp = {String.valueOf(input), keyword};
                return temp;
            }
            catch (Exception e){
                printErrorMessage(e);
            }
        }
    }

    public boolean getDeleteContactMenu(){
        String input;
        System.out.printf("Do you want delete this contact?(y or n): ");
        input = scanner.nextLine();

       if(input.startsWith("y")){
           System.out.println("Deleting...");
           return true;
       }
       else return false;
    }

    public String[] getEditContactMenu(ContactInfo contact){
        int input;
        String keyword;

        while(true) {
            try {
                System.out.printf("Which information do you want to edit?\n" +
                        "1. name\n" +
                        "2. phone number\n" +
                        "3. ");
                if (contact instanceof NormalContact)
                    System.out.println("relation");
                else if (contact instanceof ClubContact)
                    System.out.println("club name");
                else
                    System.out.println("department");
                System.out.printf("4. cancel editing\n" +
                        "Select: ");

                input = scanner.nextInt();
                scanner.nextLine();
                if (input < 1 || input > 4) throw new MenuChoiceException(input);
                if (input == 4) return null;

                System.out.printf("New keyword: ");
                keyword = scanner.nextLine();
                if (input == 2 && !Pattern.matches("^010-\\d{4}-\\d{4}$", keyword))
                    throw new InputFormatException("phone number format should be 010-xxxx-xxxx");
                else if (keyword.length() > 20 || keyword.length() < 3)
                    throw new InputFormatException();

                String[] temp = {String.valueOf(input), keyword};
                return temp;
            }
            catch (Exception e){
                printErrorMessage(e);
            }
        }
    }

    public void printAllContact(ArrayList<ContactInfo>[] arr){
        String[] type = {"Normal", "Club", "Department"};
        for(int i=0; i<3; i++){
            System.out.println(type[i] + " Contacts");
            for(int j=0; j<arr[i].size(); j++){
                System.out.printf("\t %d. %s\n", j+1, arr[i].get(j).toString());
            }
        }
    }

    public void printErrorMessage(Exception e){
        if(e instanceof InputMismatchException){
            scanner.nextLine();
            System.out.println("Please enter valid input");
        }
        else
            System.out.println(e.getMessage());
    }

    public void printContactInfo(ContactInfo contact){
        System.out.println(contact.toString());
    }

    public void printNoMatchContact() {
        System.out.println("There is no contact with matching keyword");
    }

    public void writeFile(ArrayList<ContactInfo>[] arr) {
        PrintWriter outputStream = null;
        try{
            outputStream = new PrintWriter(new FileOutputStream("ContactBook.txt"));
        }
        catch (FileNotFoundException e){
            printErrorMessage(new Exception("Error opening the file"));
        }

        System.out.println("writing file...");

        String[] type = {"Normal", "Club", "Department"};
        for(int i=0; i<3; i++){
            outputStream.println(type[i] + " Contacts");
            for(int j=0; j<arr[i].size(); j++){
                outputStream.printf("\t %d. %s\n", j+1, arr[i].get(j).toString());
            }
        }
        outputStream.close();

        System.out.println("finished!");
    }

    public ArrayList<String>[] readFile() {
        ArrayList<String>[] arr = new ArrayList[3];
        Scanner inputStream = null;
        String line;
        try{
            inputStream = new Scanner(new FileInputStream("ContactBook.txt"));
        }
        catch (FileNotFoundException e){
            printErrorMessage(new Exception("Error opening the file"));
        }

        System.out.println("reading file...");

        inputStream.nextLine();
        int i=0;
        arr[i] = new ArrayList<>();
        while(inputStream.hasNextLine()){
            line = inputStream.nextLine();
            if(line.endsWith("Contacts")){
                i++;
                arr[i] = new ArrayList<>();
                continue;
            }
            arr[i].add(line);
        }
        inputStream.close();

        return arr;
    }
}
