public class ClimbingStairs {
    /*
//recursive
class Solution {
    public int climbStairs(int n) {
        if(n<=2) return n;
        else {
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }
}*/
    /*
    //fibonnaci
    class Solution {
        public int climbStairs(int n) {
            int onestep =0;
            int twostep =1;
            int res=0;
            for(int i=0;i<n;i++){
                res = onestep+twostep;
                onestep=twostep;
                twostep=res;
            }
            return res;
        }
    }*/
//dp
    class Solution {
        public int climbStairs(int n) {
            if(n==1) return 1;
            int []dp = new int[n+1];
            dp[0] =1;
            dp[1] =1;
            for(int i=1;i<n;i++){
                dp[i+1] = dp[i]+dp[i-1];

            }
            return dp[n];
        }
    }
}
