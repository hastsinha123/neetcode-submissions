class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0, right =0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0, winSize = 0;
        while(right < s.length()) {
           map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
           maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));
           int windowSize = right - left +1;
           if(windowSize - maxFreq > k) {
              map.put(s.charAt(left), map.getOrDefault(s.charAt(left),0)-1);
              left++;
               
           }
           winSize = Math.max(winSize, right - left +1);
right++;
        }
    return winSize;
    }
}
