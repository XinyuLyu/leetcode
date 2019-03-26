/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
*/

public class PascalsTriangleII_119 {
    class Solution {
    public List<Integer> getRow(int rowIndex) {
        long key=1;
        List<Integer> pascal =new ArrayList<Integer>();
        for(int i=0;i<=rowIndex;i++)
        {
            pascal.add((int)key);
            key=key*(rowIndex-i)/(i+1);
        }
        return pascal;
    }
}
}
