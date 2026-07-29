class Solution {
    public int numEnclaves(int[][] grid) {

       int n = grid.length;
        int m = grid[0].length;

        // boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < m ; i++){
            if(grid[0][i] == 1){
                dfs(grid,0,i);
            }

            if(grid[n-1][i] == 1){
                dfs(grid,n-1,i);
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(grid[i][0] == 1){
                dfs(grid,i,0);
            }

            if(grid[i][m-1] == 1){
                dfs(grid,i,m-1);
            }
        }

        int ans = 0;

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }

        return ans;
    }

    void dfs(int[][] grid , int r , int c){
        grid[r][c] = 0;

        int n = grid.length;
        int m = grid[0].length;


        int dRow[] = {0,0,1,-1};
        int dCol[] = {1,-1,0,0};

        for(int i = 0 ; i < 4 ; i++){
            int nRow = r + dRow[i];
            int nCol = c + dCol[i];
            

            if(nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && grid[nRow][nCol] != 0) {
                dfs(grid,nRow,nCol);
            }
        }


    }
}