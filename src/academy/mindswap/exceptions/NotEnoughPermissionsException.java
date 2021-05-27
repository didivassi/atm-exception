package academy.mindswap.exceptions;

public class NotEnoughPermissionsException extends ATMException{

    public NotEnoughPermissionsException(){
        super("You have no permissions to perform this operation");
    }

    public NotEnoughPermissionsException(String message){
        super(message);
    }
}
