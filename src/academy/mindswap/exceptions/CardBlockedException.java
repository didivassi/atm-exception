package academy.mindswap.exceptions;

public class CardBlockedException extends ATMException{

    public CardBlockedException(){
        super("Your card has been blocked you need a new card. Go Away");
    }
}
