class OrangePair{
    int x;
    int y;
    int t;
    OrangePair(int x , int y , int t){
        this.x = x;
        this.y = y;
        this.t = t;
    }
}


class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<OrangePair> que = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m; j++){
                if(grid[i][j] == 2 ){
                    que.offer(new OrangePair(i,j,0));
                }
            }
        }

        int ans = 0;

        int dRow[] = {0,0,-1,1};
        int dCol[] = {1,-1,0,0};
        
        while(!que.isEmpty()){
            int r = que.peek().x;
            int c = que.peek().y;
            int t = que.peek().t;

            que.poll();

            ans = Math.max(t,ans);
            




            for(int i = 0 ; i < 4 ; i++){
                int nRow = r+dRow[i];
                int nCol = c+dCol[i];

                if(nRow < n && nCol < m && nRow >= 0 && nCol >= 0 && grid[nRow][nCol] == 1 && !visited[nRow][nCol]){
                    que.offer(new OrangePair(nRow,nCol,t+1));
                    grid[nRow][nCol] = 2;
                    visited[nRow][nCol] = true;
                }

               
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        

        return ans;
        
    }

}