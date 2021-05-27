package academy.mindswap;

import academy.mindswap.exceptions.CardBlockedException;
import academy.mindswap.exceptions.NotEnoughPermissionsException;

public class ATM {

    public static void main(String[] args) {
	// write your code here
        Card card=new Card(3344);

        card.deposit(1000);

        //erro pin
        card.withDraw(43);

        //na boa
        card.withDraw(3);

        //pin  error
        card.withDraw(43,1111);
        card.withDraw(43,1111);
        card.withDraw(43,1111);

        //blocked card error
        card.withDraw(43,3344);
        card.withDraw(3);

        //prints 97
        try {
            System.out.println(card.getBalance());
        }catch (CardBlockedException e){
            System.out.println(e.getMessage());
        }

    }
}
