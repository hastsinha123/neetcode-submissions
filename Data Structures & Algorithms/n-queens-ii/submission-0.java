class Solution {

    List<List<String>> list = new ArrayList<>();


    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                board[i][j] = '.';
            }
        }

        getQueens(board, 0);
        return list.size();
        
    }

    public void getQueens(char[][] board, int row) {

        if(row == board.length) {
            ArrayList<String> ans = new ArrayList<>();
            for(int i=0;i<board.length;i++) {
                ans.add(new String(board[i]));
            }
            list.add(ans);
            return;
        }

        for(int j =0;j < board.length; j++) {
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                getQueens(board, row+1);
                board[row][j] = '.';
            }
        }


    }

    public boolean isSafe(char[][] board, int r, int c) {

        for(int i=0;i<board.length;i++) {
            if(board[i][c] == 'Q') {
                return false;
            }
        }

        for(int i=0;i<board.length;i++) {
            if(board[r][i] == 'Q') {
                return false;
            }
        }

        for(int i=r, j=c;i>=0 && j>=0;i--,j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i=r, j=c;i>=0 && j< board[0].length;i--,j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;

    }
}