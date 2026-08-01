class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int i=0,j=n-1;
        int leftMax = -1, rightMax = -1, total = 0;

        while(i<j){
            if(arr[i] < arr[j]){
                leftMax = Math.max(arr[i],leftMax);
                total += (leftMax - arr[i]);
                i++;
            } else {
                rightMax = Math.max(arr[j],rightMax);
                total += (rightMax - arr[j]);
                j--;
            }
        }
        return total;
    }
}
