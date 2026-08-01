class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] ps = getPreviousSmaller(heights);
        int[] ns = getNextSmaller(heights);
        int maxArea = Integer.MIN_VALUE;

for(int i=0;i<heights.length;i++){
            System.out.print(" "+ps[i]);
}
System.out.println();
for(int i=0;i<heights.length;i++){
            System.out.print(" "+ns[i]);
}
System.out.println();
        for(int i=0;i<heights.length;i++){
            int sum = (ns[i] - ps[i] -1) * heights[i];
            maxArea = Math.max(maxArea,sum);
        }
        return maxArea;
    }

    public int[] getPreviousSmaller(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int []ans = new int[arr.length];
        int i=0;
        while(i< arr.length){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);
            i++;
        }
        return ans;
    }

    public int[] getNextSmaller(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        int i=arr.length-1;
        while(i >= 0){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = arr.length;
            } else {
                ans[i] = stack.peek();
            }
            stack.push(i);

            i--;
        }
        return ans;
    }
}
