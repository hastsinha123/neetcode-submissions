class Solution {
    public int[] asteroidCollision(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        for(int i= 0;i<arr.length;i++){
            if(stack.isEmpty() || arr[i] > 0 ){
                stack.push(arr[i]);
            } else {
                while(!stack.isEmpty()){
                    int top = stack.peek();
                    if(top < 0 ){
                        stack.push(arr[i]);
                        break;
                    } 
                    int mod = Math.abs(arr[i]);
                    if(top == mod){
                        stack.pop();
                        break;
                    } else if(top > mod){
                        break;
                    } else {
                        stack.pop();
                        if(stack.isEmpty()){
                            stack.push(arr[i]);
                            break;
                        }
                    }
                }
            }
            
        }

        int[] ans = new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}