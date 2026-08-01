class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1 || s.length() == 0) return s.length();
        Set<Character> set = new HashSet<>();
        int i=0,j=i+1;
        set.add(s.charAt(i));
        int max = 0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max,j-i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }

        }
        return max;
        
    }
}
