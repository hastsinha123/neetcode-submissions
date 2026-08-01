class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        
        for(int i =0;i<strs.length;i++){
           int[] count = new int[26];
           for(char c : strs[i].toCharArray()){
            count[c - 'a']++;
           }

           StringBuilder sb = new StringBuilder();
           for(int c : count){
            sb.append('#');
            sb.append(c);
           }

           String key = sb.toString();

           if(!map.containsKey(key)) {
            map.put(key, new ArrayList<String>());
           }
           map.get(key).add(strs[i]);
        }

        List<List<String>> res = new ArrayList<>();
        for(String key : map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }

    public static String sortString(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String sortedString = new String(arr);
        return sortedString;
    }
}
