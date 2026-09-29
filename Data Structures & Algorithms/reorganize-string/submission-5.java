class Solution {

    static class Mapp implements Comparable<Mapp>{
        char ch;
        int c;

        public Mapp(char c, int count ){
            this.ch = c;
            this.c = count;
        }

        public int compareTo(Mapp other){
            return other.c - this.c;
        }

    }
    public String reorganizeString(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        PriorityQueue<Mapp> pq = new PriorityQueue<>();
    

        for(Character c : map.keySet()){
            pq.offer(new Mapp(c, map.get(c)));
        }

        if(pq.peek().c > ((s.length()+1)/2)){
            return "";
        }
        StringBuilder sb= new StringBuilder();

        while(!pq.isEmpty()){
            Mapp first = pq.poll();
            sb.append(first.ch);

            if(!pq.isEmpty()){
                Mapp sec = pq.poll();
                sb.append(sec.ch);
                if(first.c-1 >0){
                    first.c = first.c -1;
                    pq.offer(first);
                }
                if(sec.c - 1 > 0){
                    sec.c = sec.c -1;
                    pq.offer(sec);
                }
            }

           
        }
        return sb.toString();
    }
}