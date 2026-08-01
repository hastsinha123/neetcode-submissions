class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!isCheckValid(i,j,board)){
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isCheckValid(int r, int c, char arr[][]){
        if(arr[r][c] == '.') return true;

        for(int i=0;i<arr.length;i++){
            if(i!=r && arr[i][c] == arr[r][c]) return false;
            if(i!=c && arr[r][i] == arr[r][c]) return false;
            int innerRow = (3*(r/3))+(i/3);
            int innerCol = (3*(c/3))+(i%3);
            if(arr[innerRow][innerCol] == arr[r][c] && r!=innerRow && c!=innerCol) return false;
        }
        return true;
    }
}
