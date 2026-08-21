class Solution {
    int[] arr;
    public int climbStairs(int n) {
        arr = new int[n+1];
        Arrays.fill(arr,-1);
        arr[0]=1;
        arr[1]=1;

        return climb(n);
    }

    int climb(int n){
        if(n < 2 || arr[n] != -1) return arr[n];
        
        arr[n] = climb(n-1) + climb(n-2);
         return arr[n];
    }

   
}