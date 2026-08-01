class Solution {
    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        int[] preSum = new int[n];
        preSum[0] = arr[0];
        for(int i=1;i<n;i++){
            preSum[i] = preSum[i-1]+arr[i];
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for(int i=0;i<n;i++){
            
            if(preSum[i] == k){
                count++;
            }
            int val = preSum[i] - k;
            if(map.containsKey(val)){
                count = count+ map.get(val);
            }
            if(map.containsKey(preSum[i])){
                map.put(preSum[i],map.get(preSum[i])+1);
            } else {
                map.put(preSum[i],1);
            }
        }

        return count;
    }
}