/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return quadTree(grid, 0, 0, grid.length);
        
    }

    public Node quadTree(int[][] grid, int r, int c, int len){
        if(sameTree(r, c, grid,len)){
            return new Node(grid[r][c] == 1, true);
        } 

        Node tl = quadTree(grid, r, c, len/2);
        Node tr = quadTree(grid, r, c + (len/2), len/2);
        Node bl = quadTree(grid, r + (len/2), c, len/2);
        Node br = quadTree(grid, r + (len/2), c + (len/2), len/2);

        Node root = new Node(false, false);
        root.topLeft = tl;
        root.topRight = tr;
        root.bottomLeft = bl;
        root.bottomRight = br;
        return root;
    }

    public boolean sameTree(int r, int c, int[][] grid, int len ){
        for(int i=r;i<r+len;i++){
            for(int j=c;j<c+len;j++){
                if(grid[i][j] != grid[r][c]){
                    return false;
                }
            }
        }
        return true;
    }
}