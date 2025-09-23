class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int ans=0,slow=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]) continue;
            if(nums[i-1]+1!=nums[i]){
                ans = Math.max(ans,nums[i-1]-slow+1);
                slow = nums[i];
            }
        }
        ans = Math.max(ans,nums[nums.length-1]-slow+1);
        return ans;
    }
}
// 0 1 1 2