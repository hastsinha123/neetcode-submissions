class Solution {

    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> ans = new LinkedList<>();
        getSubsets(nums,ans,0);
        return list;
    }

    public void getSubsets(int nums[], LinkedList<Integer> ans, int index) {
        if(index == nums.length){
            List<Integer> res = new ArrayList<>();
            for( Integer i : ans){
                res.add(i);
            }
            list.add(res);
            return;
        }

        ans.add(nums[index]);
        getSubsets(nums, ans, index+1);

        ans.removeLast();
        getSubsets(nums, ans, index+1);

    }
}
