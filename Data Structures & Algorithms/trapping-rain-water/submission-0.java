class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int leftMax = -1;
        int rightMax = -1;
        int total = 0;
        
        for(int i=0;i<n;i++){
            if(arr[i] > leftMax){
                leftMax = arr[i];
            }
            left[i] = leftMax;
            if(arr[n-i-1] > rightMax){
                rightMax = arr[n-i-1];
            }
            right[n-i-1] = rightMax;
        }

        for(int i=0;i<n;i++){
            int cap = Math.min(left[i],right[i]) - arr[i];
            total+=cap;
        }
        return total;
        
    }
}
