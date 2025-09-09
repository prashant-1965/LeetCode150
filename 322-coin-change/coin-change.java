class Solution {
    public static Integer[][] dp;
    public int coinChange(int[] nums, int k) {
        dp = new Integer[nums.length][k+1];
        int ans = dfs(0,k,nums);
        return ans==100000?-1:ans;
    }
    public static int dfs(int idx, int k, int[] nums){
        if(idx==nums.length || k<0) return 100000;
        if(k==0) return 0;
        if(dp[idx][k]!=null) return dp[idx][k];
        int take = 1+dfs(idx,k-nums[idx],nums);
        int skip = dfs(idx+1,k,nums);
        return dp[idx][k] = Math.min(take,skip);
    }
}