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
    public int size(TreeNode root){
        if(root==null) return 0;

        int leftSize=size(root.left);
        int rightSize=size(root.right);

        if(root.right==null){
            return 1+leftSize;
        }

        if(root.left==null){
            return 1+rightSize;
        }

        return 1+Math.min(leftSize,rightSize);
    }
    public int minDepth(TreeNode root) {
        int ans=size(root);
        return ans;
    }
}