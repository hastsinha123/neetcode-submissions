
class Solution {

    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)-> a[1] - b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int sum = 0;
       
        for(int i=0;i<trips.length;i++){

            int passen = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];

            while(!pq.isEmpty() && start >= pq.peek()[0]){
                sum -= pq.poll()[1];
            }

            sum += passen;

            if(sum > capacity){
                return false;
            }


            pq.offer(new int[]{end,passen});
        }
        return true;
    }
}