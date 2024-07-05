package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * A critical point in a linked list is defined as
 *  either a local maxima or a local minima.

A node is a local maxima if the current node has a value
 strictly greater than the previous node and the next node.

A node is a local minima if the current node has a value
 strictly smaller than the previous node and the next node.

Note that a node can only be a local maxima/minima
 if there exists both a previous node and a next node.

Given a linked list head, return an array of length 2 containing [minDistance, maxDistance] 
where minDistance is the minimum distance between any two distinct critical points and
 maxDistance is the maximum distance between any two distinct critical points. 
 If there are fewer than two critical points, return [-1, -1].

 

Example 1:


Input: head = [3,1]
Output: [-1,-1]
Explanation: There are no critical points in [3,1].
Example 2:


Input: head = [5,3,1,2,5,1,2]
Output: [1,3]
Explanation: There are three critical points:
- [5,3,1,2,5,1,2]: The third node is a local minima because 1 is less than 3 and 2.
- [5,3,1,2,5,1,2]: The fifth node is a local maxima because 5 is greater than 2 and 1.
- [5,3,1,2,5,1,2]: The sixth node is a local minima because 1 is less than 5 and 2.
The minimum distance is between the fifth and the sixth node. minDistance = 6 - 5 = 1.
The maximum distance is between the third and the sixth node. maxDistance = 6 - 3 = 3.
 */
public class Q_2058_find_the_minimum_and_maximum_number_of_nodes_between_critical_points {
	public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head == null || head.next == null || head.next.next == null ){
            return new int[]{-1,-1};
        }
        List<Integer> list = new ArrayList<>();
        ListNode curr = head.next;
        ListNode prev = head;
        int pos = 1;
        
        while(curr.next != null){
            if((curr.val > prev.val && curr.val>curr.next.val) || (curr.val<prev.val && curr.val<curr.next.val)){
                list.add(pos);
            }
            prev = curr;
            curr = curr.next;
            pos++;
        }
        if(list.size()<2){
            return new int[]{-1,-1};
        }

        int min = Integer.MAX_VALUE;
        int max = list.get(list.size()-1)-list.get(0);

        for(int i=1;i<list.size();i++){
            min = Math.min(min,list.get(i)-list.get(i-1));
        }
        return new int[]{min,max};

    }

}
