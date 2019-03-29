public class SameTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
/* recursive
class Solution {
    boolean flag = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null) && (q== null)) return true;
        else if((p==null) || (q== null)) flag = false;
        else{
            if(p.val!=q.val) flag = false;
            isSameTree(p.left,q.left);
            isSameTree(p.right,q.right);
        }
        return flag;
    }
}*/
/* neat recursive
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null) && (q== null)) return true;
        if((p==null) || (q== null)) return false;
        if(p.val!=q.val) return false;
        else{
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }
}*/
//
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if((p==null) && (q== null)) return true;
            if((p==null) || (q== null)) return false;
            if(p.val!=q.val) return false;
            else{
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }
        }
    }
}
