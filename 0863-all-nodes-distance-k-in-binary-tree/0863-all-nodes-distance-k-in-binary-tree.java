/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map <TreeNode ,TreeNode > parentMap=new HashMap<>();
    public void  markParent(TreeNode root){
        Queue <TreeNode>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr.left!=null){
                parentMap.put(curr.left,curr);
                q.add(curr.left);
            }
            if(curr.right!=null){
                parentMap.put(curr.right,curr);
                q.add(curr.right);
            }
        }
    }
   public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        markParent(root);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            if (distance == k) {
                break;
            }

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                // Left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    q.add(curr.left);
                    visited.add(curr.left);
                }

                // Right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    q.add(curr.right);
                    visited.add(curr.right);
                }

                // Parent
                if (parentMap.containsKey(curr) &&
                    !visited.contains(parentMap.get(curr))) {

                    q.add(parentMap.get(curr));
                    visited.add(parentMap.get(curr));
                }
            }

            distance++;
        }

        List<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            ans.add(q.poll().val);
        }

        return ans;
    }
}