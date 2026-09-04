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
    int count = 0;
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        
        counter(root, max);
        return count;
    }

    public void counter(TreeNode root, int max){
        if(root == null){
            max = Integer.MIN_VALUE;
            return;
        }

            if(root.val >= max){
                max = root.val;
                count++;
            }
            counter(root.left, max);
            counter(root.right, max);
    }
}
