class Pair{
    int i;
    int j;
    int dis;

    Pair(int i , int j , int dis){
        this.i = i;
        this.j = j;
        this.dis = dis;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] == 1) return -1;

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> que = new LinkedList<>();

        que.offer(new Pair(0,0,1));
        grid[0][0] = 1;

        while(!que.isEmpty()){
            int r = que.peek().i;
            int c = que.peek().j;

            int dis = que.peek().dis;

            que.poll();

            if(r == n-1 && c == m-1) return dis;

            for(int i = -1 ; i <= 1 ; i++){
                for(int j = -1 ; j <= 1 ; j++){
                    int nr = r+i;
                    int nc = c+j;

                    if(nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 0){
                        que.offer(new Pair(nr,nc,dis+1));
                        grid[nr][nc] = 1;
                    }
                }
            }

        }


        return -1;
    }

}