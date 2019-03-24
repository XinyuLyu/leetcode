/*Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.

*/
public class LargestNumber_179 {
    class Solution {
        public String largestNumber(int[] nums) {
            if(nums.length ==0) return "0";
            String [] numsSt = new String[nums.length];
            for(int i =0;i<nums.length;i++){
                numsSt[i] = nums[i] + "";
            }
            Comparator<String> comp = new Comparator<String>(){
                @Override
                public int compare(String str1, String str2){
                    String s1 = str1 + str2;
                    String s2 = str2 + str1;
                    return s2.compareTo(s1); // reverse order here, so we can do append() later
                }
            };
            String res ="";
            Arrays.sort(numsSt,comp);
            for(String str:numsSt){
                res+=str;
            }
            if(res.charAt(0)=='0') return "0";
            return res;
        }
    }
}

