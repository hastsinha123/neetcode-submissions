class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int minTime = 0;
        int high = Integer.MIN_VALUE;
        int low = 1;
        for(int i = 0;i<arr.length;i++){
            high = Math.max(arr[i],high);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int hour = 0;
            for(int i = 0;i<arr.length;i++){
                hour = hour + (int) Math.ceil((double) arr[i]/mid);
                System.out.println("hor=ur = "+ hour + " Mid = "+mid);
            } 
            if(hour <= h){
                minTime = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return minTime;
    }
}
