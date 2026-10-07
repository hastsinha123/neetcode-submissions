class Solution {
    class Project implements Comparable<Project> {
        int capital;
        int profit;

        public Project(int p, int c){
            this.capital = c;
            this.profit = p;
        }

        public int compareTo(Project that ){
            return this.capital - that.capital;
        }

    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Project> capQueue = new PriorityQueue<>();
        for(int i=0;i< capital.length;i++){
            capQueue.offer(new Project(profits[i], capital[i]));
        }

           PriorityQueue<Integer> profQueue = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

           while(k>0){
            while(!capQueue.isEmpty() && capQueue.peek().capital <=w){
                profQueue.offer(capQueue.poll().profit);
            }

            if(profQueue.isEmpty()) {
                break;
            }

            w += profQueue.poll();


            k--;
           }
           return w;

        
    }
}