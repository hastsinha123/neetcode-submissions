class Solution {
    public int maxProfit(int[] arr) {
        if(arr.length == 1) return 0;
        int left = 0, right = left+1;
        int max = Integer.MIN_VALUE;
        while(right < arr.length){
            if(arr[right] < arr[left]){
                left = right;
            } else {
                int profit = arr[right] - arr[left];
                max = Math.max(max,profit);
                right++;
            }
        }
        return max;
    }
}
