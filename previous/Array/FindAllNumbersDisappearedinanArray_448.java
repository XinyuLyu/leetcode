/*448. Find All Numbers Disappeared in an Array
Easy

1483

139

Favorite

Share
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

Example:

Input:
[4,3,2,7,8,2,3,1]

Output:
[5,6]
Accepted
140,318
Submissions
265,332*/
public class FindAllNumbersDisappearedinanArray_448 {
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<nums.length;i++) nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
            for(int i=0;i<nums.length;i++) if(nums[i]>0) list.add(i+1);
            return list;
        }
    }
}
