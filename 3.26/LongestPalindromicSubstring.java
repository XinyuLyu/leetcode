public class LongestPalindromicSubstring {
    //brute force
/*
class Solution {
    public String longestPalindrome(String s) {
        if(s.length() ==0) return "";
       // if(s.length()==1||s.length()==2) return s.substring();
        int max=0;
       int max_i=0;
       int max_j=0;
       //boolean [][]dp = new boolean[s.length()][s.length()];
       for(int i=0;i<s.length();i++){
           for(int j=i;j<s.length();j++){
               int temp_i =i;
               int temp_j =j;
               boolean flag = true;
               while(temp_i<=temp_j){
                   if(s.charAt(temp_i)!=s.charAt(temp_j)) {
                      //dp[i][j]=false;
                      flag =false;
                      break;
                   }
                   ++temp_i;--temp_j;
               }
               if(flag == true) {
                   //dp[i][j]= true;
                   if((j-i+1)>=max) {
                       max = j-i+1;
                       max_i=i;max_j=j;
                   }
               }
           }
       }
         return s.substring(max_i,max_j+1);
    }
}*/
/*
// DP sol
class Solution {
    public String longestPalindrome(String s) {
       if(s.length() ==0) return "";
       int max=0;
       int max_i=0;
       int max_j=0;
       boolean [][]dp = new boolean[s.length()][s.length()];
       for(int i=0;i<s.length();i++){
           for(int j=0;j<=i;j++){
               dp[i][j] = s.charAt(i)==s.charAt(j) && ((i-j)<=2 || dp[i-1][j+1]);//&&优先级最高
               if(dp[i][j] && (i-j+1)>=max) {
                   max = i-j+1;
                   max_i =i;
                   max_j =j;
               }
           }
       }
       return s.substring(max_j,max_i+1);
    }
}*/
//中心扩散法
    class Solution {
        String res = "";
        int max =0;
        public String longestPalindrome(String s) {
            for(int i=0;i<s.length();i++){
                helper(s,i,i);
                helper(s,i,i+1);
            }
            return res;
        }
        public void helper(String s,int left,int right){
            while(left>=0 && right <s.length() && s.charAt(left) ==s.charAt(right)){
                --left;
                ++right;
            }
            if((right-left-1)>=max) {
                max=right-left-1;
                res = s.substring(left+1,right);
            }
        }
    }
}
