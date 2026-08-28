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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        traverse(root,list1);
        traverse(subRoot,list2);
        int ind = Collections.indexOfSubList(list1, list2);
        return ind != -1;

    }

    public void traverse(TreeNode root, List<Integer> list){
        if(root == null){
            list.add(null);
            return;
        }

        traverse(root.left, list);
        traverse(root.right, list);
        list.add(root.val);
    }
}
