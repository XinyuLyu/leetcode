/*
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
 */
public class IntersectionofTwoArrays_349 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            Set<Integer> set = new HashSet<>();
            Set<Integer> intersectio = new HashSet<>();
            for (int i=0;i<nums1.length;i++)
            {
                set.add(nums1[i]);
            }
            for (int j=0; j<nums2.length;j++)
            {
                if(set.contains(nums2[j]))
                {
                    intersectio.add(nums2[j]);
                }
            }
            int i=0;
            int []intersection = new int [intersectio.size()];
            for (int items:intersectio)
            {
                intersection[i++] = items;
            }
            return intersection;
        }
    }
}
