package academy.mindswap;

import academy.mindswap.exceptions.ATMException;
import academy.mindswap.exceptions.CardBlockedException;
import academy.mindswap.exceptions.NotEnoughFundsException;
import academy.mindswap.exceptions.NotEnoughPermissionsException;

public class Card {

    final double MAX_AMOUNT_WITHOUT_PIN =40; //max amount of money withdraw without pin code;
    private int pinTries;
    private double balance;
    private int pinCode;
    private boolean  cardBlocked;

    public Card(int pinCode){
        this.pinCode=pinCode;
        pinTries=3;
        cardBlocked=false;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    void withDraw(double amount) {
        try {
            checkCardBlocked();
            needsPinCode(amount);
            canWithDraw(amount);
            balance -= amount;
            System.out.println("You've withdraw "+ amount);
        } catch (ATMException errorObject){
            System.out.println(errorObject.getMessage());
        } finally {//always run
        }
    }

    void withDraw(double amount, int pinCode) {
        try {
            pinTriesLeft();
            validatePinCode(pinCode);
            canWithDraw(amount);
            balance -= amount;
            System.out.println("You've withdraw "+ amount);
        }
        catch (ATMException errorObject){
            System.out.println(errorObject.getMessage());
        }
    }

    void checkCardBlocked() throws CardBlockedException {
        if(cardBlocked){
            throw new CardBlockedException();
        }
    }

    void pinTriesLeft() throws NotEnoughPermissionsException,CardBlockedException {//too much tries
        if(pinTries<=1){
            pinTries=1;
            cardBlocked=true;
            checkCardBlocked();
            //throw new NotEnoughPermissionsException("You're card has been locked. You need a new card");
        }
    }

    void validatePinCode(int pinCode) throws NotEnoughPermissionsException{
        if(this.pinCode!=pinCode){
            --pinTries;
            throw new NotEnoughPermissionsException("Wrong pin code you have " + pinTries+ " tries left");
        }
    }

    void needsPinCode(double amount) throws NotEnoughPermissionsException{
        if(amount> MAX_AMOUNT_WITHOUT_PIN){
            throw new NotEnoughPermissionsException("For this operation you need a pin code");
        }

    }

    void  canWithDraw(double amount) throws NotEnoughFundsException {
        if(balance < amount){
            throw new NotEnoughFundsException(balance);
        }
    }

    double getBalance() throws CardBlockedException{
        checkCardBlocked();
        return balance;
    }
}
