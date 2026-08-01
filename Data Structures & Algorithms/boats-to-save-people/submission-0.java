class Solution {
    public int numRescueBoats(int[] arr, int limit) {

        boolean[] visited = new boolean[arr.length];
        int boat = 0;
        for(int i=0;i<arr.length;i++){
            int min = Integer.MAX_VALUE;
            int current = -1;
            if(visited[i]){
                continue;
            }
            if(arr[i] == limit){
                boat++;
                visited[i] = true;
                continue;
            }
            for(int j=i+1;j<arr.length;j++){
                if(!visited[j]){
                    int diff = limit - (arr[i] + arr[j]);
                    if(min > diff && diff >= 0){
                        current = j;
                        min = diff;
                    }
                }
            }
            visited[i] = true;
            if(current!=-1){
                visited[current] = true;
            }
            boat++;
        }
        return boat;
        
    }
}