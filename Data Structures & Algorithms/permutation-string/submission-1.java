class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int []inp = new int[26];
        int window[] = new int[26];

        for(char c: s1.toCharArray()){
            inp[c - 'a']++;
        }

        int i=0,j=0;
        while(j<s2.length()){
            while(j<s2.length() && (j-i+1)<=s1.length()){
                char ch = s2.charAt(j);
                window[ch - 'a']++;
                j++;
            }
            int count = 0;
            for(int x = 0;x<inp.length;x++){
                if(inp[x] == window[x]){
                    count++;
                }
            }
            if(count == 26) { 
                return true;
            } else {
                window[s2.charAt(i) - 'a']--;
                i++;
            }

        }
        return false;
    }
}
