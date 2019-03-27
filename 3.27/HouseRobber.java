public class HouseRobber {// recursive method
/*
class Solution {
    public int rob(int[] nums) {
        return robHelper(nums, nums.length-1);
    }
    public int robHelper(int [] nums,int i){
        if(i<0) return 0;
        else return Math.max(nums[i]+robHelper(nums,i-2),robHelper(nums,i-1));
    }
}*/

    //DP
    class Solution {
        public int rob(int[] nums) {
            if(nums.length==0) return 0;
            else if(nums.length==1) return nums[0];
            int []mem = new int[nums.length];
            mem[0]=nums[0];
            mem[1]=Math.max(mem[0],nums[1]);
            for(int i=2;i<mem.length;i++){
                mem[i]= Math.max(mem[i-1],mem[i-2]+nums[i]);
            }
            return Math.max(mem[nums.length-2],mem[nums.length-1]);
        }
    }


}
