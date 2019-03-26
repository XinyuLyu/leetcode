/*Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

*/
public class Leaf_SimilarTrees_872 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
/*
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        preOrder(root1,list1);
        preOrder(root2,list2);
        if(list1.size()!=list2.size()) return false;
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)!=list2.get(i))return false;
        }
        return true;
    }
    public List<Integer> preOrder(TreeNode root,List<Integer>list){
        if(root == null) return list;
        if(root.left==null && root.right==null) list.add(root.val);
        if(root.left!=null) preOrder(root.left,list);
        if(root.right!=null) preOrder(root.right,list);
        return list;
    }
}*/
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1= preOrder(root1);
            List<Integer> list2 = preOrder(root2);
            if(list1.size()!=list2.size()) return false;
            for(int i=0;i<list1.size();i++){
                if(list1.get(i)!=list2.get(i))return false;
            }
            return true;
        }
        public List<Integer> preOrder(TreeNode root){
            List<Integer> list = new LinkedList<>();
            if(root==null) return list;
            Stack<TreeNode> st = new Stack();
            st.push(root);
            while(!st.isEmpty()){
                TreeNode node = st.pop();
                if(node.left==null && node.right==null) list.add(node.val);
                if(root.right!=null) st.push(root.right);
                if(root.left!=null) st.push(root.left);
            }
            return list;
        }
    }
}
