public class Main {
    public static void main(String[] args)
    {
        CommandLineInterface cli = new CommandLineInterface();
        ContactManager manager = new ContactManager(cli);
        int choice;

        while(true)
        {
            try
            {
                choice = cli.getMainMenu();
                if(choice < 1 || choice > 9)
                    throw new MenuChoiceException(choice);
                ContactInfo temp;
                switch(choice)
                {
                    case 1:
                        manager.setStorageSize();
                        break;
                    case 2:
                        manager.saveToFile();
                        break;
                    case 3:
                        manager.loadFromFile();
                        break;
                    case 4:
                        manager.createContact();
                        break;
                    case 5:
                        temp = manager.searchContact();
                        if(temp!=null)
                            cli.printContactInfo(temp);
                        break;
                    case 6:
                        manager.deleteContact();
                        break;
                    case 7:
                        manager.editContact();
                        break;
                    case 8:
                        manager.viewAllContact();
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    // Your Implementation
                }
            }
            catch(Exception e)
            {
                cli.printErrorMessage(e);
            }
        }
    }
}

