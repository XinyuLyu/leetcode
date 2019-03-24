/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.*/
public class FirstUniqueCharacterinaString_387 {
    class Solution {
        public int firstUniqChar(String s) {
    /*
     HashMap<Character, Integer> map = new HashMap<>();
        char [] chs = s.toCharArray();
        for (Character ch: chs){
            map.put(ch, !map.containsKey(ch)? 1 : map.get(ch)+1);
        }
        for(int i=0;i< chs.length;i++){
           if(map.get(s.toCharArray()[i])==1) return i;
        }
        return -1;*/
            char [] chs = s.toCharArray();
            int []freq = new int[26];
            for(Character ch : chs){
                freq[ch-'a']++;
            }
            for(int i=0;i<chs.length;i++){
                if(freq[chs[i]-'a'] == 1) return i;
            }
            return -1;
        }
    }
}
