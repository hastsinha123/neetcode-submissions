class Solution {
    public int maxArea(int[] heights) {
        int low = 0;
        int high = heights.length-1;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int max = 0;
        while(low <= high) {
            int vol = Math.min(heights[low], heights[high]) * (high - low);
            max = Math.max(max, vol);
            if(heights[low] < heights[high]){
                low++;
            } else {
                high--;
            }
        }

        return max;
    }
}
