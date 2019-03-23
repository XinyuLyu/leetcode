/*Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:

You may assume that the given expression is always valid.
Do not use the eval built-in library function.*/
public class BasicCalculatorII_227 {
    class Solution {
        public int calculate(String s) {
            int num =0;
            char sign ='+';
            Stack <Integer> st =new Stack();
            for(int i=0;i<s.length();i++){
                if(Character.isDigit(s.charAt(i))) num  = num*10+s.charAt(i)-'0';
                if((!Character.isDigit(s.charAt(i)) &&s.charAt(i)!=' ')||i==s.length()-1){
                    if(sign=='+') st.push(num);
                    else if(sign=='-') st.push(-num);
                    else if(sign=='*') st.push(st.pop()*num);
                    else st.push(st.pop()/num);
                    num=0;
                    sign = s.charAt(i);
                }
            }
            for(Integer ele:st) num+=ele;
            return num;
        }
    }

}
