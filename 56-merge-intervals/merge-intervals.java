class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int left = nums[0][0];
        int right = nums[0][1];
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lt;
        for(int i=1;i<nums.length;i++){
            if(nums[i][0]<=right && nums[i][1]>right){
                right = nums[i][1];
            }else if(nums[i][0]>right){
                lt=  new ArrayList<>();
                lt.add(left);lt.add(right);ans.add(lt);
                left = nums[i][0];right = nums[i][1];
            }
        }
        lt=  new ArrayList<>();
        lt.add(left);lt.add(right);ans.add(lt);
        nums = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            nums[i][0] = ans.get(i).get(0);
            nums[i][1] = ans.get(i).get(1);
        }
        return nums;
    }
}