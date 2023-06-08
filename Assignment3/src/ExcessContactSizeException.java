public class ExcessContactSizeException extends Exception{
    public ExcessContactSizeException(){
        super(String.format("contact storage is full!"));
    }

    public ExcessContactSizeException(String message){
        super(message);
    }

    @Override
    public String getMessage(){
        return "[ExcessContactSizeException] " + super.getMessage();
    }
}
