class Solution {
    public int[] twoSum(int[] nums, int k) {
        int low=0,high=nums.length-1,val;
        while(low<high){
            val = nums[low]+nums[high];
            if(val==k) return new int[]{low+1,high+1};
            if(val>k)high--;
            else low++;
        }
        return new int[]{low,high};
    }
}