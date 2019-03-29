public class BinaryTreeInorderTraversal {
    //iteratively
/*class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack <TreeNode> sk = new Stack();
        TreeNode cur = root;
        while(cur!=null || !sk.isEmpty()){
            while(cur!= null){
                sk.push(cur);
                cur=cur.left;
            }
            cur=sk.pop();
            res.add(cur.val);
            cur=cur.right;
        }
        return res;
    }
}*/
//recursively
    class Solution {
        List<Integer> res = new LinkedList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            if(root == null) return res;
            if(root.left!=null) inorderTraversal(root.left);
            res.add(root.val);
            if(root.right!=null) inorderTraversal(root.right);
            return res;
        }
    }
}
