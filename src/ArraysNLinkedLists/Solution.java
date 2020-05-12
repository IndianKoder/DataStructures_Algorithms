package ArraysNLinkedLists;

import java.util.*;

class Solution {
	public static int findLength(String str, int k) {
	    // TODO: Write your code here
	    int noOfChars = str.length();
	    int windowStart = 0;
	    int maxWindowLength = 0;
	    BitSet b ;
	    
	    HashMap<Character,Integer> seenChars = new HashMap();
	    for(int windowEnd = 0;windowEnd<noOfChars;windowEnd++) //Input: String="araaci", K=2
	    {
	       char curr_char = str.charAt(windowEnd);
	       if(seenChars.get(curr_char)==null)
	          seenChars.put(curr_char,1);
	       else
	          seenChars.put(curr_char,seenChars.get(curr_char)+1);
	       while(seenChars.size()>k)
	         {
	              char windowStartChar = str.charAt(windowStart);
	             // System.out.println("HI");
	              //System.out.println(windowStartChar+".."+seenChars.get(windowStartChar));
	              if(seenChars.get(windowStartChar)==1)
	                seenChars.remove(windowStartChar);
	              else
	                seenChars.put(windowStartChar,seenChars.get(windowStartChar)-1);
	              windowStart++;
	         }
	          maxWindowLength = Math.max(maxWindowLength,windowEnd-windowStart+1);
	       }
	    
	    return maxWindowLength;
	  }
  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + Solution.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + Solution.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + Solution.findLength("cbbebi", 3));
  }
}
