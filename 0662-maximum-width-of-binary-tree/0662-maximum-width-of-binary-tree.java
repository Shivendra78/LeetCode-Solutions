
class Solution {

    class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root, 0));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            long minIndex = q.peek().index;

            long first = 0;
            long last = 0;

            for (int i = 0; i < size; i++) {

                Pair curr = q.poll();

                TreeNode node = curr.node;

                long index = curr.index - minIndex;

                if (i == 0) {
                    first = index;
                }

                if (i == size - 1) {
                    last = index;
                }

                if (node.left != null) {
                    q.add(new Pair(node.left, 2 * index + 1));
                }

                if (node.right != null) {
                    q.add(new Pair(node.right, 2 * index + 2));
                }
            }

            int width = (int)(last - first + 1);

            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }
}
