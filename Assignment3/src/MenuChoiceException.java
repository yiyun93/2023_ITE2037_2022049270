import java.awt.*;

public class MenuChoiceException extends Exception{
    public MenuChoiceException(int n){
        super(String.format("%d is not selectable number", n));
    }

    public MenuChoiceException(String message){
        super(message);
    }

    @Override
    public String getMessage(){
        return "[MenuChoiceException] " + super.getMessage();
    }
}
