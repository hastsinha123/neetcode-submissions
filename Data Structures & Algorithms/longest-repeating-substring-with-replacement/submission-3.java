class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int maxWindow = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while( ((j-i+1) - maxFreq) > k ){
                char ch1 = s.charAt(i);
                map.put(ch1, map.get(ch1) -1);
                i++;
            }

            maxWindow = Math.max(maxWindow, (j-i+1));
            j++;
        }
        return maxWindow;
    }
}
