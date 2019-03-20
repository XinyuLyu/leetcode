/*Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.



Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]*/
public class FindCommonCharacters_1002 {
    class Solution {
        public static List<String> commonChars(String[] A) {
            List<String> list = new ArrayList<>();
            int [] dict = new int[26];
            for(int i=0;i< A[0].length();i++){
                dict[A[0].charAt(i)-'a']++;
            }
            for(int i=1;i<A.length;i++){
                int []temp = new int[26];
                for(int j=0;j< A[i].length();j++){
                    temp[A[i].charAt(j)-'a']++;
                }
                for(int k=0;k<temp.length;k++){
                    dict[k]=Math.min(temp[k],dict[k]);
                }
            }
            for(int i=0;i<dict.length;i++){
                for(int j=0;j<dict[i];j++){
                    list.add(String.valueOf((char)('a'+i)));
                }
            }
            return list;
        }
    }
}
