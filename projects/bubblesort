import java.util.Scanner;
public class arraysort
{  
	public static void main(String[] args) 
    {    	
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
		    int array[] =new int[num];
		    int temp = 0;
		
		  for(int i = 0;i<num;i++)
		  {
			  array[i] = scan.nextInt();
		  }

		  for(int i=0; i < num; i++)
       {  
			  for(int j=1; j < (num-i); j++)
         {  
				  if(array[j-1] > array[j])
           {   
					          temp = array[j-1];  
                    array[j-1] = array[j];  
                    array[j] = temp;  
            }  
                         
         }  
       }   
        for(int i=0; i < array.length; i++)
        {  
        	System.out.print(array[i] + " ");  
        }  
    }  
}  
