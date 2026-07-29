class Solution {
    public void solve(char[][] board) {
        
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < m ; i++){
            if(board[0][i] == 'O'){
                dfs(visited,board,0,i);
            }

            if(board[n-1][i] == 'O'){
                dfs(visited,board,n-1,i);
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(board[i][0] == 'O'){
                dfs(visited,board,i,0);
            }

            if(board[i][m-1] == 'O'){
                dfs(visited,board,i,m-1);
            }
        }

        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(boolean[][] visited , char[][] grid , int r , int c){
        visited[r][c] = true;

        int n = grid.length;
        int m = grid[0].length;


        int dRow[] = {0,0,1,-1};
        int dCol[] = {1,-1,0,0};

        for(int i = 0 ; i < 4 ; i++){
            int nRow = r + dRow[i];
            int nCol = c + dCol[i];
            

            if(nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && grid[nRow][nCol] != 'X' && !visited[nRow][nCol]){
                dfs(visited,grid,nRow,nCol);
            }
        }


    }
}