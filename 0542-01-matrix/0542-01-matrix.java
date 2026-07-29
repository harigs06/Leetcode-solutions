class Pair{
    int x;
    int y;
    int d;

    Pair(int x , int y , int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {


        int n = mat.length;
        int m = mat[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<Pair> que = new LinkedList<>();

        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    que.offer(new Pair(i,j,0));
                    visited[i][j] = true;
                }
            }
        }

        while(!que.isEmpty()){
            int r = que.peek().x;
            int c = que.peek().y;
            int d = que.peek().d;

            que.poll();

            int dRow[] = {0,0,-1,1};
            int dCol[] = {1,-1,0,0};

            for(int i = 0 ; i < 4 ;i++){
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                if(nRow < n && nCol < m && nRow >= 0 && nCol >= 0 && !visited[nRow][nCol]){
                    que.offer(new Pair(nRow,nCol,d+1));
                    mat[nRow][nCol] = d+1;
                    visited[nRow][nCol] = true;
                }
            }
        }

        return mat;
    }

    
    
}