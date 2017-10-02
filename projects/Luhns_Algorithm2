import java.util.Scanner;
public class luhnsAlgorithm2 
{
	//main method
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		//System.out.println("enter a credit card number");
		if(isValid(scan.nextLong()))
		{
			System.out.println("VALID");
		}
		else 
		{
			System.out.println("INVALID");
		}
		scan.close();
	}
	
	//return true if credit card is valid
	public static boolean isValid(long number)
	{
		int sumEven = 0;
		int sumOdd = 0;
		boolean result = false;
		
		if(getSize(number) >= 13 && getSize(number)<=16)
		{
			sumEven = sumOfdoubleEven(number);
			sumOdd = sumOddPlace(number);
			result = ((sumEven+sumOdd) % 10==0);
		}
		
		return result;
	}
	
	//check the size
	public static int getSize(long size)
	{
		return(Long.toString(size).length());
	}
	
	//get the sum of the even number and double them
	public static int sumOfdoubleEven(long number)
	{
		int sumEven = 0;
		String numberToString = Long.toString(number);
		
		for(int i = 0; i<numberToString.length(); i+=2)
		{
			sumEven = sumEven+(getDigit(Character.getNumericValue(numberToString.charAt(i))*2));
		}
		
		return sumEven;
	}
	
	//get the sum of the odd places numbers
	public static int sumOddPlace(long number)
	{
		int sumOdd = 0;
		String numberToString = Long.toString(number);
		
		for(int i = 1;i<numberToString.length();i+=2)
		{
			sumOdd += getDigit(Character.getNumericValue(numberToString.charAt(i)));
		}
		return sumOdd;
	}
	
	//get the number
	public static int getDigit(int number)
	{
		if(Integer.toString(number).length()==1)
		{
			return(number);
		}
		else
		{
			return(number%10)+1;
		}
	}
}
