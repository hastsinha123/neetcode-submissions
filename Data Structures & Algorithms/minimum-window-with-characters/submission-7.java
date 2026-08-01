class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }


        int i=0,j=0,count = map.size();
        int left =0 , minLength = Integer.MAX_VALUE;
        boolean found = false;

        while(j<s.length()){
            char cur = s.charAt(j++);
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur)-1);
                if(map.get(cur) == 0){
                    count--;
                }
            }

            while(count == 0 ) {
                 if((j-i) < minLength){
                    minLength = j-i;
                    left = i;

                    found = true;
                }
                char st = s.charAt(i++);
                if(map.containsKey(st)){
                    map.put(st, map.get(st)+1);
                    if(map.get(st) > 0){
                        count++;
                    }
                }
            }
        }

        if(found == false){
            return "";
        }
        return s.substring(left,left + minLength);

    }
}
