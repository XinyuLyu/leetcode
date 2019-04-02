public class PathSum {
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
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root==null) return false;
            if (sum-root.val == 0 && root.left == null && root.right ==null) return true;//if (sum-root.val == 0) return true; 不用到最下面
            return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
        }
    }
}
