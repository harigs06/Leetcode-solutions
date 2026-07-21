class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer ,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i , map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> heap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.getValue() , b.getValue())
        );

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            heap.add(entry);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[] res = new int[k];
        int i = 0 ; 
        while(i < k){
            res[i] = heap.poll().getKey();
            i++;
        }

        return res;
    }
}