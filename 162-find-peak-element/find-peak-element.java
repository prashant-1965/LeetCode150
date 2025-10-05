class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
        {
            return 0;
        }
        if(nums[0]>nums[1])
        {
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2])
        {
            return nums.length-1;
        }
        int start=0,end=nums.length-1;
        while(start<=end)
        {
            int mid= (start+end)/2;
            if((mid>=1 && mid<=nums.length-2) && (nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]))
            {
                return mid;
            }
            else if(mid<=nums.length-2 && nums[mid]>nums[mid+1])
            {
                end = mid;
            }
            else if(mid>=1 && nums[mid]<nums[mid+1])
            {
                start = mid;
            }
        }
        return -1;
    }
}
// 3 4 3 2 1
// 0 1 2 3 4 