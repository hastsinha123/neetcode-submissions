/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return createTree(preorder, inorder, 0, inorder.length-1);
        
    }

    public TreeNode createTree(int[] pre, int[] inO, int left, int right){
        if(left > right){
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex]);
        preIndex++;
        int inIndex = searchIndex(root.val, inO, left, right);
        root.left = createTree(pre, inO, left, inIndex-1);
        root.right = createTree(pre, inO, inIndex+1, right);
        return root;
    }

    public int searchIndex(int val,int[] inO, int left, int right){
        for(int i=left;i<= right;i++){
            if(inO[i] == val){
                return i;
            }
        }
        return -1;
    }
}
