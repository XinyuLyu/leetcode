/*Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:

Input: [100, 4, 200, 1, 3, 2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*/
public class LongestConsecutiveSequence_128 {
    class Solution {//space O(n) time O(nlogn)
          public int longestConsecutive(int[] nums) {
              if(nums.length == 0) return 0;
              else if(nums.length == 1) return 1;
              else{
                  ArrayList<Integer> result = new ArrayList<>();
                  Arrays.sort(nums);
                  int counter=0;
                  for(int i=0;i<nums.length-1;i++){
                      if(nums[i+1]-nums[i]==1) ++counter;
                      else if(nums[i+1]-nums[i]==0) continue;
                      else {
                          result.add(counter+1);
                          counter = 0;
                      }
                  }
                  result.add(counter+1);
                  return Collections.max(result);
              }
          }//space O(1) time O(nlogn)
        public int longestConsecutive(int[] nums) {
            if(nums.length == 0) return 0;
            else if(nums.length == 1) return 1;
            else{
                int result = 0;
                Arrays.sort(nums);
                int counter=0;
                for(int i=0;i<nums.length-1;i++){
                    if(nums[i+1]!=nums[i]){
                        if(nums[i+1]-nums[i]==1) ++counter;
                        else {
                            if(result<counter) result = counter;
                            counter = 0;
                        }
                    }
                }
                if(counter>result) return ++counter;
                else return ++result;
            }
        }
    }
}
