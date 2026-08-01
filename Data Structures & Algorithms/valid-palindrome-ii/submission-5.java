class Solution {
    public boolean validPalindrome(String str) {
        String s = str.toLowerCase();

        int i = 0, j = s.length() - 1;
        while (i < j) {
            char first = s.charAt(i);
            char last = s.charAt(j);
            if (isAlphaNumeric(first) && isAlphaNumeric(last)) {
                if (first == last) {
                    i++;
                    j--;
                } else {
                    return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
                }
            } else if (!isAlphaNumeric(first)) {
                i++;
            } else if (!isAlphaNumeric(last)) {
                j--;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (isAlphaNumeric(s.charAt(i)) && isAlphaNumeric(s.charAt(j))) {
                if (s.charAt(i) == s.charAt(j)) {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else if (!isAlphaNumeric(s.charAt(i))) {
                i++;
            } else if(!isAlphaNumeric(s.charAt(j))) {
                j--;
            }
        }
        return true;
    }

    public boolean isAlphaNumeric(char c) {
        boolean x = c >= 'A' && c <= 'Z';
        boolean y = c >= 'a' && c <= 'z';
        boolean z = c >= '0' && c <= '9';
        return (x || y || z);
    }
}