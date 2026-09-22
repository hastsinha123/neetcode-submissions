class Solution {

    static class Task implements Comparable<Task>{
        int f;
        int time;

        public Task(int f, int t){
            this.f = f;
            this.time = t;
        }


        public int compareTo(Task other){
            return other.f - this.f;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char t : tasks){
            map.put(t,map.getOrDefault(t,0)+1);
        }

        PriorityQueue<Task> pQueue = new PriorityQueue<>();
        for( Character c: map.keySet()){
            pQueue.offer(new Task(map.get(c),0));
        }

        Queue<Task> queue = new LinkedList<>();
        int time = 0;
        while(!queue.isEmpty() || !pQueue.isEmpty()){
            time++;
            if(!pQueue.isEmpty()){
                Task t = pQueue.poll();
                t.f = t.f-1;
                if(t.f > 0){
                    t.time = time + n;
                    queue.offer(t);
                }
            }

            if(!queue.isEmpty() && queue.peek().time == time){
                Task temp = queue.poll();
                pQueue.offer(temp);

            }
        }
        return time;
    }
}
