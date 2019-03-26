/*Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:

Return its preorder traversal as: [1,3,5,6,2,4].

Note:

Recursive solution is trivial, could you do it iteratively?*/
public class N_aryTreePreorderTraversal_589 {
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
        List<Integer> list = new LinkedList<>();
        public List<Integer> preorder(Node root){
            if(root ==null) return list;
            list.add(root.val);
            for(Node child:root.children){
                preorder(child);
            }
            return list;
        }
    /*
    public List<Integer> preorder(Node root) {
    List<Integer> list = new LinkedList<>();
    if(root ==null) return list;
    Stack <Node>st = new Stack();
    st.push(root);
    while(!st.isEmpty()){
        Node node = st.pop();
        list.add(node.val);
        for(int i=node.children.size()-1;i>=0;i--){
            st.push(node.children.get(i));
        }
    }
        return list;
    }*/
    }
}
