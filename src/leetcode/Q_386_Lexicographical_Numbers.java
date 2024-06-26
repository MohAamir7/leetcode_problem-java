package leetcode;
import java.util.*;
/*
 * Given an integer n, 
 * return all the numbers in the range [1, n] 
 * sorted in lexicographical order.

You must write an algorithm that runs in O(n) time 
and uses O(1) extra space. 
 */
public class Q_386_Lexicographical_Numbers {
	List<Integer> list = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        printCounting(0,n);
        return list;
        
    }
    public  void printCounting(int curr, int n) {
		// TODO Auto-generated method stub
		if(curr>n) {
			return;
		}
        if(curr !=0){
            list.add(curr);
        }
		
		int i=0;
		if(curr==0) {
			i=1;
		}
		for(;i<=9;i++) {
			printCounting(curr*10+i,n);
		}	
}

}
