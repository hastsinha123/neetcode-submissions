/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int low = 0, high = arr.length();

        int peak = getPeakIndex(arr);
        
            if(arr.get(peak) == target) {
                return peak;
            }
            int norm = normalSearch(0,peak,arr,target);
            if(norm == -1){
                int rev = reverseSearch(peak+1,arr.length()-1,arr,target);
                return rev;
            }
            return norm;
            
        
    }

    public int getPeakIndex( MountainArray arr){
        int low = 0, high = arr.length()-1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(arr.get(mid) > arr.get(mid+1)){
                high = mid;
            } else {
                low = mid +1;
            }
        }
        return low;
    }

    public int normalSearch(int low, int high, MountainArray arr, int target){
        while(low <= high){
            int mid = low + (high - low ) / 2;
            if(arr.get(mid) == target){
                return mid;
            } else if (arr.get(mid) < target) {
                low = mid+1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int reverseSearch(int low, int high, MountainArray arr, int target){
        while(low <= high){
            int mid = low + (high - low ) / 2;
            if(arr.get(mid) == target ){
                return mid;
            } else if(arr.get(mid) > target){
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
}