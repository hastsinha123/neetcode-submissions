class Solution {


    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        LinkedList<Integer> ans = new LinkedList<>();

        permute(nums,ans, vis);
        return list;
        
    }

    public void permute(int[] arr, LinkedList<Integer> ans, boolean[] vis){

        if(arr.length == ans.size() && !list.contains(new ArrayList<>(ans))){
            list.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i= 0;i<arr.length;i++) {

            if(vis[i]){
                continue;
            }
            vis[i] = true;
            ans.add(arr[i]);
            permute(arr, ans, vis);
            vis[i] = false;
            ans.removeLast();
        }
    }
}