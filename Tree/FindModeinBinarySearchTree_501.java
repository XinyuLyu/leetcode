
/*
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
Assume a BST is defined as follows:
The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.

For example:
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
*/

public class FindModeinBinarySearchTree_501 {
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
        public int[] findMode(TreeNode root) {
            HashMap<Integer,Integer> map = new HashMap<>();
            Queue <TreeNode> que = new LinkedList<>();
            ArrayList <Integer> list = new ArrayList<>();
            int []empty = new int[list.size()] ;
            if (root == null) return empty;
            que.add(root);
            while (!que.isEmpty()){
                int size = que.size();
                for (int i =0;i<size ;i++){
                    TreeNode node = que.remove();
                    int val= node.val;
                    map.put(val,map.containsKey(val)?map.get(val)+1:1);
                    if(node.left != null) que.add(node.left);
                    if(node.right!=null) que.add(node.right);
                }
            }
            int fre =0;
            for (Integer key: map.keySet()){
                if(map.get(key)>fre) fre = map.get(key);
            }
            for (Integer key: map.keySet()){
                if(map.get(key)==fre) list.add(key);
            }
            int [] result = new int[list.size()];
            for (int i =0; i<list.size();i++){
                result[i]= list.get(i);
            }
            Arrays.sort(result);
            return result;
        }
    }
}
