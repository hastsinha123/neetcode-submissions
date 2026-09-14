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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null){
            return "null";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder str = new StringBuilder();

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node == null) {
                 str.append("null,");
                 continue;
            }
            str.append(node.val);
            str.append(",");
            queue.offer(node.left); 
            queue.offer(node.right);
        }
        return str.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.equals("null")){
            return null;
        }

        String[] str = data.split(",");
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        queue.add(root);
        int i= 1;
        while(!queue.isEmpty() && i < str.length){
            TreeNode node = queue.poll();

            if(i < str.length && !str[i].equals("null")){
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                node.left = left;
                queue.add(left);                
            }
            i++;

             if(i < str.length && !str[i].equals("null")){
                TreeNode right = new TreeNode(Integer.parseInt(str[i]));
                node.right = right;
                queue.add(right);                
            }
            i++;
        }
        return root;
    }
}
