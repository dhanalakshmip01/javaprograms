import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	            boolean valid = isPalindrome(sub);
	           // System.out.println(sub + " : " + valid);
	            if (valid ) {
	                count++;
	            }
	        }
	    }
	    return count;
	}

	// Check if substring can form a Palindrome
	private static boolean isPalindrome(String input) {		
			Set<Character> oddChars = new HashSet<>();		  
		  for (char c : input.toCharArray()) { if (!oddChars.add(c)) {
		  oddChars.remove(c); } } return oddChars.size() <= 1;			 
    
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
