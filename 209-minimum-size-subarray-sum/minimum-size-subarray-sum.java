class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int sum=0,ans=Integer.MAX_VALUE,slow=0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
            while(slow<=i && sum>=k){
                ans = Math.min(ans,i-slow+1);
                sum-=nums[slow];
                slow++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}