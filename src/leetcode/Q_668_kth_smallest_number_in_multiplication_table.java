package leetcode;
/*
 * Nearly everyone has used the Multiplication Table.
 *  The multiplication table of size m x n is an integer matrix mat
 *   where mat[i][j] == i * j (1-indexed).

Given three integers m, n, and k, 
return the kth smallest element in the m x n multiplication table.
 */
public class Q_668_kth_smallest_number_in_multiplication_table {
//	copy from here
	 public int lessthanmid(int m, int n,int mid){
	        int count=0;
	        int i=1;
	        int j=m;
	        while(i<=n&&j>=1){
	            if(i*j<=mid){
	                count +=j;
	                i++;
	            }else{
	                j--;
	            }
	        }
	        return count;
	    }
	    public int findKthNumber(int m, int n, int k) {
	        int l = 1;
	        int r = m*n;
	        int res = 0;
	        while(l<=r){
	            int mid = l+(r-l)/2;
	            int count = lessthanmid(m,n,mid);
	            if(count<k){
	                l = mid+1;
	            }else{
	                res = mid;
	                r = mid-1;
	            }
	        }
	        return res;
	        
	    }
	

}
