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
        int max = 0;// 全局变量 如果在函数内部初始化的话 下一个函数找不到 传入参数也没用 传参改变的话取药传出来 不传出来 max没有变
        public int diameterOfBinaryTree(TreeNode root) {
            diameter(root);
            return max;
        }

        public int diameter(TreeNode root){
            if (root == null) return 0;
            int left = diameter(root.left);
            int right = diameter(root.right);
            max = Math.max(max,left+right);
            return Math.max(left,right)+1;
        }

    }
}
