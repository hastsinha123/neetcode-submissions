class Solution {
    public int maxArea(int[] arr) {
        int maxVolume = Integer.MIN_VALUE;
        int i = 0,j = arr.length-1;
        while(i<j){
            int vol = Math.min(arr[i],arr[j]) * (j-i);
            maxVolume = Math.max(maxVolume,vol);
            if(arr[i] < arr[j]){
                i++;
            } else {
                j--;
            }
        }
        return maxVolume;
        
    }
}
