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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        Deque<TreeNode> dq = new LinkedList<>();
        List<Integer> lt = new ArrayList<>();
        dq.add(root);
        TreeNode last = root;
        boolean start = true;
        TreeNode temp;
        while(!dq.isEmpty())
        {
            if(start)
            {
                temp = dq.pollFirst(); // adr_9
                if(temp.left!=null)
                {
                    dq.addLast(temp.left);
                }
                if(temp.right!=null)
                {
                    dq.addLast(temp.right);
                }
            }
            else
            {
                temp = dq.pollLast();
                if(temp.right!=null)
                {
                    dq.addFirst(temp.right);
                }
                if(temp.left!=null)
                {
                    dq.addFirst(temp.left);
                }
            }
            lt.add(temp.val);
            if(temp==last)
            {
                if(start)
                {
                    start=false;
                    last = dq.peekFirst();
                }
                else
                {
                    start=true;
                    last = dq.peekLast();
                }
                ans.add(lt);
                lt = new ArrayList<>();
            }

        }
        return ans;
    }
}
// strt = true, end = false
// lt = 3;, ans = [3], last = adr_20
// q = adr_9, ard_20