class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();

        return divide(s,0, set, map);
        
    }

    public ArrayList<String> divide(String s, int start, HashSet<String> set, HashMap<Integer, ArrayList<String>> map){
        ArrayList<String> ans = new ArrayList<>();

        if(map.containsKey(start)){
            return map.get(start);
        }

        if(start == s.length()) {
            ans.add("");
            return ans;
        }


        for(int end = start+1; end <= s.length();end++) {
            String word = s.substring(start, end);
            if(set.contains(word)) {
                ArrayList<String> suffixes = divide(s,end, set , map);
                for(String str : suffixes) {

                    if(str.isEmpty()){
                        ans.add(word);
                    } else {
                        ans.add(word+" "+str);
                    }

                }
            }
        }
        map.put(start, ans);
        return ans;
    }
}