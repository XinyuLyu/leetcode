/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
Note: The length of path between two nodes is represented by the number of edges between them.
*/
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
