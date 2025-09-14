class Solution {
    public int earliestTime(int[][] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            ans = Math.min(ans,nums[i][0]+nums[i][1]);
        }
        return ans;
    }
}