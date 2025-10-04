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
    public static Map<String,List<Integer>> map;
    public static Map<Integer,List<String>> map2;
    public static Set<String> set;
    public static int min,max;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        this.map=  new HashMap<>();
        this.map2 = new HashMap<>();
        this.set = new HashSet<>();
        this.min = Integer.MAX_VALUE; this.max=0;
        dfs(0,0,root);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lt;
        for(int i=min;i<=max;i++){
            List<String> keys = map2.get(i);
            Collections.sort(keys, (a,b) -> {
                int rowA = Integer.parseInt(a.split(":")[0]);
                int rowB = Integer.parseInt(b.split(":")[0]);
                return rowA - rowB;
            });
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<keys.size();j++){
                lt = map.get(keys.get(j));
                if(lt.size()>1){
                    Collections.sort(lt);
                }
                temp.addAll(lt);
            }
            ans.add(temp);
        }
        return ans;
    }
    public static void dfs(int row, int col, TreeNode root){
        if(root==null) return;
        List<Integer> lt;
        StringBuilder sb = new StringBuilder();
        sb.append(row).append(":").append(col);
        String key = sb.toString();
        if(!map.containsKey(key)){
            lt = new ArrayList<>();
            map.put(key,lt);
            min = Math.min(col,min);
            max = Math.max(col,max);
        }
        List<String> lt2;
        if(!map2.containsKey(col)){
            lt2 = new ArrayList<>();
            map2.put(col,lt2);
        }
        if(!set.contains(key)){
            lt2 = map2.get(col);
            lt2.add(key);
            set.add(key);
        }
        lt = map.get(key);
        lt.add(root.val);
        dfs(row+1,col-1,root.left);
        dfs(row+1,col+1,root.right);
    }
}