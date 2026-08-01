class Solution {
    public int[] dailyTemperatures(int[] arr) {

        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        int []ans = new int[arr.length];
        
        Pair p = new Pair(arr[arr.length-1],arr.length-1);
        stack.push(p);
        for(int i=arr.length-2;i>=0;i--){
        
            if(!stack.isEmpty()){
                Pair<Integer,Integer> tem = stack.peek();
                if(tem.getKey() > arr[i]){                
                    ans[i] = tem.getValue() - i;
                    stack.push(new Pair(arr[i],i));
                } else {
                    while(tem.getKey() <= arr[i]){
                        stack.pop();
                        if(!stack.isEmpty()){
                            tem = stack.peek();
                        } else {
                            ans[i] = 0;
                            break;
                        }
                    }
                    if(!stack.isEmpty()){
                        ans[i] = tem.getValue() - i;
                    }
                    Pair p1 = new Pair(arr[i],i);
                    stack.push(p1);
                }
            }
        }
        return ans;
    }
}
