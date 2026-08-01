class Solution {
    public boolean isPalindrome(String str) {
        String s = str.toLowerCase();
        int i =0,j = s.length()-1;

        while(i<=j){
            char first = s.charAt(i);
            char last = s.charAt(j);

            if(isAlphaNumeric(first) && isAlphaNumeric(last)){
                if(first != last){
                    return false;
                } else {
                    i++;
                    j--;
                }
            } else if(!isAlphaNumeric(first)){
                i++;
            } else if(!isAlphaNumeric(last)){
                j--;
            }
        }

        return true;

        
    }

    public boolean isAlphaNumeric(char c) {
        boolean x = (c >= 'A' && c <= 'Z');
        boolean y = (c >= 'a' && c <= 'z');
        boolean z = (c >= '0' && c <= '9');
        if(x || y || z){
            return true;
        }
        return false;
    }
}
