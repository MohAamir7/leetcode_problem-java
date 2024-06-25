package leetcode;
import java.util.*;
/*
 * Given a string containing digits from 2-9 inclusive, 
 * return all possible letter combinations that the number could represent. 
 * Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) 
is given below. 
Note that 1 does not map to any letters.
 */
public class Q_17_Letter_Combination_of_Phone_Number {
	 List<String> list = new ArrayList<>();
	    static String code[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

	    public List<String> letterCombinations(String digits) {
	        if(digits.length()==0){
	            return list;
	        }
	        printans(digits,"");
	        return list;
	        
	    }
	    public  void printans(String ques, String ans) {
			// TODO Auto-generated method stub
			if(ques.length()==0) {
				list.add(ans);
				return;
			}
			
			char ch = ques.charAt(0);
			String press = code[ch-48];
			for(int i=0;i<press.length();i++) {
				printans(ques.substring(1),ans+press.charAt(i));
			}
			
		}

}
