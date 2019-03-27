public class ProductofArrayExceptSelf {
    //brute force time limited
/*class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            result[i] = 1;
            for(int j=0;j<nums.length;j++){
                if(i==j) continue;
                result[i] *= nums[j];
            }
        }
        return result;
    }
}*/
//除法
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int zero = -1;
            int temp = 1;
            for(int i=0;i<nums.length;i++){
                if(nums[i]==0) {
                    zero=i;
                    break;
                }
            }
            if(zero>=0){
                for(int i=0;i<nums.length;i++){
                    if(i==zero) continue;
                    temp*=nums[i];
                }
                for(int i=0;i<nums.length;i++){
                    if(i==zero) nums[i]=temp;
                    else nums[i]=0;
                }
            }
            else{
                for(Integer num:nums) temp*=num;
                for(int i=0;i<nums.length;i++){
                    nums[i] = temp/nums[i];
                }
            }
            return nums;
        }
    }
}
