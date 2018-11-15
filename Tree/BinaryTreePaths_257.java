/*
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3*/
public class BinaryTreePaths_257 {
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new LinkedList<>();
            if (root == null) return result;
            result = dfs(root,"",result);
            return result;
        }
        public List<String> dfs(TreeNode root,String path, List<String> result){
            if(root.left == null && root.right == null) result.add(path+root.val);
            if(root.left != null) dfs(root.left, path+root.val+"->",result);
            if(root.right != null) dfs(root.right, path+root.val+"->",result);
            return result;
        }

    }
}

