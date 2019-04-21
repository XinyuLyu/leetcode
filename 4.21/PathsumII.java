public class PathsumII {
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
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List <List<Integer>> res = new LinkedList<>();
            List <Integer>temp = new LinkedList<>();
            dfs(root,sum,res,temp);
            return res;
        }
        public void dfs (TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp){
            if(root == null) return;
            temp.add(root.val);
            if(root.val-sum ==0 && root.left==null && root.right ==null){
                res.add(new LinkedList<Integer>(temp));
                temp.remove(temp.size()-1);
                return;
            }
            else{
                dfs(root.left, sum-root.val, res,temp);
                dfs(root.right, sum-root.val, res,temp);
            }
            temp.remove(temp.size()-1);
        }
    }
}

