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
    public static List<Integer> lt;
    public static int i;

    public BSTIterator(TreeNode root) {
        lt=  new ArrayList<>();
        dfs(root);
        i = 0;
    }
    
    public int next() {
        return lt.get(i++);
    }
    
    public boolean hasNext() {
        return i<lt.size()?true:false;
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        lt.add(root.val);
        dfs(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */