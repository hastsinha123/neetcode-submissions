class Solution {
    public int[] sortArray(int[] nums) {

        return partition(nums,0,nums.length-1);
    }

    public int[] partition(int[] nums, int i, int j){
        if(i<j){
            int pivot = quickSort(nums,i,j);
            partition(nums,i,pivot-1);
            partition(nums,pivot+1,j);
        }
        return nums;
    }

    public int quickSort(int[] arr, int i, int j){

        int p = i;
        while(i<j){
            while(i<=j && arr[i]<=arr[p]){
                i++;
            }
            while(j>=i && arr[j]>arr[p]){
                j--;
            }
            if(i<j){
                swap(arr,i,j);
            }
        }
        if(i>=j){
            swap(arr,j,p);
        }
        return j;
    }

    public void swap(int arr[], int i, int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}