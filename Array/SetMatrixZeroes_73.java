/*Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?*/
public class SetMatrixZeroes_73 {
    //时间复杂度比较大 主要是练习 二维矩阵和一维矩阵的转换公式
    class Solution {
        public void setZeroes(int[][] matrix) {
            List<Integer> list = new LinkedList<>();
            List<Integer> zeros = new LinkedList<>();
            int M = matrix.length;//row
            int N = matrix[0].length;//coloumn
            for(int i=0;i<matrix.length;i++){//控制每个一维数组
                for(int j=0;j<matrix[i].length;j++){//控制每个一维数组中的元素
                    list.add(matrix[i][j]);
                }
            }

            for (int ii =0;ii<list.size();ii++){
                if(list.get(ii)==0) {
                    int x = ii/N;
                    int y = ii%N;
                    for(int jj =0;jj<N;jj++){
                        zeros.add(x*N+jj);
                    }
                    for(int kk =0;kk<M;kk++){
                        zeros.add(y+kk*N);
                    }
                }
            }
            for(Integer in : zeros){
                int xx = in/N;
                int yy = in%N;
                matrix[xx][yy] = 0;
            }
        }}
}
