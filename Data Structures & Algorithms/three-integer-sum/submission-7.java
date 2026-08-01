class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i =0;i<arr.length-2; i++){
            int j =i +1 ;
            int k= arr.length-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum >0){
                    k--;
                } else if(sum < 0){
                    j++;
                } else{
                    List<Integer> a = new ArrayList<>();
                    a.add(arr[i]);
                    a.add(arr[j]);
                    a.add(arr[k]);
                    ans.add(a);
                    j++;
                    k--;
                    while(j<k && arr[j] == arr[j-1]){
                        j++;
                    }

                    while(j < k && arr[k] == arr[k+1]){
                        k--;
                    }
                }
            }
            while(i<arr.length-2 && arr[i] == arr[i+1]){
                i++;
            }
        }
        return ans;
    }
}
