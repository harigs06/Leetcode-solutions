/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    List<Integer> list ;
    int size ;
    int curr ;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        traversal(root);
        size = list.size();
        curr = -1;
        
    }

    public void traversal(TreeNode root){

        if(root == null)return ;

        traversal(root.left);
        list.add(root.val);
        traversal(root.right);

    }
    
    public int next() {

        if(curr < size){
            return list.get(++curr);
        }
        
        return -1;
    }
    
    public boolean hasNext() {
        return (curr < size-1);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */