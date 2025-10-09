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
    public static int cnt;
    public int pathSum(TreeNode root, int k) {
        this.cnt=0;
        dfs(root,k);
        return cnt;
    }
    public static void dfs(TreeNode root, int k){
        if(root==null) return;
        findSum(root,0L,k);
        dfs(root.left,k);
        dfs(root.right,k);
    }
    public static void findSum(TreeNode root, long sum, int k){
        if(root==null) return;
        if(sum+root.val==k)cnt++;
        findSum(root.left,sum+root.val,k);
        findSum(root.right,sum+root.val,k);
    }
}