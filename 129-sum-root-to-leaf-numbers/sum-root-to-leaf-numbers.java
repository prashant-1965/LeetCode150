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
    public static int total;
    public int sumNumbers(TreeNode root) {
        total =0;
        dfs(0,root);
        return total;
    }
    public static void dfs(int sum, TreeNode root){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            // System.out.println(sum*10+root.val+" "+total);
            total+=(sum*10+root.val); return;
        }
        sum = sum*10+root.val;
        dfs(sum,root.left);
        dfs(sum,root.right);
    }
}