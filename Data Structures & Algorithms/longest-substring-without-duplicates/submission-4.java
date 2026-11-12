class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left =0, right =0;
        Set<Character> set = new HashSet<>();
        int len = 0;

        while(right < s.length()) {
        
            while(set.contains(s.charAt(right))){  
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            len = Math.max(len, right - left +1);
            right++;
        }        
        return len;
    }
}
