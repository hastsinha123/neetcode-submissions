class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i=0,j= arr.length -1;
        while(j-i >=k){
            if(Math.abs(arr[j] - x) > Math.abs(arr[i] - x)){
                j--;
            } else if(Math.abs(arr[j] - x) < Math.abs(arr[i] - x)){
                i++;
            } else {
                j--;
            }
        }
        List<Integer> list = new ArrayList<>();
        if((j-i+1) == k){
            for(int p=i;p<=j;p++){
                list.add(arr[p]);
            }
        }
        return list;
    }
}