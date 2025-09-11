class Solution {
    public int uniquePathsWithObstacles(int[][] nums) {
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]==1) nums[i][j] = Integer.MAX_VALUE;
                else if(i==0 || j==0){
                    if(i-1>=0 && nums[i-1][j]==Integer.MAX_VALUE){
                        nums[i][j] = Integer.MAX_VALUE;
                    }else if(j-1>=0 && nums[i][j-1]==Integer.MAX_VALUE){
                        nums[i][j] = Integer.MAX_VALUE;
                    }else{
                        nums[i][j] = 1;
                    }
                }
                else{
                    if(nums[i-1][j]==Integer.MAX_VALUE && nums[i][j-1]==Integer.MAX_VALUE){
                        nums[i][j]=Integer.MAX_VALUE;
                    }else if(nums[i-1][j]==Integer.MAX_VALUE){
                        nums[i][j] = nums[i][j-1];
                    }else if(nums[i][j-1]==Integer.MAX_VALUE){
                        nums[i][j] = nums[i-1][j];
                    }else{
                        nums[i][j] = nums[i-1][j]+nums[i][j-1];
                    }
                }
            }
        }
        int ans = nums[nums.length-1][nums[0].length-1];
        return ans==Integer.MAX_VALUE?0:ans ;
        
    }
}