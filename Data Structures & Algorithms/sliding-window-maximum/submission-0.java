class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int[] ans = new int[arr.length-k+1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int i=0,j=0,q = 0;
        while(j < arr.length){
            if(i==0 && j-i+1 < k){
                pq.add(arr[j]);
            } else if(j-i+1 == k){
                pq.add(arr[j]);
                ans[q++] = pq.peek();
                System.out.println(pq.peek());
                pq.remove(arr[i]);
                i++;
            }
            j++;
        }
        return ans;
    }
}
