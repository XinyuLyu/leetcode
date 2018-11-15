/*Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.
subString（i，i）时 subString 为空
For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().*/
public class ImplementstrStr_28 {
    class Solution {
        public int strStr(String haystack, String needle) {
            if(haystack.length()-needle.length()<0) return -1;
            for(int i =0;i<=haystack.length()-needle.length();i++){
                if(haystack.substring(i,i+needle.length()).equals(needle))
                    return i;
            }
            return -1;
        }
    }
}
