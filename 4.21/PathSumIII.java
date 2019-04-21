public class PathSumIII {
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
        int count =0;
        public int pathSum(TreeNode root, int sum) {
            if(root == null) return count;
            dfs(root,sum);
            pathSum(root.left,sum);
            pathSum(root.right,sum);
            return count;
        }
        public void dfs(TreeNode root, int sum){
            if(root == null) return ;
            if(sum == root.val) {
                ++ count;
            }
            dfs(root.left,sum-root.val);
            dfs(root.right,sum-root.val);
            return;
        }

    }
}
