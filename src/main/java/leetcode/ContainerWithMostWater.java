package leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxV = 0;
        int left = 0,right = height.length-1;
        while(left!=right) {

            if(height[right]>height[left]){
                maxV = Math.max(height[left]*(right-left),maxV);
                left++;
            }else{
                maxV = Math.max(height[right]*(right-left),maxV);
                right--;
            }
        }
        return maxV;
    }
}
