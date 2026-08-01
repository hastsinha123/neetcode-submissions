class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = getRow(matrix,target);
        if(row != -1) {
            return isTargetPresent(matrix, target, row);
        }
        return false;
    }


    public int getRow(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i =0;
        int l = 0, h = row-1;
        while(l <= h){
            int mid = l+(h-l) / 2;
            if(matrix[mid][0] <= target && matrix[mid][col-1] >= target){
                return mid;
            } else if(matrix[mid][0] > target){
                h = mid-1;
            } else if(matrix[mid][0] < target){
                l = mid+1;
            }
        }
        return -1;
    }

    public boolean isTargetPresent(int[][] arr, int target, int row){
        int l = 0, h = arr[row].length-1;
        while(l <= h){
            int mid = l + (h -l) /2;
            if(arr[row][mid] > target){
                h = mid -1;
            } else if(arr[row][mid] < target){
                l = mid +1;
            } else {
                return true;
            }
        }
        return false;
    }
}
