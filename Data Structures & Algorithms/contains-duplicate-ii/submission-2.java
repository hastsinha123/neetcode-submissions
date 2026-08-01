class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        int n = arr.length;
        int i=0,j=0;
        Set<Integer> set = new HashSet<>();
        while(j<n){
            if(Math.abs(i-j) <= k){
                if(set.contains(arr[j])){
                    return true;
                } else {
                    set.add(arr[j]);
                }
                j++;
            } else {
                set.remove(arr[i]);
                i++;
            }
        }

      return false;  
    }
}