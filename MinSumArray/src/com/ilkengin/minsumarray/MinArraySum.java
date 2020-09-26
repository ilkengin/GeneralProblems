package com.ilkengin.minsumarray;

import java.lang.Math;

public class MinArraySum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        
        return minPathSum(grid, 0, 0, memo);
    }
    
    private int minPathSum(int[][] grid, int row, int col, int[][] memo) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        if (row >= m || col >= n) {
            return 0;
        }
        
        if (row == m - 1 && col == n - 1) {
            return grid[row][col];
        }
        
        if (memo[row][col] == 0) {
            int pathFromBottom = minPathSum(grid, row + 1, col, memo);
            int pathFromRight = minPathSum(grid, row, col + 1, memo);

            if(row == m - 1) {
                memo[row][col] = pathFromRight + grid[row][col];
            } else if(col == n - 1) {
                memo[row][col] = pathFromBottom + grid[row][col];
            } else {
                memo[row][col] = Math.min(pathFromBottom, pathFromRight) + grid[row][col];
            }          
        }
        
        return memo[row][col];
    }
}
