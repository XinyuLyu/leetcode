/*Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.*/
public class GroupAnagrams_49 {
    class Solution1{
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        HashMap <String,List<String>> map = new HashMap<>();
        for(String s :strs){
            char [] b = s.toCharArray();
            Arrays.sort(b);
            String ss = String.valueOf(b);
            if(!map.containsKey(ss)) map.put(ss,new LinkedList<String>());// add list to hashmap as value
            map.get(ss).add(s);
        }
        for(List<String> list: map.values(){
            res.add(list);
        }
        return res;
    }
    }
    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> res = new LinkedList<>();
            String [] ss = new String[strs.length];
            int i=0;
            for(String s: strs){
                char [] b = s.toCharArray();
                Arrays.sort(b);
                ss[i++] = String.valueOf(b);
            }
            HashMap <String,Integer> map = new HashMap<>();
            for(String sss: ss){
                map.put(sss , map.containsKey(sss)? map.get(sss)+1:1);
            }
            for(String ch:map.keySet()){
                List<String> list = new LinkedList<>();
                for(int k=0;k<ss.length;k++){
                    if( ss[k].equals(ch)) list.add(strs[k]);
                }
                res.add(list);
            }
            return res;
        }
    }
}
