class StockSpanner {

    Stack<Integer> stack;
    List<Integer> list = new ArrayList<>();
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        list.add(price);
        int res = 0;
        while(!stack.isEmpty() && list.get(stack.peek()) <= price){
            stack.pop();
        }
        if(!stack.isEmpty()){
            res = list.size()-1 - stack.peek();
        } else {
            res = list.size();
        }
        stack.push(list.size()-1);
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */