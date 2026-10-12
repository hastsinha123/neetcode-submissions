class Solution {
    List<List<Integer>> list = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        LinkedList<Integer> ans = new LinkedList<>();
        getSum(nums, ans, 0, target);
        return list;
        
    }

    public void getSum(int arr[], LinkedList<Integer> ans, int index, int target){
        if(index == arr.length || target <0){
            return;
        }

        if(target == 0){
            ArrayList<Integer> res = new ArrayList<>();
            for(Integer i : ans){
                res.add(i);
            }
            if(!set.contains(res)){
                list.add(res);
                set.add(res);
            }
            return;
        }

        ans.add(arr[index]);
        getSum(arr, ans, index+1, target- arr[index]);
        getSum(arr, ans, index, target - arr[index]);
        ans.removeLast();
        getSum(arr, ans, index+1, target);
    }
}
