/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
*/
public class MajorityElement_169 {
    class Solution {
        public Map<Integer,Integer> counts(int []nums)
        {
            Map<Integer,Integer> counts=new HashMap<Integer,Integer>();
            for(int num:nums)
            {
                if(!counts.containsKey(num))
                {
                    counts.put(num,1);
                }else{
                    counts.put(num,counts.get(num)+1);
                }
            }
            return counts;
        }
        public int majorityElement(int[] nums) {
            Map<Integer,Integer> count=counts(nums);
            Map.Entry<Integer,Integer> majorityElement=null;
            for(Map.Entry<Integer,Integer> entry:count.entrySet())
            {
                if(majorityElement==null||entry.getValue()>majorityElement.getValue())
                {
                    majorityElement=entry;
                }
            }
            return majorityElement.getKey();
        }
    }
}

