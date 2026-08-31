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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }

        if(root.val > key){
            root.left = deleteNode(root.left,key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right , key);
        } else {
            if(root.left == null){
                TreeNode temp = root.right;
                // root = null;
                return temp;
            } else if(root.right == null){
                TreeNode temp = root.left;
                // root = null;
                return temp;
            } else {
                TreeNode inorderSuccessor = inorderSuccessor(root.right);
                root.val = inorderSuccessor.val;
                root.right = deleteNode(root.right, inorderSuccessor.val);
            }

        }
        
        return root;
    
    }

    public TreeNode inorderSuccessor(TreeNode root){
        while(root != null && root.left != null){
            root = root.left;
        }
        return root;
    }
}