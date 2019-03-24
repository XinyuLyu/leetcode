/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true*/
public class RansomNote_383 {
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            char [] ransom = ransomNote.toCharArray();
            char [] magazines = magazine.toCharArray();
            int  [] freq =new int[26];
            for(Character ch: magazines){
                freq[ch-'a']++;
            }
            for(Character chs: ransom){
                freq[chs-'a']--;
            }
            for(Integer i: freq){
                if(i<0) return false;
            }
            return true;
        }
    }
}
