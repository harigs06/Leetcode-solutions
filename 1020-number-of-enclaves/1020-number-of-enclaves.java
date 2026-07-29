class Solution {
    public int numEnclaves(int[][] grid) {

       int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < m ; i++){
            if(grid[0][i] == 1){
                dfs(visited,grid,0,i);
            }

            if(grid[n-1][i] == 1){
                dfs(visited,grid,n-1,i);
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(grid[i][0] == 1){
                dfs(visited,grid,i,0);
            }

            if(grid[i][m-1] == 1){
                dfs(visited,grid,i,m-1);
            }
        }

        int ans = 0;

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    ans++;
                }
            }
        }

        return ans;
    }

    void dfs(boolean[][] visited , int[][] grid , int r , int c){
        visited[r][c] = true;

        int n = grid.length;
        int m = grid[0].length;


        int dRow[] = {0,0,1,-1};
        int dCol[] = {1,-1,0,0};

        for(int i = 0 ; i < 4 ; i++){
            int nRow = r + dRow[i];
            int nCol = c + dCol[i];
            

            if(nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && grid[nRow][nCol] != 0 && !visited[nRow][nCol]){
                dfs(visited,grid,nRow,nCol);
            }
        }


    }
}