class Solution {

    int size = 0;
    public String encode(List<String> strs) {

        this.size = strs.size();

        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> res = new ArrayList<String>();
        int i=0;
        while(i< str.length()){
            int startIndex = str.indexOf("#",i);
            int length = Integer.parseInt(str.substring(i,startIndex));
            String decoded = str.substring(startIndex+1,startIndex+1+length);
            i = startIndex+1+length;
            res.add(decoded);
        }
        
        
      
        return res;
    }
}
