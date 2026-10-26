class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        return divide(s,0, set);
        
    }

    public ArrayList<String> divide(String s, int start, HashSet<String> set){
        ArrayList<String> ans = new ArrayList<>();

        if(start == s.length()) {
            ans.add("");
            return ans;
        }


        for(int end = start+1; end <= s.length();end++) {
            String word = s.substring(start, end);
            if(set.contains(word)) {
                ArrayList<String> suffixes = divide(s,end, set);
                for(String str : suffixes) {

                    if(str.isEmpty()){
                        ans.add(word);
                    } else {
                        ans.add(word+" "+str);
                    }

                }
            }
        }
        return ans;
    }
}