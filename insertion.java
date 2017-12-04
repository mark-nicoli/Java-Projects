import java.util.Scanner;
public class insertion
{
    public static void main(String a[])
    {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr1 = new int [size];
        for(int i = 0;i<size;i++)
            arr1[i] = scan.nextInt();
        int[] arr2 = InsertionSort(arr1);
        for(int i=0;i<size;i++)
        {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static int[] InsertionSort(int[] input){

        int temp;
        for (int i = 1; i < input.length; i++)
        {
            for(int j = i ; j > 0 ; j--)
            {
                if(input[j] < input[j-1])
                {
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
        return input;
    }
}