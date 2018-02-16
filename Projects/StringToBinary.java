import java.util.*;
public class StringToBinary 
{
  public static void main(String[] args) 
  {
    Scanner scan = new Scanner (System.in);
    System.out.println("Enter your sentence:");
    String sentence = scan.nextLine();
    Stack <Integer> stack = new Stack<>();
    int x = 0;
    String binary ="";
    int[] ASCII = new int[256];
    for(int i=0; i<sentence.length(); i++)
    {
    	x = (int)(sentence.charAt(i));
    	stack.push(x);
    	ASCII[x]++;
    	binary += Integer.toBinaryString(stack.peek());
    	binary = binary + " ";
    	
    	if(binary.length()<7) {
    		for(int j = 0; j< 7 - binary.length(); j++) {
    			binary = "0" + binary;
    		}
    		System.out.println(binary + " ");
    	}
    }
    System.out.println(binary);
    for(int i = 0; i<256; i++)
    {
      if(ASCII[i]!=0) System.out.println("The character "+ Character.toString((char)i) +""+" appears "+ASCII[i]+" times");
    }
  }
}
