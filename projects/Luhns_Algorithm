import java.util.Scanner;
public class luhnsAlgorithm 
{
	public static void main(String[] args)    
    {
    	Scanner scan = new Scanner(System.in);
        String cardNo = scan.nextLine();
        System.out.println();
        System.out.println("Check card number: " + cardNo+" for validity");
        //String digit = calculateCheckDigit(cardNo);
        System.out.println("Valid: " + luhnCheck(cardNo));
        System.out.println();
        scan.close();
        
    }
	
    public static boolean luhnCheck(String card) 
    {
        if (card == null)
        {
            return false;
        }
        
        char checkDigit = card.charAt(card.length() - 1);
        String digit = calculateCheckDigit(card.substring(0, card.length() - 1));
        return checkDigit == digit.charAt(0);
    }
    
    
    public static String calculateCheckDigit(String card) 
    {
        if (card == null)
        {
            return null;
        }
        String digit;
        
        int[] digits = new int[card.length()];
        
        for (int i = 0; i < card.length(); i++) 
        {
            digits[i] = Character.getNumericValue(card.charAt(i));
        }
       
        for (int i = digits.length - 1; i >= 0; i -= 2)    
        {
            digits[i] = digits[i]+digits[i];
            
            if (digits[i] >= 10) 
            {
                digits[i] = digits[i] - 9;
            }
            
        }
        int sum = 0;
        for (int i = 0; i < digits.length; i++) 
        {
            sum += digits[i];
        }
        
        sum = sum * 9;
        digit = sum + "";
        return digit.substring(digit.length() - 1);
    }
}
