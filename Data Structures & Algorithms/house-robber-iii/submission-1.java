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
    public int rob(TreeNode root) {
        int arr[] = house(root);
        return Math.max(arr[0], arr[1]);
        
    }

    public int[] house(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }

        int[] left = house(root.left);
        int[] right = house(root.right);
        int val1 = root.val + left[1] + right[1];
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0],right[1]);
        return new int[]{val1, val2};
    }
}