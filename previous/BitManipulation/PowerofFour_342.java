/*
Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

Example 1:

Input: 16
Output: true
Example 2:

Input: 5
Output: false
Follow up: Could you solve it without loops/recursion?

*/
public class PowerofFour_342 {
    class Solution {
        public boolean isPowerOfFour(int num) {
            if(num==0) return false;
            while(num%4==0) num/=4;
            if(num==1) return true;
            else return false;
        }
    }
}
