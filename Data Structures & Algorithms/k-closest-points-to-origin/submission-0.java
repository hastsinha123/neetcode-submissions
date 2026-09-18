class Solution {

    static class Cor{
        int[] pair;
        double dist;

        public Cor(int[] p, double d){
            this.pair = p;
            this.dist = d;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Cor> queue = new PriorityQueue<>(
            (a, b) -> Double.compare(b.dist, a.dist)
        );

        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            double dist = Math.sqrt(x*x + y*y);
            queue.add(new Cor(points[i], dist));
            if(queue.size() > k){
                queue.poll();
            }
        }

        int[][] ans = new int[k][2];
        int q =0;
        for(Cor c : queue){
            ans[q++] = c.pair;
        }

        return ans;

    }
}
