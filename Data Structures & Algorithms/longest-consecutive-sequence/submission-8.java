class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        HashMap<Integer,Boolean> hm = new HashMap<>();
        int count = 1;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],true);
        }

        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i]-1)){
                hm.put(nums[i],false);
            }
        }

        for(int i=0;i<nums.length;i++){
            int num = nums[i];

            while(hm.containsKey(num+1)){
                count++;
                num = num+1;
            }
            max = Math.max(max,count);
            count =1;
        }
        return max;
    }
}
