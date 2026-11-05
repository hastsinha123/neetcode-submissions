class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(target == nums[0]){
                return 0;
            } else {
                return -1;
            }
        }
        int low = 0, high = nums.length -1;
        while(low <= high) {
            int mid = low + (high - low) /2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < nums[low]){
                if(target >= nums[mid] && target <= nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else {
                if(target >=nums[low] && target <= nums[mid]){
                    high = mid;
                } else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
