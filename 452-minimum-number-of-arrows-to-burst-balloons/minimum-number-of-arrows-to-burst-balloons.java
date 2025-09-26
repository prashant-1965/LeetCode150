class Solution {
    public int findMinArrowShots(int[][] nums) {
        Arrays.sort(nums,(a,b)->Integer.compare(a[0],b[0]));
        // for(int i=0;i<nums.length;i++)System.out.println(nums[i][0]+" "+nums[i][1]);
        int min = nums[0][1];
        int ans=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i][0]>min){
                ans++;
                min = nums[i][1];
            }
            if(nums[i][0]<=min){
                min = Math.min(min,nums[i][1]);
            }
        }
        ans++;
        return ans;
        
    }
}