package leetcode;
import java.util.*;
/*
 * Given a collection of candidate numbers (candidates) and
 *  a target number (target), find all unique combinations in candidates
 *   where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
 */
public class Q_40_Combinations_Sum_2 {
	List<List<Integer>> ll = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        combinations(candidates,target,list,0);
        return ll;
        
    }
    public void combinations(int[]candidates,int target,List<Integer> list,int idx){
        if(target==0){
            ll.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(i>idx && candidates[i]==candidates[i-1]){
                continue;
            }
            if(target>=candidates[i]){
                list.add(candidates[i]);
                combinations(candidates,target-candidates[i],list,i+1);
                list.remove(list.size()-1);
            }
        }
    }

}
