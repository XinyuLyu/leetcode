/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?*/
public class BackspaceStringCompare_844 {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            Stack <Character> stackS = new Stack<>();
            Stack <Character> stackT = new Stack<>();
            if(S.equals(T)) return true;
            for (int i =0 ;i< S.length();i++){
                if (S.charAt(i) == '#' ) {
                    if (!stackS.isEmpty()) {
                        stackS.pop();
                    }
                    continue;
                }
                stackS.push(S.charAt(i));
            }
            for (int j =0 ;j< T.length();j++){
                if (T.charAt(j) == '#' ) {
                    if (!stackT.isEmpty()) {
                        stackT.pop();
                    }
                    continue;
                }
                stackT.push(T.charAt(j));
            }
            if(stackT.size() != stackS.size()) return false;
            for (int k =0; k<stackS.size();k++){
                if(stackS.pop() != stackT.pop()) return false;
            }
            return true;
        }
    }
}
