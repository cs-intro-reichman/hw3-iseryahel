/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1); // clean the strings
		str2 = preProcess(str2); // clean the strings
		int len1 = str1.length();
		int len2 = str2.length();

		if (len1 != len2) // if length are diffrent nos anagram
			return false;

		boolean isAn = true; 
		char ch1, ch2 ;

		for ( int i = 0 ; i < len1 ; i++) // go over each char
		{
			ch1 = str1.charAt(i); // put cuurent char to check
			for (int j = 0 ; j < len2 ; j++) // go over try to find the char
			{
				ch2 = str2.charAt(j); // put cuurent char to check
				if (ch1 == ch2) // checking to see 
				{
					isAn = true;
					break; // stop the inside loop if found
				}
				else
					isAn = false;
					
			}
			if (isAn==false)
				break;
		}
		return isAn;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String string = "" ; 
		char ch;

		for (int i = 0 ; i < str.length() ; i++) // check each char
		{
			ch = str.charAt(i);
			if (ch >= 'A' && ch <= 'Z')// if capital change to lower
				ch = (char) (ch + 32);

			if (ch >= 'a' && ch <= 'z') // if lower or space
				string = string + ch; // adding to the new string


		}

		return string;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String string = "" ; 
		int random ;
		char ch;
		
		while (str.length() > 0) // as long its not empty
		{
			random = (int) ((Math.random()) * str.length()); // random index
			ch = str.charAt(random);
			string = string + ch ; // adding string
			str = str.substring(0, random) +str.substring(random + 1) ; // remove the char from original
		}
		
		return string;
	}
}

