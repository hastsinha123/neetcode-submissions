class Solution {
    public int removeElement(int[] nums, int val) {
        
        int n = nums.length;
        int c = 0;
        for(int i=0;i<n;i++){
            if(val != nums[i]){
                nums[c] = nums[i];
                c++;
            }
        }
        return c;
    }

}