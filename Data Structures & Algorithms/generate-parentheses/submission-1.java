class Solution {

    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
StringBuilder ans = new StringBuilder();
        paramthesis(n, ans, 0,0);
        return list;
        
    }

    public void paramthesis(int n, StringBuilder ans, int open, int close){

        if(ans.length() == (n*2)){
            list.add(ans.toString());
            return;
        }

        if(open < n) {
            paramthesis(n, ans.append('('),open+1, close );
            ans.deleteCharAt(ans.length() - 1);
        }
        if(close < open) {
            paramthesis(n, ans.append(')'),open, close+1 );
            ans.deleteCharAt(ans.length() - 1);
        }

    }
}
