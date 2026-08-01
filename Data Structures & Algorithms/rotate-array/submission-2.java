class Solution {
    public void rotate(int[] arr, int k) {

        reverse(arr,0,arr.length-1);
        int key = k%(arr.length);
        reverse(arr,0,key-1);
        reverse(arr,key,arr.length-1);
        
    }

    public void reverse(int arr[], int i, int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;j--;
        }
    }
}