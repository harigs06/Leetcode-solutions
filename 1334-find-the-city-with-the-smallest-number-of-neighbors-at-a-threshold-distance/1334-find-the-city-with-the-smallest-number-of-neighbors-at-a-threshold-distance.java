class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        long[][] matrix = new long[n][n];

        for(int i = 0 ; i < n; i++){
            for (int j = 0 ; j < n ; j++){
                if(i == j){
                    matrix[i][j] = 0;
                }else{
                    matrix[i][j] = Long.MAX_VALUE;
                }
            }
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            matrix[u][v] = w;
            matrix[v][u] = w;
        }

        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(matrix[i][k] != Long.MAX_VALUE && matrix[k][j] != Long.MAX_VALUE ){
                        matrix[i][j] = Math.min(matrix[i][j] , matrix[i][k] + matrix[k][j]);
                    }
                }
            }
        }

        int[] nodes = new int[n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(matrix[i][j] <= distanceThreshold){
                    nodes[i]++;
                }
            }
        }

        int min = 0;
        int i = 1;
        while(i < n){
            if(nodes[i] <= nodes[min]){
                min = i;
            }
            i++;

        }

        return min;
    }
}