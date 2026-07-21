import java.util.*;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for(int i : nums){
            que.add(i);
        }

        int i = 1;
        while(i < k){
            que.poll();
            i++;
        }

        return que.poll();
    }
}