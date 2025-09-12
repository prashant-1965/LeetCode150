class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0,slow=0;
        boolean[] track = new boolean[128];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            while(slow<i && track[ch-' ']){
                track[s.charAt(slow)-' '] = false;
                slow++;
            }
            track[ch-' '] = true;
            ans = Math.max(ans,i-slow+1);
        }
        return ans;
    }
}