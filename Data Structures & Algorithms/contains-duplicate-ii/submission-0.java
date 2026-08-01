class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(arr[i] == arr[j] && Math.abs(i-j) <=k ){
                    return true;
                }
            }
        }

      return false;  
    }
}