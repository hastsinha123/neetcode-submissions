class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        String firstString = sortString(strs[0]);
        ArrayList<String> arrList = new ArrayList<>();
        arrList.add(strs[0]);
        map.put(firstString,arrList);

        for(int i =1;i<strs.length;i++){
            String s = sortString(strs[i]);
            if(!map.isEmpty() && map.containsKey(s)){
                ArrayList<String> al = new ArrayList<>();
                al.addAll(map.get(s));
                al.add(strs[i]);
                map.put(s,al);
            } else {
                ArrayList<String> al = new ArrayList<>();
                al.add(strs[i]);
                map.put(s,al);
            }
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
