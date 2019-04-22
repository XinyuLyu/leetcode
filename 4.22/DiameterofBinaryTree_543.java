public class DiameterofBinaryTree_543 {
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
        int max =0;
        public int diameterOfBinaryTree(TreeNode root) {
            MaxDepth(root);
            return max;
        }
        public int MaxDepth(TreeNode root){
            if (root == null) return 0;
            int left = MaxDepth(root.left);
            int right = MaxDepth(root.right);
            max = Math.max(left+right,max);
            return Math.max(left,right)+1;
        }
    }
}

