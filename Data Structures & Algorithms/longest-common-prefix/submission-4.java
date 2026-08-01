class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];
        String ans = "";
        for(int i=0;i<strs[0].length();i++){
            String word = strs[0];
            String ch = "";
            if(word.length() > 1) {
                ch = word.substring(0,i+1);
            } else {
                ch = word;
            }
            System.out.println("ch ="+ch);
            for(int j=1;j<strs.length;j++){
                if(strs[j].startsWith(ch)){
                    if(j == strs.length-1){
                        ans = ch;
                    }
                    continue;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}