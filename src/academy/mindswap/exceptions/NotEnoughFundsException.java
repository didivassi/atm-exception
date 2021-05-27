package academy.mindswap.exceptions;

public class NotEnoughFundsException extends ATMException{

    public NotEnoughFundsException(double balance){
        super("You have no money on your account your balance is: " + balance );
    }
}
