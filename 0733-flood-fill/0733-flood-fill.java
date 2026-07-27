class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;
        int precolor = image[sr][sc];
        image[sr][sc] = color;

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{sr,sc});

        int n = image.length;
        int m = image[0].length;

        while(!que.isEmpty()){
            int r = que.peek()[0];
            int c = que.peek()[1];

            que.poll();

            int dRow[]= {0,0,1,-1};
            int dCol[] = {1,-1,0,0,};

            for(int i = 0 ; i < 4 ; i++){
                int nRow = r+dRow[i];
                int nCol = c+dCol[i];

                if(nRow >=0 && nCol >= 0 && nRow < n && nCol < m && image[nRow][nCol] == precolor){
                    que.offer(new int[]{nRow,nCol});
                    image[nRow][nCol] = color;
                }
            }
        }

    
        return image;
        
    }
}