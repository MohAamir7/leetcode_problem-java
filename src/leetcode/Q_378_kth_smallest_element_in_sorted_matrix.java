package leetcode;
/*
 * Given an n x n matrix where each of the rows and
 *  columns is sorted in ascending order,
 * return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, 
not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).
 */
public class Q_378_kth_smallest_element_in_sorted_matrix {
	public int lessthanmid(int [][]matrix,int mid){
        int count=0;
        int n=matrix.length;
        int j = n-1;
        for(int i=0;i<n;i++){
            while(j>=0 && matrix[i][j]>mid){
                j--;
            }
            count +=(j+1);
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l =matrix[0][0];
        int r = matrix[n-1][n-1];
        int res = 0;
        while(l<=r){
            int mid = l+(r-l)/2;
            int count = lessthanmid(matrix,mid);
            if(count>=k){
                r=mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
        
    }

}
