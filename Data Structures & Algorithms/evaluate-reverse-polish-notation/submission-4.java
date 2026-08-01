class Solution {
    public int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();
        int ans = 0;
        for(int i=0;i<tokens.length;i++){
            String cur = tokens[i];
            if(cur.equals("+")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = a+b;
                stack.push(String.valueOf(c));
            }  else if(cur.equals("-")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = b-a;
                stack.push(String.valueOf(c));
            } else if(cur.equals("*")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = a*b;
                stack.push(String.valueOf(c));
            } else if(cur.equals("/")){
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = b/a;
                stack.push(String.valueOf(c));
            } else {
                stack.push(cur);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
