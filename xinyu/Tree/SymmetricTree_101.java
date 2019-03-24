/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3*/
public class SymmetricTree_101 {
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
        public boolean isSymmetric(TreeNode root) {
            return isMirror(root,root);
        }
        public boolean isMirror(TreeNode node1, TreeNode node2)
        {
            if(node1==null&&node2==null){return true;}
            if(node1==null||node2==null){return false;}
            return (node1.val==node2.val)&&isMirror(node1.left,node2.right)&&isMirror(node1.right,node2.left);
        }
    }
}
