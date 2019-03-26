/*
42. Trapping Rain Water
Hard

3161

58

Favorite

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6*/
public class TrappingRainWater_42 {
    //for two adversary
    class Solution {
        public int trap(int[] height) {
            int []left =new int[height.length];
            int []right = new int[height.length];
            int leftMax = Integer.MIN_VALUE;
            int rightMax= Integer.MIN_VALUE;
            //while 代替 试一下
            for(int i=0;i<height.length;i++){
                leftMax = Math.max(leftMax,height[i]);
                left[i]= leftMax;
            }
            for(int j=height.length-1;j>=0;j--){
                rightMax = Math.max(rightMax, height[j]);
                right[j]= rightMax;
            }
            int sum = 0;
            for(int i=0;i<height.length;i++){
                sum+= Math.min(left[i],right[i])-height[i];
            }
            return sum;
        }
    }
}
