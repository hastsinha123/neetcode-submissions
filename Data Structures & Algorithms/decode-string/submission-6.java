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
                System.out.println("Val = "+val);
                numStack.push(val);
            } else {
                if(ch == ']'){
                    String s1 = "";
                    String cur = "";
                    while(!stack.peek().equals("[")){
                        s1 = stack.peek() + cur;
                        cur = s1;
                        stack.pop();
                    }
                    stack.pop();
                    int n = numStack.pop();
                    String res = "";
                    while(n>0){
                        res += s1;
                        n--;
                    }
                    stack.push(res);
                } else {
                    stack.push(String.valueOf(ch));
                }
                i++;
            }
        }
        String answer = "";

        for(String an : stack){
            answer +=an;
        }
        return answer;
        
    }

    public boolean isNum(char c){
        if(c>='0' && c <= '9'){
            return true;
        }
        return false;
    }
}