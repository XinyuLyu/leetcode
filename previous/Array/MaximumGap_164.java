public class MaximumGap_164 {
    class Solution {
        public int maximumGap(int[] nums) { // time O(nlogn) space O(1)
            if(nums.length<2) return 0;
            int interval=0;
            Arrays.sort(nums);
            for(int i=0;i<nums.length-1;i++){
                int temp =nums[i+1]-nums[i];
                if(temp>interval) interval = temp;
            }
            return interval;
        }
    }
    class Solution1 {//Radix sort Buckets
        public int maximumGap(int[] nums) { // time O(nlogn) space O(1)

    }
}
