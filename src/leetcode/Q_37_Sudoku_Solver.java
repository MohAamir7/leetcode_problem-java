package leetcode;
/*
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.
 */
public class Q_37_Sudoku_Solver {
	 public void solveSudoku(char[][] grid) {
	        Print(grid,0,0);
	        
	    }
	    public static boolean Print(char[][] grid, int row, int col) {
			// TODO Auto-generated method stub
			if(row==grid.length){
	            return true;
	        }
	        if(col == grid[0].length){
	            return Print(grid,row+1,0);
	        }
	        if(grid[row][col]!='.'){
	            return Print(grid,row,col+1);
	        }

	        for(char val = '1';val<='9';val++){
	            if(isitsafe(grid,row,col,val)){
	                grid[row][col]=val;
	                if(Print(grid,row,col+1)){
	                    return true;
	                }
	                grid[row][col]='.';
	            }
	        }
	        return false;
		}

		public static boolean isitsafe(char[][] grid, int row, int col, char val) {
			// TODO Auto-generated method stub
			// row
			for (int i = 0; i < 9; i++) {
				if (grid[row][i] == val) {
					return false;
				}
			}
			// col
			for (int i = 0; i < 9; i++) {
				if (grid[i][col] == val) {
					return false;
				}
			}
			// 3*3 Matrix
			int r = row - row % 3;
			int c = col - col % 3;
			for (int i = r; i < r + 3; i++) {
				for (int j = c; j < c + 3; j++) {
					if (grid[i][j] == val) {
						return false;
					}
				}
			}

			return true;
		}

}
