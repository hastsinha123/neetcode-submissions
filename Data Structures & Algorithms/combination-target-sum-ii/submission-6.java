class Solution {

    List<List<Integer>> list = new ArrayList<>();
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        list.clear();
        set.clear();
        Arrays.sort(candidates);
        LinkedList<Integer> ans = new LinkedList<>();
        getComb(candidates, ans, 0, target);
        return list;
        
    }

    public void getComb(int[] arr, LinkedList<Integer> ans, int index, int target) {
        
            if(target == 0) {
                if(!set.contains(ans)) {
                    list.add(new ArrayList<>(ans));
                    set.add(new ArrayList<>(ans));
                }
            return;
            }
            if(index >= arr.length || target < 0 ) {
            return;
        }


        ans.add(arr[index]);
        getComb(arr, ans, index+1, target-arr[index]);
        
        ans.removeLast();
        
        while(index < arr.length-1 && arr[index] == arr[index+1]){
            index++;
        }
        
        getComb(arr, ans, index+1, target);
    }
}
