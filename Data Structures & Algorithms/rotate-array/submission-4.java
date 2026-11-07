class Solution {
    public void rotate(int[] nums, int key) {
        int k =(int) key%nums.length;
      reverse(nums, 0, nums.length-1);
      reverse(nums,0,k-1);
      reverse(nums, k, nums.length-1);
    }

    public static void reverse(int[] arr, int left, int right){
        while(left <= right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}