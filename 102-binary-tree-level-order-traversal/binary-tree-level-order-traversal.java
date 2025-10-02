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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lt = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if(root==null)
        {
            return ans;
        }
        q.addFirst(root);
        TreeNode last = root,temp=null;
        while(!q.isEmpty())
        {
            temp  = q.pollFirst();
            if(temp.left!=null)
            {
                q.addLast(temp.left);
            }
            if(temp.right!=null)
            {
                q.addLast(temp.right);
            }
            lt.add(temp.val);
            if(temp==last)
            {
                ans.add(new ArrayList<>(lt));
                lt.clear();
                last = q.peekLast();
            }
        }
        return ans;
    }
}