public class CountingBits {
    class Solution {
        public int[] countBits(int num) {
            int []f = new int[num+1];
            f[0]=0;
            for(int i=1;i<f.length;i++) f[i]=f[i/2]+i%2;
            return f;
        }
    }
}
