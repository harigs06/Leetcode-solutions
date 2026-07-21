/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(ListNode node : lists){
            while(node!=null){
                heap.add(node.val);
                node = node.next;
            }
        }

        if(heap.isEmpty()) return null;

        ListNode root = new ListNode(heap.poll());
        ListNode curr = root;

        while(!heap.isEmpty()){
            curr.next = new ListNode(heap.poll());
            curr = curr.next;

        }

        return root;
    }
} 