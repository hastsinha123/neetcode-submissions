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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        iterTree(p, list1);
        iterTree(q, list2);

        if(list1.size() != list2.size()){
            return false;
        }

        for(int i=0;i< list1.size();i++){
            if(list1.get(i) != list2.get(i)){
                return false;
            }
        }
        return true;
        
    }

    public void iterTree(TreeNode root, List<Integer> list){
        if(root == null){
            list.add(-1);
            return;
        }
        
        iterTree(root.left,list);
        iterTree(root.right,list);
        list.add(root.val);
    }
}
