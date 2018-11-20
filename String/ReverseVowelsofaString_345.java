/*Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".

 */
public class ReverseVowelsofaString_345 {
    class Solution {
        public String reverseVowels(String s) {
            char [] chs = s.toCharArray();
            List <Integer> index = new ArrayList<>();
            for(int i=0;i<chs.length;i++){
                if(chs[i] == 'a' ||chs[i] == 'e'||chs[i] == 'i'||chs[i] == 'o'||chs[i] == 'u'||chs[i] == 'A' ||chs[i] == 'E'||chs[i] == 'I'||chs[i] == 'O'||chs[i] == 'U'){
                    index.add(i);
                }
            }
            for(int m=0,n=index.size()-1;m<n;m++,n--){
                char temp = chs[index.get(m)];
                chs[index.get(m)] = chs[index.get(n)];
                chs[index.get(n)] = temp;
            }
            return String.valueOf(chs);// 不是 chs.toString(); 或者用 stringbuilder 和 String S= ''；
        }
    }
}
