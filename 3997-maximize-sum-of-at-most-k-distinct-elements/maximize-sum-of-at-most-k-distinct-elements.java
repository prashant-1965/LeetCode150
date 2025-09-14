class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i:nums){
            if(!set.contains(i)){
                pq.add(i);
                set.add(i);
                if(pq.size()>k) pq.poll();
            }
        }
        int[] ans = new int[pq.size()];
        for(int i=ans.length-1;i>=0;i--)ans[i] = pq.poll();
        return ans;
    }
}