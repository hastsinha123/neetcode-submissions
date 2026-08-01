class Solution {
    public int trap(int[] arr) {
        int i =0, j = arr.length -1;
        int leftMax = -1, rightMax = -1;
        int total = 0;
        while ( i< j){
            if(arr[i] < arr[j]){
                leftMax = Math.max(leftMax,arr[i]);
                total = total + (leftMax - arr[i]);
                i++;
            } else {
                rightMax = Math.max(rightMax, arr[j]);
                total = total + (rightMax - arr[j]);
                j--;
            }
        }
        return total;
    }
}
