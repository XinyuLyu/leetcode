/*A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.



Example 1:


Input: [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: [2,2,2,5,2]
Output: false


Note:

The number of nodes in the given tree will be in the range [1, 100].
Each node's value will be an integer in the range [0, 99].*/
public class UnivaluedBinaryTree_965 {
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
        public boolean isUnivalTree(TreeNode root) {
            if(root == null) return false;
            Queue<TreeNode> que = new LinkedList();
            que.add(root);
            int temp = root.val;
            while(!que.isEmpty()){
                int size = que.size();
                int idx = 0;
                while(idx<size){
                    TreeNode node = que.remove();
                    if(node.val!=temp) return false;
                    if(node.left !=null) que.add(node.left);
                    if(node.right!=null) que.add(node.right);
                    idx++;
                }
            }
            return true;
        }
    }
}
