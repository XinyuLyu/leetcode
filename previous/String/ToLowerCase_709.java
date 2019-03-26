/*Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.



Example 1:

Input: "Hello"
Output: "hello"
Example 2:

Input: "here"
Output: "here"
Example 3:

Input: "LOVELY"
Output: "lovely"*/
public class ToLowerCase_709 {
    /*class Solution {
     public String toLowerCase(String str) {
         StringBuilder sb = new StringBuilder(str);
         for(int i=0;i<str.length();i++){
             if(str.charAt(i)<='Z' && str.charAt(i)>='A'){
                 sb.setCharAt(i,(char)(str.charAt(i)+32));
             }
         }
         return sb.toString();
     }
 }*/
/*
class Solution {
    public String toLowerCase(String str) {
        char [] array = str.toCharArray();
        for(int i=0;i<array.length;i++){
            if(array[i]<='Z' && array[i]>='A'){
                array[i]=(char)(array[i]+32);
            }
        }
        return String.valueOf(array);
    }
}*/
    class Solution {
        public String toLowerCase(String str) {
            return str.toLowerCase();
        }
    }
}
