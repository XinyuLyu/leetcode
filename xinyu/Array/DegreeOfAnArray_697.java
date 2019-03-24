public class DegreeOfAnArray_697 {
    class Solution {
        public int findShortestSubArray(int[] nums) {
            HashMap<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (!map.containsKey(nums[i])) {
                    map.put(nums[i], new int[]{1, i, i});
                } else {
                    int[] temp = map.get(nums[i]);
                    temp[0]++;
                    temp[2] = i;
                }
            }
            int max = 0;
            int res = 0;
            for (Integer key : map.keySet()) {
                int count = map.get(key)[0];
                if (count > max) {
                    max = count;
                    res = map.get(key)[2] - map.get(key)[1] + 1;
                } else if (count == max) {
                    res = Math.min(res, map.get(key)[2] - map.get(key)[1] + 1);
                }
            }
            return res;
        }
    }
}
