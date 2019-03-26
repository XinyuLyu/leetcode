/*There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5*/
public class MedianofTwoSortedArrays_4 {
    //log(min(m,n)) https://www.youtube.com/watch?v=do7ibYtv5nk
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
            int len = nums1.length + nums2.length;
            int cut1 = 0;
            int cut2 = 0;
            int cutL = 0;
            int cutR = nums1.length;
            while (cut1 <= nums1.length) {
                cut1 = (cutR - cutL) / 2 + cutL;
                cut2 = len / 2 - cut1;
                int L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
                int L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
                int R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
                int R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
                if (L1 > R2) cutR = cut1 - 1;
                else if (L2 > R1) cutL = cut1 + 1;
                else if (len % 2 == 0) return (double) (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
                else return (double) Math.min(R1, R2);
            }
            return -1;
        }
    }
//heap edition no order with one array}
/*class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int []num = new int[nums1.length+nums2.length];
        for(int i=0;i<nums1.length;i++){
            num[i]= nums1[i];
        }
        for(int j=0;j<nums2.length;j++){
            num[nums1.length+j]= nums2[j];
        }
        int heapsize = num.length/2+1;
        PriorityQueue<Integer> heap = new PriorityQueue<>(heapsize);
        for(int i=0;i<heapsize;i++){
            heap.offer(num[i]);
        }
        for(int j=heapsize;j<num.length;j++){
            if(heap.peek()<num[j]){
                heap.poll();
                heap.add(num[j]);
            }
        }
        if(num.length%2 == 1) return (double)heap.peek();
        else return (double)(heap.poll()+heap.peek())/2.0;
    }
}*/

}
