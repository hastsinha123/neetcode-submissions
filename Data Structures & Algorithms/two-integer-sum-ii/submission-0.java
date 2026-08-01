class Solution {
    public int[] twoSum(int[] arr, int t) {
        int i=0,j= arr.length-1;
        int[] ans = new int[2];
        while(i<j){
            int sum = arr[i] + arr[j];
            if(sum > t){
                j--;
            } else if(sum < t){
                i++;
            } else {
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }
        }
        return ans;
    }
}
