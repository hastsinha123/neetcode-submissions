class Solution {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        LinkedList<Integer> ans = new LinkedList<>();
        getCombination(arr, ans, 0 , k);
        return list;
        
    }

    public void getCombination(int[] arr, LinkedList<Integer> ans, int index, int k){
        if(index >= arr.length){
            if(ans.size() == k){
                list.add(new ArrayList<>(ans));
            }
            return;
        } 

        ans.add(arr[index]);
        getCombination(arr, ans, index+1,k);

        ans.removeLast();
        getCombination(arr, ans, index+1,k);
    }
}