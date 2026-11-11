class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0, right =1;
        Set<Integer> set = new HashSet<>();
        set.add(nums[left]);
        while(right < nums.length){
            if(set.contains(nums[right])){
                return true;
            }
            set.add(nums[right]);
            if((right - left ) >= k){
                set.remove(nums[left]);
                left++;
            }
            right++;
    
        }
        return false;
        
    }
}