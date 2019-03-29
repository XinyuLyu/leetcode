public class N_aryTreePreorderTraversal {
//iterativel
class Solution {
    public List<Integer> preorder(Node root) {
        List <Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack <Node>sk = new Stack<>();
        sk.push(root);
        while(!sk.isEmpty()){
            Node node =sk.pop();
            res.add(node.val);
            for(int i=node.children.size()-1;i>=0;i--){//注意顺序
                sk.push(node.children.get(i));
            }
        }
        return res;
    }
}
//recursive
    class Solution {
        List <Integer> res = new LinkedList<>();
        public List<Integer> preorder(Node root) {
            if(root == null) return res;
            else{
                res.add(root.val);
                for(Node child:root.children){//注意顺序
                    preorder(child);
                }
            }
            return res;
        }
    }
}
