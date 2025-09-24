class Solution {
    public List<List<String>> groupAnagrams(String[] str) {
        String[][] strs = new String[str.length][2];
        for(int i=0;i<str.length;i++){
            strs[i][0] = str[i];
            char[] chars = str[i].toCharArray();
            Arrays.sort(chars);
            strs[i][1] = new String(chars);
        }
        Map<String,List<String>> map = new HashMap<>();
        List<String> lt;
        for(int i=0;i<str.length;i++){
            if(!map.containsKey(strs[i][1])){
                lt=  new ArrayList<>();
                lt.add(strs[i][0]);
                map.put(strs[i][1],lt);
            }else{
                lt = map.get(strs[i][1]);
                lt.add(strs[i][0]);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String i:map.keySet()){
            lt= map.get(i);
            ans.add(lt);
        }
        return ans;
        
    }
}