import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for(int i = 0 ; i < nums.length ; i++){
            que.add(nums[i]);

            if(i > k-1) que.poll();
        }

       

        return que.poll();
    }
}