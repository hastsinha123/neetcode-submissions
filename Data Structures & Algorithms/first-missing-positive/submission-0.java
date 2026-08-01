class Solution {
    public int firstMissingPositive(int[] arr) {
        int ans[] = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(arr[i] > 0 && arr[i]<=arr.length){
                ans[arr[i]-1] = arr[i];
            }
        }

        for(int i=0;i<ans.length;i++){
            if(ans[i] == 0){
                return i+1;
            }
        }
        return arr.length+1;
    }
}