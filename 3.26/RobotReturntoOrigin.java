public class RobotReturntoOrigin {
    class Solution {
        public boolean judgeCircle(String moves) {
            char[] steps = moves.toCharArray();
            int x=0;
            int y=0;
            for(Character ch : steps){
                if (ch == 'L') x-=1;
                else if (ch == 'R')x+=1;
                else if (ch == 'U')y+=1;
                else y-=1;
            }
            if(x==0 && y==0) return true;
            return false;
        }
    }
}
