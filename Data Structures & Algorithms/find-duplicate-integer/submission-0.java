class Solution {
    public int findDuplicate(int[] arr) {
        int slow = 0, fast = 0;
        slow = arr[slow];
        fast = arr[arr[fast]];
        while(slow != fast){
            slow = arr[slow];
            fast = arr[arr[fast]];
        }

        slow = 0;
        while(slow != fast){
            slow = arr[slow];
            fast = arr[fast];
        }

        return fast;
    }
}
