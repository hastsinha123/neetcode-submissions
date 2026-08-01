class FreqStack {

    HashMap<Integer,Stack<Integer>> map ;
    HashMap<Integer,Integer> freq;
    int max = 0;

    public FreqStack() {
        map = new HashMap<>();
        freq  = new HashMap<>();
    }
    
    public void push(int val) {
        freq.put(val,freq.getOrDefault(val,0)+1);
        max = Math.max(max,freq.get(val));
        int key = freq.get(val);
        if(map.containsKey(key)){
            map.get(key).push(val);
        } else {
            Stack<Integer> stack = new Stack<>();
            stack.push(val);
            map.put(key,stack);
        }
    }
    
    public int pop() {
        Stack<Integer> stack = (Stack<Integer>) (map.get(max));
        int ans = stack.pop();
        freq.put(ans,freq.get(ans)-1);
        if(stack.isEmpty()) max--;
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */