class Solution {

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        if(digits.equals("")){
            return list;
        }

        HashMap<Integer, String> map = new HashMap<>();

        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");


        getCombi(map, digits, "",0);
        return list;

        
    }

    public void getCombi(HashMap<Integer, String> hm, String val, String ans, int index) {

        if(index == val.length()){
            list.add(ans);
            return;
        }

        String value = hm.get((int) Integer.parseInt(String.valueOf(val.charAt(index))));

        for(int i=0;i<value.length();i++) {
            ans = ans+value.charAt(i);
            getCombi(hm, val, ans, index+1);
            ans = ans.substring(0, ans.length()-1);
        }
    }
}
