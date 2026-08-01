class Solution {
    public void merge(int[] num1, int m, int[] num2, int n) {
        // if(m == 0 && n == 1) {
        //     num1[0] = num2[0];
        // }
        int i=m-1, j = n-1, k = num1.length-1;
        while(i>=0 && j>=0){
            if(num1[i] > num2[j]){
                num1[k] = num1[i];
                i--;
                k--;
            } else {
                num1[k] = num2[j];
                k--;
                j--;
            }
        }

        if(i>=0 && k>=0){
            while(i>=0){
                num1[k] = num1[i];
                i--;
                k--;
            }
        } else if(j>=0 && k>=0){
            while(j>=0){
                num1[k] = num2[j];
                j--;
                k--;
            }
        }
        
    }
}