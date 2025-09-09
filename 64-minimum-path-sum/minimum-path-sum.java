class Solution {
    public int minPathSum(int[][] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(!(i==0 && j==0) && i-1<0){
                    nums[i][j]+=nums[i][j-1];
                }else if(!(i==0 && j==0) && j-1<0){
                    nums[i][j]+=nums[i-1][j];
                }else if(!(i==0 && j==0)){
                    nums[i][j] = nums[i][j]+Math.min(nums[i][j-1],nums[i-1][j]);
                }
            }
        }
        return nums[nums.length-1][nums[0].length-1];
    }
}