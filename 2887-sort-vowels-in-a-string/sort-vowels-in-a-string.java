class Solution {
    public String sortVowels(String s) {
        int[] track = new int[54];
        char[] arr = {'A','E','I','O','U','a','e','i','o','u'};
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch=='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                track[ch-'A']++;
            }
        }
        StringBuilder sb = new StringBuilder();
        int low=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch=='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                while(low<10 && track[arr[low]-'A']==0)low++;
                sb.append(arr[low]);
                track[arr[low]-'A']--;
            }else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}