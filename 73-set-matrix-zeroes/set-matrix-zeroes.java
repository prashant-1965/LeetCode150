class Solution {
    public void setZeroes(int[][] nums) {
        boolean[] row = new boolean[nums.length];
        boolean[] col = new boolean[nums[0].length];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(nums[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(row[i] || col[j]){
                    nums[i][j] = 0;
                }
            }
        }
    }
}