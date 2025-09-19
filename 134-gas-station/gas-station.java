class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0,j=0;
        int[] nums = new int[gas.length];
        for(int i=0;i<gas.length;i++){
            nums[i] = gas[i]-cost[i];
            sum+=nums[i];
        }
        if(sum<0)return-1;
        for(j=0;j<nums.length && nums[j]<0;j++);
        int ans=j;
        sum=nums[j];
        for(int i=j+1;i<nums.length;i++){
            sum+=nums[i];
            if(sum<0){
                ans=-1;sum=0;
            }
            else if(ans==-1 && sum>=0){
                ans = i;
            }
        }
        return ans;
    }
}