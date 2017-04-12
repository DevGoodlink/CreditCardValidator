/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tool;

/**
 *
 * @author YASSALIE
 */
public class LuhForumla {
    /**
 * Runs the Luhn Equation on a user inputed CCN, which in turn
 * determines if it is a valid card number.
 * @param c A user inputed CCN.
 * @param cn The check number for the card.
 * @return If the card is valid based on the Luhn Equation.
 */
    public static boolean luhn (String c, int cn)
    {
        String card = c;
        String checkString = "" + cn;
        int check = Integer.valueOf(checkString);

        //Drop the last digit.
        card = card.substring(0, ( card.length() - 1 ) );

        //Reverse the digits.
        String cardrev = new StringBuilder(card).reverse().toString();

        //Store it in an int array.
        char[] cardArray = cardrev.toCharArray();
        int[] cardWorking = new int[cardArray.length];
        int addedNumbers = 0;

        for (int i = 0; i < cardArray.length; i++)
        {
            cardWorking[i] = Character.getNumericValue( cardArray[i] );
        }

        //Double odd positioned digits (which are really even in our case, since index starts at 0).

        for (int j = 0; j < cardWorking.length; j++)
        {
            if ( (j % 2) == 0)
            {
                cardWorking[j] = cardWorking[j] * 2;
            }
        }

        //Subtract 9 from digits larger than 9.

        for (int k = 0; k < cardWorking.length; k++)
        {
            if (cardWorking[k] > 9)
            {
                cardWorking[k] = cardWorking[k] - 9;
            }
        }

        //Add all the numbers together.
        for (int l = 0; l < cardWorking.length; l++)
        {
            addedNumbers += cardWorking[l];
        }

        //Finally, check if the number we got from adding all the other numbers
        //when divided by ten has a remainder equal to the check number.
        /*if (addedNumbers % 10 == check)
        {
            return true;
        }
        else
        {           
            return false;
        }*/
        return (addedNumbers % 10 == check);
    }
}
