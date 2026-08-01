class Solution {
    public int calPoints(String[] oper) {

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i< oper.length;i++){
            String op = oper[i];
            if(op.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                int res = a+b;
                stack.push(b);
                stack.push(a);
                stack.push(res);
            } else if(op.equals("C")){
                stack.pop();
            } else if(op.equals("D")){
                int res = 2*stack.peek();
                stack.push(res);
            } else {
                int val = Integer.parseInt(op);
                stack.push(val);
            }
        }
        int ans = 0;
        for(Integer i : stack){
            ans+=i;
        }
        return ans;
    }
}