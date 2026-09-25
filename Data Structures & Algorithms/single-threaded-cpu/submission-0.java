class Solution {

    static class Task implements Comparable<Task> {
        int index;
        int processTime;
        int enqueTime;

        public Task(int i, int p, int e){
            this.index =i;
            this.processTime = p;
            this.enqueTime = e;
        }

        public int compareTo(Task other) {
           if(this.processTime == other.processTime){
            return this.index - other.index;
           }

           return this.processTime - other.processTime;
        }
    }

    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> pq = new PriorityQueue<>();
        
        Task[] arr = new Task[tasks.length];
        for(int i =0;i<tasks.length;i++){
            arr[i] = new Task(i, tasks[i][1], tasks[i][0]);
        }

        Arrays.sort(arr,(a,b) -> a.enqueTime - b.enqueTime);
        ArrayList<Integer> res = new ArrayList<>();
        int time = 0;
        int i=0;
        while(res.size() < arr.length){
            if(pq.isEmpty()){
                time = Math.max(time, arr[i].enqueTime);
            }

            while(i< arr.length && arr[i].enqueTime <= time) {
                pq.offer(arr[i]);
                i++;
            }

            Task t = pq.poll();
            time += t.processTime;
            res.add(t.index);

        }

        int[] ans = new int[tasks.length];
        int a =0;
        for(Integer val: res){
            ans[a++] = val;
        }
        return ans;
    }
}