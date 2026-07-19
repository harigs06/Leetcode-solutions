class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int[] array : matrix){
            if(binarySeach(array,target , 0 , array.length-1)) return true;
        }

        return false;
    }

    boolean binarySeach(int[] array , int target ,int left , int right){
        if(left <= right){
            int mid = left+(right-left)/2;

            if(array[mid] == target) return true;
            if(array[mid] < target){
                return binarySeach(array , target , mid+1 , right);
            }
            return binarySeach(array,target,left,mid-1);
        }
        return false;
    }
}