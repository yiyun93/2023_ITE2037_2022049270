package Week11.Practice2;

public class Account {
    private String ID;
    int account_num;
    int balance;

    public Account(String id, int account_num, int balance) throws Exception{
        if(id.length() == 4 && Character.isLetter(id.charAt(0))){
            for(int i=1; i<4; i++){
                if(!Character.isDigit(id.charAt(i))) throw new Exception("Customer ID must start with a letter and should be followed by tree digits.");
            }

            this.ID = id;
        } else throw new Exception("Customer ID must start with a letter and should be followed by tree digits.");

        if(10000 <= account_num && account_num <= 99999){
            this.account_num = account_num;
        }
        else throw new Exception("Account number must be of five digits.");

        if(balance > 1000){
            this.balance = balance;
        }
        else throw new Exception("Initial balance must be above $1000.");
    }

    public String toString(){
        return "ID: " + ID + "\naccount number: " + account_num + "\nbalance: $" + balance;
    }
}
