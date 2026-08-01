class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i =0,j=0;
        Set<Character> set = new HashSet<>();
        int maxL = 0;
        while ( j < s.length()){
            while(j < s.length() && set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxL = Math.max(maxL,(j-i+1));
            j++;
        }
        return maxL;
    }
}
