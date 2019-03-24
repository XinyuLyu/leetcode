/*Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/
public class isPalindrome_125 {
    class Solution {
   /* public boolean isPalindrome(String s) {
        //if(s.length() == 0) return true;
        char []str = s.replaceAll( "[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]" , "").replaceAll(" ", "").toLowerCase().toCharArray();
        int i =0;
        int j =str.length-1;
    while(i<=j){
        if(str[i++] != str[j--]) return false;
    }
        return true;
    }*/

        public boolean isPalindrome(String s) {
            StringBuilder rev = new StringBuilder(s.replaceAll("[^A-Za-z0-9]", "").toLowerCase());
            if(rev.toString().equals(rev.reverse().toString())) return true;
            return false;
        }

    }
}
