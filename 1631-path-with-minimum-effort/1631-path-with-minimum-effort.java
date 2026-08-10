class Pair{
    int diff;
    int r;
    int c;

    Pair(int diff , int r , int c){
        this.diff = diff;
        this.r = r;
        this.c = c;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;

        int[][] diff = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                diff[i][j] = Integer.MAX_VALUE;
            }
        }

        diff[0][0] = 0;

        PriorityQueue<Pair> que = new PriorityQueue<Pair>(
            (x,y) -> (x.diff - y.diff)
        );

        que.add(new Pair(0,0,0));

        while(!que.isEmpty()){
            int r = que.peek().r;
            int c = que.peek().c;


            que.remove();

            int nRow[] = {0,0,-1,1};
            int nCol[] = {1,-1,0,0};

            for(int i = 0 ; i < 4 ; i++){
                int x = r + nRow[i];
                int y = c + nCol[i];

                if(x >= 0 && y >= 0 && x < n && y < m){
                    

                    int curr = Math.abs(heights[r][c] - heights[x][y]);
                    int newE  = Math.max(curr , diff[r][c]);
                    if( newE  < diff[x][y]){
                        diff[x][y] =  newE ;
                        que.add(new Pair(newE , x , y));
                    }


                }
            }
        }

        return diff[n-1][m-1];
        
    }
}