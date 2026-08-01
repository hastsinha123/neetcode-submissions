class Solution {
    public int[] dailyTemperatures(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        int []ans = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                ans[i] = stack.peek() - i;
            } else {
                ans[i] = 0;
            }
            stack.push(i);
        }
        return ans;
    }
}
