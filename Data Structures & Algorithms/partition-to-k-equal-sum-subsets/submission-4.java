class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {


        int[] ans = new int[k];
        int sum = 0;

        for(int i: nums) {
            sum+=i;
        }
        if(sum %k !=0){
            return false;
        }


        return subset(nums,(int) sum/k,k, ans, 0);
        
    }

    public boolean subset(int[] arr, int target, int k, int[] ans, int index) {

        if(index == arr.length) {
            int temp = ans[0];
            for(int in : ans){
                if(in != target){
                    return false;
                }
            }
            return true;
        }
        
        for(int i=0; i<k;i++) {
            boolean duplicate = false;
            for(int j=0;j<i;j++){
                if(ans[i] == ans[j]){
                    duplicate= true;
                    break;
                }
            }

            if(duplicate) {
                continue;
            }

            ans[i] +=arr[index];
            if(ans[i] > target ) {
                ans[i] -= arr[index];
                continue;
            }
            if(subset(arr, target, k, ans, index+1)) {
                return true;
            }
            ans[i] -= arr[index];

        }
        return false;
    }
}