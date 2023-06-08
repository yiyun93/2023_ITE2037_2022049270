public class InputFormatException extends Exception{
    public InputFormatException(){
        super("Please enter letters between 3 and 20 characters");
    }

    public InputFormatException(String message){
        super(message);
    }

    @Override
    public String getMessage(){
        return "[InputFormatException] " + super.getMessage();
    }
}
