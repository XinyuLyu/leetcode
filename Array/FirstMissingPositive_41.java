/*
* Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.*/
public class FirstMissingPositive_41 {
    class Solution { //space O(max of nums) time O(n)
        public int firstMissingPositive(int[] nums) {
            if(nums.length ==0)return 1;
            Arrays.sort(nums);
            int length = nums[nums.length-1]>0 ?  nums[nums.length-1]+1: 0;
            int [] A = new int [length];
            for(Integer num : nums){
                if(num>0) A[num-1] = num;
            }
            for(int i=0;i<A.length;i++){
                if(A[i]==0) return i+1;
            }
            return 1;
        }
    }
}
