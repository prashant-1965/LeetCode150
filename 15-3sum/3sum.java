class Solution {
    public static List<List<Integer>> ans;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            find(i+1,nums.length-1,-(nums[i]),nums);
            while(i<nums.length-1 && nums[i]==nums[i+1])i++;
        }
        return ans;
    }
    public static void find(int low, int high, int k, int[] nums){
        String last = "";
        StringBuilder now;
        List<Integer> lt;
        while(low<high){
            int val = nums[low]+nums[high];
            if(val==k){
                lt=  new ArrayList<>();
                lt.add(nums[low]);lt.add(nums[high]);lt.add(-k);
                now = new StringBuilder();
                now.append(nums[low]).append(nums[high]).append(-k);
                if(!last.equals(now.toString())){
                    ans.add(lt);
                    last = now.toString();
                }
            }
            if(val>=k)high--;
            else low++;
        }
    }
}