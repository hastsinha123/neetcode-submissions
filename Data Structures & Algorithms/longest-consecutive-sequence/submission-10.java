class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        HashSet<Integer> hm = new HashSet<>();
        int count = 1;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            hm.add(nums[i]);
        }


        for(int i=0;i<nums.length;i++){

            if(!hm.contains(nums[i]-1)){
            int num = nums[i];

            while(hm.contains(num+1)){
                count++;
                num = num+1;
            }
            max = Math.max(max,count);
            count =1;
            }
        }
        return max;
    }
}
