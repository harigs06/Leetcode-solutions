class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {



        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }



        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        dp[m-1][n-1] = 1;

        return paths(0,0,obstacleGrid);
        
    }

    int paths(int i, int j , int[][] grid){
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1) {
            return 0;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = paths(i + 1, j, grid) + paths(i, j + 1, grid);
        return dp[i][j];
    }
}