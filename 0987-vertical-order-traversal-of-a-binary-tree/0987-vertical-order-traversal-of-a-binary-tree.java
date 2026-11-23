
class Solution {

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    } // Close Pair class here

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer,
            TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        // Root starts at row 0 and column 0
        q.add(new Pair(root, 0, 0));

        while (!q.isEmpty()) {

            Pair p = q.poll();

            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;

            map.putIfAbsent(col, new TreeMap<>());

            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            map.get(col).get(row).add(node.val);

            // Left child
            if (node.left != null) {
                q.add(new Pair(node.left, row + 1, col - 1));
            }

            // Right child
            if (node.right != null) {
                q.add(new Pair(node.right, row + 1, col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows
                : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> nodes : rows.values()) {

                while (!nodes.isEmpty()) {
                    column.add(nodes.poll());
                }
            }

            ans.add(column);
        }

        return ans;
    }
}
