/*Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.*/
public class LongestCommonPrefix_14 {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length==0) return "";
            int minLength = Integer.MAX_VALUE ;
            for(String words:strs){
                if(words.length()<minLength) minLength = words.length();
            }
            for(int i=0;i<minLength;i++){
                Character ch = strs[0].charAt(i);
                for(String words: strs){
                    if(words.charAt(i) != ch) return strs[0].substring(0,i);
                }
            }
            return strs[0].substring(0,minLength);
        }
    }
}
