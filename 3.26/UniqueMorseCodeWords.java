import java.util.HashSet;

public class UniqueMorseCodeWords {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String [] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            for(int i=0;i<words.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<words[i].length();j++){
                    sb.append(morse[words[i].charAt(j)-'a']);
                }
                words[i]=sb.toString();
            }
            HashSet<String> res = new HashSet<String>();
            for(String word:words){
                res.add(word);
            }
            return res.size();
        }
    }
}
