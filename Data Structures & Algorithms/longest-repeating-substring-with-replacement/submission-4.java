class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j =0;
        HashMap<Character,Integer> map = new HashMap<>();
        int maxVal = 0;
        int curMax = 0;
        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            curMax = Math.max(curMax,map.get(ch));
            while(j < s.length() && ((j-i+1) - curMax) > k ){
                char ch2 = s.charAt(i);
                map.put(ch2, map.get(ch2) -1);
                i++;
            }
            maxVal = Math.max(maxVal, j-i+1);
            j++;
        }
        return maxVal;
    }
}
