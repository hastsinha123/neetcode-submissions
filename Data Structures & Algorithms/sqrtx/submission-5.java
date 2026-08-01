class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int l =1,h = x/2;
        int ans = 0;
        while(l <= h){
            int mid = l + (h - l) / 2;
            long sqr = (long)mid*mid;
            if(sqr > x){
                h = mid-1;
            } else if(sqr < x){
                ans = (int)mid;
                l = mid+1;
            } else {
                return mid;
            }
        }
        return ans;
        
    }
}