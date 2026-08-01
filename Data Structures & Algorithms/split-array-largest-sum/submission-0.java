class Solution {
    public int splitArray(int[] arr, int k) {
        int low = 0, high = 0;
        for(int i=0;i<arr.length;i++){
            low = Math.max(low,arr[i]);
            high+=arr[i];
        }

        while(low < high){
            int mid = low + (high - low) / 2;
            int div =  divideArray(arr,mid);
        
            if(div > k){
                low = mid +1;
            } else {
                high = mid;
            }
        }
        return low;
        
    }

    public int divideArray(int arr[], int total){
        int sum = 0, count = 1;
        for(int i = 0;i<arr.length;i++){
            if(sum + arr[i] <= total){
                sum += arr[i];
            } else {
                count++;
                sum = arr[i];
            }
        }
        return count;
    }
}