class Solution {

    List<List<String>> list = new ArrayList<>();


    public List<List<String>> partition(String s) {

        ArrayList<String> sb = new ArrayList();
        getPart(s, sb, 0);
        return list;
        
    }

    public void getPart(String str, ArrayList<String> ans, int index) {
        if(str.length() == 0){
            list.add(new ArrayList<>(ans));
            return;
        }


        for(int i=0;i<str.length();i++) {
            String temp = str.substring(0, i+1);
            if(isPaindrome(temp)) {
                ans.add(temp);
                getPart(str.substring(i+1), ans, index+1);
                ans.removeLast();
            }
            
        }
    }

    public boolean isPaindrome(String s ){
        if(s == " " || s == ""){
            return false;
        }

        if(s.length() == 1){
            return true;
        }

        for(int i = 0;i<=s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
