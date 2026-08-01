class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> stack = new Stack<>();
        int i= 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            if(isNum(ch)){
                String num = "";
                while(isNum(s.charAt(i))){
                    num +=s.charAt(i++);
                }
                int val = Integer.parseInt(num);
                numStack.push(val);
            } else {
                if(ch == ']'){
                    StringBuilder sb= new StringBuilder();
                    while(!stack.peek().equals("[")){
                        sb.insert(0,stack.pop());
                    }
                    stack.pop();
                    int n = numStack.pop();
                    StringBuilder res = new StringBuilder();
                    while(n>0){
                        res.append(sb.toString());
                        n--;
                    }
                    stack.push(res.toString());
                } else {
                    stack.push(String.valueOf(ch));
                }
                i++;
            }
        }
        StringBuilder answer = new StringBuilder();

        for(String an : stack){
            answer.append(an);
        }
        return answer.toString();
        
    }

    public boolean isNum(char c){
        if(c>='0' && c <= '9'){
            return true;
        }
        return false;
    }
}