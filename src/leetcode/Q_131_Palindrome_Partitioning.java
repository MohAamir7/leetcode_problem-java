package leetcode;
import java.util.*;
/*
 * Given a string s, partition s such that every substring
 of the partition is a palindrome
. Return all possible palindrome partitioning of s.
 */
public class Q_131_Palindrome_Partitioning {
	 List<List<String>> ll = new ArrayList<>();
	    public List<List<String>> partition(String s) {
	        List<String> list = new ArrayList<>();
	        partitioning(s,list);
	        return ll;
	        
	    }
	    public  void partitioning(String str,List<String> list) {
			if(str.length()==0) {
				ll.add(new ArrayList<>(list));
				return;
			}
			
			
			for(int i=1;i<=str.length();i++) {
				String s = str.substring(0,i);
				if(palindrome(s)) {
					list.add(s);
					partitioning(str.substring(i),list);
					list.remove(list.size()-1);
				}
				
			}
		}
		public static boolean palindrome(String str2) {
			int i=0;
			int j = str2.length()-1;
			while(i<j) {
				if(str2.charAt(i) == str2.charAt(j)) {
					i++;
					j--;
					
				}else {
					return false;
				}
				
			}
			return true;
			
		}

}
