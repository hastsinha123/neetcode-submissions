class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        int s1 = maxHeap.size();
        int s2 = minHeap.size();

        if(!maxHeap.isEmpty() && s1 > s2+1){
            minHeap.offer(maxHeap.poll());
        } else if(!minHeap.isEmpty() && s2 > s1){
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        int s1 = maxHeap.size();
        int s2 = minHeap.size();

        if((s1+s2) % 2 == 0){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        } 
        return maxHeap.peek();
    }
}
