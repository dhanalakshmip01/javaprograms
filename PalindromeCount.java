import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromeCount {
	
	public static int getPalindromeCount(String str) {
	    // all single characters are treated as palindrome
	    int count = str.length();

	    // Get all sub strings
	    List<String> subs = new ArrayList<>();
	    subString(str, subs);

	    for (String sub : subs) {
	        String rev = new StringBuilder(sub).reverse().toString();

	        if (rev.equals(sub)) {
	          //  System.out.println(sub);
	            count++;
	        } else {
	            String valid = isPalindrome(sub);
	           // System.out.println(sub + " : " + valid);
	            if (valid != null) {
	                count++;
	            }
	        }
	    }
	    return count;
	}

	// Check if substring can form a Palindrome
	private static String isPalindrome(String input) {		
		
		if (input == null || input.length() < 2 || input.equals("") ) {
		    return null;
		}
		Map<Character, Integer> mapChars = new HashMap<Character, Integer>();

		char[] chars = input.toCharArray();

		// Build map of each char and count occurences in String
		for (int i = 0; i < chars.length; i++) {
		    if (mapChars.containsKey(chars[i])) {
		        Integer val = mapChars.get(chars[i]);
		        mapChars.put(chars[i], val+1);
		    } else {        
		        mapChars.put(chars[i], 1);    
		    }
		}

		// Validate String if possible to form palindrome rule is:
		// must have all chars count even, except middle char which can be odd
		int oneCharCount = 0;
		for (Map.Entry<Character, Integer> entry : mapChars.entrySet()) {
		    if (entry.getValue() % 2 != 0) {
		        oneCharCount++;
		        
		        if (oneCharCount > 1) {
		           return null;
		        }
		    }
		}

		int sLen = input.length();
		int middle = sLen/2;   
		Character midChar = null;
		StringBuilder s1 = new StringBuilder();

		// rearrange each group of chars distributing them at the start and end of string 
		for (Map.Entry<Character, Integer> entry : mapChars.entrySet()) {
		    int charCount = entry.getValue();
		    Character c = entry.getKey();
		    
		    if (charCount % 2 != 0) {
		        midChar = c;
		    }
		    
		        int i = charCount / 2;
		        while (i > 0) {
		           s1.append(c);
		           s1.insert(0, c);
		           i--;
		        }                              
		}

		// if middle Char exists from odd count, place it otherwise ignore
		if (midChar != null) {
			s1.insert(middle, midChar);	
		}

		return s1.toString();
    
	}

	// Get all substrings
	private static void subString(String input, List<String> list) {
	    for (int i = 0; i < input.length(); i++) {
	        for (int j = i + 2; j <= input.length(); j++) {
	            list.add(input.substring(i, j));
	        }
	    }
	}
	
	  public static void main(String[] args) {
		    String str = "aabb";
		    
		    System.out.println(getPalindromeCount(str));
		  }
 
	

}
