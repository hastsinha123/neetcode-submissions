class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] input = path.split("/");

        for(int i=0;i<input.length;i++){
            String res = input[i];
            if(res.equals("..") && !stack.isEmpty()){
                stack.pop();
            } else if(!res.equals("..") && !res.equals(".") && !res.equals("")){
                stack.push(res);
            }
        }
        
        String s = "";
        for(String str : stack) {
            s += "/"+str;
        }
        return s.length() == 0 ? "/" : s;
    }
}