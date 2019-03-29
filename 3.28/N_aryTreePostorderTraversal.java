public class N_aryTreePostorderTraversal {
// iteratively
class Solution {
    public List<Integer> postorder(Node root) {
        List <Integer> res = new LinkedList<Integer>();
        if(root == null) return res;
        Stack <Node>sk1 = new Stack();
        Stack <Node>sk2 = new Stack();
        sk1.push(root);
        while(!sk1.isEmpty()){
            Node node = sk1.pop();
            sk2.push(node);
            for(Node child: node.children){
                sk1.push(child);
            }
        }
        while(!sk2.isEmpty()){
            Node node = sk2.pop();
            res.add(node.val);
        }
        return res;
    }
}
//Recursive
    class Solution {
        List <Integer> res = new LinkedList<Integer>();//注意在这里初始化list 否则每次递归都将list初始化 会有问题
        public List<Integer> postorder(Node root) {
            if(root == null) return res;
            else{
                for(Node child:root.children){//注意顺序
                    postorder(child);
                }
                res.add(root.val);
            }
            return res;
        }
    }
}
