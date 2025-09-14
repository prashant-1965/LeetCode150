class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length!=1 && nums[0]==0) return false;
        if(nums[0]==0) return true;
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            if(i<=max){
                max = Math.max(max,i+nums[i]);
            }else{
                return false;
            }
        }
        return true;
    }
}
// 3 2 1 0 4