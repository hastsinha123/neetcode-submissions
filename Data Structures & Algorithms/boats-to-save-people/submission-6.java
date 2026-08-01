class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        Arrays.sort(arr);
        int i =0,j=arr.length-1;
        int boat = 0;
        while( i<j ) {
            int sum = arr[i] + arr[j];
            if(sum <= limit) {
                boat++;
                i++;
                j--;
            } else {
                boat++;
                j--;
            }
            
        }
        if(i == j) {
            boat++;
        }
        return boat;
    }
}