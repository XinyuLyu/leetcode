/*
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.*/
public class AverageofLevelsinBinaryTree_637 {
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
        public List<Double> averageOfLevels(TreeNode root) {
            if (root ==null)
            {
                return null;
            }
            Queue <TreeNode> que = new LinkedList();
            que.add(root);
            List <Double> res = new LinkedList();
            while(!que.isEmpty())
            {
                int size = que.size();
                int idx =0;
                double sum = 0.0;
                while(idx<size)
                {
                    TreeNode node = que.remove();
                    sum += node.val;
                    idx ++;
                    if(node.left!=null)
                    {
                        que.add(node.left);
                    }
                    if(node.right!=null)
                    {
                        que.add(node.right);
                    }
                }
                sum /= size;
                res.add(sum);
            }
            return res;
        }

    }
}
