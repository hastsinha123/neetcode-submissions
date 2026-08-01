class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int i=0;
        for(i=0;i<nums.length-1;i++){
            if(nums[i] != nums[i+1]){
                nums[count++] = nums[i];
            } else {
                continue;
            }
        }
        if(i== nums.length-1){
            nums[count++] = nums[i];
        }

        return count;
    }
}