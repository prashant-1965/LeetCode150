class Solution {
    public boolean doesAliceWin(String s) {
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i)))return true;
        }
        return false;
    }
    public static boolean isVowel(char ch){
        if(ch=='a' || ch=='e'|| ch=='i' || ch=='o' || ch=='u') return true;
        return false;
    }
}