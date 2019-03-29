public class BinaryTreeLevelOrderTraversal_II {
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
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            Stack<List<Integer>> st = new Stack<>();
            if (root == null) return res;
            Queue<TreeNode> que = new LinkedList<>();
            que.offer(root);
            while (!que.isEmpty()) {
                List<Integer> temp = new LinkedList<>();
                int size = que.size();
                while (size > 0) {
                    TreeNode node = que.poll();
                    temp.add(node.val);
                    if (node.left != null) {
                        que.offer(node.left);
                    }
                    if (node.right != null) {
                        que.offer(node.right);
                    }
                    --size;
                }
                st.push(temp);
            }
            while(!st.isEmpty()){
                res.add(st.pop());
            }
            //Collections.reverse(res);
            return res;
        }
    }

}
