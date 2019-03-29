public class SymmetricTree {
    //iterative
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root ==null) return true;
            Queue <TreeNode> que = new LinkedList<>();
            que.offer(root);
            while(!que.isEmpty()){
                int size = que.size();
                List <Integer> list = new ArrayList<>();
                while(size>0){
                    TreeNode node = que.poll();
                    if(node.left !=null) {que.offer(node.left) ;list.add(node.left.val);}
                    else{ list.add(null);}
                    if(node.right !=null) {que.offer(node.right);list.add(node.right.val);}
                    else{list.add(null);}
                    --size;
                }
                int i=0;
                int j=list.size()-1;
                while(i<j){
                    if(list.get(i++)!=list.get(j--)) return false;
                }
            }
            return true;
        }
    }
}
