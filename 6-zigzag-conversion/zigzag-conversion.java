class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder[] str = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            str[i] = new StringBuilder();
        }
        int i=0,j=0;
        boolean forword = true;
        while(i<s.length()){
            str[j].append(s.charAt(i));
            if(forword){
                j++;
            }else{
                j--;
            }
            i++;
            if(j==numRows){
                forword = false;
                j=numRows-2;
            }else if(j==-1){
                forword = true;
                j=1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder k:str){
            // System.out.print(k+" ");
            sb.append(k);
        }
        return sb.toString();
    }
}