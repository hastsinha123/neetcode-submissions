class KthLargest {

    int size;
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.size = k;
        for(int i: nums){
            queue.add(i);
            if(queue.size() > k){
                queue.poll();
            }
        }
        
    }
    
    public int add(int val) {
        queue.add(val);
        if(queue.size() > size){
            queue.poll();
        }
        return queue.peek();
    }
}
