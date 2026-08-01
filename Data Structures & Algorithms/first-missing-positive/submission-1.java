class Solution {
    public int firstMissingPositive(int[] arr) {
        
        for(int i=0;i<arr.length;i++){
            while(arr[i] > 0 && arr[i]<=arr.length && arr[i] != arr[arr[i]-1]){
                
                    swap(arr,i,arr[i]-1);

            }
        }

        for(int i=0;i<arr.length;i++){
            if(arr[i] != i+1){
                return i+1;
            }
        }
        return arr.length+1;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}