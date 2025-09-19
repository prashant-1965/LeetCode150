class Solution {
    public String longestCommonPrefix(String[] str) {
        StringBuilder sb = new StringBuilder(str[0]);
        for(int i=1;i<str.length && sb.length()>0 ;i++){
            int j=0;
            while(j<str[i].length() && j<sb.length() && sb.charAt(j)==str[i].charAt(j)){
                j++;
            }
            sb = new StringBuilder(sb.substring(0,j));
        }
        return  sb.toString();
    }
}