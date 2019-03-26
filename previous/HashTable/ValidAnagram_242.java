/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

*/
public class ValidAnagram_242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            // char[] str1=s.toCharArray();
            // char[] str2=t.toCharArray();
            // Arrays.sort(str1);
            // Arrays.sort(str2);
            // return Arrays.equals(str1,str2);
            if(s.length()!=t.length()){
                return false;
            }
            int []counter=new int[26];
            for(int i=0;i<s.length();i++)
            {
                counter[s.charAt(i)-'a']++;
                counter[t.charAt(i)-'a']--;
            }
            for(int counts:counter)
            {
                if(counts!=0)
                    return false;
            }
            return true;
        }
    }
}
