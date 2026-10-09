class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        getXor(nums,list,0);
        return sum;
    }

    public void getXor(int[] arr, LinkedList<Integer> ans, int index) {
        if(index == arr.length){
            int xor = 0;
            for(Integer i : ans){
                xor = xor^i;
            }
            sum += xor;
            return ;
        }
        ans.add(arr[index]);
        getXor(arr,ans,index+1);
        ans.removeLast();
        getXor(arr,ans,index+1);

    }
}