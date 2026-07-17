/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root == null) return root;
        
        List<List<Node>> list = new ArrayList<>();

        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();

            List<Node> sub = new ArrayList<>();
            for(int i = 0 ; i < size ; i++){
                Node node = que.poll();
                if(node.left != null) que.offer(node.left);
                if(node.right != null) que.offer(node.right);

                sub.add(node);

            }
            list.add(sub);
        }

        for(List<Node> level : list){
            int size = level.size();
            for(int i = 0 ; i <= size-1; i++){
                if(i == size-1){
                    level.get(i).next = null;
                }else{
                    level.get(i).next = level.get(i+1);
                }
            }
        }
        
        return list.get(0).get(0);
    }
}