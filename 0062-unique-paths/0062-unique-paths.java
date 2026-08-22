class Solution {
    int[][] arr;
    public int uniquePaths(int m, int n) {
        arr  =  new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = -1;
            }
        }
        arr[m-1][n-1] = 1;

        return paths(0,0);
        
    }

    int paths(int i , int j){

        if(arr[i][j] != -1) return arr[i][j];


        if(i == arr.length-1 ){
            arr[i][j] = paths(i,j+1);
        }else if(j == arr[i].length-1){
            arr[i][j] = paths(i+1,j);
        }else{
            arr[i][j] = paths(i+1,j)+paths(i,j+1);
        }

        return arr[i][j];
    }
}