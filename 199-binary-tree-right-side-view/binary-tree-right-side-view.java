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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        Deque<TreeNode> q= new LinkedList<>();
        q.add(root);
        TreeNode last = root;
        while(!q.isEmpty())
        {
            TreeNode temp = q.pollFirst();
            if(temp.left!=null)
            {
                q.addLast(temp.left);
            }
            if(temp.right!=null)
            {
                q.addLast(temp.right);
            }
            if(temp==last)
            {
                ans.add(temp.val);
                last = q.peekLast();
            }
        }
        return ans;
    }
}