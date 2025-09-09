class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp = new int[nums.length];
        int n = nums.length;
        dp[n-1] = nums[n-1];
        dp[n-2] = nums[n-2];
        for(int i=n-3;i>=0;i--){
            dp[i] = Math.max(dp[i],dp[i+2]);
            if(i+3<n){
                dp[i] = Math.max(dp[i],dp[i+3]);
            }
            dp[i]+=nums[i];
        }
        return Math.max(dp[0],dp[1]);
    }
}