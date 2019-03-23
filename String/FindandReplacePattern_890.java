public class FindandReplacePattern_890 {
    class Solution1 {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List <String> list = new LinkedList<>();
            for(String word:words){
                if(match(word,pattern)) list.add(word);
            }
            return list;
        }
        public boolean match(String a,String b){
            HashMap<Character, Character> map = new HashMap<>();
            char [] array1 = a.toCharArray();
            char [] array2 = b.toCharArray();
            if(array1.length!=array2.length) return false;
            for(int i =0;i<array1.length;i++){
                char ch1 = array1[i];
                char ch2 = array2[i];
            /*
            if(!map.containsKey(ch1)){
                if(map.containsValue(ch2)) return false;
                map.put(ch1,ch2);
            }
            else{if(map.get(ch1)!=ch2) return false;}  */
                if(map.containsKey(ch1) && map.get(ch1)!=ch2) return false;
                if(map.containsValue(ch2) && !map.containsKey(ch1)) return false;
                map.put(ch1,ch2);
            }
            return true;
        }
    }
    class Solution2 {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List <String> list = new LinkedList<>();
            for(String word:words){
                if(match(word,pattern)) list.add(word);
            }
            return list;
        }
        public boolean match(String a,String b){
            HashMap<Character, Character> map = new HashMap<>();
            char [] array1 = a.toCharArray();
            char [] array2 = b.toCharArray();
            if(array1.length!=array2.length) return false;
            for(int i =0;i<array1.length;i++){
                char ch1 = array1[i];
                char ch2 = array2[i];
            if(!map.containsKey(ch1)){
                if(map.containsValue(ch2)) return false;
                map.put(ch1,ch2);
            }
            else{if(map.get(ch1)!=ch2) return false;}
            }
            return true;
        }
    }
}
