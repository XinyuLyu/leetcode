/*Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a 3-ary tree:






We should return its max depth, which is 3.



Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
*/
public class MaximumDepthofN_aryTree_559 {

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

    class Solution {
        public int maxDepth(Node root) {
            Queue<Node> que = new LinkedList<Node>();
            if (root == null) return 0;
            que.add(root);
            int level =0;
            while(!que.isEmpty()){
                //for(Node nodes: que){//这样的话必须是对每一个nodes操作
                int size = que.size();
                for(int i =0; i<size; i++){
                    Node father = que.remove();
                    for(Node node: father.children){
                        que.add(node);
                    }
                }
                ++level;
            }
            return level;
        }
    }
}
