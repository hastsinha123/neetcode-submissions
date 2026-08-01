class Solution {
    public int minSubArrayLen(int target, int[] arr) {

        int minWindow = Integer.MAX_VALUE;
        int sum = 0;
        int i=0,j=0;
        while(j<arr.length) {
            sum = sum + arr[j];
            while(sum >= target) {
                minWindow = Math.min(minWindow, (j-i+1));
                    sum = sum - arr[i];
                    i++;
            } 
                j++;
            
        }
        if(minWindow != Integer.MAX_VALUE){
            return minWindow;
        } else {
            return 0;
        }
        
    }
}