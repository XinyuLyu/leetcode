/*Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.*/
public class MoveZeroes_283 {
    class Solution {
        public void moveZeroes(int[] nums) {
            int i=0;
            for(int k=0;k<nums.length;k++)
            {
                if(nums[k]!=0)
                {
                    int temp=0;
                    temp=nums[k];
                    nums[k]=nums[i];
                    nums[i]=temp;
                    i++;
                }
            }
            for(int j=i;j<nums.length;j++)
            {
                nums[j]=0;
            }
        }
    }
}
