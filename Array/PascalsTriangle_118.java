/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]

*/

public class PascalsTriangle_118 {
    class Solution {
        List<List<Integer>> List=new ArrayList<List<Integer>>();
        public List<List<Integer>> generate(int numRows) {
            for(int i=0;i<numRows;i++)
            {
                List<Integer> sublist=new ArrayList<Integer>();
                if(i==0){
                    sublist.add(1);
                    List.add(sublist);
                    continue;
                }
                for(int j=0;j<i+1;j++)
                {
                    if(j==0||j==i) {
                        sublist.add(1);
                    }
                    else{
                        int temp=List.get(i-1).get(j-1)+List.get(i-1).get(j);
                        sublist.add(temp);
                    }
                }
                List.add(sublist);
            }
            return List;
        }
    }
}
