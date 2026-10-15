class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        getPermute(nums, ans, list);
        return list;
        
    }

    public void getPermute(int[] arr, ArrayList<Integer> ans, List<List<Integer>> list) {

        if(ans.size() == arr.length){
            list.add(new ArrayList<>(ans));
        }


        for(int i : arr){
            if(ans.contains(i)){
                continue;
            }

            ans.add(i);
            getPermute(arr, ans, list);
            ans.removeLast();
        }
    }
}
