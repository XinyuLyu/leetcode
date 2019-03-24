/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]*/

public class BinaryTreeLevelOrderTraversal_II_107 {/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution{
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<Integer> st = new Stack<Integer>();
        if (root!=null) st.push(root);
        List <List<Integer>> result = new LinkedList<>();
        while(!st.isEmpty()){
            //int size = st.size();
            List <Integer> list = new LinkedList<>();
            {
                dfs();

            }
            result.add(list);
        }
        Collections.reverse(result);
        return result;

    }
    public List dfs(TreeNode node,list){
        if(node == null) return null;
        //List <Integer> list = new LinkedList<>();
        st.push(node);

        dfs(node.left);
        //if(nodeL != null) list.add(nodeL.val);

        dfs(node.right);
        //if(nodeR != null) list.add(nodeR.val);

        st.pop(node);
        list.add(node.val)
    }

}

}
/*
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    Queue<TreeNode> que = new LinkedList<>();
    List <List<Integer>> result = new LinkedList<>();
    if(root != null){
        que.add(root);
    }
    while(!que.isEmpty()){
        int size = que.size();
        List <Integer> list = new LinkedList<>();
        for (int i=0; i<size; i++)
        {
            TreeNode node= que.remove();
            list.add(node.val);
            if(node.left!=null){
                que.add(node.left);
            }
            if(node.right!=null){
                que.add(node.right);
            }
        }
        result.add(list);
    }
     Collections.reverse(result);
     return result;
    }
}*/
