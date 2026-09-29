class Solution {
    static class Mapp implements Comparable<Mapp>{
        char ch;
        int c;

        public Mapp(char c, int i){
            this.ch = c;
            this.c = i;
        }

        public int compareTo(Mapp other ){
            return other.c - this.c;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Mapp> pq = new PriorityQueue<>();
        if(a > 0){pq.offer(new Mapp('a',a));}
        if(b > 0) {pq.offer(new Mapp('b',b));}
        if(c > 0) {pq.offer(new Mapp('c',c)); }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Mapp first = pq.poll();
            
            if(sb.length() >=2 && sb.charAt(sb.length()-1) == first.ch && sb.charAt(sb.length()-2) == first.ch){
                if(pq.isEmpty()){
                    break;
                }

                Mapp sec = pq.poll();
                sb.append(sec.ch);
                sec.c--;
                if(sec.c > 0){
                    pq.offer(sec);
                }
                pq.offer(first);
            } else {
                sb.append(first.ch);
                first.c--;
                if(first.c > 0){
                    pq.offer(first);
                }
            }
        }

     
        
        return sb.toString();
    }
}