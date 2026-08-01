class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> list = new ArrayList<>();
        for(int i =0;i<n-3;i++){
            if(i>0 && arr[i] == arr[i-1]){
                    continue;
            }
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && arr[j] == arr[j-1]){
                        continue;
                    }
                int p = j+1;
                int q = n-1;
                while(p<q){
                    long sum = (long)arr[i]+arr[j]+arr[p]+arr[q];
                    if(sum > target){
                        q--;
                    } else if(sum < target){
                        p++;
                    } else {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(arr[i]);
                        ans.add(arr[j]);
                        ans.add(arr[p]);
                        ans.add(arr[q]);
                        list.add(ans);
                        p++;
                        q--;
                        while(p<q && arr[p] == arr[p-1]){ p++;}
                        while(p<q && arr[q] == arr[q+1]){ q--;} 
                    }
                    
                }
                
            }
        }
        return list;
    }
}