/*Given an n-ary tree, return the postorder traversal of its nodes' values.

For example, given a 3-ary tree:







Return its postorder traversal as: [5,6,3,2,4,1].


Note:

Recursive solution is trivial, could you do it iteratively?*/
public class N_aryTreePostorderTraversal_590 {
    /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
    class Solution {
        /*
        List<Integer> list = new LinkedList<>();
        public List<Integer> postorder(Node root) {
            if(root==null) return list;
            for(Node child: root.children){
                postorder(child);
            }
            list.add(root.val);
            return list;
        }*/
        public List<Integer> postorder(Node root){
            List<Integer> list = new LinkedList<>();
            if(root ==null) return list;
            Stack<Node> st1 = new Stack();
            Stack<Node> st2 = new Stack();
            st1.push(root);
            while(!st1.isEmpty()){
                Node node = st1.pop();
                st2.push(node);
                for(Node child:node.children){
                    st1.push(child);
                }
            }
            while(!st2.isEmpty()){
                Node node=st2.pop();
                list.add(node.val);
            }
            return list;
        }
    }
}
