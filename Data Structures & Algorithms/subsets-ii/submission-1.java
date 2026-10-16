class Solution {

    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        Arrays.sort(nums);
        getSubset(nums, list, ans, 0);
        return list;
        
    }

    public void getSubset(int[] arr, List<List<Integer>> list, LinkedList<Integer> ans, int index ){

        if(index == arr.length){
            if(!set.contains(new ArrayList<>(ans))){
                set.add(new ArrayList<>(ans));
                list.add(new ArrayList<>(ans));
            }
            return;
        }
        ans.add(arr[index]);
        getSubset(arr, list, ans , index+1);
        if(index < arr.length-1 && arr[index] == arr[index+1]) {
            index++;
        }


        ans.removeLast();
        getSubset(arr, list, ans , index+1);
    }
}
