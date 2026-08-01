class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        int[] arr1;
        int[] arr2;
        if(nums1.length > nums2.length){
            arr1 = nums2;
            arr2 = nums1;
        } else {
            arr1 = nums1;
            arr2 = nums2;
        }
        int low = 0, high = arr1.length;
        while(low <= high){


            int partA = low + (high - low ) / 2;
            int partB =( (total +1)/2 ) - partA;

            int l1 = (partA == 0) ? Integer.MIN_VALUE : arr1[partA -1];
            int r1 = (partA == arr1.length) ? Integer.MAX_VALUE : arr1[partA];
            int l2 = (partB == 0) ? Integer.MIN_VALUE : arr2[partB-1];
            int r2 = (partB == arr2.length) ? Integer.MAX_VALUE : arr2[partB];
            if(l1 <= r2 && l2 <= r1){
                if(total%2 != 0){
                    return Math.max(l1,l2);    
                } else {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            }
            if(l1 > r2){
                high = partA-1;
            } else if(l2 > r1){
                low = partA +1;
            }
        }
        return -1.0;
    }
}
