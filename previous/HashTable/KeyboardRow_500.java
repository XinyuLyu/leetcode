/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


Example:

Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]

Note:

You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.*/
public class KeyboardRow_500 {
    class Solution {
        public String[] findWords(String[] words) {
            ArrayList<String> res = new ArrayList<>();
            Map<Character, Integer> map = new HashMap<>();
            String []keyboard = {"QWERTYUIOP","ASDFGHJKL","ZXCVBNM"};
            for (int i=0;i<keyboard.length;i++)
            {
                for (char c: keyboard[i].toCharArray() )
                {
                    map.put(c,i);
                }
            }
            for (String word : words)
            {
                if(word.equals("")) continue;///////重点
                int index = map.get(word.toUpperCase().charAt(0));
                for (char c : word.toUpperCase().toCharArray())
                {
                    if(map.get(c)!=index)
                    {
                        index =-1;
                        break;
                    }
                }
                if (index !=-1)  res.add(word);
            }
            return res.toArray(new String[0]);
        }
    }
}
