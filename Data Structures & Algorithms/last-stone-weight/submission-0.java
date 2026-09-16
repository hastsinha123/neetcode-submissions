class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i : stones){
            queue.add(i);
        }

        while(queue.size() > 1){
            int a = queue.poll();
            int b = queue.poll();
            if(a > b){
                queue.add(a-b);
            } else if(b >a){
                queue.add(b-a);
            } else {
                continue;
            }
        }
        if(queue.isEmpty()){
            return 0;
        } else if (queue.size() == 2){

        
        int a = queue.poll();
        int b = queue.poll();
        if(a > b){
            return (a - b);
        } else if(b >a){
            return (b-a);
        } else {
            return 0;
        }
        }
        return queue.peek();
        
    }
}
