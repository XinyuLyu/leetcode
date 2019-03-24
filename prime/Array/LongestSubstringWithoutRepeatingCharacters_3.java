package Array;
/*3. Longest Substring Without Repeating Characters
Medium

5063

266

Favorite

Share
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
public class LongestSubstringWithoutRepeatingCharacters_3 {
    /*class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap <Character, Integer>map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int j=0;
        for (int i=0;i< s.length();i++){
            if(!map.containsKey(s.charAt(i))) map.put(s.charAt(i),++j);
            else{
                if(s.charAt(i)==s.charAt(i-1)){
                   list.add(map.get(s.charAt(i-1)));
                   j = 0;
                   map.put(s.charAt(i),++j);
                }
                else {
                    int minus = map.get(s.charAt(i));
                    for(int m=i-1;m>=0;m--){
                        if(s.charAt(i)==s.charAt(m)) break;
                        map.put(s.charAt(m),map.get(s.charAt(m))-minus);
                    }
                    j= map.get(s.charAt(i-1));
                    map.put(s.charAt(i),++j);
                }
            }
            if(i==s.length()-1) list.add(map.get(s.charAt(i)));
        }
        return Collections.max(list);
    }
}*/
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length()==0) return 0;
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            int max=0;
            for (int i=0, j=0; i<s.length(); ++i){
                if (map.containsKey(s.charAt(i))){
                    j = Math.max(j,map.get(s.charAt(i))+1);
                }
                map.put(s.charAt(i),i);
                max = Math.max(max,i-j+1);
            }
            return max;
        }
    }
}

