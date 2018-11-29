/*Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:

Input: [1,3,4,2,2]
Output: 2
Example 2:

Input: [3,1,3,4,2]
Output: 3
Note:

You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
*/
public class FindtheDuplicateNumber_287 {
    class Solution {
        /* public int findDuplicate(int[] nums) {
             if(nums.length==1 || nums.length ==0) return -1;
             Arrays.sort(nums);
             for(int i=0;i<nums.length;i++){
                 if(nums[i]==nums[i+1]) return nums[i];
             }
             return -1;
         }
         */
        public int findDuplicate(int[] nums) {
            if(nums.length==1 || nums.length ==0) return -1;
            HashSet<Integer> sh = new HashSet<>();
            for(Integer num:nums){
                if(!sh.add(num)) return num;
            }
            return -1;
        }
    }
}
