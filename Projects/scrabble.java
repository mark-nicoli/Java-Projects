//takes in a dictionary file and asks the user for input of letters available. the code then looks for the highest scoring words.

import java.util.*;

class Main
{
	public static void main(String [] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the letters to use: ");
		String characters = scan.nextLine().replaceAll(" ","");
		System.out.println();

		FileIO reader = new FileIO();
		String [] dictionary = reader.load("dictionary.txt");

		//System.out.println(dictionary[0]);

		List <String> array2 = new ArrayList <>();

		for(String dictWord : dictionary)
		{
			if(Make(dictWord, characters))
			{
				array2.add(dictWord);
			}

		}
		Collections.sort(array2, new Comparator <String>()
		{
			@Override
			public int compare(String a, String b)
			{
				int lengthA = a.length(), lengthB = b.length();
				if(lengthA > lengthB)
				{
					return -1;
				}
				if(lengthA > lengthB)
				{
					return 1;
				}
				return a.compareTo(b);
			}
		});

		for(String word : array2)
		{
			System.out.println(word);
		}
	}

		public static boolean Make(String word, String available)
		{
			//return true of Make word using available letters
			//System.out.println(word);
			for(char c : word.toCharArray())
			{
				if(available.indexOf("" + c) == -1) //-1 means it's not there
				{
					return false;
				}
				//"free".replaceFirst("e", " ") -> "fre"
				available = available.replaceFirst("" + c, "");
			}
			return true;
		}
}
