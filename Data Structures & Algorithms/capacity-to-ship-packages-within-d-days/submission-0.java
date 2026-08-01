class Solution {
    public int shipWithinDays(int[] arr, int days) {
        int minCap = Integer.MIN_VALUE;
        int maxCap = 0;
        int res = 0;
        for(int i=0;i<arr.length;i++){
            minCap = Math.max(minCap,arr[i]);
            maxCap += arr[i];
        }
        while(minCap <= maxCap){
            int mid = minCap + (maxCap - minCap) / 2;
            int sum = 0;
            int day = 1;
            for(int i=0;i<arr.length;i++){
                    sum+=arr[i];
                    if(sum > mid){
                        day++;
                        sum = arr[i];
                    }
            }

            if(day <= days){
                maxCap = mid -1;
                res = mid;
            } else {
                minCap = mid+1;
            }
        }
        return res;
    }
}