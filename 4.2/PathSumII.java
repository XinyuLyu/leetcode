public class PathSumII {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> res = new LinkedList<>();
            List<Integer> temp = new LinkedList<>();
            dfs(root,sum,temp,res);
            return res;
        }
        public void dfs(TreeNode root, int sum, List<Integer> temp, List<List<Integer>> res){
            if(root ==null) return;
            temp.add(root.val);
            if(root.left ==null && root.right == null && sum-root.val == 0){
                res.add(new LinkedList(temp));
                return;
            }
            if(root.left != null){
                dfs(root.left,sum-root.val,temp,res);
                temp.remove(temp.size()-1);
            }
            if(root.right != null){
                dfs(root.right,sum-root.val,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }
}
