class Solution {
    public int trap(int[] height) {

        int low = 0, high = height.length-1;
        int lMax = 0, rMax = 0;
        int vol = 0;

        while(low  <= high){
            lMax = Math.max(lMax, height[low]);
            rMax = Math.max(rMax, height[high]);
            if(lMax < rMax){
                vol += lMax - height[low];
                low++;
            } else{ 
                vol  += rMax - height[high];
                high--;
            }
        }
        return vol;
        
    }
}
