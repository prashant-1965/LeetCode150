class Solution {
    public static Integer[] dp;
    public int jump(int[] nums) {
        dp = new Integer[nums.length];
        return dfs(0,nums);
    }
    public static int dfs(int idx, int[] nums){
        if(idx==nums.length-1) return 0;
        if(dp[idx]!=null) return dp[idx];
        int jump = 10001;
        for(int i=1;i<=nums[idx] && i+idx<nums.length;i++){
            jump =  Math.min(jump,1+dfs(i+idx,nums));
        }
        return dp[idx] = jump;
    }

}