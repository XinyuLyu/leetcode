/*Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.*/
public class ReverseWordsinaStringIII_557 {
    class Solution {
        public String reverseWords(String s) {
            String []array= s.split(" ");
            for(int i=0;i<array.length;i++){
                StringBuilder sb = new StringBuilder(array[i]);
                array[i]=sb.reverse().toString();
            }
            //String result = Arrays.toString(array);
            return String.join(" ",array);
        }
    }
    class Solution {
        public String reverseWords(String s) {
            String []array= s.split(" ");
            for(int i=0;i<array.length;i++){
                char [] word=array[i].toCharArray();
                for(int st=0,en=word.length-1;st<en;st++,en--){
                    char temp=word[st];
                    word[st]=word[en];
                    word[en]=temp;
                }
                array[i] = String.valueOf(word);
            }
            return String.join(" ",array);//essential
        }
    }
}
