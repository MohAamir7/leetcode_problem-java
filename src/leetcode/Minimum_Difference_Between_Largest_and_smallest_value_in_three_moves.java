package leetcode;
import java.util.*;
/*
 * You are given an integer array nums.

In one move, you can choose one element of nums and change it to any value.

Return the minimum difference between the largest and smallest value of
 nums after performing at most three moves.

 

Example 1:

Input: nums = [5,3,2,4]
Output: 0
Explanation: We can make at most 3 moves.
In the first move, change 2 to 3. nums becomes [5,3,3,4].
In the second move, change 4 to 3. nums becomes [5,3,3,3].
In the third move, change 5 to 3. nums becomes [3,3,3,3].
After performing 3 moves, the difference between the minimum and maximum is 3 - 3 = 0.
 */
public class Minimum_Difference_Between_Largest_and_smallest_value_in_three_moves {
	 public int minDifference(int[] nums) {
	        int n= nums.length;
	        if(n<=4) return 0;
	        Arrays.sort(nums);
	        int a = nums[n-4]-nums[0];
	        int b = nums[n-3]-nums[1];
	        int c = nums[n-2]-nums[2];
	        int d = nums[n-1]-nums[3];

	        return Math.min(a,Math.min(b,Math.min(c,d)));

	        
	    }

}
