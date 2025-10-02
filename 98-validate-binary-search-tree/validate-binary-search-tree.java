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
    public static void dfs(TreeNode root, long[] prev, boolean[] ans)
    {
        if(!ans[0])
        {
            return;
        }
        if(root==null)
        {
            return;
        }
        dfs(root.left,prev,ans);
        if(prev[0]==Integer.MAX_VALUE+1L)
        {
            prev[0] = (long)root.val;
        }
        else
        {
            if((long)root.val<=prev[0])
            {
                ans[0] = false;
                return;
            }
            prev[0] = (long)root.val;
        }
        dfs(root.right,prev,ans);
    }
    public boolean isValidBST(TreeNode root) {
        long[] prev = {Integer.MAX_VALUE+1L};
        boolean[] ans = {true};
        dfs(root,prev,ans);
        return ans[0];
    }
}