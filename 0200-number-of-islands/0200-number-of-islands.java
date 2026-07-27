class Solution {
    public int numIslands(char[][] grid) {
        int V = grid.length;
        boolean[][] visited = new boolean[V][grid[0].length];
        int ans = 0;
        for(int i = 0 ; i < V ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    bfs(grid,i,j,visited);
                    ans++;
                }
            }
        }

        return ans;
    }

    void bfs(char[][] grid , int r, int c , boolean[][] visited){
        visited[r][c] = true;
        Queue<Pair<Integer,Integer>> que = new LinkedList<>();
        que.offer(new Pair(r,c));

        int n = grid.length;
        int m = grid[0].length;
        while(!que.isEmpty()){

            int row = que.peek().getKey();
            int col = que.peek().getValue();
            que.poll();

            if(row >= 0 && row < n && col-1 >= 0 && col-1 < m && grid[row][col-1] == '1' && !visited[row][col-1]){
                que.offer(new Pair(row,col-1));
                visited[row][col-1] = true;

            }
            if(row >= 0 && row < n && col+1 >= 0 && col+1 < m && grid[row][col+1] == '1' && !visited[row][col+1]){
                que.offer(new Pair(row,col+1));
                visited[row][col+1] = true;

            }
            if(row-1 >= 0 && row-1 < n && col >= 0 && col < m && grid[row-1][col] == '1' && !visited[row-1][col]){
                que.offer(new Pair(row-1,col));
                visited[row-1][col] = true;

            }
            if(row+1 >= 0 && row+1 < n && col >= 0 && col < m && grid[row+1][col] == '1' && !visited[row+1][col]){
                que.offer(new Pair(row+1,col));
                visited[row+1][col] = true;

            }
            
                    
                  
            }

        }
    }
