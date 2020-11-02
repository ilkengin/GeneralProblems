package com.ilkengin.numberofislands;

public class IslandCountCalculator {
    private char[][] islandGrid;
    private int m;
    private int n;
    
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        islandGrid = grid;
        
        int islandCount = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    processIsland(i, j);    
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
    
    private void processIsland(int row, int col) {
        if (isOutOfBounds(row, col) || islandGrid[row][col] == '0') {
            return;
        }
        
        islandGrid[row][col] = '0';

        processIsland(row - 1, col);
        processIsland(row, col - 1);
        processIsland(row + 1, col);
        processIsland(row, col + 1);
    }
    
    private boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= m || col < 0 || col >= n;
    }
}
