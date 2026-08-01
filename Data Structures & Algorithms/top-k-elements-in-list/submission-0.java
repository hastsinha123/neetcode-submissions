class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        LinkedList<Integer>[] bucket = new LinkedList[nums.length+1];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<bucket.length;i++){
            bucket[i] = new LinkedList();
        }

        for(int i=0;i<nums.length;i++){
            if(!map.isEmpty() && map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }

        for(Integer key : map.keySet()){
    
                bucket[map.get(key)].add(key);
            
        }

        int ans[] = new int[k];
        int p=0;
        for(int i=bucket.length-1;i>=0;i--){
            if(k > 0 && !bucket[i].isEmpty()){
                for(Integer val : bucket[i]){
                    System.out.print(""+val);
                    ans[p++] = val;
                    k--;
                }
            }
        }
        return ans;
    }
}
