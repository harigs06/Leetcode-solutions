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
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        // Push all left children starting from root
        pushAllLeft(root);
    }
    
    public int next() {
        // Top of stack is the next smallest element
        TreeNode node = stack.pop();
        
        // If it has a right child, push its left branch
        if (node.right != null) {
            pushAllLeft(node.right);
        }
        
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper method to push all left descendants of a node
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */