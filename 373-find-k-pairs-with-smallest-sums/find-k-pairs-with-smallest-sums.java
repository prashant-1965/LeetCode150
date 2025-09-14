class KeyValue{
    public int key;
    public int[] value;
    public KeyValue(int key, int[] value){
        this.key=  key;
        this.value = value;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<KeyValue> pq=  new PriorityQueue<>((a,b)->Integer.compare(b.key,a.key));
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lt = new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            if(!pq.isEmpty() && nums1[i]+nums2[0]>=pq.peek().key && pq.size()==k) break;
            for(int j=0;j<nums2.length;j++){
                if(!pq.isEmpty() && nums1[i]+nums2[j]>=pq.peek().key && pq.size()==k) break;
                pq.add(new KeyValue(nums1[i]+nums2[j],new int[]{nums1[i],nums2[j]}));
                if(pq.size()>k){
                    pq.poll();
                }
            }
        }
        while(!pq.isEmpty()){
            int[] temp = pq.poll().value;
            lt = new ArrayList<>();lt.add(temp[0]);lt.add(temp[1]);
            ans.add(lt);
        }
        return ans;
    }
}