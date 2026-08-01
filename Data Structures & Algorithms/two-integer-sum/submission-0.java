class Solution {
    public int[] twoSum(int[] arr, int t) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }
            if(map.containsKey(t-arr[i]) && map.get(t-arr[i])!=i){
                res[0] = map.get(t-arr[i]);
                res[1] = i;
                return res;
            }
        }
        return res;
    }
}
