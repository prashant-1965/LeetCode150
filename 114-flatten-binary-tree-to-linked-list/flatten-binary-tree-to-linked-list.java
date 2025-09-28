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
class Solution {
    public static TreeNode last;
    public void flatten(TreeNode root) {
        dfs(root);
    }
    public static void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        if(root.left!=null){
            last.right = root.right;
            root.right = root.left;
            root.left=null;
            root = last.right;
            dfs(root);
        }
        if(root!=null){
            dfs(root.right);
        }
        if(root!=null && root.left==null && root.right==null) last = root;
        // System.out.println(last.val);
    }
}